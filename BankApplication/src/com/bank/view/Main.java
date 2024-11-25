package com.bank.view;

import java.util.Scanner;

import com.bank.repo.Repository;
import com.bank.viewmodel.BaseViewModel;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static BaseViewModel viewModel = new BaseViewModel();
	static BaseView view = new BaseView();
	static Repository repo = Repository.getInstance();
	public static void main(String[] args) throws Exception {
		viewModel.init();		
		loginView();
	}
	private static void loginView() throws Exception {
		int choice;
		while(true) {
			System.out.println("1)Login\n"
							 + "2)Sign Up\n"
							 + "3)Top n Customer\n"
							 + "4)Display Customers\n"
							 + "5)Exit");
			choice = scanner.nextInt();
			switch(choice){
				case 1:
					view.loginCus(scanner);
					break;
				case 2:
					view.signUpCus(scanner);
					break;
				case 3:
					view.displayTopCus();
					break;
				case 4:
					view.displayCustomerList();
					break;
				default:
					System.out.println("Thank  You!");
					System.exit(0);
					break;
			}

			
		}
		
		
	}
	
	

}
