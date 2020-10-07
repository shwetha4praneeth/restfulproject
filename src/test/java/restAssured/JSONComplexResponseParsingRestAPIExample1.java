package restAssured;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class JSONComplexResponseParsingRestAPIExample1 
{
	public static void main(String[] args) 
	{
		//Register end-point & create HTTP request
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employees";
		RequestSpecification req=RestAssured.given();
		

	}
}
