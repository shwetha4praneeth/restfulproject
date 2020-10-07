package restAssured;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class XMLResponseParsingUsingXMLPathExpressions 
{
	public static void main(String[] args) 
	{
		//Specify the base URL to the Restful webservice
		RestAssured.baseURI="http://ergast.com/api/f1";
		//Get the Response
		Response res=RestAssured.given().get("/2011");
		//Take response body to parse using XmlPath expressions
		XmlPath xp=res.xmlPath();
		
		//1.Using **, findAll() with one condition on node name & size()
		int c1=xp.get("**.findAll{it.name()=='Race'}.size()");
		System.out.println("Total number of Race named nodes are:"+c1);
		
		//2.Using **, findAll() with one condition on attribute & size()
		int c2=xp.get("**.findAll{it.@season=='2011'}.size()");
		System.out.println(c2);
		
		//3.Using **, findAll() with more than one condition & size()
		int c3=xp.get("**.findAll{it.name()=='Race' && it.@season=='2011' && it.@round=='1'}.size()");
		System.out.println(c3);
		//4.Using **, findAll() & child node with size()
		int c4=xp.get("**.findAll{it.name()=='Race' && it.@season=='2011'}.RaceName.size()");
		System.out.println(c4);
		//5.Using **,findAll() nodes & get values of those nodes
		List<String>nvl=xp.get("**.findAll{it.name()=='Race' && it.@season=='2011'}");
		System.out.println(nvl);
		//6.Using **, findAll() nodes & get required attribute values of those nodes
		List<String>avl=xp.get("**.findAll{it.name()=='Race' && it.@season=='2011'}.@round");
		System.out.println(avl);
		//7.Using **, find & get that node value
		String v1=xp.getString("**.find{it.@season=='2011' && it.@round=='1'}");
		System.out.println(v1);
		//8.Using **, find & get attribute value
		String v2=xp.get("**.find{it.@season=='2011' && it.@round=='1'}.@url");
		System.out.println(v2);
		//9.Using **, find & get child node value
		String v3=xp.get("**.find{it.@season=='2011' && it.@round=='1'}.RaceName");
		System.out.println(v3);
		//10.Using **, find & get child node's attribute value
		String v4=xp.get("**.find{it.@season=='2011' && it.@round=='1'}.Circuit.@circuitId");
		System.out.println(v4);
	}
}
