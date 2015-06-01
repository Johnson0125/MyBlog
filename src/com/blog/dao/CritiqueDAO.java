package com.blog.dao;

import java.util.List;

import com.blog.fenye.Page;
import com.blog.po.Article;
import com.blog.po.Critique;

public interface CritiqueDAO {
	
	public void addCritique(Critique critique);
	
	//获得制定文章的评论数
	public int queryCritiqueCount(int AId);
	
	//分页显示评论
	public List<Critique> queryByPage(int AId, Page page);
	
	//删除文章时候删除评论
	public void deleteByAId(int id);
}
