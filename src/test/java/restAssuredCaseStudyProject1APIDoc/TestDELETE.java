package restAssuredCaseStudyProject1APIDoc;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestDELETE 
{
	public static void main(String[] args) 
	{
		//Register end-point & create HTTP Request
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RequestSpecification req=RestAssured.given();
		//Send HTTP Request with one path parameter value
		Response res=req.request(Method.DELETE,"/delete/24");
		//Get Status line from Response
		String rsl=res.getStatusLine();
		System.out.println("Status line is:\n"+rsl);
		//Get Status header value
		String header=res.getHeader("Content-Type");
		System.out.println(header);
		//Get Response Body
		String rbody=res.getBody().asString();
		System.out.println(rbody);
	}
}
