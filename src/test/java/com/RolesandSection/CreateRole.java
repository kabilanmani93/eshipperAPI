package com.RolesandSection;

import static io.restassured.RestAssured.*;
import static io.restassured.authentication.FormAuthConfig.springSecurity;
import static org.hamcrest.Matchers.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.filter.session.SessionFilter;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyData;
import io.restassured.specification.RequestSpecification;



public class CreateRole {
	
	//private static final String JSON = "application/json";

	private class SessionData {
	    private String csrf;
	    private String session;
	}
	
	
	@Test(priority=1)
	public void createRole() throws FileNotFoundException
	{
		RestAssured.baseURI = "https://dev.eshipper.com";
		RestAssured.port = 8080;
		RestAssured.basePath = "/api";
		
		String userName = "admin";
		String userPassword = "admin";
		
		SessionFilter sessionFilter = new SessionFilter();
		
		Response getLoginResponse =
		        given().
		            filter(sessionFilter).
		        when().
		            get("/login.html").
		        then().
		            extract().response();
		
		 String token = getLoginResponse.header("XSRF-TOKEN");
		
		
		
	    Response response=
	    		
			given().
				//auth().form(userName,userPassword,new FormAuthConfig("/authentication", "j_username", "j_password").withAutoDetectionOfCsrf()).
				auth().form(userName,userPassword,springSecurity()).
	        	filter(sessionFilter).	
			when().
				post("/authentication").			   
		    then().
		    	assertThat().statusCode(200).		       
		     and().
		     	extract().response();

		
		System.out.println("Response Body is: " +response );
		


	}

	}


