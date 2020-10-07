package restAssured;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TakingResponseIntoAPOJOClass
{
	public static void main(String[] args) throws Exception
	{
		//Register end-point of Restful webservice
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employees";
		//Define http request 
		RequestSpecification req=RestAssured.given();
		//Send request to get response
		Response res=req.request(Method.GET,"");
		//Get Status Line from Response
		String rsl=res.getStatusLine();
		System.out.println("Status line is:\n"+rsl);
		//Parse Json Response Body
		JsonPath jp=res.jsonPath();
		//Get all employee details
		//Way:3 (Via deserialization using POJO class like Employee)
		List<EmployeePOJO> emps=jp.getList("data",EmployeePOJO.class);
		int i=1;
		for(EmployeePOJO e:emps)
		{
			System.out.println("Employee:"+i);
			System.out.println(e.id);
			System.out.println(e.employee_name);
			System.out.println(e.employee_salary);
			System.out.println(e.employee_age);
			System.out.println(e.profile_image);
			i=i+1;
		}
	}
}
