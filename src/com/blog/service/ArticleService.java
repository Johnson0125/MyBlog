package com.blog.service;

import java.util.List;

import com.blog.fenye.Page;
import com.blog.fenye.Result;
import com.blog.po.Article;

public interface ArticleService {
	//add an article for user
	public void addArticle(Article article);
	
	//list all article of the user
	public List<Article> showUserAllArticle(String username);
	
	//list all article of the user by page
	public Result showUserArticleByPage(String username , Page page);
	
	//list all article of all users by page
	public Result showArticleByPage(Page page);
	
	//display one of the article by its'id
	public Article showArticle(int id);
	
	//获得评论数
	public int getCritiqueCount(int AId);
	
	public void deleteArticleById(int id);
}
