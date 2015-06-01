package com.blog.dao;

import java.util.List;

import com.blog.fenye.Page;
import com.blog.po.Article;

public interface ArticleDAO {
	
	public void add(Article article);

	public List<Article> queryUserAll(String username);
	
	public int queryUserAllCount(String username);
	//查询用户的blog按照分页
	public List<Article> queryByPage(String username, Page page);

	//获取所有文章的总记录数
	public int queryAllCount();
	
	//按分页信息查询记录，这里是所有的记录
	public List<Article> queryAllByPage(Page page);
	
	//query article by its' id
	public Article queryById(int id);
	
	public void deleteArticleById(int id);

}
