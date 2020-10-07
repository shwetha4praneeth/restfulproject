package restAssured;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MatrixParameters 
{
	public static void main(String[] args) 
	{
		//Create HTTP Request with matrix parameters
		RestAssured.urlEncodingEnabled=false;
		RestAssured.baseURI="https://petstore.swagger.io/v2/pet/findByStatus;matrixParm=test";
		RequestSpecification req=RestAssured.given();
		//Send HTTP Request with HTTP method & query parameter values
		Response res=req.queryParam("offset","0").queryParam("pageSize","10").get("");
		//Analyse HTTP Response
		String rsl=res.getStatusLine();
		System.out.println("Status Line is: \n"+rsl);
		System.out.println("Headers are:");
		List<Header>hs=res.getHeaders().asList();
		for(Header h:hs)
		{
			System.out.println(h.getName()+":"+h.getValue());
		}
		String rbody=res.getBody().asString();
		System.out.println("Response Body is:\n"+rbody);
	}
}
