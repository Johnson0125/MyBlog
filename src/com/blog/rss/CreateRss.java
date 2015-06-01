package com.blog.rss;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.blog.po.Article;

public class CreateRss {

	public static void publishRss(List<Article> list, String filePath) {
		// 想文件中写内容
		try {
			// 文件输出流
			FileWriter fw = new FileWriter(filePath);
			// 缓冲流
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n");
			// bw.write("<!DOCTYPE feed [<!ENTITY nbsp   \"&#160;\">]>\r\n");
			// bw.write("<feed xmlns=\"http://www.w3.org/2005/Atom\">\r\n");

			bw.write("<rss version=\"2.0\" xmlns:atom=\"http://www.w3.org/2005/Atom\"\r\n");
			bw.write("xmlns:cf=\"http://www.microsoft.com/schemas/rss/core/2005\"\r\n");
			bw.write("xmlns:dc=\"http://purl.org/dc/elements/1.1/\"\r\n");
			bw.write("xmlns:trackback=\"http://madskills.com/public/xml/rss/module/trackback/\"\r\n");
			bw.write("xmlns:wfw=\"http://wellformedweb.org/CommentAPI/\"\r\n");
			bw.write("xmlns:slash=\"http://purl.org/rss/1.0/modules/slash/\">\r\n");

			bw.write("<channel>\r\n");
			bw.write("<title>博客网</title>\r\n");
			bw.write("<link>http://localhost:8080/MyBlog/login.jsp</link>\r\n");
			bw.write("<description>张森的毕设</description>\r\n");

			for (Article art : list) {
				bw.write("<item>\r\n");
				bw.write("<title>" + art.getTitle() + "</title>\r\n");
				bw.write("<link>http://localhost:8080/MyBlog/user/showArticle.action?id="
						+ art.getId() + "</link>\r\n");
				//bw.write("<description>" + art.getContent()
				//		+ "</description>\r\n");
				bw.write("<author>" + art.getUsername() + "</author>\r\n");
				// bw.write("<pubDate>" + art.getDate() + "</pubDate>\r\n");
				bw.write("</item>\r\n");
			}

			bw.write("</channel>\r\n");
			bw.write("</rss>\r\n");

			// bw.write("</feed>\r\n");
			// 关闭流
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
