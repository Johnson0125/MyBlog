package com.blog.dao;

import java.util.List;

import com.blog.fenye.Page;
import com.blog.po.Article;
import com.blog.po.User;

public interface UserDAO {
	//add a user
	public void add(User user);
	
	//delete a user
	public void delete(User user);
	
	//update a user
	public void update(User user);
	
	//query all
	public List queryAll();
	
	//query by id
	public User queryByID(String username);
	
	
	public int queryAllCount();
	
	//按分页信息查询记录，这里是所有的记录
	public List<User> queryAllByPage(Page page);

}
