package com.Employeeapi.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {

	 public static String empname() {
		 
		 String generatedString =RandomStringUtils.randomAlphabetic(1);
		 return ("Raje"+generatedString);
		 
	 }
	 
	 public static String empSal() {
		 
		 String generatedString = RandomStringUtils.random(5);
		 return(generatedString);	 
		
		 
	 }
	
	 public static String empAge() {
		 
		 String generatedString = RandomStringUtils.random(2);
		 return(generatedString);
		 
	 }
	
	 
	
	
}
