package com.blog.service;

import com.blog.fenye.Page;
import com.blog.fenye.Result;
import com.blog.po.User;

public interface UserService {
	//user register
	public boolean registerUser(User user);
	
	//user login
	public boolean loginUser(User user);
	
	public boolean ResetPassword(User user);
	
	public boolean deleteUser(User user);
	
	public Result showUserByPage(Page page);
}
