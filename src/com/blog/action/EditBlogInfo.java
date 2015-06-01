package com.blog.action;

import java.util.Map;

import com.blog.po.BlogInfo;
import com.blog.service.BlogInfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditBlogInfo extends ActionSupport {
	private String idiograph;
	private String blogtitle;
	private BlogInfoService blogInfoService;
	

	public BlogInfoService getBlogInfoService() {
		return blogInfoService;
	}


	public void setBlogInfoService(BlogInfoService blogInfoService) {
		this.blogInfoService = blogInfoService;
	}


	public String getIdiograph() {
		return idiograph;
	}


	public void setIdiograph(String idiograph) {
		this.idiograph = idiograph;
	}


	public String getBlogtitle() {
		return blogtitle;
	}


	public void setBlogtitle(String blogtitle) {
		this.blogtitle = blogtitle;
	}


	@Override
	public String execute() throws Exception {
//		
//		HttpServletRequest request = ServletActionContext.getRequest();
//		HttpSession session = request.getSession();
//		
//		String username = (String)session.getAttribute("username");
		
		Map session = ActionContext.getContext().getSession();
		String username = (String)session.get("username");
		
		BlogInfo blogInfo = new BlogInfo();
		//blogInfo.setUsername("chenfei");
		blogInfo.setUsername(username);
		blogInfo.setBlogtitle(blogtitle);
		blogInfo.setIdiograph(idiograph);
		
		blogInfoService.setBlogInfo(blogInfo);
		
		return SUCCESS;
	}
	

}
