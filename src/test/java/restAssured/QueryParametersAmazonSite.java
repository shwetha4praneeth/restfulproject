package restAssured;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class QueryParametersAmazonSite 
{
	public static void main(String[] args) throws Exception
	{
		//Register end point & Create HTTP Request
		RestAssured.baseURI="https://www.amazon.com/s";
		RequestSpecification req=RestAssured.given();
		//Send HTTP Request with query parameter value but without path parameter
		Response res=req.queryParam("k","apple laptop").queryParam("ref","nb_sb_noss_1").get("");
		//Get Status Line from Response
		String rsl=res.getStatusLine();
		System.out.println("Status line is:\n"+rsl);
		File f = null;
		String hv=res.getHeader("Content-Type");
		if(hv.contains("json"))
		{
			f=new File("amazonsearchjsonresponse.json");
		}
		else if(hv.contains("xml"))
		{
			f=new File("amazonsearchxmlresponse.xml");
		}
		else if(hv.contains("html"))
		{
			f=new File("amazonsearchhtmlresponse.html");
		}
		else if(hv.contains("plain"))
		{
			f=new File("amazonsearchplaintextresponse.txt");
		}
		else if(hv.contains("csv"))
		{
			f=new File("amazonsearchcsvresponse.csv");
		}
		else
		{
			System.out.println("Invalid data format as per Restful service");
		}
		FileWriter fw=new FileWriter(f);
		fw.write(res.getBody().asString());
		fw.close();
	}
}
