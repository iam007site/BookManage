package com.hsq.service;

import java.util.List;

import com.hsq.model.Book;
/*
 *author:huangshanqi
 *time  :2014-8-2下午4:44:58
 *email :hsqmobile@gmail.com
 */

public interface BookService {
	/*记得这里的接口要跟BookController中的对应,在jsp页面里的action方法调用的方法会分发到
	 * BookController中相对应的方法中，BookController调用对应的BookService接口完成
	 * 请求
	 */
	int addBook(Book book);
	List<Book> getAllBooks();
	Book findBookById(int id);
	int modifyBook(Book book);
	int deleteBookById(int id);
	

}
