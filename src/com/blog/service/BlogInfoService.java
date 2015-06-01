package com.blog.service;

import com.blog.po.BlogInfo;

public interface BlogInfoService {
	
	//设置blog个性化内容
	public void setBlogInfo(BlogInfo blogInfo);
	
	//获取blog个性化内容
	public BlogInfo getBlogInfo(String username);

}
