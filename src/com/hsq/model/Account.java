package com.hsq.model;

/*
 *author:huangshanqi
 *time  :2014-8-3下午4:00:30
 *email :hsqmobile@gmail.com
 */

public class Account {
	/*
	 * 账户类 
	 * 账户id:accountId 
	 * 账户余额:balance
	 */
	private int accountId;
	private float balance;

	public Account() {
		super();
	}

	public Account(int accountId, float balance) {
		super();
		this.accountId = accountId;
		this.balance = balance;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Account[accountId="+accountId+";balance="+balance+"]";
	}
}
