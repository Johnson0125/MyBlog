package com.blog.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.blog.fenye.Page;
import com.blog.po.Article;
import com.blog.po.User;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {

	@Override
	public void add(User user) {
		this.getHibernateTemplate().saveOrUpdate(user);
	}

	@Override
	public void delete(User user) {
		this.getHibernateTemplate().delete(user);
	}

	//更改用户密码
	@Override
	public void update(User user) {
		this.getHibernateTemplate().update(user);
	}

	@Override
	public List queryAll() {
		return null;
	}

	@Override
	public User queryByID(String username) {
		List list = this.getHibernateTemplate().find("select user from User user where user.username = '" +username +"'");
		if(list.size() == 0) {
			return null;
		}
		else{
			return (User)list.get(0);
		}
	}

	@Override
	public int queryAllCount() {
		List find = this.getHibernateTemplate().find("select count(*) from User");
		
		return ((Long)find.get(0)).intValue();	
	}

	@Override
	public List<User> queryAllByPage(final Page page) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException , SQLException{
				Query query = session.createQuery("select user from User user");
			
				//设置每页显示多少个，设置多大结果。
				query.setMaxResults(page.getEveryPage());
				//设置起点
				query.setFirstResult(page.getBeginIndex());
				return query.list();
			}

		
		});
	}

	
}
