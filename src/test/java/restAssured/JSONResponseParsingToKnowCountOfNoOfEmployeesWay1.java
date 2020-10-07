package restAssured;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JSONResponseParsingToKnowCountOfNoOfEmployeesWay1 
{
	public static void main(String[] args) 
	{
		//Register end-point of Restful webservice
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employees";
		//Define http request
		RequestSpecification req=RestAssured.given();
		//Send request to Service end-point to get Response
		Response res=req.request(Method.GET,"");
		//Parse JSON Response
		JsonPath jp=res.jsonPath();
		//Get all employee details in response
		//Way:1
		//int noe=jp.getList("data").size(); //to know count of no. of employees
		for(int i=0;i<24;i++)
		{
			System.out.println("Employee:"+(i+1));
			Map<String,String>m=jp.getMap("data["+i+"]"); //Parameterized json path
			System.out.println(m.get("id"));
			System.out.println(m.get("employee_name"));
			System.out.println(m.get("employee_salary"));
			System.out.println(m.get("employee_age"));
			System.out.println(m.get("profile_image"));
		}
	}
}
