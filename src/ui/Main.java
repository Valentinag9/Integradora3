package ui;

import java.util.Scanner;
import model.ControllerB;



public class Main{

	private Scanner reader;
	private ControllerB controller;



	public Main() {

		reader = new Scanner(System.in);
		controller = new ControllerB();
	}

	public static void main(String[] args) {

		Main ejecutable = new Main();
		ejecutable.menu();

	}

	public void menu(){

		System.out.println("Welcome to ReadX");

		boolean flag = false;

		while (!flag) {
			System.out.println("\n1. Register now");
			System.out.println("2. Manage bibliographic products");
			System.out.println("3. ");
			System.out.println("4. ");
			System.out.println("5. ");
			System.out.println("6. Exit");
			int option = reader.nextInt();

		switch (option) {

			case 1: 
				registerUser();
				break;

			case 2:
				System.out.println("\n        Choose from the following options");
				System.out.println("\n1. Register bibliographic products");
				System.out.println("2. Modify bibliographic products");
				System.out.println("3. Idelete books and magazines");
				int option2 = reader.nextInt();
				
				break;

			case 3:
				
				break;

			case 4:
				
				break;
	
			}
    		
		
		}
	}
}
