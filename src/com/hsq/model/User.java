package com.hsq.model;

import java.util.LinkedHashSet;
import java.util.Set;

/*
 *author:huangshanqi
 *time  :2014-8-3下午4:00:42
 *email :hsqmobile@gmail.com
 */

public class User {
	/*
	 * 用户类：用户id:userId
	 * 用户名:username
	 * 银行账户id:accountId
	 * 用户交易的集合：tradeSet
	 */

	private int userId;
	private String username;
	private int accountId;
	private Set<Trade> tradeSet = new LinkedHashSet<Trade>();

	public User() {
		super();
	}

	public User(int userId, String username, int accountId, Set<Trade> tradeSet) {
		super();
		this.userId = userId;
		this.username = username;
		this.accountId = accountId;
		this.tradeSet = tradeSet;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public Set<Trade> getTradeSet() {
		return tradeSet;
	}

	public void setTradeSet(Set<Trade> tradeSet) {
		this.tradeSet = tradeSet;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "User[userId=" + userId + ";username=" + username + ";accountId="
				+ accountId + "]";
	}
}