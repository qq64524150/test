<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="user.alertTite"/></title>
</head>
<body>
	<s:form action="actionUserInfo_upUserInfo"  method="post" enctype="multipart/form-data">
		<table align="center">
			<tr>
				<th colspan="6"><s:text name="user.alertTite"/></th>
			</tr>
			<tr>
				<td><s:text name="user.name"/>：</td>
				<td>
					<s:textfield name="user.uname"/>
					<s:hidden name="user.uno"/>
				</td>
				<td></td>
			</tr>
			<tr>
				<td><s:text name="uesr.age"/>：</td>
				<td><s:textfield name="user.uage"/></td>
				<td></td>
			</tr>
			<tr>
				<td><s:text name="user.sex"/>：</td>
				<td><s:radio list="{'男','女'}" value="user.usex" name="user.usex"/></td>
				
			</tr>
			<tr>
				<td><s:text name="user.imges"/>：</td>
				<td><s:file name="userImage"/><s:hidden name="user.uimges"/></td>
				<td></td>
			</tr>
			
			<tr>
				<td colspan="6" align="center">
					<s:submit value="%{getText('user.alter') }"/>
					<s:reset value="%{getText('user.cance')}"/>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>