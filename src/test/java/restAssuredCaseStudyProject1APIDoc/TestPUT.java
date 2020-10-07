package restAssuredCaseStudyProject1APIDoc;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestPUT 
{
	public static void main(String[] args) 
	{
		//Register end-point & create HTTP Request
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RequestSpecification req=RestAssured.given();
		//Pack data
		JSONObject jo=new JSONObject();
		jo.put("id","25");
		jo.put("employee_name","Shwetha");
		jo.put("employee_salary",100000);
		jo.put("employee_age",35);
		jo.put("profile_image","");
		req.body(jo.toString());
		//Send HTTP Request with one path parameter value
		Response res=req.request(Method.PUT,"/update/2846");
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
