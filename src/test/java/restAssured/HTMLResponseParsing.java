package restAssured;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HTMLResponseParsing 
{
	public static void main(String[] args) 
	{
		//Register end point & Create HTTP Request
		RestAssured.baseURI="http://lipsum.com";
		RequestSpecification req=RestAssured.given();
		//Send HTTP request with one path parameter value & get HTTP response
		Response res=req.request(Method.GET,"/hindi");
		//Get Status Line from Response
		String rsl=res.getStatusLine();
		System.out.println("Status line is:"+rsl);
		//Get Response body
		String resbody=res.getBody().asString();
		System.out.println("Response body is:"+resbody);
		String hv=res.getHeader("Content-Type");
		if(hv.contains("html"))
		{
			XmlPath hp=res.htmlPath();
			String svinres1=hp.get("html.head.title");
			System.out.println("Title value in Response is:\n"+svinres1);
			String svinres2=hp.get("html.@lang");
			System.out.println("Attribute like lang value in Response is:\n"+svinres2);
		}
	}
}
