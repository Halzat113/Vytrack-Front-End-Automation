# VyTrack_Front_End Automation
This is a demonstration of fleet application automation testing project with UI acceptance. The framework
covers most of the testing strategy with Java cucumber page object model and retrieving the data
from json file. The goal is to cover all the test cases and try to automate them all and have a
stable passing rate. Meanwhile secure the sensitive data from publicly read, instead 
they should be encrypted and getting them from vault. However this is not the top priority but it should
be done in the near future.


## Getting Started

### pre-requirements:
- Java 11 or higher
- Maven
    - To install maven go to https://maven.apache.org/download.cgi 
   download and install it.
    - If you are using homebrew run 
   ```brew install maven``` on terminal to install maven

## Concept Included
- Parallel test runs (feature level)
- Shared state across cucumber step definitionsShared state across cucumber step definitions
- Dependency injection
- Page Object pattern
- Common web page interaction methods
- Mavenised performance tests
- Externalised test configuration
- Commonly used test utility classes


## Tools
- Maven
- Cucumber-JVM
- JUnit5
- Selenium Webdriver
- Jackson


## Usage
The project is only for front-end functional testing. The test can be 
utilised independently of the others using maven profiles.

To run the test , navigate to ``Vytrack`` directory and simply run
``mvn clean verify``
To run the test remotely, change driver to 'remote' in the configuration.properties file


Selenium-gird: http://34.205.16.125:4444/grid/console
## Reporting
Reports for each module are written into their respective /target directories after a successful run.

## Test Cases
All the test cases are written in this location [link](https://docs.google.com/spreadsheets/d/1E9a5syBCIpWJbewapRCqp2eXGG2uRicorV7RJRL76Ek/edit#gid=0)







