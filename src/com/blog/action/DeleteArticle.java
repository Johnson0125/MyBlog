package com.blog.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.blog.service.ArticleService;
import com.blog.service.CritiqueService;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteArticle extends ActionSupport {
	private ArticleService articleService;

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		// 删除相应的文章
		articleService.deleteArticleById(Integer.parseInt(id));

		return SUCCESS;
	}

}
