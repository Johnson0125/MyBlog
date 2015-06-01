package com.blog.service;

import java.util.Date;

public interface DianjiliangService {
	//判断是否已经点击过了
	public boolean isVistor(int AId , String IP , Date time);
}
