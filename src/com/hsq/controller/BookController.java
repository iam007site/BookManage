package com.hsq.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hsq.model.Book;
import com.hsq.model.ShoppingCart;
import com.hsq.model.ShoppingCartItem;
import com.hsq.model.page.Criteria;
import com.hsq.model.page.Page;
import com.hsq.service.BookService;
import com.hsq.web.WebUtils;

/*
 *author:huangshanqi
 *time  :2014-8-2涓嬪崍4:41:36
 *email :hsqmobile@gmail.com
*/

@Controller
public class BookController {
	/*
	 *瀵瑰簲Book鐩稿叧jsp椤甸潰鐨刟ction璇锋眰 
	 * 1锛歴pring涓殑C涓�埇璧风被鍚峏XXController
	 * 鍦ㄨ繖涓被閲岄潰 闇�鍔犲叆@controller鏍囧織杩欎釜绫诲彲浠ヤ綔涓鸿姹傚鐞嗙被   涔熷氨鏄�鎺у埗绫�
       2锛氳繖涓帶鍒剁被閲岄潰鍙互鏈夊緢澶氭柟娉�鍝釜鏂规硶鐢ㄦ潵澶勭悊鐢ㄦ埛璇锋眰锛屽氨鍦ㄩ偅涓柟娉曞墠闈�鍔� @RequestMapping锛堚�/xxxxx璇锋眰璺緞鈥濓級
       3;褰撹姹傚鐞嗗畬姣曞悗杩斿洖鍊煎喅瀹氫簡璇ュ鐞嗗畬姣曞悗鐢ㄦ埛灏嗚烦杞埌閭ｄ釜椤甸潰 杩欎釜寰堥噸瑕�
                鑻ュ湪web.xml涓姞鍏ean閰嶇疆
       <bean class="org.s...f....web.servlet.view.InternalResourceViewResolver">
            <property  name="prefix" value="/WEB-INF/views"/>                     鍓嶇紑
           <property  name="suffix"   value=".jsp"/>                                        鍚庣紑
       </bean>
            鑻ユ柟娉曡繑鍥�return 鈥渟omething鈥�
            鍒欎細璺宠浆鍒�WEB-INF/views/something.jsp椤甸潰
	 */
	private BookService bookService;

	public BookService getBookService() {
		return bookService;
	}
	
    @Autowired
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
    
    /*鍝嶅簲鏉ヨ嚜jsp椤甸潰action璇锋眰*/
    @RequestMapping("addBook")
    public String addBook(Book book,HttpServletRequest request){
    	System.out.println("RequestMapping-addBook================================================");
    	String resultPage = "result";
    	String infoMessageString = "null";
    	if(0<=bookService.addBook(book))
    	{
    		infoMessageString="鎻掑叆Book鎴愬姛";
    	}else{
    		infoMessageString = "鎻掑叆Book(澶辫触";
    	}
    	request.setAttribute("infoMessage",infoMessageString);
    	return resultPage;
    }
    
    @RequestMapping("listAll")
    public String findAllBook(HttpServletRequest request,HttpServletResponse response){
    	
    	String pageNoStr = request.getParameter("pageNo");
    	String minPriceStr = request.getParameter("minPrice");
    	String maxPriceStr = request.getParameter("maxPrice");
    	
    	System.out.println("RequestMapping-getAllBooks================================================request.getParameter(pageNo)="+pageNoStr);
    	
    	int pageNo = 1;
    	float minPrice = 0;
    	float maxPrice = Integer.MAX_VALUE;
    	
		if (pageNoStr != null) {
			try {
				pageNo = Integer.parseInt(pageNoStr);
			} catch (NumberFormatException e) {
			}
		}

		if (minPriceStr != null) {
			try {
				minPrice = Float.valueOf(minPriceStr);
			} catch (NumberFormatException e) {
			}
		}

		if (maxPriceStr != null) {
			try {
				maxPrice = Float.valueOf(maxPriceStr);
			} catch (NumberFormatException e) {}
		}
/*
			pageNo = Integer.valueOf(pageNoStr);
			System.out.println("aaaaaaaa"+pageNo);
		}else{
			System.out.println("pageNoStr == null");
		}
		if (minPriceStr != null) {
			minPrice = Float.valueOf(minPriceStr);
		}else{
			System.out.println("minPriceStr == null");
		}
		if (maxPriceStr != null) {
			maxPrice = Float.valueOf(maxPrice);

		}
  */
    	
		try {
			Criteria criteria = new Criteria(maxPrice, minPrice, pageNo);
			//System.out.println(criteria.toString());
			
			/*
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("minPrice", criteria.getMinPrice());
			params.put("maxPrice", criteria.getMaxPrice());
			params.put("pageNo", criteria.getPageNo());
			params.put("pageSize", 3);
			*/
			System.out.println(criteria);
			Page<Book> bookpage = new Page<>(criteria.getPageNo());
			bookpage.setPageSize(3);
			bookpage.setTotalItemNumber(bookService.getTotalBookNumber(criteria));
			//鏍￠獙pageNO

			criteria.setPageNo(pageNo);
			System.out.println("bookpage.getPageNo()="+criteria.getPageNo()+",bookService.getTotalBookNumber(criteria)="+bookService.getTotalBookNumber(criteria));

			criteria.setPageNo(bookpage.getPageNo());
			bookpage.setLists(bookService.getBooksByCriteria(criteria, 3));
			
			System.out.println(bookpage.getLists().size());
			
			//Page<Book> = bookService.////
			//List<Book> booklist = bookService.getAlls();
			request.setAttribute("bookpage",bookpage);
			return "listAll";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("infoMessage","鏌ヨ鍑洪敊"+e.getMessage());
			return "result";
		}
  
    }
    
    @RequestMapping("delete")
    public String delete(int id,HttpServletRequest request){
    	System.out.println("RequestMapping-delete================================================");
    	String resultPage ="listAll";
    	int rid = bookService.deleteBookById(id);
    	if(rid>0){
    		
    		//List<Book> books=bookService.getBooksByCriteria(criteria, pageSize)();
    		//request.setAttribute("booklist",books);
    		request.setAttribute("infoMessage","鍒犻櫎涔︾睄淇℃伅鎴愬姛");
			resultPage = "result";
    	}else {
			request.setAttribute("infoMessage","鍒犻櫎澶辫触");
		}
    	return resultPage;
    }
    
    @RequestMapping("modify")
    public String modify(Book book,HttpServletRequest request){
    	System.out.println("RequestMapping-modify================================================");
    	String resultPage = "listAll";
    	int uid = bookService.modifyBook(book);
    	if(uid >0){
    		//List<Book> booklist=bookService.getAlls();
    		//request.setAttribute("booklist", booklist);
    		request.setAttribute("infoMessage","淇敼涔︾睄淇℃伅鎴愬姛");
			resultPage = "result";
    	}else {
			request.setAttribute("infoMessage","淇敼涔︾睄淇℃伅鍑洪敊");
			resultPage = "result";
		}
    	return resultPage;
    }
    
    @RequestMapping("addToCart")
    public String addToCart(HttpServletRequest request,HttpServletResponse response){
    	String idString = request.getParameter("id");
    	if (idString !=null) {
			int id = Integer.valueOf(idString);
			Book book = bookService.findBookById(id);
			ShoppingCart shoppingCart=WebUtils.getShoppingCart(request);
			shoppingCart.addBook(book);
			return findAllBook(request,response);
		}else {
			String infoMessage="添加到购物车出错";
			request.setAttribute("infoMessage", infoMessage);
			return "result";
		}
    }
   

}
