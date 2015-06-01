package com.blog.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.blog.fenye.Page;
import com.blog.fenye.Result;
import com.blog.po.User;
import com.blog.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class ShowUser extends ActionSupport {
	
	private UserService userService;
	private int currentPage;
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	@Override
	public String execute() throws Exception {
		Page page = new Page();
		page.setCurrentPage(this.getCurrentPage());
		page.setEveryPage(7);
		
		Result result = userService.showUserByPage(page);
		page = result.getPage();
		List<User> all = result.getList();
		//System.out.println(all.size());
		//System.out.println(all);
		//for(User user : all) {
		//	System.out.println(user.getUsername());
		//}
	
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("userList", all);
		request.setAttribute("pageList", page);
		return SUCCESS;
	}
	
	

}
