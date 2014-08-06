package com.hsq.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hsq.model.Book;
import com.hsq.model.page.Criteria;
import com.hsq.model.page.Page;
import com.hsq.service.BookService;

/*
 *author:huangshanqi
 *time  :2014-8-2涓嬪崍4:41:36
 *email :hsqmobile@gmail.com
*/

@Controller
public class BookController {
	/*
	 *对应Book相关jsp页面的action请求 
	 * 1：spring中的C一般起类名XXXController
	 * 在这个类里面 需要加入@controller标志这个类可以作为请求处理类   也就是 控制类
       2：这个控制类里面可以有很多方法,哪个方法用来处理用户请求，就在那个方法前面 加  @RequestMapping（“/xxxxx请求路径”）
       3;当请求处理完毕后返回值决定了该处理完毕后用户将跳转到那个页面 这个很重要 
                若在web.xml中加入bean配置
       <bean class="org.s...f....web.servlet.view.InternalResourceViewResolver">
            <property  name="prefix" value="/WEB-INF/views"/>                     前缀
           <property  name="suffix"   value=".jsp"/>                                        后缀
       </bean>
            若方法返回 return “something”
            则会跳转到/WEB-INF/views/something.jsp页面
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
    	System.out.println("RequestMapping-getAllBooks================================================");
    	
    	String pageNoStr = request.getParameter("pageNo");
    	String minPriceStr = request.getParameter("minPrice");
    	String maxPriceStr = request.getParameter("maxPrice");
    	
    	int pageNo = 1;
    	float minPrice = 0;
    	float maxPrice = Integer.MAX_VALUE;
		if (pageNoStr != null) {
<<<<<<< HEAD

			try {
				pageNo = Integer.parseInt(pageNoStr);
			} catch (NumberFormatException e) {
			}
		}

		if (minPriceStr != null) {
			try {
				minPrice = Integer.parseInt(minPriceStr);
			} catch (NumberFormatException e) {
			}
		}

		if (maxPriceStr != null) {
			try {
				pageNo = Integer.parseInt(pageNoStr);
			} catch (NumberFormatException e) {
			}
=======
			pageNo = Integer.valueOf(pageNoStr);
		}
		if (minPriceStr != null) {
			minPrice = Float.valueOf(minPriceStr);
		}
		if (maxPriceStr != null) {
			maxPrice = Float.valueOf(maxPrice);
>>>>>>> 4d6fd7a91a04edc4a384eb97a84277ad7408eb0a
		}
  
    	
		try {
			Criteria criteria = new Criteria(maxPrice, minPrice, pageNo);
			//System.out.println(criteria.toString());
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("minPrice", criteria.getMinPrice());
			params.put("maxPrice", criteria.getMaxPrice());
			params.put("pageNo", criteria.getPageNo());
			params.put("pageSize", 3);
			
			Page<Book> bookpage = new Page<>(criteria.getPageNo());
			bookpage.setPageSize(3);
			bookpage.setTotalItemNumber(bookService.getTotalBookNumber(criteria));
			//鏍￠獙pageNO
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
    
    
	
	
	

}
