package com.hsq.model;

import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

/*
 *author:huangshanqi
 *time  :2014-8-3下午4:02:08
 *email :hsqmobile@gmail.com
 */

public class Trade {
	/*
	 * 交易类： 交易id:tradeId 
	 * 交易时间tradeTime 该交易用户userId 
	 * 该交易的项目集合tradeItems
	 */

	private int tradeId;
	private Date tradeTime;
	private int userId;
	private Set<TradeItem> tradeItems = new LinkedHashSet<TradeItem>();

	public Trade() {
		super();
	}

	public Trade(int tradeId, Date tradeTime, int userId,
			Set<TradeItem> tradeItems) {
		super();
		this.tradeId = tradeId;
		this.tradeTime = tradeTime;
		this.userId = userId;
		this.tradeItems = tradeItems;
	}

	public int getTradeId() {
		return tradeId;
	}

	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}

	public Date getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Set<TradeItem> getTradeItems() {
		return tradeItems;
	}

	public void setTradeItems(Set<TradeItem> tradeItems) {
		this.tradeItems = tradeItems;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Trade[treadeId=" + tradeId + ";tradeTime=" + tradeTime + ";userId="
				+ userId + "]";
	}

}
