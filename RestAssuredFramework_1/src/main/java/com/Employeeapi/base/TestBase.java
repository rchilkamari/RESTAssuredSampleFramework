package com.Employeeapi.base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	
	public static RequestSpecification httpRequest;
	public static Response response;
	public String empID="81545"; //Hard Code value -Input to other methods.
	
	public Logger logger;
	
	@BeforeClass
	
	public void setup() {
		
		logger = Logger.getLogger("EmployeesRestAPI");//Logger initiate
		PropertyConfigurator.configure("log4j.properties");//Logger add
		logger.setLevel(Level.DEBUG);	
		
		
	}
	
	
	
	
	

}
