<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>修改密码</title>
<link rel="stylesheet" href="image/style.css">
</head>

<body topmargin="0" leftmargin="0" bgcolor="#f3f3f3">
		<jsp:include page="include/MainHeader.jsp"></jsp:include>
		
		<form id="Form1" action="resetUserInfo.action" method="post">
		     
                           
                           
			<table width="1000" cellpadding="0" cellspacing="0" border="0">
				<tr height="100">
					<td colspan="2">&nbsp;</td>
				</tr>
				
				<tr>
				    
					<td align="right" width="300" valign="top"><img src="image/manager1.gif"></td>
					<td width="20">&nbsp;</td>
					<td valign="top">
					
						<table width="600" border="1" cellpadding="0" cellspacing="0" style="background-color:#FFFFFF;BORDER-RIGHT:#cccccc 1px solid; BORDER-TOP:#cccccc 1px solid; BORDER-LEFT:#cccccc 1px solid; BORDER-BOTTOM:#cccccc 1px solid; BORDER-COLLAPSE:collapse">
							
							<tr height="30">
								<td colspan="3" align="center" background="image/main/l-bg1.jpg"><font color="#ff0000"><b>请修改密码： ${ request.info}</b></font></td>
							</tr>
    						<tr height="30">
                                <td align="right" width="160">您的帐号是：&nbsp;</td>
                               <td>${sessionScope.users.username}</td>
                               <input type="hidden" name="username" value="${sessionScope.users.username}" />
                            </tr>
                            
							 <tr height="30">
                                <td align="right">原始密码&nbsp;</td>
                                <td><input type="password" name="oldPassword" value="${sessionScope.users.password }"/>*</td>
                                <td><s:fielderror><s:param>oldPassword</s:param></s:fielderror></td>                             
                            </tr>
							
							<tr height="30">
								<td align="right">新密码&nbsp;</td>
								<td><input type="password" name="password"/>*</td>
							     <td><s:fielderror><s:param>password</s:param></s:fielderror></td> 
							</tr>
							<tr height="30">
								<td align="right">确认新密码&nbsp;</td>
								<td><input type="password" name="repassword"/>*</td>
							     <td><s:fielderror><s:param>repassword</s:param></s:fielderror></td> 
								
							</tr>
							
							 <tr height="30">
                                <td align="right">昵称&nbsp;</td>
                                 <td><input type="text" name="nickname" value="${sessionScope.users.nickname }"/>*</td>
                                 <td><s:fielderror><s:param>nickname</s:param></s:fielderror></td> 
                                
                            </tr>
						
							<tr height="30">
								<td align="right">密码保护问题&nbsp;</td>
								<td>
									<select name="question">
										<option value="你的生日">你的生日</option>
										<option value="你的家乡">你的家乡</option>
										<option value="你最喜欢的食物">你最喜欢的食物</option>
									</select>*
							     <td><s:fielderror><s:param>question</s:param></s:fielderror></td> 
								</td>
							
							</tr>
							<tr height="30">
								<td align="right">密码保护的答案&nbsp;</td>
								<td><input type="text" name="answer"/>*</td>
							     <td><s:fielderror><s:param>answer</s:param></s:fielderror></td> 
							</tr>
							<tr height="30">
								<td colspan="3" align="center"><input type="submit" value="提交"/>
								<input type="reset" value="重置"/>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>

