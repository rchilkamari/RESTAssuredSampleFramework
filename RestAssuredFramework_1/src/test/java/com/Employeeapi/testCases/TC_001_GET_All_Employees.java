package com.Employeeapi.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC_001_GET_All_Employees extends TestBase {

	@BeforeClass

	public void getAllEmployees() {

		logger.info("**********Started TC_001_GET_AllEmployees**********");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = RestAssured.request(Method.GET, "/employees");
		logger.info("****All Employees collected*************");

	}

	@Test

	public void CheckResponseBody() {

		logger.info("*******Checking Repsponse Body***********");
		String responseBody = response.getBody().asString();
		logger.info("ResponseBody is ::" + responseBody);
		Assert.assertTrue(responseBody != null);
	}

	// Check Status code

	@Test

	public void CheckStatusCode() {

		logger.info("*********Checking Status***********");
		int Status = response.getStatusCode();
		logger.info("Status Code is::" + Status);
		Assert.assertEquals(Status, 200);

	}

	// Check Content type
	@Test

	public void checkContentType() {

		logger.info("*********Checking Content Type***********");
		String ContentType = response.header("Content-Type");
		logger.info("Content Type is:" + ContentType);
		Assert.assertEquals(ContentType, "text/html; charset=UTF-8");

	}

	@Test

	public void checkServerType() {

		logger.info("*********Checking Server Type***********");
		String serverType = response.header("Server");
		logger.info("Server Type iw::" + serverType);
		Assert.assertEquals(serverType, "nginx/1.14.1");

	}

	@Test

	public void CheckContentEncoding() {

		logger.info("*********Checking Content Encoding***********");
		String ContentEncoding = response.header("Content-Encoding");
		logger.info("ContentEncoding is::" + ContentEncoding);
		Assert.assertEquals(ContentEncoding, "gzip");

	}

	@Test

	public void CheckStatusLine() {

		logger.info("*********Checking Status Line***********");
		String Statusline = response.getStatusLine();
		logger.info("Status line is::" + Statusline);
		Assert.assertEquals(Statusline, "HTTP/1.1 200 OK");

	}
	
	@Test
	//PHPSESSID=j86ulirv4f0nb52bgqrjq4mqb4

	public void CheckContentLength() {

		logger.info("*********Checking Content Lenght***********");
		String ContentLength = response.header("Content-Length");
		logger.info("ContentLength is::" + ContentLength);
		
		if(Integer.parseInt(ContentLength)<100)
			logger.warn("Content is length is less than 100");		
		
		Assert.assertTrue(Integer.parseInt(ContentLength)<100);

	}
	
	@Test
	public void CheckCookies() {

		logger.info("*********Checking Cookies***********");
		String cookie = response.getCookie("PHPSESSID");
		//logger.info("Status line is::" + cookie);
		//Assert.assertEquals(Statusline, "HTTP/1.1 200 OK");

	}

	@Test
	
	public void ResponseTime() {
		
		
		logger.info("*****Checking Response Time*****");
		long responseTime = response.getTime();
		
		if(responseTime>2000) {
			logger.warn("Response Time is greater than 2000");			
			
		}		
		
	}
	
	@AfterClass
	
	public void teardown() {
		
		logger.info("************Finished TC_001_GET_ALL_Employees********");
		
	}
	
	
}
