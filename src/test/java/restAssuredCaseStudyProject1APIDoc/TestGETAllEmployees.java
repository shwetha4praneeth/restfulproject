package restAssuredCaseStudyProject1APIDoc;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestGETAllEmployees
{
	public static void main(String[] args) throws Exception
	{
		//Register end-point
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		//Get the response
		Response res=RestAssured.given().get("/employees");
		//Display response status line
		String rsl=res.getStatusLine();
		System.out.println("Status line is:\n"+rsl);
		//Display response headers
		System.out.println(res.getHeader("Content-Type"));
		//Display response body
		String rb=res.getBody().asString();
		System.out.println("Response Body is:\n"+rb);
	}
}
