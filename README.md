# UI_Testing_Selenium_Webdiver

### PURPOSE
This project plan describes UI framework to test the Rescale platform by uploading a new file.
It only tests the happy path for successfully uploading a file through a User Interface.

### OVERVIEW
The automation tool I used to create the UI test framework is Selenium Web driver using
Google Chrome browser only. I have used Page Object Module design pattern to write optimized code
for the UI tests. For more details about the Selenium framework

### STEPS TO IMPORT THIS PROJECT
1. Select import the project into any IDE, here I am using IntelliJ IDEA IDE for the development purpose.
2. Click on "Get From Version Control" and entire the URL of this github repository
3. Select pom.xml to import the project.
4. Once the pom.xml has been imported, it will start downloading all the dependencies mentioned in the
pom file which are mandatory to run the project.
5. After downloading all dependencies, both projects are ready to run individually in order to test the test
script to upload a new file in to Rescale platform.

### PROJECT STRUCTURE
Below are packages used in the project: -
#### 1. Helper: -
Helper package contains all helper methods categorized. These methods are called into test methods.
#### 2. pageObject: -
Page Object contains separate class for all main activity or test scenarios mentioned and we have used page
object module design pattern to locate a web element and its factory method and some other helping test
methods.
#### 3. testBase
Test base contains the base class to support out test methods using different JUnit 5 annotations. These
annotations are necessary to make the test script to run successfully. Here, we have initiated selenium driver
for chrome browser.
#### 4. testScripts
Test scripts package contain all test method which we want to execute against a feature to test.
#### 5. Util
This package contains only a sample file to upload into the Rescale platform using Selenium Web driver.
#### 6. Resource
The properties file contains all the information related to configuration settings for the test framework.
This dynamic test data can be changed as per our environment, login information etc.

### TEST RESULT
This test results will show all test methods which are run as a part of test script runner. It will show all pass
and fail tests. And the console will show the actual steps executed during the run.
