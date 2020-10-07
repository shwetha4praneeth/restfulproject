package restAssured;

import java.io.File;
import java.io.FileWriter;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestBodyParameters 
{
	public static void main(String[] args) 
	{
		//Register end point & Create HTTP Request
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/posts";
		RequestSpecification req=RestAssured.given();
		//Pack data in Json Representation
		JSONObject jo=new JSONObject();
		//Conveying data
		jo.put("userId",11);
		jo.put("id",101);
		jo.put("title","First post");
		jo.put("body","Api practice");
		//Converting data
		req.body(jo.toString());
		//(Submitting)Send HTTP Request with query parameter value but without path parameter
		Response res=req.post();
		//Get Status line from Response
		String rsl=res.getStatusLine();
		System.out.println("Status Line is:"+rsl);
		String rbody=res.getBody().asString();
		System.out.println("Response body is:"+rbody);
	}
}
