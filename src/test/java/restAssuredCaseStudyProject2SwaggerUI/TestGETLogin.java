package restAssuredCaseStudyProject2SwaggerUI;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestGETLogin 
{
	public static void main(String[] args) 
	{
		//Register end-point & create HTTP Request
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		RequestSpecification req=RestAssured.given();
		//Send HTTP Request with one path parameter value
		//Providing credentials in URL is called as deep linking
		Response res=req.queryParam("username","Shwpraneeth").queryParam("password","shwpra").request(Method.GET,"/user/login");
		//Get Status Line from Response
		String rsl=res.getStatusLine();
		System.out.println("Status Line is:"+rsl);
		//Get Status header value
		String header=res.getHeader("Content-Type");
		System.out.println(header);
		//Get response body
		String rbody=res.getBody().asString();
		System.out.println("Response body is :\n"+rbody);
	}
}
