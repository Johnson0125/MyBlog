<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.blog.po.Article" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>我的文章</title>
		<link rel="stylesheet" href="image/style.css" />
	</head>

	<body topmargin="0" leftmargin="0" bgcolor="#F3F3F3">
	<!-- 头 -->
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
                if(name != null && !"".equals(name)) {
             	   // String username1 = (String) session.getAttribute("usernameArticle");
                	   String usernameArticle = (String) session.getAttribute("usernameArticle");
                	    if(name.equals(usernameArticle)) {
                       
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
                    <td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="resetPassword.jsp">修改密码</a></td>
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
                </tr>
                	   <% 
                	    }
                    }
                    else {
                      
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
                </tr>
                <%
                    }
                %>
            </table>
        </td>
    </tr>
</table>
<!-- 头 -->
		<table width="1000" border="0" cellpadding="0" cellspacing="0" align="center">
			<tr>
				<td width="722" valign="top">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr height="30" valign="bottom">
							<td class="title">
								&nbsp;
							</td>
						</tr>
						<tr>
							<td colspan="2" valign="top">
								<table width="1000" cellpadding="4" cellspacing="1">
									<tr>
										<td>
											<table width="1000" cellpadding="6" cellspacing="1"
												bgcolor="#CCCCCC">

												<tr>
													<td bgcolor="#FFFFFF">
														<font class="chinesefont105main">
														<p align="center" style="font-size=20px"><s:property value="#request.article.title"/></p>
															<hr size='1' noshade color='#CCCCCC'> <br>
															<div>
														<s:property value="#request.article.content" escape="false"/>
															</div> </font>
													</td>
												</tr>
												<!-- display the critique -->
												<s:set name="loushu" value="#request.page.beginIndex"></s:set>
												<s:iterator value="#request.allCri" id="cri">
												<s:set name="loushu" value="#loushu + 1"></s:set>
												
												    <tr><td height="25"></td></tr>
												    <tr>
												        <td bgcolor="#FFFFFF">
												        <p align="right" ><s:property value="#loushu"/>楼</p>
                                                        <font class="chinesefont105main">
                                                        <s:property value="#cri.content"  escape="false"/>
                                                            <hr size='1' noshade color='#CCCCCC'> <br>
                                                            
                                                       <p align="right">作者： <s:property value="#cri.username"/></p>
                                                            </font>
                                                    </td>
												    </tr>
												</s:iterator>
												    <tr>
                                    <td align="center">
                                    <s:if test="#request.page.hasPrePage">
                                       <a href="showArticle.action?id=${requestScope.article.id }&currentPage=1">首页</a>
                                       <a href="showArticle.action?id=${requestScope.article.id }&currentPage=${page.currentPage - 1}">上一页</a>
                                    </s:if>
                                    <s:else>
                                                                                                                         首页
                                                                                                                     上一页
                                    </s:else>
                                    
                                    <s:if test="#request.page.hasNextPage">
                                       <a href="showArticle.action?id=${requestScope.article.id }&currentPage=${page.currentPage + 1}">下一页</a>
                                       <a href="showArticle.action?id=${requestScope.article.id }&currentPage=${page.totalPage}">尾页</a>
                                    </s:if>
                                    
                                    <s:else>
                                                                                                                    下一页 尾页
                                    </s:else>
                                    </td>
                                    
                                </tr>
								</table>
											<!-- 添加删除文章操作 -->
											<%
											  //String username = (String) session.getAttribute("username");
											  if(name != null && !"".equals(name)) {												 
												  String usernameArticle = (String) session.getAttribute("usernameArticle");
												  //一篇文章肯定是有作者的，就是说 usernameArticle是一定有值的
												        //判断当前登录用户和文章的作者是不是同一个人。
												      if(name.equals(usernameArticle)) {
										  
											%>
											<form action="deleteArticle.action" method="post">
											<input type="hidden" name="id" value='${requestScope.article.id}' />
											<input type="hidden" name="username" value='${requestScope.article.username}' />
											      <TABLE WIDTH="100"  height="30" BORDER="0" CELLPADDING="0" CELLSPACING="0" align="center">
											             <td>
                                                                <input align="center" type="submit" value="删除本文" onclick="return confirm('确定将此记录删除?')"/>
                                                         </td>
                                                         <td><p align="center" style="width:220px;">注意：此操作不可回复，请谨慎操作！</p></td>
											      </TABLE>
											</form>
											<%
												      }      
											  }
											%>
											<!-- 添加删除文章操作 -->
			<!-- 添加评论，表单 --> 
          <form action="addCritique.action" method="post">
            <input type="hidden" name="id" value='${requestScope.article.id }'/>
            <TABLE WIDTH="1000"  height="300" BORDER="0" CELLPADDING="0" CELLSPACING="0" align="center">
                <tr height="20">
                    <td height="24" colspan="2">&nbsp;</td>
                </tr>
                <TR>
                    <td valign="top">
                    </td>
                    <TD COLSPAN="2" align="center" valign="top">
                        <table width="1000" style="BORDER-RIGHT:#cccccc 1px solid; BORDER-TOP:#cccccc 1px solid; BORDER-LEFT:#cccccc 1px solid; BORDER-BOTTOM:#cccccc 1px solid; BACKGROUND-COLOR:#f5f5f5"
                            CellPadding="0" CellSpacing="0">
                            <tr height="30">
                                <td background="image/l-bg3.jpg">&nbsp;&nbsp;&nbsp;<font color="#ffff66"><b>评论</b></font></td>
                            </tr>
                            <tr>
                                <td>
                                    &nbsp;&nbsp;&nbsp;内容：
                                    <FCK:editor instanceName="content" basePath="/user/fckeditor" toolbarSet="myToolbar" height="200"></FCK:editor>
                                </td>
                            </tr>
                            <tr height="20">
                                <td>
                                    <input type="submit"  value="添加" Style="ButtonCss" />
                                    <input type="button" name="cancelButton" value="取消" onClick="history.back()" Class="ButtonCss">
                                </td>
                            </tr>
                        </table>
                    </TD>
                </TR>
            </TABLE>
        </form>
											<table id="noCount" runat="server" width="1000"
												cellpadding="6" cellspacing="1" bgcolor="#cccccc">
												<tr bgcolor="#ffffff" height="50">
													<td align="center">
														<s:property value="#request.article.username"/>的博客
													</td>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
</body>
</html>