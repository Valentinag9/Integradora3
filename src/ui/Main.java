package ui;

import java.util.ArrayList;
import java.util.Scanner;
import model.ControllerB;



public class Main{

	private static Scanner reader = new Scanner(System.in);
	private static ControllerB controller;



	public Main() {
		controller = new ControllerB();
	}

	public static void main(String[] args) {

		Main ejecutable = new Main();
		ejecutable.menu();

	}
	int option1 = -1;
	public void menu(){

		System.out.println("Welcome to ReadX");

		boolean flag = false;

		while (!flag) {
			System.out.println("\n1. Register now");
			System.out.println("2. Register bibliographic products");
			System.out.println("3. Modify books");
			System.out.println("4. Modify magazines");
			System.out.println("5. Delete books ");
			System.out.println("6. Delete magazines ");
			System.out.println("7. Buy book");
			System.out.println("8. Subscribe to a magazine ");
			System.out.println("9. Reading simulation");
			System.out.println("10. Exit");
			int option = reader.nextInt();

		if (option == 10){
			System.out.println("You have exited the program");
			flag = true;
		}

		switch (option) {

			case 1: 
				registerUser();
				break;

			case 2:
				registerProducts();
				break;
			case 3:
				modifyBooks();
				break;

			case 4:
				modifyMagazines();
				break;
			case 5:
				deleteBooks();
				break;
			case 6:
				deleteMagazines();
				break;
			case 7:
				purchaseBook();
				break;
			case 8:
				purchaseMagazine();
				
				break;
			case 9: 
				readingSimulation();
				
				break;
			default: 
				System.out.println("Wrong option, try again");
				break;
			}
		}
	}


	public void registerUser(){
		System.out.println("Enter the type of user: \n1. Premium\n2. Standard");
		int optionRegister= reader.nextInt();

		System.out.println("Enter your name. Ex: Valentina");
		String nameU= reader.next();

		System.out.println("Enter your ID number");
		String cc= reader.next();

		if(controller.registerUser(nameU, cc, optionRegister)){
            System.out.println("\nHas been successfully registered\n");
        }else{
            
            System.out.println("Could not register");
        }
	}

	public void registerProducts(){
		System.out.println("Enter the type of Product: \n1. Libro \n2. Revista");
		int optionProducts= reader.nextInt();

	switch(optionProducts){
		case 1: 
			registerBook();
			break;
		case 2:
			registerMagazine();
			break;
		}

		
	}

	
	public void registerBook(){
		int readedPages= 0;
		String id= "";

		reader.nextLine();

		System.out.println("type the name");
		String name= reader.nextLine();

		System.out.println("Enter the number of pages");
		int numPages= reader.nextInt();

		System.out.println("Enter the publication date");
		System.out.println("Day");
		int dayPublish = reader.nextInt();
		System.out.println("Month");
		int monthPublish = reader.nextInt();
		System.out.println("Year");
		int yearPublish = reader.nextInt();

		

		System.out.println("Enter the URL");
		String URL = reader.next();

		reader.nextLine();

		System.out.println("Review");
		String review= reader.nextLine();

		System.out.println("Type the gender \n1.FICTION SCIENCE \n2.FANTASY \n3.HISTORICAL NOVEL");
		int genre = reader.nextInt();

		System.out.println("Price");
		double priceB= reader.nextDouble();

	

		if(controller.registerBook(   name,  numPages, dayPublish ,monthPublish,yearPublish, URL,review,genre,priceB)){
			System.out.println("\nHas been successfully registered\n");
		}else{
			
			System.out.println("Could not register");
			
		}

	}

