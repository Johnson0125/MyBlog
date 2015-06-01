package com.blog.dao;

import com.blog.po.BlogInfo;

public interface BlogInfoDAO {
	//set bloginfo
	public void save(BlogInfo info);
	
	//get info
	public BlogInfo get(String username);

}
