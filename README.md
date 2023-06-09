#  Automat-CT - Non-Critical: TestNG Add-on

**Non-Critical is an add-on package for TestNG, provided by Automat-CT, 
the automation department of Automat-IT.** The package is designed to streamline 
the process of identifying and reporting bugs during software testing.


The Non-Critical package works by comparing the test results with 
the status of any related bugs in the project management system, 
such as Jira and/or Tfs/Azure ticket system. Typically, if the bug is open, 
the test should fail, and if the bug is closed, the test should pass. 
Non-Critical suggests how the user should proceed by logging the user's actions 
regarding the bug and even changing the test result to warn the user if necessary.


This package is particularly useful for software testers who want to ensure
that their test results are aligned with the current state of the project, 
thereby avoiding false positives and false negatives in their test reports.


To use Non-Critical, simply install the package and integrate it with your 
TestNG test suite. Non-Critical will automatically compare your test results 
with the status of any related bugs in the project management system and log 
the user's actions accordingly.

## Installation
To install the non-critical listener, you can download it from the Maven repository. Follow the steps below:
1. Navigate to the [Maven repository non-critical-listener page.](https://mvnrepository.com/artifact/io.github.itzikshiva/non-critical-listener)
2. Copy the code snippet for the version of the listener you wish to install.
3. Add the code snippet to your project's pom.xml file, within the dependencies section.
4. Save the pom.xml file.

Here's an example of how the dependency code snippet should look like:
```
<dependency>
<groupId>io.github.itzikshiva</groupId>
<artifactId>non-critical-listener</artifactId>
<version>2.0.1</version>
</dependency>
```
Once you have saved the pom.xml file, you can build your project and start using the non-critical listener.

## Configuration

Non-Critical Listener requires a configuration file to customize its behavior. 
You must create a configuration file with the necessary options and provide 
it when running Non-Critical Listener.

### Creating a Configuration File
To create a configuration file for Non-Critical Listener, create a new file in your working
directory with exact path and name: **src/main/resources/noncritical.config.properties** and add the necessary options.

This configuration file contains the required settings to use the Non-Critical-Listener package for two different ticketing systems: TFS and Jira.

To use this package, set the appropriate values for the configuration settings in this file based on the ticketing system you want to use.


**Copy the following configuration settings to your config file and edit the values as required for your ticketing system:**
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

## How to use

To use the Non-Critical Listener, follow the steps below:

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



### How to Get and Generate API Tokens:

In order to use the Jira or Tfs/Azure integration with this project, you will need to generate an API token. Follow the steps below to generate an API token for each platform:

Jira API Token:

1. Log in to your Atlassian account on the Jira platform.
2. Go to the API tokens page. You can find it by going to Profile settings > Security > API tokens.
3. Click on Create API token and follow the prompts to create your token.
4. Follow the instructions provided in the official [Atlassian documentation on managing API tokens.](https://support.atlassian.com/atlassian-account/docs/manage-api-tokens-for-your-atlassian-account/)
5. Copy the generated API token and use it in the configuration file for this project.


Tfs/Azure API Token: 

1. Log in to your Azure DevOps or Tfs account.
2. Go to the Personal access tokens page. You can find it by going to User settings > Personal access tokens.
3. Click on New Token and follow the prompts to create your token.
4. Follow the instructions provided in the official [Azure DevOps documentation on Use personal access tokens.](https://learn.microsoft.com/en-us/azure/devops/organizations/accounts/use-personal-access-tokens-to-authenticate)
5. Copy the generated API token and use it in the configuration file for this project.