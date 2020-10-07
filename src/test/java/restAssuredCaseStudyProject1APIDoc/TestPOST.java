package restAssuredCaseStudyProject1APIDoc;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestPOST 
{
	public static void main(String[] args) 
	{
		//Register end-point & create HTTP Request
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RequestSpecification req=RestAssured.given();
		//Pack data
		JSONObject jo=new JSONObject();
		jo.put("id","23");
		jo.put("employee_name","Shwetha");
		jo.put("employee_salary",100000);
		jo.put("employee_age",35);
		jo.put("profile_image","");
		req.body(jo.toString());
		//Send HTTP Request with one path parameter value
		Response res=req.post("/create");
		//Validate response
	}
}
