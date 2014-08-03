package com.hsq.model;

import java.util.LinkedHashSet;
import java.util.Set;

/*
 *author:huangshanqi
 *time  :2014-8-3下午4:03:36
 *email :hsqmobile@gmail.com
 */

public class ShoppingCart {
	/*
	 * 购物车类
	 * 购物项的集合：shoppingCartItems
	 */
	private Set<ShoppingCartItem> shoppingCartItems = new LinkedHashSet<ShoppingCartItem>();

	public ShoppingCart() {
		super();
	}

	public ShoppingCart(Set<ShoppingCartItem> shoppingCartItems) {
		super();
		this.shoppingCartItems = shoppingCartItems;
	}

	public Set<ShoppingCartItem> getShoppingCartItems() {
		return shoppingCartItems;
	}

	public void setShoppingCartItems(Set<ShoppingCartItem> shoppingCartItems) {
		this.shoppingCartItems = shoppingCartItems;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ShoppingCart[shoppingCartItems=" + shoppingCartItems + "]";
	}

}
