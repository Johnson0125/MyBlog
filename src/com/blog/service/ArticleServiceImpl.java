package com.blog.service;

import java.util.List;

import com.blog.dao.ArticleDAO;
import com.blog.dao.CritiqueDAO;
import com.blog.fenye.Page;
import com.blog.fenye.PageUtil;
import com.blog.fenye.Result;
import com.blog.po.Article;

public class ArticleServiceImpl implements ArticleService {
	private ArticleDAO articleDAO;
	private CritiqueDAO critiqueDAO;

	public CritiqueDAO getCritiqueDAO() {
		return critiqueDAO;
	}

	public void setCritiqueDAO(CritiqueDAO critiqueDAO) {
		this.critiqueDAO = critiqueDAO;
	}

	public ArticleDAO getArticleDAO() {
		return articleDAO;
	}

	public void setArticleDAO(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}

	@Override
	public void addArticle(Article article) {

		articleDAO.add(article);
	}

	@Override
	public List<Article> showUserAllArticle(String username) {
		return articleDAO.queryUserAll(username);

	}

	@Override
	public Result showUserArticleByPage(String username, Page page) {
		page = PageUtil
				.createPage(page, articleDAO.queryUserAllCount(username));
		List<Article> list = articleDAO.queryByPage(username, page);

		Result result = new Result();
		result.setPage(page);
		result.setList(list);

		return result;
	}

	@Override
	public Result showArticleByPage(Page page) {
		page = PageUtil.createPage(page, articleDAO.queryAllCount());
		List<Article> list = articleDAO.queryAllByPage(page);

		Result result = new Result();
		result.setPage(page);
		result.setList(list);

		return result;
	}

	@Override
	public Article showArticle(int id) {
		return articleDAO.queryById(id);
	}

	@Override
	public int getCritiqueCount(int AId) {
		return critiqueDAO.queryCritiqueCount(AId);
	}

	@Override
	public void deleteArticleById(int id) {
		articleDAO.deleteArticleById(id);
		critiqueDAO.deleteByAId(id);
	}
	
	

}
