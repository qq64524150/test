package com.userInfo.dao;

import java.sql.*;

public class OraclsJDBC {

	public static Connection getConnection() {
		try {
			// 获取驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 得到连接
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "userinfo", "123456");
			//将事务模式设置为手动提交事务：  
            conn.setAutoCommit(false);  
          
			return conn ;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void closeDb(Connection con, Statement st, ResultSet rs) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (st != null)
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	
	public static boolean updateDb(String sql) throws SQLException {
		Connection conn = getConnection();
		Statement st = null;
		try {
			st = conn.createStatement();
			 //提交事务  
            conn.commit();  
			if (st.executeUpdate(sql) > 0)
				return true;
		} catch (SQLException e) {
			// 若事务发生异常，回滚事务  
            conn.rollback(); 
			e.printStackTrace();
		} finally {
			OraclsJDBC.closeDb(conn, st, null);
		}
		return false;
	}

	public static boolean updateDb(String sql, Object[] objs) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			if (objs != null && objs.length > 0) {
				for (int i = 0; i < objs.length; i++) {
					if (objs[i] == null)
						objs[i] = "";
					ps.setObject(i + 1, objs[i]);
				}
			}
			 //提交事务  
            conn.commit();  
			if (ps.executeUpdate() > 0)
				return true;
		} catch (Exception e) {
			// 若事务发生异常，回滚事务  
            conn.rollback();  
			e.printStackTrace();
		} finally {
			closeDb(conn, ps, null);
		}
		return false;
	}


}