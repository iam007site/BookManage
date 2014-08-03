package com.hsq.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hsq.model.Book;
import com.hsq.service.BookService;

/*
 *author:huangshanqi
 *time  :2014-8-2下午4:41:36
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
    
    /*响应来自jsp页面action请求*/
    @RequestMapping("addBook")
    public String addBook(Book book,HttpServletRequest request){
    	System.out.println("RequestMapping-addBook================================================");
    	String resultPage = "result";
    	String infoMessageString = "null";
    	if(0<=bookService.addBook(book))
    	{
    		infoMessageString="插入Book成功";
    	}else{
    		infoMessageString = "插入Book(失败";
    	}
    	request.setAttribute("infoMessage",infoMessageString);
    	return resultPage;
    }
    
    @RequestMapping("listAll")
    public String findAllBook(HttpServletRequest request){
    	System.out.println("RequestMapping-getAllBooks================================================");
    	
		try {
			List<Book> booklist = bookService.getAllBooks();
			request.setAttribute("booklist",booklist);
			return "listAll";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("infoMessage","查询出错"+e.getMessage());
			return "result";
		}
  
    }
    
    @RequestMapping("delete")
    public String delete(int id,HttpServletRequest request){
    	System.out.println("RequestMapping-delete================================================");
    	String resultPage ="listAll";
    	int rid = bookService.deleteBookById(id);
    	if(rid>0){
    		List<Book> books=bookService.getAllBooks();
    		request.setAttribute("booklist",books);
    	}else {
			request.setAttribute("infoMessage","删除失败");
		}
    	return resultPage;
    }
    
    @RequestMapping("modify")
    public String modify(Book book,HttpServletRequest request){
    	System.out.println("RequestMapping-modify================================================");
    	String resultPage = "listAll";
    	int uid = bookService.modifyBook(book);
    	if(uid >0){
    		List<Book> booklist=bookService.getAllBooks();
    		request.setAttribute("booklist", booklist);
    	}else {
			request.setAttribute("infoMessage","修改书籍信息出错");
			resultPage = "result";
		}
    	return resultPage;
    }
    
    
	
	
	

}
