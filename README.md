# RestAPI471
Rest API tests for challenge by Intel471


IDE used:
Eclipse IDE for Java
Version: 2022-12 (4.26.0)
Build id: 20221201-1913

Dependencies:
In order for the project to work correctly, the following dependencies have been added to the pom.xml file:
- RestAssured
- TestNG
- Hamcrest

This specifies the configuration details used by Maven to build the project. They were extracted from the Maven Repository (https://mvnrepository.com/). By default those dependencies include the <scope>test</scope> tag which has been removed.

How to run the tests:

Once the project is loaded in Eclipse run Tests.java (Run --> Run As --> Java Application). This file is located inside default package into "src" folder. Test results and details will be shown in the Console.

*NOTE:*
"http://dummy.restapiexample.com" throws error 429 after a short time of repeating the requests through code. By running them manually through Postman and waiting a few seconds, the endpoints return the information correctly.
