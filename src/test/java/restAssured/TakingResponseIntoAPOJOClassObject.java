package restAssured;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TakingResponseIntoAPOJOClassObject 
{
	public static void main(String[] args) 
	{
		//Register end-point and Create HTTP Request
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employees";
		RequestSpecification req=RestAssured.given();
		//Send HTTP Request with one path parameter value
		Response res=req.request(Method.GET,"");
		//Get Status line from Response
		String rsl=res.getStatusLine();
		System.out.println("Status line is:\n"+rsl);
		//Get Response Body
		JsonPath jp=res.jsonPath();
		EmployeePOJO[] emps=jp.getObject("data",EmployeePOJO[].class);
		int i=1;
		for(EmployeePOJO e:emps)
		{
			System.out.println("Employee"+i+":");
			System.out.println("Emp id is-->"+e.id);
			System.out.println("Emp name is-->"+e.employee_name);
			System.out.println("Emp sal is-->"+e.employee_salary);
			System.out.println("Emp age is-->"+e.employee_age);
			System.out.println("Emp img is-->"+e.profile_image);
			System.out.println();
			i++;
		}
	}
}
