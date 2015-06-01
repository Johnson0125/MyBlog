package com.blog.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.blog.dao.UserDAO;
import com.blog.po.User;
import com.blog.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteUser extends ActionSupport {
	private UserService userService;
	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");

		User user = userDAO.queryByID(username);
		userService.deleteUser(user);
		return SUCCESS;
	}

}
