package restAssured;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class XMLResponseParsing 
{
	public static void main(String[] args) 
	{
		//Register end point & Create HTTP Request
		RestAssured.baseURI="http://ergast.com/api/f1/2008";
		RequestSpecification req=RestAssured.given();
		//Send HTTP request with one path parameter value & get HTTP response
		Response res=req.request(Method.GET,"/9");
		//Get Status Line from Response
		String rsl=res.getStatusLine();
		System.out.println("Status line is:"+rsl);
		//Get Response body
		String resbody=res.getBody().asString();
		System.out.println("Response body is:"+resbody);
		String hv=res.getHeader("Content-Type");
		if(hv.contains("xml"))
		{
			XmlPath xp=res.xmlPath();
			String svinres1=xp.getString("MRData.RaceTable.Race.Circuit.Location.Country");
			System.out.println("Node like Country value in Response is:\n"+svinres1);
			String svinres2=xp.getString("MRData.RaceTable.Race.Circuit.Location.@long");
			System.out.println("Attribute like longitude value in Response is:\n"+svinres2);
			String svinres3=xp.getString("MRData.@series");
			System.out.println("Attribute like series value in Response is:\n"+svinres3);
		}
	}
}
