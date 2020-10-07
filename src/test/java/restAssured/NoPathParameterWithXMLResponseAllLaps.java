package restAssured;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class NoPathParameterWithXMLResponseAllLaps 
{
	public static void main(String[] args) 
	{
		//Register end point & Create HTTP Request
		RestAssured.baseURI="http://ergast.com/api/f1/2008";
		RequestSpecification req=RestAssured.given();
		//Send HTTP request with one path parameter value & get HTTP response
		Response res=req.request(Method.GET,"");
		//Analyse HTTP response in various representations
		String rsl=res.getStatusLine();
		System.out.println("Status line is : \n"+rsl);
		System.out.println("Headers are: ");
		//Display response headers
		List<Header> hs=res.getHeaders().asList();
		for(Header h:hs)
		{
			System.out.println(h.getName()+":"+h.getValue());
		}
		//Display response body
		String rbody=res.getBody().asString();
		System.out.println("Response body is :\n"+rbody);
	}
}
