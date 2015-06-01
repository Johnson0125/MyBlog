package com.blog.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class AdminLogin extends ActionSupport {
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		if(username != null && "admin".equals(username)) {
			
			if(password != null && "password".equals(password)) {
				request.setAttribute("info", "登录成功");
				request.setAttribute("url", "showAllArticle_Admin.action");
				return SUCCESS;
			} else {
				request.setAttribute("info", "密码/用户名不正确");
				request.setAttribute("url", "login.jsp");
				return INPUT;
			}
			
		} else {
			request.setAttribute("info", "用户名/密码不正确");
			request.setAttribute("url", "login.jsp");
			return INPUT;
		}
		//return ERROR;
	}
	
	

}
