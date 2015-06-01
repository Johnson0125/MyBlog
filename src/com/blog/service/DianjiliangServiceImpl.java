package com.blog.service;

import java.util.Date;

import com.blog.dao.DianjiliangDAO;
import com.blog.po.Dianjiliang;

public class DianjiliangServiceImpl implements DianjiliangService {
	private DianjiliangDAO djlDAO;
	
	

	public DianjiliangDAO getDjlDAO() {
		return djlDAO;
	}



	public void setDjlDAO(DianjiliangDAO djlDAO) {
		this.djlDAO = djlDAO;
	}



	@Override
	public boolean isVistor(int AId, String IP, Date time) {
		if(djlDAO.queryByAId(AId, IP, time).size() != 0) {
			//表示用户确实点击过了
			return true;
		} else{
			Dianjiliang djl = new Dianjiliang();
			djl.setAId(AId);
			djl.setIp(IP);
			djl.setTime(time);
			
			//save it
			djlDAO.addJilu(djl);
			return false;
		}
		
	}

}
