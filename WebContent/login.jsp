<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="user.login"/></title>
</head>
<body>
	<form action="actionUserInfo_dogoin" method="post">
		<table align="center" width="300">
			<tr>
				<th align="center"><div style="font-size: 14px"><a href="actionUserInfo_Loi18n?lang=zh">中文</a> |<a href="actionUserInfo_Loi18n?lang=en">English</a> </div></th>
			</tr>
			<tr>
				
				<th align="center"><s:text name="user.login"/></th>
				
			</tr>
			
			<tr>
				<th style="color:red;" align="center">
					
						<s:actionerror/>
					
				</th>
			</tr>
			<tr>
				<td><s:text name="user.loginName"/>:</td>
				<td><s:textfield name="name"/></td>
			</tr>
			<tr>
				<td><s:text name="user.password"/>:</td>
				 <td><s:password name="pwd"/></td>
			</tr>
			<tr>
				<td><s:submit value="%{getText('user.go')}"/></td>
			</tr>
		</table>

		
		
	</form>
</body>
</html>