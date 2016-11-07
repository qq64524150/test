package com.userInfo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.userInfo.entity.UserInfo;

public class UserInfoDao {

	//��ѯ
	public List<UserInfo> allUserInfo(){
		//��ȡ�������ݿ����
		Connection conn = OraclsJDBC.getConnection();
		Statement st = null ;
		ResultSet rs = null ;
		String sql="select * from userinfo order by uintime desc";
		List<UserInfo> list = new ArrayList<UserInfo>();
		try {
			st = conn.createStatement() ;
			rs = st.executeQuery(sql);
			while(rs.next()){
				//�����û�ʵ�����
				UserInfo user = new UserInfo();
				user.setUno(rs.getString(1));
				user.setUname(rs.getString(2));
				user.setUage(rs.getInt(3));
				user.setUsex(rs.getString(4));
				user.setUimges(rs.getString(5));
				user.setUintime(rs.getDate(6));
				list.add(user);
			}
			
			return list ;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null ;
	}
	
	//��ѯ--id
	public UserInfo lineUserInfoId(String id){
		
		//��ȡ�������ݿ����
		Connection conn = OraclsJDBC.getConnection();
		Statement st = null ;
		ResultSet rs = null ;
		String sql="select * from userinfo where uno="+id;
		
		try {
			st = conn.createStatement() ;
			rs = st.executeQuery(sql);
			if(rs.next()){
				//�����û�ʵ�����
				UserInfo user = new UserInfo();
				user.setUno(rs.getString(1));
				user.setUname(rs.getString(2));
				user.setUage(rs.getInt(3));
				user.setUsex(rs.getString(4));
				user.setUimges(rs.getString(5));
				user.setUintime(rs.getDate(6));
				return user ;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null ;

	}
	
	//���
	public boolean addUserInfo(UserInfo user) throws SQLException{
		String sql="insert into userinfo values(my_sequence.nextval,?,?,?,?,default)";
		return OraclsJDBC.updateDb(sql, new Object[]{user.getUname(),user.getUage(),user.getUsex(),user.getUimges()});
	}
	
	//ɾ��
	
	public boolean delUserInfo(String id) throws SQLException{
		return OraclsJDBC.updateDb("delete userinfo where uno ="+id);
	}
	
	//�޸�
	public boolean upUserInfo(UserInfo user) throws SQLException{
		String sql="update userinfo set uname=?,uage=?,usex=?,uimges=? where uno="+user.getUno();
		return OraclsJDBC.updateDb(sql, new Object[]{user.getUname(),user.getUage(),user.getUsex(),user.getUimges()});
		
		
	}
	
}
