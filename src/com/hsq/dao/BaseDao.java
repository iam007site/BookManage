package com.hsq.dao;

import java.util.List;

import com.hsq.model.page.Criteria;
import com.hsq.model.page.Page;
/*
 *author:huangshanqi
 *time  :2014-8-3下午6:21:42
 *email :hsqmobile@gmail.com
 */

public interface BaseDao<T>{
	/*
	 * 数据库的增删改查操作
	 * 这里一个接口名字跟mapper包中的BookDaoMapper.xml方法名要对应起来
	 * 实际实现的就是xml中的sql语句
	 * 一个dao对应一个mapper.xml，这在spring-mybatis.xml中做了对应
	 */
	int add(T t);                        //增
	int deleteById(int id);              //删
	int update(T t);                     //改
	List<T> getAlls();                   //查
	T findById(int id);                  //查
	Page<T> getPage(Criteria criteria);   //查

}
