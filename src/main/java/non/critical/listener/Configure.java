package non.critical.listener;

import non.critical.listener.connectors.Connector;
import non.critical.listener.connectors.JiraConnector;
import non.critical.listener.connectors.TfsConnector;

import java.io.*;
import java.util.Properties;

public class Configure {
    private static final String CONFIG_FILE_NAME = "noncritical.config.properties";
    private static final Properties PROPERTIES = new Properties();
    public static String TOKEN = null;
    //TODO - check how to get jira token like tfs PAT
    public static String YOUR_DOMAIN = null;
    public static String baseUrl = null;
    public static String TFS_ORGANIZATION = null;
    public static String TFS_PROJECT = null;
    public static String TICKET_SYSTEM = null;
    public static Connector connector;

    /**
     * static initializer block is executed when the class is loaded into memory, before any instance of the class is created.
     */
    static {
        System.getProperty("java.class.path");
        try (InputStream input = new FileInputStream(new File("src/main/resources/noncritical.config.properties"))) {

            if (input != null) {
                PROPERTIES.load(input);
                setParamsFromConfigFile();
            } else {
                throw new FileNotFoundException("Configuration file '" + CONFIG_FILE_NAME + "' not found in the classpath");
            }
        } catch (IOException ex) {
            throw new RuntimeException("Error loading configuration file", ex);
        }
    }

    public static void init(){
        try (InputStream input = Configure.class.getClassLoader().getResourceAsStream(CONFIG_FILE_NAME)) {
            if (input != null) {
                PROPERTIES.load(input);
                setParamsFromConfigFile();
            } else {
                throw new FileNotFoundException("Configuration file '" + CONFIG_FILE_NAME + "' not found in the classpath");
            }
        } catch (IOException ex) {
            throw new RuntimeException("Error loading configuration file", ex);
        }
    }


    public Configure() {
//        init();
        setTicketSystem();
        setBaseUrl();
        setToken();
    }

    public static void setParamsFromConfigFile() {
        YOUR_DOMAIN = PROPERTIES.getProperty("YOUR_DOMAIN");
        TFS_ORGANIZATION = PROPERTIES.getProperty("TFS_ORGANIZATION");
        TFS_PROJECT = PROPERTIES.getProperty("TFS_PROJECT");
        TICKET_SYSTEM = PROPERTIES.getProperty("TICKET_SYSTEM");
    }

    public void setBaseUrl() {
        if ("Tfs".equals(TICKET_SYSTEM)) {
            this.baseUrl = "https://dev.azure.com/" + TFS_ORGANIZATION + "/" + TFS_PROJECT + "/_apis/wit/workitems/";
        } else if ("Jira".equals(TICKET_SYSTEM)) {
            this.baseUrl = "https://" + YOUR_DOMAIN + ".atlassian.net/rest/api/latest/issue/";
        }
    }

    public void setToken() {
        if ("Tfs".equals(TICKET_SYSTEM)) {
            this.TOKEN = PROPERTIES.getProperty("TFS_AUTH_TOKEN");
        } else if ("Jira".equals(TICKET_SYSTEM)) {
            this.TOKEN = PROPERTIES.getProperty("JIRA_AUTH_TOKEN");
        }
    }

    public void setTicketSystem() {
        if ("Jira".equals(TICKET_SYSTEM)) {
            this.connector = new JiraConnector();
        } else if ("Tfs".equals(TICKET_SYSTEM)) {
            this.connector = new TfsConnector();
        } else {
            throw new IllegalArgumentException("Unsupported ticketing system: " + TICKET_SYSTEM);
        }
    }

    public Connector getConnector() {
        return connector;
    }

}
