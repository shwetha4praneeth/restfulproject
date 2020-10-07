package restAssured;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OnePathParameterWithJSONResponse
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
		Headers rhs=res.getHeaders();
		List<Header> hs=rhs.asList();
		for(Header h:hs)
		{
			System.out.println(h.getName()+":"+h.getValue());
		}
		String rb=res.getBody().asString();
		//Display response body
		String rbody=res.getBody().asString();
		System.out.println("Response body is :\n"+rbody);
	}
}
