#  Automat-CT - non-critical-listener

***Configuration File***

@non-critical-listener requires a configuration file to customize its behavior. 
You must create a configuration file with the necessary options and provide 
it when running @non-critical-listener.

**Creating a Configuration File**
To create a configuration file for @non-critical-listener, create a new file in your working
directory with exact path and name: **src/main/resources/noncritical.config.properties** and add the necessary options.

This configuration file contains the required settings to use the Non-Critical-Listener package for two different ticketing systems: TFS and Jira.

To use this package, set the appropriate values for the configuration settings in this file based on the ticketing system you want to use.


**Copy the following configuration settings to your config file and edit the values as required for your ticketing system::**
```
# This file contains configuration settings for the Non-Critical-Listener package.

# - TICKET_SYSTEM: The name of the ticketing system to use. Examples: "Tfs" or "Jira".
TICKET_SYSTEM=

# TFS-CONFIG:
# To use TFS as your ticketing system, set the value of TICKET_SYSTEM to "Tfs". The following settings are required for TFS configuration:
# - TFS_AUTH_TOKEN: A token for authenticating with TFS. Example: "Basic OmluMzV3aGQzd3E3...."
# - TFS_ORGANIZATION: The name of the TFS organization to connect to.
# - TFS_PROJECT: The name of the TFS project to work with.
TFS_AUTH_TOKEN=
TFS_ORGANIZATION=
TFS_PROJECT=

# JIRA-CONFIG (basic auth):
# To use Jira as your ticketing system, set the value of TICKET_SYSTEM to "Jira". The following settings are required for Jira configuration:
# - JIRA_AUTH_TOKEN: A token for authenticating with Jira. Example: "Basic OmluMzV3aGQzd3E3...."
# - YOUR_DOMAIN: The domain name of your Jira instance.
JIRA_AUTH_TOKEN=
YOUR_DOMAIN=
```

***How to use***

To use the @NonCritical, follow the steps below:

1. Configure the config file with the required values.
2. Add @Listeners(NonCriticalListener.class) before the public class TestClass statement in your test class.
3. Add @NonCritical(bugId = "bugIdToCheck") before the @Test annotation in your test method.
   
For example:
```
@Listeners(NonCriticalListener.class)
public class TestClass {

    @NonCritical(bugId = "bugIdToCheck")
    @Test
    public void testMethod() {
        // ...
    }
}
```
Make sure to replace bugIdToCheck with the actual ID of the bug you want to check.