package com.hsq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsq.dao.BookDao;
import com.hsq.model.Book;
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
	public int add(Book book) {
		// TODO Auto-generated method stub
		return bookDao.addBook(book);
	}

	@Override
	public List<Book> getAlls() {
		// TODO Auto-generated method stub
		return bookDao.getAllBooks();
	}

	@Override
	public Book findById(int id) {
		// TODO Auto-generated method stub
		return bookDao.findBookById(id);
	}

	@Override
	public int update(Book book) {
		// TODO Auto-generated method stub
		return bookDao.modifyBook(book);
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return bookDao.deleteBookById(id);
	}

}
