package restAssured;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JSONResponseParsingToKnowCountOfNoOfEmployeesWay2WithExtraCondition 
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
		//Way:2 With Extra Condition
		List<Map<String,String>>ml=jp.getList("data");
		for(int i=0;i<ml.size();i++) //on list of maps
		{
			if(Integer.parseInt(ml.get(i).get("employee_salary"))<100000&&ml.get(i).get("employee_name").startsWith("A"))
			{
				System.out.println(ml.get(i).get("id"));
				System.out.println(ml.get(i).get("employee_name"));
			}
		}
	}
}
