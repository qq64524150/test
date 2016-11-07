package com.userInfo.entity;

import java.util.Date;

/**
 * 创建用户实体对象
 * @author z
 *
 */
public class UserInfo {
	private String uno ;  
    private String uname ;
    private int uage ;
    private String usex ;
    private String uimges ;
    private Date uintime ;
    
    
    
    
    
	public UserInfo() {
		super();
	}
	public UserInfo(String uno, String uname, int uage, String usex, String uimges, Date uintime) {
		super();
		this.uno = uno;
		this.uname = uname;
		this.uage = uage;
		this.usex = usex;
		this.uimges = uimges;
		this.uintime = uintime;
	}
	public String getUno() {
		return uno;
	}
	public void setUno(String uno) {
		this.uno = uno;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getUage() {
		return uage;
	}
	public void setUage(int uage) {
		this.uage = uage;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	public String getUimges() {
		return uimges;
	}
	public void setUimges(String uimges) {
		this.uimges = uimges;
	}
	public Date getUintime() {
		return uintime;
	}
	public void setUintime(Date uintime) {
		this.uintime = uintime;
	}   
	
    
    
	
}
