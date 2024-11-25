package com.bank.viewmodel;

import java.util.Scanner;

import com.bank.dto.Customer;
import com.bank.repo.Repository;
import com.bank.view.LogedUser;


public class BaseViewModel {
	static Repository repo = Repository.getInstance();
	
	public static void init() {
		repo.customerList.add(new Customer("Kumar",10000,"ApipNbjm"));
		repo.customerList.add(new Customer("Madhu",20000,"Cboljoh"));
		repo.customerList.add(new Customer("Rahul",30000,"dbnqvt"));
		repo.customerList.add(new Customer("Robin",40000,"kbwb22"));
		for(Customer cus : repo.getCustomerList()) {
			cus.addTransaction("Opening", cus.getBalance(), cus.getBalance());
		}
	}

	public void checkLogin(int cusId, String password) throws Exception {
		for(Customer cus : repo.getCustomerList()) {
			if(cus.getCustId() ==  cusId && repo.decryptPassword(cus.getPassword()).equals(password)) {
				System.out.println("Welcome "+ cus.getName());
				new LogedUser(cus,this);
			}
		}
	}

	public int withdraw(Customer logedCus,String process) throws Exception {
		System.out.println("Enter Amount : ");
		int amount  = new Scanner(System.in).nextInt();
		int nextBalance = logedCus.getBalance() - amount;
		if(nextBalance < 1000) {
			throw new Exception("Insufficient Balance");
		}
		logedCus.setBalance(-amount);
		if(process.equals("Withdraw")) {
			logedCus.addTransaction("Withdraw", amount, nextBalance);	
			System.out.println("Amount Withdrawaled Successfully");
		}
		return amount;
		
	}

	public void deposit(Customer logedCus) {
		System.out.println("Enter Amount : ");
		int amount  = new Scanner(System.in).nextInt();
		logedCus.setBalance(amount);
		System.out.println("Amount Added Successfully");
		logedCus.addTransaction("Cash Deposit", amount, logedCus.getBalance());
	}

	public void transfer(Customer logedCus) throws Exception {
		int toAccNo;
		int amount;
		Scanner scanner = new Scanner(System.in);
		Customer toCustomer;
		do {
			System.out.print("Enter Beneficiary Account Number : ");
			toAccNo = scanner.nextInt();
			amount = withdraw(logedCus,"Transfer");
			toCustomer= repo.getCus(toAccNo);
		}while(toCustomer == null) ;	
		
		System.out.println(toCustomer.getName());
		toCustomer.setBalance(amount);
		toCustomer.addTransaction("Transfer From "+ logedCus.getAccNo(), amount, toCustomer.getBalance());
		logedCus.addTransaction("Transfer To" + toCustomer.getAccNo(), amount, logedCus.getBalance());
		System.out.println("Amount Transfered Successfully");		
		
	}

}
