package com.Employeeapi.testCases;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Employeeapi.base.TestBase;
import com.Employeeapi.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.ResponseBody;

public class TC_003_POST_Employee_Record extends TestBase {
		
		
		String empName = RestUtils.empname();
		String empSal = RestUtils.empSal();
		String empAge = RestUtils.empAge();
		
	@BeforeClass
	
	public void CreateEmployee() throws InterruptedException {
		
		logger.info("**********Started TC_003_POST_Employee Record**********");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		//JSON object to  send key Value pair using put
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("name",empName);
		requestParams.put("salary", empSal);
		requestParams.put("age", empAge);
		
		//Add a Header Starting Request Body is a JSON
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParams.toString());
		response = httpRequest.request(Method.POST,"/create");
		
		System.out.println(empName);
		
		Thread.sleep(5000);			
		
	}
	
	@Test
	
	public void CheckResponseBody() {
		
		String reponseBody = response.getBody().asString();
		Assert.assertEquals(reponseBody.contains(empName), true);
		Assert.assertEquals(reponseBody.contains(empSal), true);
		Assert.assertEquals(reponseBody.contains(empAge), true);
		
		
	}
		
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
		
		/**
		 * Validate Server Type
		 * 
		 */

		public void checkServerType() {

			logger.info("*********Checking Server Type***********");
			String serverType = response.header("Server");
			logger.info("Status line is::" + serverType);
			Assert.assertEquals(serverType, "Apache");

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
	
	

}
