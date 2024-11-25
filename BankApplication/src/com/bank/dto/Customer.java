package com.bank.dto;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private static int genId = 1;
	private int transId = 1;
	private int custId;
	private int accNo;
	private String name;
	private int balance = 10000;
	private String password;
	List<Transaction> transactionList;
	
	public Customer(String name, String password) {
		custId = Integer.parseInt((genId +""+genId)); genId++;
		accNo = Integer.parseInt(custId + "0"  + custId);
		this.name = name;
		this.password = password;
		transactionList = new ArrayList<>();
	}
	public Customer(String name, int balance, String password) {
		this(name,password);
		this.balance = balance;
	}
	public int  getTransid() {
		return transId++;
	}
	
	
	class Transaction {
		private int transId;
		private String transType;
		private int amount;
		private int balance;
		
		public Transaction(String transType, int amount, int balance) {
			this.transId = getTransid();
			this.transType = transType;
			this.amount = amount;
			this.balance = balance;
		}
		public int getTransId() {
			return transId;
		}
		public void setTransId(int transId) {
			this.transId = transId;
		}
		public String getTransType() {
			return transType;
		}
		public void setTransType(String transType) {
			this.transType = transType;
		}
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
		public int getBalance() {
			return balance;
		}
		public void setBalance(int balance) {
			this.balance = balance;
		}
		
	}

	public void addTransaction(String transType, int amount, int balance) {
		transactionList.add(new Transaction(transType,amount,balance));
	}
	
	public int getCustId() {
		return custId;
	}
	public int getAccNo() {
		return accNo;
	}
	public String getName() {
		return name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance += balance;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void displayTransaction() {
		System.out.println("Account Statement");
		System.out.println("Name - " + this.getName());
		System.out.println("Account No - " + this.getAccNo());
		System.out.println("Customer id - "+ this.getCustId());
		System.out.println("TransId  TransTpye  Amount  Balance");
		for(Transaction trans : transactionList) {
			System.out.println(trans.getTransId() +" "+ trans.getTransType()+" "+trans.getAmount()+" "+trans.getBalance());
		}
	}
	

}
