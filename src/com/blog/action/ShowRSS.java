package com.blog.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.blog.fenye.Page;
import com.blog.fenye.Result;
import com.blog.po.Article;
import com.blog.rss.CreateRss;
import com.blog.service.ArticleService;
import com.opensymphony.xwork2.ActionSupport;

public class ShowRSS extends ActionSupport{
	private ArticleService articleService;

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	@Override
	public String execute() throws Exception {
		Page page = new Page();
		page.setCurrentPage(0);
		page.setEveryPage(7);
		
		Result result = articleService.showArticleByPage(page);
		page = result.getPage();
		List<Article> all = result.getList();
		
		String filePath = ServletActionContext.getServletContext().getRealPath("/rss.xml");
		CreateRss.publishRss(all, filePath);
		
		return SUCCESS;
	}

}
