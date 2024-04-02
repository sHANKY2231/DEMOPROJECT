package library;

import java.util.Scanner;

public class Normaluser extends user {
	
	public Normaluser(String name) {
		super(name);
		this.operations = new  IOOperation[] {
				new ViewBooks(),
				new Search(),
				new PlaceOrder(),
				new BorrowBook(),
				new CalculateFine(),
				new Return(),
				new Exit()
		};
	}
	public Normaluser (String name , String email, String phonenumber) {
		super(name,email,phonenumber);
		
	}
	@Override
	public void menu(Database database, User user) {
		System.out.println("1. View Books");
		System.out.println("2. Search");
		System.out.println("3. Place Order");
		System.out.println("4. Borrow Book");
		System.out.println("5. Calculate Fine");
		System.out.println("6. Return");
		System.out.println("1. Exit");
		
		Scanner s = new Scanner (System.in);
		int n =s.nextInt();
		this.operations[n-1].oper(  database,   user);
		s.close();
	}
	
	public String toString() {
		return name+"<N/>"+email+"<N/>"+phonenumber+"<N/>"+"Normal";
	}

}
