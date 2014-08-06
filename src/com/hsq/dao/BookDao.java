package com.hsq.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hsq.model.Book;
import com.hsq.model.page.Criteria;
/*
 *author:huangshanqi
 *time  :2014-8-2下午11:50:44
 *email :hsqmobile@gmail.com
 */
import com.hsq.model.page.Page;

public interface BookDao {
	/*
	 * 数据库的增删改查操作
	 * 这里一个接口名字跟mapper包中的BookDaoMapper.xml方法名要对应起来
	 * 实际实现的就是xml中的sql语句
	 * 一个dao对应一个mapper.xml，这在spring-mybatis.xml中做了对应
	 */
	
	//通过Mybatis的注解方式传入多个参数
	//List<Book> getBooksByCriteria(@Param(value = "minPrice") String criteria,@Param(value = "pageSize") int pageSize);
	List<Book> getBooksByCriteria(Map<String, Object> map);

	List<Book> getAllBooks();
	int addBook(Book book);
	Book findBookById(int id);
	int deleteBookById(int id);
	int modifyBook(Book book);
	//Page<Book> getPage(Criteria criteria);
	int getTotalBookNumber(Criteria criteria);//根据价格区间计算所有书的数量
	

}
