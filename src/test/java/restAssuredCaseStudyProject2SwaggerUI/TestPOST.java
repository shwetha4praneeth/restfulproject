package restAssuredCaseStudyProject2SwaggerUI;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestPOST 
{
	public static void main(String[] args) 
	{
		//Register end-point & create HTTP Request
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		RequestSpecification req=RestAssured.given();
		//Pack data
		JSONObject jo=new JSONObject();
		req.contentType("application/json");
		//jo.put("id","25"); //optional
		jo.put("username","Shwethapraneeth");
		jo.put("firstName","Shwetha");
		jo.put("lastName","Praneeth");
		jo.put("email","shwpra@gmail.com");
		jo.put("password","shwpra");
		jo.put("phone","1234567890");
		//jo.put("userStatus",""); //optional
		req.body(jo.toString());
		//Send HTTP Request with one path parameter value
		Response res=req.request(Method.POST,"/user");
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
