package com.bank.repo;

import java.util.ArrayList;
import java.util.List;

import com.bank.dto.Customer;

public class Repository {
	
	public List<Customer> customerList;
	static Repository repo;
	private Repository(){
		customerList = new ArrayList<>();
	}

	public static Repository getInstance() {
		if(repo == null) repo = new Repository();
		return repo;
	}

	public void addCustomer(Customer cus) {
		cus.setPassword(encryptPassword(cus));
		customerList.add(cus);	
	}

	
	public List<Customer> getCustomerList() {
		return customerList;
	}
	
	private String encryptPassword(Customer cus) {
		char password[] = cus.getPassword().toCharArray();
		for(int i=0;i<password.length;i++) {
			char currentChar = password[i];
			if((currentChar >='A' && currentChar <= 'Z' )) {
				currentChar = (char) (currentChar % 'Z' == 0? 64 : currentChar % 'Z');
				currentChar++;
			}else if( (currentChar >= 'a' && currentChar <= 'z')) {
				currentChar = (char) (currentChar % 'z'  == 0? 96 : currentChar % 'z');
				currentChar++;
			}else {
				if(currentChar != '0') {
					currentChar = (char) (currentChar % '9'  == 0? 47 : currentChar % '9');					
				}
				currentChar++;
			}
			password[i] = currentChar;
		
		}
		return new String( password);
	}

	public String decryptPassword(String pass) {
		char password[] = pass.toCharArray();
		for(int i=0;i<password.length;i++) {
			char currentChar = password[i];
			if((currentChar >='A' && currentChar <= 'Z' )) {
				currentChar = (char) (currentChar % 'A' == 0? 91 : currentChar % 'Z');
				currentChar--;
			}else if( (currentChar >= 'a' && currentChar <= 'z')) {
				currentChar = (char) (currentChar % 'a'  == 0? 123 : currentChar % 'z');
				currentChar--;
			}else {
				currentChar = (char) (currentChar % '0'  == 0? 58 : currentChar % '9');
				currentChar--;
			}
			password[i] = currentChar;
		
		}
		return new String( password);
		
	}

	public Customer getCus(int toAccNo) {
		for(Customer cus : customerList) {
			if(cus.getAccNo() == toAccNo) {
				return cus;
			}
		}
		return null;
		
	}


}
