package com.hsq.web;

import javax.servlet.http.HttpServletRequest;

import com.hsq.model.ShoppingCart;
/*
 *author:huangshanqi
 *time  :2014-8-3下午11:12:13
 *email :hsqmobile@gmail.com
 */

public class WebUtils {
	/*
	 * 关于web的工具类
	 */
	
	//获取购物车的session
	public static  ShoppingCart getShoppingCart(HttpServletRequest request){
		ShoppingCart shoppingCart=(ShoppingCart) request.getSession().getAttribute("ShoppingCart");
		if (null == shoppingCart) {
		   shoppingCart = new ShoppingCart();
		   request.getSession().setAttribute("ShoppingCart", shoppingCart);
		}
		return shoppingCart;
		
	}

}
