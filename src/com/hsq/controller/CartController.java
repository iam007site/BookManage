package com.hsq.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hsq.model.ShoppingCart;
import com.hsq.model.ShoppingCartItem;
import com.hsq.web.WebUtils;

/*
 *author:huangshanqi
 *time  :2014-8-3下午7:49:08
 *email :hsqmobile@gmail.com
 */
@Controller
public class CartController {
	/*
	 * 有关购物车的控制器
	 */
	
	@RequestMapping("listCarts")
	public String listCarts(HttpServletRequest request){
		ShoppingCart shoppingCart = WebUtils.getShoppingCart(request);
		Collection<ShoppingCartItem> shoppingCartItems=shoppingCart.getShoppingCartItems();
		request.setAttribute("shoppingCartItems", shoppingCartItems);
		return "cart";
	}
	

}
