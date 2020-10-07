package restAssured;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OnePathParameterWithJSONResponseSpecificPost 
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
		System.out.println("Status line is : "+rsl);
		//Display response headers
		List<Header> lrhs=res.getHeaders().asList();
		System.out.println("Status headers are:\n");
		for(Header h:lrhs)
		{
			System.out.println(h.getName()+":"+h.getValue());
		}
		//Display response body
		String rbody=res.getBody().asString();
		System.out.println("Response body is :\n"+rbody);
	}
}
