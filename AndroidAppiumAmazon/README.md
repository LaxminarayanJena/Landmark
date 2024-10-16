# AppiumAmazonProject

Framework Architecture
----------------------------------

1)Base- All initialisation related to driver, utilities,property,waits has been done here </br>
2)Listener -Custom and extent listener has been implemented for reporting, screenshot on failure </br>
3)Screens- we have followed page object design model and separated our business scenarios from test cases </br>
4)TestCases- all tests has been implemented </br>
5)Utility-all type of resubale methods like excel reading, handling of property files etc </br>
6)Logs- description for methods has been implemnted with logs </br>
7)apks - amazon app is present </br>
8)properties- all constant keys like url,package name has been defined </br>
9)testdata- excel for parameterisation of test </br>
10)runner -testng.xml to trigger our tests </br>
11)extent report -  test-output/Extent.html </br>



Project has been build in</br>
macOS catalina 1.15.2 </br>
appium version 1.17 </br>


### Preconfiguration-
1)email and password to be changed in the below file </br>
testData-/src/test/resources/testdata </br>

### Running:
project can be run from runner-testng.xml</br>
or from maven root path using mvn clean test command

### Report:
<img width="1679" alt="Report" src="https://user-images.githubusercontent.com/24494133/81373530-90a2ff80-911a-11ea-9433-6f578be5a445.png">

