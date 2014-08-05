package com.hsq.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsq.dao.BookDao;
import com.hsq.model.Book;
import com.hsq.model.page.Criteria;
import com.hsq.model.page.Page;
import com.hsq.service.BookService;

/*
 *author:huangshanqi
 *time  :2014-8-2下午4:45:22
 *email :hsqmobile@gmail.com
 */
/* BookController中汇用到bookService*/
@Service("bookService")
public class BookServiceImpl implements BookService{
	private BookDao bookDao;

	public BookDao getBookDao() {
		return bookDao;
	}
    
	/*spring 注入会用到setter方法*/
	@Autowired
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}


	@Override
	public int getTotalBookNumber(Criteria criteria) {
		// TODO Auto-generated method stub
		return bookDao.getTotalBookNumber(criteria);
	}

	@Override
	public List<Book> getBooksByCriteria(Criteria criteria, int pageSize) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("minPrice", criteria.getMinPrice());
		params.put("maxPrice", criteria.getMaxPrice());
		params.put("start", (criteria.getPageNo()-1)*pageSize);
		params.put("pageSize", 3);
		System.out.println("params"+params.toString());
		
		return bookDao.getBooksByCriteria(params);
		//return bookDao.getBooksByCriteria(criteria, pageSize);
	}

	@Override
	public int addBook(Book book) {
		// TODO Auto-generated method stub
		return bookDao.addBook(book);
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookDao.getAllBooks();
	}

	@Override
	public Book findBookById(int id) {
		// TODO Auto-generated method stub
		return bookDao.findBookById(id);
	}

	@Override
	public int modifyBook(Book book) {
		// TODO Auto-generated method stub
		return bookDao.modifyBook(book);
	}

	@Override
	public int deleteBookById(int id) {
		// TODO Auto-generated method stub
		return bookDao.deleteBookById(id);
	}		

}