	public void registerMagazine(){

		System.out.println("type the name");
		String name= reader.nextLine();

		System.out.println("Enter the number of pages");
		int numPages= reader.nextInt();

		System.out.println("Enter the publication date");
		System.out.println("Day");
		int dayPublish = reader.nextInt();
		System.out.println("Month");
		int monthPublish = reader.nextInt();
		System.out.println("Year");
		int yearPublish = reader.nextInt();


		System.out.println("Enter the URL");
		String URL = reader.next();

		System.out.println("Enter the category \n1.VARIETIES \n2.DESIGN \n3.SCIENTIFIC");
		int category = reader.nextInt();

		System.out.println("Value sub");
		int valueSub= reader.nextInt();

		System.out.println("Issuance period");
		String periodEmission = reader.nextLine();

		
	

		if(controller.registerMagazine(name, numPages, dayPublish ,monthPublish,yearPublish,URL,category,valueSub, periodEmission)){
			System.out.println("\nHas been successfully registered\n");
		}else{
			
			System.out.println("Could not register");
			
		}



	}

	public static void modifyBooks() {


		System.out.println("These are the books registered in the system");

		String query = controller.ListBook();

		if (query.equals("")) {

			System.out.println("There are no registered books.");
		} else {
			System.out.println(query);
			System.out.println("Write the number of the book you want to modify");
			int option = reader.nextInt();
			System.out.println("\n-MOOD EDITION-");
	
			reader.nextLine();

			System.out.println("type the name");
			String newName= reader.nextLine();
	
			System.out.println("Enter the number of pages");
			int newNumPages= reader.nextInt();
	
			System.out.println("Enter the publication date");
			System.out.println("Day");
			int newdayPublish = reader.nextInt();
			System.out.println("Month");
			int newmonthPublish = reader.nextInt();
			System.out.println("Year");
			int newyearPublish = reader.nextInt();
	
			System.out.println("Enter the URL");
			String newURL = reader.next();
	
			System.out.println("Review");
			String newReview= reader.nextLine();
	
			System.out.println("Type the gender \n1.FICTION SCIENCE \n2.FANTASY \n3.HISTORICAL NOVEL");
			int newGenre = reader.nextInt();
	
			System.out.println("Price");
			double newpriceB= reader.nextDouble();
	
			if(controller.modifyBooks(option, newName, newNumPages, newdayPublish,  newmonthPublish, newyearPublish, newURL, newReview, newGenre,   newpriceB)){
				System.out.println("-----------------------------");
				System.out.println("\nBook edited correctly");
				System.out.println("This is how it looks:");
				System.out.println(controller.ListModifyBook(option, newName, newNumPages,newdayPublish,  newmonthPublish, newyearPublish, newURL,newReview, newGenre, newpriceB));
			}else{
				System.out.println("I cannot edit the book");
			}
		}

	
	}

	public static void modifyMagazines() {


		System.out.println("These are the Magazines registered in the system");

		String query = controller.ListMagazine();

		if (query.equals("")) {

			System.out.println("There are no registered Magazines.");
		} else {
			System.out.println(query);
			System.out.println("Write the number of the magazine you want to modify");
			int optionM = reader.nextInt();
			System.out.println("\n-MOOD EDITION-");
	
			System.out.println("type the name");
			String newName= reader.nextLine();
	
			System.out.println("Enter the number of pages");
			int newNumPages= reader.nextInt();
	
			System.out.println("Enter the publication date");
			System.out.println("Day");
			int newdayPublish = reader.nextInt();
			System.out.println("Month");
			int newmonthPublish = reader.nextInt();
			System.out.println("Year");
			int newyearPublish = reader.nextInt();
	
			System.out.println("Enter the URL");
			String newURL = reader.next();
	
			System.out.println("Enter the category \n1.VARIETIES \n2.DESIGN \n3.SCIENTIFIC");
			int newcategory = reader.nextInt();
	
			System.out.println("Value sub");
			int newvalueSub= reader.nextInt();
	
			System.out.println("Issuance period");
			String newperiodEmission = reader.nextLine();
	
			if(controller.modifyMagazines(optionM, newName, newNumPages, newdayPublish,  newmonthPublish, newyearPublish, newURL, newcategory,newvalueSub, newperiodEmission)){
				System.out.println("\n-----------------------------");
				System.out.println("Book edited correctly");
				System.out.println("This is how it looks:");
				System.out.println(controller.ListModifyMagazine(optionM, newName, newNumPages,newdayPublish,  newmonthPublish, newyearPublish, newURL,newcategory,newvalueSub, newperiodEmission));
			}else{
				System.out.println("I cannot edit the book");
			}
		}

	
	}

