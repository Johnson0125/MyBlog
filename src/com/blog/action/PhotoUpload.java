package com.blog.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class PhotoUpload extends ActionSupport{
	private File myFile;
	private String myFileContentType;
	private String myFileFileName;
	public File getMyFile() {
		return myFile;
	}
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
	public String getMyFileContentType() {
		return myFileContentType;
	}
	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}
	public String getMyFileFileName() {
		return myFileFileName;
	}
	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}
	
	@Override
	public String execute() throws Exception {
		Map session = ServletActionContext.getContext().getSession();
		String username = (String) session.get("username");
		
		//创建输入流
		InputStream is = new FileInputStream(myFile);
		//创建 文件保存目录
		String photoPath = ServletActionContext.getServletContext().getRealPath("/user/photo/" + username);
		
		File filePhotoPath = new File(photoPath);
		if(!filePhotoPath.isDirectory()) {
			filePhotoPath.mkdir();
		}
		
		//文件名自动替换----- 解决中文文件不能转化成uri的问题
		String extension = FilenameUtils.getExtension(this.getMyFileFileName());
		String filename = UUID.randomUUID().toString() + "."+ extension;
		
		//设置目标文件
		File tofile = new File(photoPath, filename);
		//创建输出流
		OutputStream os = new FileOutputStream(tofile);
		byte[] buffer = new byte[1024];
		int length = 0;
		while((length = is.read(buffer)) > 0) {
			os.write(buffer, 0 ,length);
		}
		//关闭各种流
		is.close();
		os.close();
		return SUCCESS;
	}

	
}
