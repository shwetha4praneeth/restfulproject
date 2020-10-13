package restAssured;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StatusHeaderParsingToKnowRepresentationForLoop 
{
	public static void main(String[] args) 
	{
		//Register end point & Create HTTP Request
		//RestAssured.baseURI="http://jsonplaceholder.typicode.com/posts";
		//RestAssured.baseURI="http://www.lipsum.com";
		RestAssured.baseURI="http://ergast.com/api/f1/2008";
		RequestSpecification req=RestAssured.given();
		//Send HTTP request with one path parameter value
		//Response res=req.request(Method.GET,"/1");
		//Response res=req.request(Method.GET,"/hindi");
		Response res=req.request(Method.GET,"/1");
		//Get status line from Response
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
		for(int i=0;i<lrhs.size();i++)
		{
			System.out.println(lrhs.get(i).getName()+" : "+lrhs.get(i).getValue());
		}
		//Get Specific Header value
		String ct=res.getHeader("Content-Type");
		System.out.println("Value for Content-Type Header is:"+ct);
		if(ct.contains("json"))
		{
			System.out.println("Response is in JSON");
		}
		else if(ct.contains("xml"))
		{
			System.out.println("Response is in XML");
		}
		else if(ct.contains("html"))
		{
			System.out.println("Response is in HTML");
		}
		else if(ct.contains("plain"))
		{
			System.out.println("Response is in Plain Text");
		}
		else if(ct.contains("csv"))
		{
			System.out.println("Response is in CSV");
		}
		else
		{
			System.out.println("Response is a Code");
		}
		//Get response body
		String rbody=res.getBody().asString();
		System.out.println("Response body is :\n"+rbody);
	}
}
