package com.hsq.service;

import java.util.List;

import com.hsq.model.page.Criteria;
import com.hsq.model.page.Page;
/*
 *author:huangshanqi
 *time  :2014-8-3下午6:32:10
 *email :hsqmobile@gmail.com
 */

public interface BaseService<T> {
	/*记得这里的接口要跟BookController中的对应,在jsp页面里的action方法调用的方法会分发到
	 * BookController中相对应的方法中，BookController调用对应的BookService接口完成
	 * 请求
	 */
	int add(T t);                        //增
	int deleteById(int id);              //删
	int update(T t);                     //改
	List<T> getAlls();                   //查
	T findById(int id);                  //查
	Page<T> getPage(Criteria criteria);    //查

}
