<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个性化设置</title>
<link rel="stylesheet" href="image/style.css" />
<style type="text/css">
<!--
.STYLE1 {
	color: #0000FF;
	font-weight: bold;
}
-->
</style>
</head>

<body topmargin="0" leftmargin="0" bgcolor="#f3f3f3">
		
		<!-- 增加自己的头 -->
<table width="1000" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
        <td background="image/bg1.jpg" height="150">
        <!-- 博客标题位置-->
        <span class="blogtitle">${sessionScope.blogtitle}</span><br />
      <span class="idiograph">${sessionScope.idiograph}     </span>     <!-- 个性签名位置-->      </td>
    </tr>
    <tr height="31">
        <td background="../image/line.jpg">
            <table width="1000" border="0" cellpadding="0" cellspacing="0">
        
             <%
                String name = (String) session.getAttribute("username");
                  if(name==null || "".equals(name)) {              
             %>
            
                <tr height="20" align="center">
                    <td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="../showAllArticle.action">博客首页</a></td>
                    <td class="ltsep">|</td>
                    <td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="showUserAllArticle.action">用户首页</a></td>
                    <td class="ltsep">|</td>
                    <td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="editbloginfo.jsp">个性化设置</a></td>
                    <td class="ltsep">|</td>
                    <td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="addArticle.jsp">写博文</a></td>
                    <td class="ltsep">|</td>
                    <td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="showPhoto.action">相册</a></td>
                    <td class="ltsep">|</td>                
                </tr>
                <%
                  } else {
                %>
                    <tr height="20" align="center">
                    <td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="../showAllArticle.action">博客首页</a></td>
                    <td class="ltsep">|</td>
                    <td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="showUserAllArticle.action?username=${param.username}">用户首页</a></td>
                    <td class="ltsep">|</td>
                    <td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="editbloginfo.jsp">个性化设置</a></td>
                    <td class="ltsep">|</td>
                    <td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="addArticle.jsp">写博文</a></td>
                    <td class="ltsep">|</td>
                    <td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="showPhoto.action">相册</a></td>
                    <td class="ltsep">|</td>
                    <td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="resetPassword.jsp">修改密码</a></td>
                    <td class="ltsep">|</td>
                  
                </tr>
                <%
                  }
                %>
            </table>
        </td>
    </tr>
</table>	
		<!-- 增加自己的头 -->
		
		<form id="Form1" action="editBlogInfo.action" method="post">
			<table width="1000" cellpadding="0" cellspacing="0" border="0" align="center">
				<tr height="100">
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td align="right" width="300" valign="top"><img src="image/editbloginfo.gif"></td>
					<td width="20">&nbsp;</td>
					<td valign="top">
						<table width="500" border="1" cellpadding="0" cellspacing="0" style="background-color:#FFFFFF;BORDER-RIGHT:#cccccc 1px solid; BORDER-TOP:#cccccc 1px solid; BORDER-LEFT:#cccccc 1px solid; BORDER-BOTTOM:#cccccc 1px solid; BORDER-COLLAPSE:collapse">
							<tr height="30">
								<td colspan="2" align="center" background="image/l-bg1.jpg"><span class="STYLE1">个性化设置</span></td>
							</tr>
							<tr height="30">
								<td align="right">博客标题</td>
								<td><input name="blogtitle" type="text"/>*</td>
								<td width=><s:fielderror><s:param>blogtitle</s:param></s:fielderror></td>
							</tr>
							<tr height="30">
								<td align="right">个性签名</td>
								<td><input name="idiograph" type="text"/>*</td>
								<td width=><s:fielderror><s:param>idiograph</s:param></s:fielderror></td>
							</tr>
							<tr height="30">
								<td colspan="2" align="center"><input type="submit" value="提交" name="submit" onclick="return confirm('个人信息将会在页面左上角显示')"/><input type="reset" value="重置" name="reset" /></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>

