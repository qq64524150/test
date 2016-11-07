<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="user.tite"/></title>
</head>
<body>
	
	<table border="1" width="700" align="center">
		<tr>
			<th colspan="8">
				<div style="font-size: 14px"><a href="actionUserInfo_i18n?lang=zh">中文</a> |<a href="actionUserInfo_i18n?lang=en">English</a> </div>
				<div style="font-size: 25px"><s:text name="user.tite"/></div>
				<div >
					<b style="color: red;"><s:actionerror/></b>
					<b style="color: green;"><s:actionmessage/></b>
					
				</div>
			</th>
			
		</tr>
		<tr>
			<th><s:text name="user.id"/></th>
			<th><s:text name="user.no"/></th>
			<th><s:text name="user.name"/></th>
			<th><s:text name="uesr.age"/></th>
			<th><s:text name="user.sex"/></th>
			<th><s:text name="user.imges"/></th>
			<th><s:text name="user.time"/></th>
			<th><s:text name="user.manage"/></th>
		</tr>
		<s:if test="#attr.userInfoList == null or #attr.userInfoList==0">
			<tr>
				<td style="color:red;font-size: 20px;font-weight: 800; text-align: center;"  colspan="8">没有数据，请<a href="#">添加</a>新的数据吧！</td>
			</tr>
		</s:if>
		<s:else>
			<s:iterator value="#attr.userInfoList" var="user" status="st">
				<tr align="center">
					<td>${st.count }</td>
					<td>${user.uno }</td>
					<td>${user.uname }</td>
					<td>${user.uage }</td>
					<td>${user.usex }
						
					</td>
					<td>
						 <s:if test="#user.uimges==null or #user.uimges==0">
						 	<img style="width: 40px; height: 70px;" src="upload/imges/C2CE53EC23E7AE7574AF3BB609546690.jpg"/>
						 </s:if>
						<s:else>
							<img style="width: 40px; height: 70px;" src="${user.uimges }"/>
						</s:else>
					</td>
					<td>${user.uintime }</td>
					<td><a href="actionUserInfo_lineUserInfoId?user.uno=${user.uno }"><s:text name="user.alter"/></a> <a href="actionUserInfo_delUserInfo?user.uno=${user.uno }"><s:text name="user.delete"/></a></td>
				</tr>
			</s:iterator>
		</s:else>
		
		<tr>
			<th colspan="8"><a href="actionUserInfo_adds"><s:text name="user.addUser"/></a></th>
			
		</tr>
	</table>

	
</body>
</html>

