package com.blog.dao;

import java.util.Date;
import java.util.List;

import com.blog.po.Dianjiliang;

public interface DianjiliangDAO {
	//return the list which belongs to the id , ip , time
	public List queryByAId(int AId, String IP, Date time);
	
	//add 点击记录
	public void addJilu(Dianjiliang dianjilinag);

}
