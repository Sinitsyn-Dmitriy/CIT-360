package org.studyeasy.hibernate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class View {
	
	String username;
	String password;
	String firstname;
	String lastname;

	public String username() {
		
		System.out.println("Please input username");
		Scanner myVar = new Scanner(System.in);

		username = myVar.nextLine();
		//myVar.close();
		return username;

	}
	
	public String password() {
		
		System.out.println("Please input password");
		Scanner myVar = new Scanner(System.in);
	    
		password = myVar.nextLine();
		//myVar.close();
	    return password;
	}
	
	public String firstname() {
		
		System.out.println("Please input first name");
		Scanner myVar = new Scanner(System.in);
  
		firstname = myVar.nextLine();
		//myVar.close();
	    return firstname;
	}
	
	public String lastname() {
		
		System.out.println("Please input last name");
		Scanner myVar = new Scanner(System.in);
 
		lastname = myVar.nextLine();
		//myVar.close();
	    return lastname;
	   
	}
	
	public void end(String username, String password, String firstname, String lastname) {
		
		System.out.println("We added new data to DataBase");
		System.out.println(username + " - your username, " + password + " - your password, " + firstname + 
				" - your firstname, " + lastname + " - your lastname.");

	}

}
