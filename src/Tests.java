import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Tests {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://dummy.restapiexample.com/";
		
		//ADD EMPLOYEE and assert that operation is successful
		String response = given().log().all().queryParam("name", "test").queryParam("salary", "123").queryParam("age", "23")
				.when().post("/api/v1/create")
				.then().assertThat().statusCode(200).body("status", equalTo("success")).extract().response().asString();
		
		System.out.println("-*-*-*-*-*-*-*-*-*-*-" + "\n" + response + "\n" + "-*-*-*-*-*-*-*-*-*-*-");
		
		JsonPath js = new JsonPath(response); //for parsing json
		String employeeId = js.getString("data.id");
		
		
		//UPDATE the previously added employee and assert that the operation is successful
		String newEmployeeName = "Nico";
		String newEmployeeSalary = "12345";
		String newEmployeeAge = "45";
		
		given().log().all().queryParam("name", newEmployeeName).queryParam("salary", newEmployeeSalary).queryParam("age", newEmployeeAge)
		.when().put("/api/v1/update/" + employeeId)
		.then().assertThat().log().all().statusCode(200).body("status", equalTo("success"));
		
		//GET data from previously updated employee 
		String getEmployeeResponse = given().log().all()
				.when().get("/api/v1/employee" + employeeId)
				.then().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(getEmployeeResponse);

	}

}
