package com.blog.action;



import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.blog.dao.UserDAO;
import com.blog.po.User;
import com.blog.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPassword extends ActionSupport{
	private UserService userService;
	private UserDAO userDAO;
	private String oldPassword;
	private String password;
	private String repassword;
	private String question;
	private String answer;
	
	
	
	

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

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
		//根据已登录用户的用户名
		Map session = ActionContext.getContext().getSession();
		String username = (String) session.get("username");
		
		User oldUser = userDAO.queryByID(username);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		//获取页面参数
		String oldPassword = request.getParameter("oldPassword").trim();
		//校验密码
		if(!oldPassword.equals(oldUser.getPassword())) {
			request.setAttribute("url", "resetPassword.jsp");
			request.setAttribute("info", "密码验证不成功");
			return ERROR;
		}
		
		String password = request.getParameter("password").trim();
		String repassword = request.getParameter("repassword").trim();
		if(!password.equals(repassword)) {
			request.setAttribute("url", "resetPassword.jsp");
			request.setAttribute("info", "两次输入的新密码不一致");
			return INPUT;
		}
		
		String question = request.getParameter("question").trim();
		String answer = request.getParameter("answer").trim();
		if(question.equals(oldUser.getQuestion())) {
			
			if(answer.equals(oldUser.getAnswer())) {
				request.setAttribute("url", "showUserAllArticle.jsp");
				request.setAttribute("info", "恭喜！密码修改成功");
				
				oldUser.setPassword(password);
				
				userService.ResetPassword(oldUser);
				return SUCCESS;
			} else {
				request.setAttribute("url", "resetPassword.jsp");
				request.setAttribute("info", "密保问题的答案不正确");
				return ERROR;
			}
		} else {
			request.setAttribute("url", "resetPassword.jsp");
			request.setAttribute("info", "密保保护问题不正确");
			return ERROR;
		}
		

	}
	
	

}
