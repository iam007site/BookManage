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

	public ShoppingCartItem(Book product) {
		super();
		this.product = product;
		this.quantity=1;
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
	
	//返回购物项的总钱数
	public float getItemMoney(){
		return product.getPrice()*quantity;
	}
	
	//数量加一
	public void increment(){
		quantity++;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ShoppingCartItem[product=" + product + ";quantity=" + quantity
				+ "]";
	}

}
