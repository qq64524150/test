<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="user.add"/></title>
</head>
<body>
	<s:form action="actionUserInfo_addUserInfo"  method="post" enctype="multipart/form-data">
		<table align="center">
			<tr>
				<th colspan="6"><s:text name="user.add"/></th>
			</tr>
			<tr>
				<td><s:text name="user.name"/>：</td>
				<td><s:textfield name="user.uname"/></td>
				<td style="color: red;" ><s:fielderror fieldName="user.uname"/></td>
			</tr>
			<tr>
				<td><s:text name="uesr.age"/>：</td>
				<td><s:textfield name="user.uage"/></td>
				<td style="color: red;text-align: left;" ><s:fielderror fieldName="user.uage"/></td>
			</tr>
			<tr>
				<td><s:text name="user.sex"/>：</td>
				<td><s:radio list="{'男','女'}" value="%{'男'}" name="user.usex"/></td>
				
			</tr>
			<tr>
				<td><s:text name="user.imges"/>：</td>
				<td><s:file name="userImage"/></td>
				<td style="color: red;text-align: left;"><s:actionerror/></td>
			</tr>
			
			<tr>
				<td colspan="6" align="center">
					<s:submit value="%{getText('user.submit')}"/>
					<s:reset value="%{getText('user.cancel')}"/>
				</td>
			</tr>
		</table>
	</s:form>
		
</body>
</html>