package com.blog.action;

import java.util.Map;

import com.blog.po.BlogInfo;
import com.blog.service.BlogInfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GetBlogInfo extends ActionSupport {
	private BlogInfoService blogInfoService;

	public BlogInfoService getBlogInfoService() {
		return blogInfoService;
	}

	public void setBlogInfoService(BlogInfoService blogInfoService) {
		this.blogInfoService = blogInfoService;
	}

	@Override
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		String username = (String)session.get("username");
		
		BlogInfo blogInfo = blogInfoService.getBlogInfo(username);
		if(blogInfo != null) {
			session.put("blogtitle", blogInfo.getBlogtitle());
			session.put("idiograph", blogInfo.getIdiograph());
		}
		
		return SUCCESS;
	}
	
	

}
