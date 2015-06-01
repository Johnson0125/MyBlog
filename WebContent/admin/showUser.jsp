<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>全部用户</title>
<link rel="stylesheet" href="image/style.css" />
</head>

<body topmargin="0" leftmargin="0" bgcolor="#F3F3F3">
    <jsp:include page="include/MainHeader.jsp"></jsp:include>
    
    <table width="90%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center">
               <tr bgcolor="#E7E7E7">
                    <td height="14" colspan="10" background="images/tbg.gif">&nbsp;会员管理&nbsp;</td>
                </tr>
                <tr align="center" bgcolor="#FAFAF1" height="22">
                    <td width="10%">账号</td>          
                   <!--   <td width="10%">密码</td> -->
                    <td width="10%">昵称</td>           
                    <td width="10%">密码保护问题</td>
                    <td width="10%">保护问题答案</td>
                    <!-- <td width="40%">删除该用户</td> -->
                    <td width="10%">修改用户信息</td>
                    <td width="10%">删除该用户</td>
                </tr>   
                <s:iterator value="#request.userList" id="user">
                <tr align='center' bgcolor="#FFFFFF"  height="22">
                    <td bgcolor="#FFFFFF" align="center">
                       <s:property value="#user.username"/>
                    </td>
                    
                    <!--  
                    <td bgcolor="#FFFFFF" align="center">
                       <s:property value="#user.password"/>
                    </td>
                    -->
                    
                     <td bgcolor="#FFFFFF" align="center">
                       <s:property value="#user.nickname"/>
                    </td>
                      <td bgcolor="#FFFFFF" align="center">
                      <s:property value="#user.question"/>
                    </td>
                    <td bgcolor="#FFFFFF" align="center">
                      <s:property value="#user.answer"/>
                    </td>
                    
                        <td onMouseMove="javascript:this.bgColor='yellow';" onMouseOut="javascript:this.bgColor='#FFFFFF';">
                            <a href="userManager.action?username=<s:property value="#user.username"/>" >修改信息</a>
                        </td>
                         <td onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';">
                        <a href="deleteUser.action?username=<s:property value="#user.username"/>" onclick="return confirm('确定将此记录删除?')">删除用户</a>
                        </td>
                  
                </tr>
                </s:iterator>
                    <tr >
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    
                                   <td align="right">
                                    <s:if test="#request.pageList.hasPrePage">
                                       <a href="showUser.action?currentPage=1">首页</a>
                                       <a href="showUser.action?currentPage=${pageList.currentPage - 1}">上一页</a>
                                    </s:if>
                                    <s:else>
                                                                                                                    首页
                                                                                                                     上一页
                                    </s:else>
                                    
                                    <s:if test="#request.pageList.hasNextPage">
                                       <a href="showUser.action?currentPage=${pageList.currentPage + 1}">下一页</a>
                                       <a href="showUser.action?currentPage=${pageList.totalPage}">尾页</a>
                                    </s:if>
                                    
                                    <s:else>
                                                                                                                 下一页 尾页
                                    </s:else>
                                    <td>
                        </tr>
            </table>
            
            
            <div id="noCount" runat="server" width="1000" cellpadding="6"
                                cellspacing="1" bgcolor="#cccccc" align="center">
                                <tr bgcolor="#ffffff" height="50">
                                    <td align="center">陕西科技大学--个人博客网站  作者张森</td>
                                </tr>
                            </div>
            
</body>
</html>