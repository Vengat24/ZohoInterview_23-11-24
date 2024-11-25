package com.bank.view;

import java.util.Scanner;

import com.bank.dto.Customer;
import com.bank.viewmodel.BaseViewModel;

public class LogedUser {
	Customer logedCus;
	BaseViewModel viewModel ;
	public LogedUser(Customer cus,BaseViewModel viewModel) throws Exception{
		this.viewModel = viewModel;
		logedCus = cus;//1234567890ABZzabojJ
		init();
	}

	private void init() throws Exception {
		char choice; 
	 outer : while(true) {
			System.out.println("a)ATM Withdrawal\n"
			          +"b) Cash Deposit\n"
			          +"c) Account Transfer\n"
			          +"d)History\n");
			Scanner scanner = new Scanner(System.in);
			choice = scanner.next().charAt(0);
			switch(choice) {
			case 'a' : 
				viewModel.withdraw(logedCus,"Withdraw");
				break;
			case 'b':
				viewModel.deposit(logedCus);
				break;
			case 'c':
				viewModel.transfer(logedCus);
				break;
			case 'd':
				logedCus.displayTransaction();
				break;
			default :
				System.out.println("User Loged Out");
				break outer;
			}
		}
		
	
	}

}
