package ui;

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
			System.out.println("5. Idelete books ");
			System.out.println("6. Idelete magazines ");
			System.out.println("7. Exit");
			int option = reader.nextInt();

		if (option == 7){
			System.out.println("Usted ha salido del programa");
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
	
			}
		}
	}


	public void registerUser(){
		System.out.println("Digite el tipo de usuario: \n1. Premium \n2. Estandar");
		int optionRegister= reader.nextInt();

		System.out.println("Digite su nombre");
		String nameU= reader.next();

		System.out.println("Digite su numero de cedula");
		String cc= reader.next();

		if(controller.registerUser(nameU, cc, optionRegister)){
            System.out.println("\nHas been successfully registered\n");
        }else{
            
            System.out.println("Could not register");
        }
	}

	public void registerProducts(){
		System.out.println("Digite el tipo de Producto: \n1. Libro \n2. Revista");
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

		System.out.println("Digite el nombre");
		String name= reader.next();

		System.out.println("Digite el numero de paginas");
		int numPages= reader.nextInt();

		System.out.println("Digite la fecha de publicación");
		System.out.println("Dia");
		int dayPublish = reader.nextInt();
		System.out.println("Mes");
		int monthPublish = reader.nextInt();
		System.out.println("Año");
		int yearPublish = reader.nextInt();

		

		System.out.println("Digite la URL");
		String URL = reader.next();

		System.out.println("Review");
		String review= reader.next();

		System.out.println("Digite el genero \n1.FICTION SCIENCE \n2.FANTASY \n3.HISTORICAL NOVEL");
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

		System.out.println("Digite el nombre");
		String name= reader.next();

		System.out.println("Digite el numero de paginas");
		int numPages= reader.nextInt();

		System.out.println("Digite la fecha de publicación");
		System.out.println("Dia");
		int dayPublish = reader.nextInt();
		System.out.println("Mes");
		int monthPublish = reader.nextInt();
		System.out.println("Año");
		int yearPublish = reader.nextInt();


		System.out.println("Digite la URL");
		String URL = reader.next();

		System.out.println("Digite la categoria \n1.VARIETIES \n2.DESIGN \n3.SCIENTIFIC");
		int category = reader.nextInt();

		System.out.println("Value sub");
		int valueSub= reader.nextInt();

		System.out.println("Periodo de emision");
		String periodEmission = reader.next();

		
	

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
			System.out.println("Escriba el numero del libro que desea modificar");
			int option = reader.nextInt();
			System.out.println("\n-MOOD EDITION-");
	
			System.out.println("Digite el nombre");
			String newName= reader.next();
	
			System.out.println("Digite el numero de paginas");
			int newNumPages= reader.nextInt();
	
			System.out.println("Digite la fecha de publicación");
			System.out.println("Dia");
			int newdayPublish = reader.nextInt();
			System.out.println("Mes");
			int newmonthPublish = reader.nextInt();
			System.out.println("Año");
			int newyearPublish = reader.nextInt();
	
			System.out.println("Digite la URL");
			String newURL = reader.next();
	
			System.out.println("Review");
			String newReview= reader.next();
	
			System.out.println("Digite el genero \n1.FICTION SCIENCE \n2.FANTASY \n3.HISTORICAL NOVEL");
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

		String query = controller.ListBook();

		if (query.equals("")) {

			System.out.println("There are no registered Magazines.");
		} else {
			System.out.println(query);
			System.out.println("Escriba el numero del libro que desea modificar");
			int option = reader.nextInt();
			System.out.println("\n-MOOD EDITION-");
	
			System.out.println("Digite el nombre");
			String newName= reader.next();
	
			System.out.println("Digite el numero de paginas");
			int newNumPages= reader.nextInt();
	
			System.out.println("Digite la fecha de publicación");
			System.out.println("Dia");
			int newdayPublish = reader.nextInt();
			System.out.println("Mes");
			int newmonthPublish = reader.nextInt();
			System.out.println("Año");
			int newyearPublish = reader.nextInt();
	
			System.out.println("Digite la URL");
			String newURL = reader.next();
	
			System.out.println("Digite la categoria \n1.VARIETIES \n2.DESIGN \n3.SCIENTIFIC");
			int newcategory = reader.nextInt();
	
			System.out.println("Value sub");
			int newvalueSub= reader.nextInt();
	
			System.out.println("Periodo de emision");
			String newperiodEmission = reader.next();
	
			if(controller.modifyMagazines(option, newName, newNumPages, newdayPublish,  newmonthPublish, newyearPublish, newURL, newcategory,newvalueSub, newperiodEmission)){
				System.out.println("\n-----------------------------");
				System.out.println("Book edited correctly");
				System.out.println("This is how it looks:");
				System.out.println(controller.ListModifyMagazine(option, newName, newNumPages,newdayPublish,  newmonthPublish, newyearPublish, newURL,newcategory,newvalueSub, newperiodEmission));
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
			System.out.println("Escriba el numero del libro que desea borrar");
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
			System.out.println("Escriba el numero de la revista que desea borrar");
			int magazineIndex = reader.nextInt();
			if(controller.deleteMagazines(magazineIndex)){
			System.out.println("\n-----------------------------");
			System.out.println("Magazine delete correctly");

			}else{
				System.out.println("I cannot delete the Magazine");
			}
		} 
		
		
	}



}
