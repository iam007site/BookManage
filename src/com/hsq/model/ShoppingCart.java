package com.hsq.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
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
	private Map<Integer, ShoppingCartItem> bookMap=new HashMap<>();
	
	//更新购物车里商品数量
	public void updateShoppingCartItem(int id,int quantity){
		ShoppingCartItem shoppingCartItem= bookMap.get(id);
		if (shoppingCartItem!=null) {
			shoppingCartItem.setQuantity(quantity);
		}
	}
	
	public Map<Integer, ShoppingCartItem> getBookMap() {
		return bookMap;
	}

	public void setBookMap(Map<Integer, ShoppingCartItem> bookMap) {
		this.bookMap = bookMap;
	}

	//移除购物车里的选项
	public void removeShoppingCartItem(int id){
		bookMap.remove(id);
	}
	
	//清空购物车
	public void clearShoppingCart(){
		bookMap.clear();
	}
	
	//购物车是否为空
	public boolean isEmpty(){
		return bookMap.isEmpty();
	}
	
	public float getTotalMoney(){
		float total=0;
		for (int id:bookMap.keySet()) {
			
		}
		return total;
	}
	
	//得到所有的ShoppingCartItems
    public Collection<ShoppingCartItem> getShoppingCartItems(){
    	return bookMap.values();
    }
    
    //得到所有书的总数
    public int getTotalBookNumber(){
    	int total=0;
    	for (ShoppingCartItem shoppingCartItem:bookMap.values()) {
			total+=shoppingCartItem.getQuantity();
		}
    	return total;
    }
    
    //是否包含书目
    public boolean isHasBook(int id){
    	return bookMap.containsKey(id);
    }
    
    public void addBook(Book book){
    	ShoppingCartItem shoppingCartItem = bookMap.get(book.getId());
    	if (shoppingCartItem == null) {
			shoppingCartItem = new ShoppingCartItem(book);
			bookMap.put(book.getId(), shoppingCartItem);
		}else {
			shoppingCartItem.increment();
		}
    }
	
	/*
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
	*/

}
