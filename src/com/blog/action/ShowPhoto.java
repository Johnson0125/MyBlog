package com.blog.action;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ShowPhoto extends ActionSupport{

	@Override
	public String execute() throws Exception {
		Map session = ServletActionContext.getContext().getSession();
		String username = (String) session.get("username");
		
		//创建 文件保存目录
		String photoPath = ServletActionContext.getServletContext().getRealPath("/user/photo/" + username);
		
		
		File filePhotoPath = new File(photoPath);
		String[] photoList = filePhotoPath.list();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("photoList", photoList);
		return SUCCESS;
	}
	
}