	public static void deleteBooks(){
		System.out.println("These are the books registered in the system");

		String query = controller.ListBook();

		if (query.equals("")) {

			System.out.println("There are no registered books.");
		} else {
			System.out.println(query);
			System.out.println("Write the number of the book you want to delete");
			int bookIndex = reader.nextInt();
			if(controller.deleteBooks(bookIndex)){
			System.out.println("\n-----------------------------");
			System.out.println("Book delete correctly");

			}else{
				System.out.println("I cannot delete the book");
			}
		} 
		
		
	}

	public static void deleteMagazines(){
		System.out.println("These are the Magazines registered in the system");

		String query = controller.ListMagazine();

		if (query.equals("")) {

			System.out.println("There are no registered Magazines.");
		} else {
			System.out.println(query);
			System.out.println("Write the number of the book you want to delete");
			int magazineIndex = reader.nextInt();
			if(controller.deleteMagazines(magazineIndex)){
			System.out.println("\n-----------------------------");
			System.out.println("Magazine delete correctly");

			}else{
				System.out.println("I cannot delete the Magazine");
			}
		} 
		
		
	}

	public static void purchaseBook(){
		System.out.println("These are the Books registered in the system");

		String query = controller.ListBook();

		if (query.equals("")) {

			System.out.println("There are no registered Books.");
		} else {
			System.out.println(query);
			System.out.println("Enter the number of the book you want to buy");
			int optionBuy = reader.nextInt();

			System.out.println("Enter the type of user \n1. Premium \n2. Regular");
			int opt = reader.nextInt();

			switch(opt){
				case 1:
				System.out.println(controller.ListUserPremium());
				break;
				case 2:
				System.out.println(controller.ListUserRegular());
				break;
			}

			System.out.println("Type the user");
			int userBook = reader.nextInt();

			if(controller.purchaseBook(optionBuy, userBook-1)){
				System.out.println("The book was purchased successfully");
			}else {
				System.out.println("could not buy the book");
			}
			
		} 
	}
	public static void purchaseMagazine(){
		System.out.println("These are the Books registered in the system");

		String query = controller.ListMagazine();

		if (query.equals("")) {

			System.out.println("There are no registered Magazine.");
		} else {
			System.out.println(query);
			System.out.println("Type the number of the magazine you want to buy");
			int optionBuyM = reader.nextInt();

			System.out.println("Enter the type of user \n1. Premium \n2. Regular");
			int optM = reader.nextInt();

			switch(optM){
				case 1:
				System.out.println(controller.ListUserPremium());
				break;
				case 2:
				System.out.println(controller.ListUserRegular());
				break;
			}

			System.out.println("Type the user");
			int userMagazine = reader.nextInt();

			if(controller.purchaseBook(optionBuyM, userMagazine)){
				System.out.println("Subscribed to the magazine");
			}else {
				System.out.println("Could not subscribe to the magazine");
			}
			
			
		} 
	}

	public static void readingSimulation(){
		
			System.out.println("Enter the type of user \n1. Premium \n2. Regular");
			int opt1 = reader.nextInt();

			switch(opt1){
				case 1:

				System.out.println(controller.showUserLibraryPremium(opt1));
				break;

				case 2: 
				System.out.println(controller.ListUserRegular());
				break;
			}
			
			System.out.println("Your reading simulation has begun");
			System.out.println("Type A to go to the previous page");
			System.out.println("Type S to go to the next page");
			System.out.println("Type B to go to the library");

			String opt2 = reader.next();
			int cont= 1;

			switch(opt2){
				case "A":
					cont--;
			

					break;
				case "S":
					cont++;
				
					break;
				case "B":
					return;
				default: 
					System.out.println("Wrong option, try again");
					break;

			}
			
		}
		

	



}
