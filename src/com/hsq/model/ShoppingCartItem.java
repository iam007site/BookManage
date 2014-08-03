package com.hsq.model;

/*
 *author:huangshanqi
 *time  :2014-8-3下午4:03:49
 *email :hsqmobile@gmail.com
 */

public class ShoppingCartItem {
	/*
	 * 购物车项目类 
	 * 商品：product,这里为Book 
	 * 数量：quantity
	 */

	private Book product;
	private int quantity;

	public ShoppingCartItem() {
		super();
	}

	public ShoppingCartItem(Book product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	public Book getProduct() {
		return product;
	}

	public void setProduct(Book product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ShoppingCartItem[product=" + product + ";quantity=" + quantity
				+ "]";
	}

}
