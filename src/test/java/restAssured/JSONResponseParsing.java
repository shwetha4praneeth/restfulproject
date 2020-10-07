package restAssured;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JSONResponseParsing 
{
	public static void main(String[] args) 
	{
		//Register end point & Create HTTP Request
		RestAssured.baseURI="http://jsonplaceholder.typicode.com/posts";
		RequestSpecification req=RestAssured.given();
		//Send HTTP request with one path parameter value & get HTTP response
		Response res=req.request(Method.GET,"/1");
		//Analyse HTTP response in various representations
		String rsl=res.getStatusLine();
		System.out.println("Status line is:"+rsl);
		String hv=res.getHeader("Content-Type");
		if(hv.contains("json"))
		{
			JsonPath jp=res.jsonPath();
			String svinres=jp.getString("title");
			System.out.println("Title value in Response is:"+svinres);
		}
	}
}
