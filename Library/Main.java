package Library;

import java.util.Scanner;

import library.Admin;
import library.Normaluser;
import library.database;
import library.user;

public class Main {
	static Scanner s;
	static Database database;

	public static void main(String[] args) {
	database = new database();
	System.out.println("welcome to library management system!");
	
		     int num;
 
			 System.out.println( "0. Exit\n1. Login\n2. New user");
			 s = new Scanner(System.in);
			 num  = s.nextInt();
				
				switch (num) {
				    case 1: login(); break;
				    case 2: newuser();break;
				     
		}
	 
	}
 
	private static void login() {
		System.out.println("Enter phone number:");
		String phonenumber = s.next();
		System.out.println("Enter email:");
		String email = s.next(); 
		int n = database.login(phonenumber , email);
		if ( n != -1) {
			user user = database.getUser(n);
			 user.menu(  database,  user);
		}else {
			System.out.println("user dosent exist");
			 
		}
	}
	private static void newuser() {
		System.out.println("Enter  name:");
		String  name = s.next();
		if (database.userExist(name)) {
			System.out.println("User exists!");
			newuser();
		}
		System.out.println("Enter phone number:");
		String phonenumber = s.next();
		System.out.println("Enter email:");
		String  email = s.next();
		System.out.println("1. Admin\n2. Normal user");
		int n2 = s.nextInt();
		user user;
		if (n2==1) {
			  user = new Admin(name,email,phonenumber);
			 
		} else {
		  user = new Normaluser(name,email,phonenumber);
		 
			
		}
		database.AddUser(user);
	 user.menu(database,user);
	}
}

