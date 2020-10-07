package restAssured;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JSONResponseParsingToGetOneChildFieldValue 
{
	public static void main(String[] args) 
	{
		//Register end-point of Restful webservice
		RestAssured.baseURI="https://restcountries.eu/rest/v2/name";
		//Define http request
		RequestSpecification req=RestAssured.given();
		//Send request to get Response
		Response res=req.queryParam("fullText","true").get("/India");
		//Get & display response
		System.out.println("Response body is:\n"+res.getBody().asString());
		//Parse JSON Response
		JsonPath jp=res.jsonPath();
		//Get single value of a field
		String cap=jp.getString("capital");
		System.out.println("Capital is:"+cap);
		//Get array of values of a field
		List<String>bl=jp.getList("borders");
		System.out.println("Borders of India are:"+bl);
		//Get one child field value of a parent field
		String cn=jp.getString("currencies.name");
		System.out.println("Currencies are:"+cn);
		//Get all child field values of a parent field
		List<String>ll=jp.getList("languages.name");
		System.out.println("Languages are:"+ll);
	}
}
