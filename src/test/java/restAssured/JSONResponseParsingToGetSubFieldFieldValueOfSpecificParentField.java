package restAssured;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JSONResponseParsingToGetSubFieldFieldValueOfSpecificParentField 
{
	public static void main(String[] args) 
	{
		//Register end-point of Restful webservice
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employees";
		//Define http request
		RequestSpecification req=RestAssured.given();
		//Send request to get Response
		Response res=req.request(Method.GET,"");
		//Parse JSON Response
		JsonPath jp=res.jsonPath();
		//Get single value of a field
		String s=jp.getString("status");
		System.out.println(s);
		//Get subfield value of a specific parent field
		String en=jp.getString("data[0].employee_name");
		System.out.println(en);
		//Get subfield values of all parent fields
		List<String>nl1=jp.getList("data.employee_name"); //data[*].employee_name
		System.out.println("Count of employees is:"+nl1.size());
		System.out.println(nl1);
		//Get subfield values of given parent fields
		List<String>nl2=jp.getList("data[0,4,9].employee_name");
		System.out.println(nl2);
		//Get subfield value of last parent field
		String le=jp.getString("data[-1].employee_name"); //-2 for last but one
		System.out.println(le);
	}
}
