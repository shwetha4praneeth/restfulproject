package restAssured;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StatusLineParsing
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
		System.out.println("Status line is:\n"+rsl);
		//Parse Status Line
		//Get Protocol Version
		String pv=rsl.substring(0,8);
		System.out.println("Protocol version is:"+pv);
		//Get Status Code
		//int sc=res.getStatusCode();
		String sc=rsl.substring(9,12);
		System.out.println("Status code is:"+sc);
		//Get Status Verb(Message)
		String svorsm=rsl.substring(13);
		System.out.println("Status Verb/Status Message is:"+svorsm);
		//Get Status headers from Response
		List<Header> lrhs=res.getHeaders().asList();
		System.out.println("Status headers are:");
		for(Header h:lrhs)
		{
			System.out.println(h.getName()+":"+h.getValue());
		}
		//Get response body
		String rbody=res.getBody().asString();
		System.out.println("Response body is :\n"+rbody);        
	}
}
