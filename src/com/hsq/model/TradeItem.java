package com.hsq.model;

/*
 *author:huangshanqi
 *time  :2014-8-3下午4:03:18
 *email :hsqmobile@gmail.com
 */

public class TradeItem {
	/*
	 * 交易项目类 
	 * 交易项目类id:tradeItemId 
	 * 商品id：productId 
	 * 购买商品数量:quantity 
	 * 所属交易id:tradeId
	 */

	private int tradeItemId;
	private int productId;
	private int quantity;
	private int tradeId;

	public TradeItem() {
		super();
	}

	public TradeItem(int tradeItemId, int productId, int quantity, int tradeId) {
		super();
		this.tradeItemId = tradeItemId;
		this.productId = productId;
		this.quantity = quantity;
		this.tradeId = tradeId;
	}

	public int getTradeItemId() {
		return tradeItemId;
	}

	public void setTradeItemId(int tradeItemId) {
		this.tradeItemId = tradeItemId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTradeId() {
		return tradeId;
	}

	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "TradeItem[tradeItemId=" + tradeItemId + ";productId=" + productId
				+ ";quantity=" + quantity + ";tradeId" + tradeId + "]";
	}

}
