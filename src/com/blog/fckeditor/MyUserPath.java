package com.blog.fckeditor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.fckeditor.requestcycle.UserPathBuilder;

public class MyUserPath implements UserPathBuilder {

	@Override
	public String getUserFilesPath(HttpServletRequest request) {
		//返回一个路径，用户的file
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		return "/userfiles/" + username;
		
	}

}
