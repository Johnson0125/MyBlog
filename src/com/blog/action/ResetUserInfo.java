package com.blog.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.blog.dao.UserDAO;
import com.blog.po.User;
import com.opensymphony.xwork2.ActionSupport;

public class ResetUserInfo extends ActionSupport {
	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		
		User oldUser = userDAO.queryByID(username);
		String password = request.getParameter("password").trim();
		String nickname = request.getParameter("nickname").trim();
		String question = request.getParameter("question").trim();
		String answer = request.getParameter("answer").trim();
	
		
		oldUser.setPassword(password);
		oldUser.setNickname(nickname);
		oldUser.setQuestion(question);
		oldUser.setAnswer(answer);
		
		userDAO.update(oldUser);
		
		return SUCCESS;
	}
	

}
