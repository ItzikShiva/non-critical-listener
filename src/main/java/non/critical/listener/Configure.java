package non.critical.listener;

import non.critical.listener.connectors.Connector;
import non.critical.listener.connectors.JiraConnector;
import non.critical.listener.connectors.TfsConnector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Properties;

public class Configure {
    private static final Logger logger = LogManager.getLogger(Configure.class);

    private static final String CONFIG_FILE_NAME = "noncritical.config.properties";
    private static final Properties PROPERTIES = new Properties();
    public static String TOKEN = null;
    public static String YOUR_DOMAIN = null;
    public static String baseUrl = null;
    public static String TFS_ORGANIZATION = null;
    public static String TFS_PROJECT = null;
    public static String TICKET_SYSTEM = null;
    public static Connector connector;

    public Configure() {
        init();
    }

    /**
     * The init() method loads the configuration file from the classpath and sets the properties from it.
     * It throws a runtime exception if there is an error loading the configuration file.
     */
    private static void init() {
        try (InputStream input = new FileInputStream(new File("src/main/resources/noncritical.config.properties"))) {
            if (input != null) {
                logger.info("Configure file loaded successfully");
                PROPERTIES.load(input);
                setClassParamsFromConfigFile();
            } else {
                throw new FileNotFoundException("Configuration file '" + CONFIG_FILE_NAME + "' not found in the classpath");
            }
        } catch (IOException ex) {
            throw new RuntimeException("Error loading configuration file", ex);
        }
    }

    /**
     * The setClassParamsFromConfigFile() method sets the properties for the class variables from the loaded configuration file.
     * The setBaseUrl(), setToken(), and setConnector() methods set the baseUrl, TOKEN, and connector class variables, respectively,
     * based on the TICKET_SYSTEM property from the configuration file.
     */
    private static void setClassParamsFromConfigFile() {
        YOUR_DOMAIN = PROPERTIES.getProperty("YOUR_DOMAIN");
        TFS_ORGANIZATION = PROPERTIES.getProperty("TFS_ORGANIZATION");
        TFS_PROJECT = PROPERTIES.getProperty("TFS_PROJECT");
        TICKET_SYSTEM = PROPERTIES.getProperty("TICKET_SYSTEM");
        setConnector();
        setBaseUrl();
        setToken();
    }

    public static void setBaseUrl() {
        if ("Tfs".equals(TICKET_SYSTEM)) {
            baseUrl = "https://dev.azure.com/" + TFS_ORGANIZATION + "/" + TFS_PROJECT + "/_apis/wit/workitems/";
        } else if ("Jira".equals(TICKET_SYSTEM)) {
            baseUrl = "https://" + YOUR_DOMAIN + ".atlassian.net/rest/api/latest/issue/";
        }
    }

    public static void setToken() {
        if ("Tfs".equals(TICKET_SYSTEM)) {
            TOKEN = PROPERTIES.getProperty("TFS_AUTH_TOKEN");
        } else if ("Jira".equals(TICKET_SYSTEM)) {
            TOKEN = PROPERTIES.getProperty("JIRA_AUTH_TOKEN");
        }
    }

    public static void setConnector() {
        logger.info("setting ticket system: " + TICKET_SYSTEM);
        if ("Jira".equals(TICKET_SYSTEM)) {
            connector = new JiraConnector();
        } else if ("Tfs".equals(TICKET_SYSTEM)) {
            connector = new TfsConnector();
        } else {
            throw new IllegalArgumentException("Unsupported ticketing system: " + TICKET_SYSTEM);
        }
    }

    /**
     * The getConnector() method returns the connector object that can be used to access the ticketing system.
     */
    public Connector getConnector() {
        return connector;
    }

}
