package com.blog.service;

import java.util.List;

import com.blog.dao.UserDAO;
import com.blog.fenye.Page;
import com.blog.fenye.PageUtil;
import com.blog.fenye.Result;
import com.blog.po.Article;
import com.blog.po.User;

public class UserServiceImpl implements UserService {



	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public boolean registerUser(User user) {
		// judge the user exist?
		if (userDAO.queryByID(user.getUsername()) != null) {
			return false;
		} else {
			userDAO.add(user);
			return true;
		}
	}

	// 登录用户之前的判断
	@Override
	public boolean loginUser(User user) {
		if (userDAO.queryByID(user.getUsername()) == null) {
			return false;
		} else {
			User queryUser = userDAO.queryByID(user.getUsername());
			if (queryUser.getPassword().equals(user.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}

	//重置密码的逻辑还没写好
	@Override
	public boolean ResetPassword(User user) {
		userDAO.update(user);
		return true;
	}
	
	
	@Override
	public boolean deleteUser(User user) {
		userDAO.delete(user);
		return true;
	}

	@Override
	public Result showUserByPage(Page page) {
		page = PageUtil.createPage(page, userDAO.queryAllCount());
		List<User> list = userDAO.queryAllByPage(page);

		Result result = new Result();
		result.setPage(page);
		result.setList(list);

		return result;
		
	}
	
	

}
