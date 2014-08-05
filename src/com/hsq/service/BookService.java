package com.hsq.service;


import java.util.List;

import com.hsq.model.Book;
/*
 *author:huangshanqi
 *time  :2014-8-2下午4:44:58
 *email :hsqmobile@gmail.com
 */
import com.hsq.model.page.Criteria;

public interface BookService{

	
	int addBook(Book book);
	List<Book> getAllBooks();
	Book findBookById(int id);
	int modifyBook(Book book);
	int deleteBookById(int id);
	
	
	int getTotalBookNumber(Criteria criteria);//得到查询条件的所有书的数目
	List<Book> getBooksByCriteria(Criteria criteria,int pageSize);//根据查询条件返回分页结果

}
