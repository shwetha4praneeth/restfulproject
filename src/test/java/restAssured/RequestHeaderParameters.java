package restAssured;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestHeaderParameters 
{
	public static void main(String[] args) 
	{
		//Specify the base URI to the Restful webservice
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
		//Set Authentication details
		PreemptiveBasicAuthScheme auth=new PreemptiveBasicAuthScheme();
		auth.setUserName("ToolsQA");
		auth.setPassword("TestPassword");
		RestAssured.authentication=auth;
		//Define HTTP request
		RequestSpecification req=RestAssured.given();
		//Send request & get the Response
		Response res=req.request(Method.GET,"");
		//Display response status line
		String rsl=res.getStatusLine();
		System.out.println("Status line is:"+rsl);
		//Display response headers
		List<Header>hs=res.getHeaders().asList();
		for(Header h:hs)
		{
			System.out.println(h.getName()+":"+h.getValue());
		}
		//Display response body 
		String rb=res.getBody().asString();
		System.out.println("Response Body is:\n"+rb);
	}
}
