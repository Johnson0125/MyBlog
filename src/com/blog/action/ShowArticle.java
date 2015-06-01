package com.blog.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.blog.fenye.Page;
import com.blog.fenye.Result;
import com.blog.po.Article;
import com.blog.po.BlogInfo;
import com.blog.service.ArticleService;
import com.blog.service.BlogInfoService;
import com.blog.service.CritiqueService;
import com.blog.service.DianjiliangService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowArticle extends ActionSupport{
	//beacuse wo need to deal with it, so wo need DI articleService
	private ArticleService articleService;
	private int id;
	//增加点击量的业务逻辑属性
	private DianjiliangService dianjiliangService;
	
	private CritiqueService critiqueService;
	
	private int currentPage;
	
	private String username;
	
	private BlogInfoService blogInfoService;
	
	
	

	public BlogInfoService getBlogInfoService() {
		return blogInfoService;
	}



	public void setBlogInfoService(BlogInfoService blogInfoService) {
		this.blogInfoService = blogInfoService;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public int getCurrentPage() {
		return currentPage;
	}



	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}



	public CritiqueService getCritiqueService() {
		return critiqueService;
	}



	public void setCritiqueService(CritiqueService critiqueService) {
		this.critiqueService = critiqueService;
	}



	public DianjiliangService getDianjiliangService() {
		return dianjiliangService;
	}



	public void setDianjiliangService(DianjiliangService dianjiliangService) {
		this.dianjiliangService = dianjiliangService;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public ArticleService getArticleService() {
		return articleService;
	}



	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}



	@Override
	public String execute() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		//query the article 
		Article article = articleService.showArticle(id);
		
		//获取用户ip
		String IP = request.getRemoteAddr();
		
		//获取时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String stime = sdf.format(new Date());
		Date time = sdf.parse(stime);
		
		if(!dianjiliangService.isVistor(id, IP, time)){
			article.setHasread(article.getHasread() +1 );
		}
		
		
		articleService.addArticle(article);
		
		//show the critique of the article
		Page page = new Page();
		page.setCurrentPage(this.getCurrentPage());
		page.setEveryPage(5);
		
		Result result = critiqueService.showCritiqueByPage(id, page);
		request.setAttribute("page", result.getPage());
		request.setAttribute("allCri", result.getList());
		
		// add the article to request
		request.setAttribute("article", article);
		
		
		
		if(username != null || !"".equals(username)){
			
			//删除文章时候设置文章的username
			//request.setAttribute("username", username);
					
			Map session = ActionContext.getContext().getSession();
			//如果是从用户自己的首页点进查看所有文章的时候，已经存储了 userArticle变量了，这个时候就不需要继续存储那个变量了
			if( session.get("usernameArticle") != null) {
				session.put("usernameArticle", username);
			}
			
		
			//设置对应文章作者的对应的个性化标题
			BlogInfo blogInfo = blogInfoService.getBlogInfo(username);
			if(blogInfo != null) {
				session.put("blogtitle", blogInfo.getBlogtitle());
				session.put("idiograph", blogInfo.getIdiograph());
			}
		}
	
		
		return super.execute();
	}
	
	

}
