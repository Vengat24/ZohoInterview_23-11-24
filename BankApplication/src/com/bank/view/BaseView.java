package com.bank.view;

import java.util.Collections;
import java.util.Scanner;

import com.bank.dto.Customer;
import com.bank.repo.Repository;
import com.bank.viewmodel.BaseViewModel;

public class BaseView {
	Repository repo = Repository.getInstance();
	BaseViewModel viewModel = new BaseViewModel();

	public void signUpCus(Scanner scanner) {
		String cusName ;
		String password = new String();
		System.out.print("Enter Your Id : ");
		cusName = scanner.next();
		do {
			System.out.print("Enter Password : ");
			password = scanner.next();
			System.out.print("Re-enter Password : ");			
		}while(!password.equals(scanner.next()));
		
		Customer cus = new Customer(cusName,password);
		repo.addCustomer(cus);
		cus.addTransaction("Opening", cus.getBalance(), cus.getBalance());
		System.out.println("User Added Successfully => Id : "+ cus.getCustId());
	}
	
	
	public void displayCustomerList() {
		for(Customer cus : repo.getCustomerList()) {
			System.out.printf("%d  %d  %s  %s  %d\n",cus.getAccNo(),cus.getCustId(),cus.getName(),cus.getPassword(),cus.getBalance());
		}
	}


	public void loginCus(Scanner scanner) throws Exception {
		int cusid ;
		String password ;
		System.out.print("Enter Your Id : ");
		cusid = scanner.nextInt();
		System.out.print("Enter Your Password : ");
		password = scanner.next();
		viewModel.checkLogin(cusid,password);
		
	}


	

}
