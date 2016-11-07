package com.userInfo.web;

import java.io.File;
import java.sql.SQLException;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.userInfo.dao.UserInfoDao;
import com.userInfo.entity.UserInfo;

public class UserInfoWeb extends ActionSupport{

	private UserInfo user ;
	//--修改测试
	//定义一个File类型的属性,封装上传文件
	private File userImage ;
	
	//定义一个String类型的属性，封装上传原文件名
	private String userImageFileName ;
	//定义一个String类型的属性，封装上传文件的文件类型
	private String userImageContentType ;
	
	private String lang ;
	
	private String name ;
	private String pwd ;
	//获取dao
	UserInfoDao  dao = new UserInfoDao() ;

	
	//登录 -- 
	public String dogoin(){
		if("admin".equals(name) && "admin".equals(pwd)){
			ActionContext.getContext().getSession().put("loginName", name);
			UserInfoDao  daos = new UserInfoDao() ;
			//获取ActionContext对象
			ActionContext tex = ActionContext.getContext();
			tex.getSession().put("userInfoList",daos.allUserInfo());
			return "welcome" ;
		}
		addActionError(getText("user.loginErrorup"));
		return "login" ;
		
	}
	
	
	//查询
	public String allUserInfo(){
		UserInfoDao  daos = new UserInfoDao() ;
		//获取ActionContext对象
		ActionContext tex = ActionContext.getContext();
		tex.getSession().put("userInfoList",daos.allUserInfo());
		return "welcome" ;
		
	}
	
	
	//添加
	public String addUserInfo() throws Exception{
	
		
		//设置允许上传图片格式
		String allowType="image/bmp,image/png,image/x-png,image/gif,image/jpeg";
		if(userImageContentType!=null){
			if(allowType.indexOf(userImageContentType)>=0){
				//截取后缀--用于生产uuid唯一文件名
				String img = userImageFileName.substring(userImageFileName.lastIndexOf("."));
				userImageFileName = UUID.randomUUID()+img;
				//要上传服务器的位置
				String path =ServletActionContext.getServletContext().getRealPath("/upload/imges");
				path = path+File.separator+userImageFileName ;
				userImageFileName = "upload/imges/"+userImageFileName;
				//文件上传
				FileUtils.copyFile(userImage, new File(path));
				if(dao.addUserInfo(new UserInfo("",user.getUname(),user.getUage(),user.getUsex(),userImageFileName,new Date()))){
					addActionMessage("添加成功！！");
					return "jiazai" ;
				}
			}else{
				addActionError(getText("user.imageerror"));
				return "input" ;
			}
			
		}
		return "input" ;
	}
	
	//删除
	public String delUserInfo() throws SQLException{
		if(dao.delUserInfo(user.getUno())){
			addActionMessage("删除成功！！");
			return  "jiazai" ;
		}
		addActionError("删除失败！！");
		return "jiazai" ;
	}
	
	//修改
	public String upUserInfo() throws Exception{
		if("".equals(userImage)||userImage==null){
			
			if(dao.upUserInfo(new UserInfo(user.getUno(),user.getUname(),user.getUage(),user.getUsex(),user.getUimges(),new Date()))){
				return  "jiazai" ;
			}else{
				return  "upUserInfo" ;
			}
			
		}else{
			//设置允许上传图片格式
			String allowType="image/bmp,image/png,image/x-png,image/gif,image/jpeg";
			if(userImageContentType!=null){
				if(allowType.indexOf(userImageContentType)>=0){
					//截取后缀--用于生产uuid唯一文件名
					String img = userImageFileName.substring(userImageFileName.lastIndexOf("."));
					userImageFileName = UUID.randomUUID()+img;
					//要上传服务器的位置
					String path =ServletActionContext.getServletContext().getRealPath("/upload/imges");
					path = path+File.separator+userImageFileName ;
					userImageFileName = "upload/imges/"+userImageFileName;
					//文件上传
					FileUtils.copyFile(userImage, new File(path));
					if(dao.upUserInfo(new UserInfo(user.getUno(),user.getUname(),user.getUage(),user.getUsex(),userImageFileName,new Date()))){
						return  "jiazai" ;
					}
				}else{
					addActionError(getText("user.file"));
					return "addUserInfo" ;
				}
			
			}
			
			}
			
		
		return null ;
		
		
	}
	//查询--id
	public String lineUserInfoId() throws SQLException{
		user = dao.lineUserInfoId(user.getUno());
		
		return "upUserInfo" ;
		
	}
	
	//添加
	public String adds(){
		return "add";
	}
	
	
	//国际化
	public String i18n(){
		if(lang!=null && lang.length()>0){
			ActionContext ctx = ActionContext.getContext();
			if("zh".equals(lang)){
				ctx.setLocale(Locale.CHINA);
				ctx.getSession().put("WW_TRANS_I18N_LOCALE", Locale.CHINA);
			}else if("en".equals(lang)){
				ctx.setLocale(Locale.ENGLISH);
				ctx.getSession().put("WW_TRANS_I18N_LOCALE", Locale.ENGLISH);
			}
		}
		return "jiazai" ;
	}
	public String Loi18n(){
		if(lang!=null && lang.length()>0){
			ActionContext ctx = ActionContext.getContext();
			if("zh".equals(lang)){
				ctx.setLocale(Locale.CHINA);
				ctx.getSession().put("WW_TRANS_I18N_LOCALE", Locale.CHINA);
			}else if("en".equals(lang)){
				ctx.setLocale(Locale.ENGLISH);
				ctx.getSession().put("WW_TRANS_I18N_LOCALE", Locale.ENGLISH);
			}
		}
		return "login" ;
	}
	
	
	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}


	public File getUserImage() {
		return userImage;
	}


	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}


	public String getUserImageFileName() {
		return userImageFileName;
	}


	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}


	public String getUserImageContentType() {
		return userImageContentType;
	}


	public void setUserImageContentType(String userImageContentType) {
		this.userImageContentType = userImageContentType;
	}


	public String getLang() {
		return lang;
	}


	public void setLang(String lang) {
		this.lang = lang;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	


	
	
	
}
