package com.itheima.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtils {
	private static ComboPooledDataSource ds=new ComboPooledDataSource();
	
	/**
	 * ��ȡ����Դ
	 * @return ���ӳ�
	 */
	public static DataSource getDataSource(){
		return ds;
	}
	
	/**
	 * ��ȡ����
	 * @return ����
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	
	
	
	/**
	 * �ͷ���Դ
	 * 
	 * @param conn
	 *            ����
	 * @param st
	 *            ���ִ����
	 * @param rs
	 *            �����
	 */
	public static void closeResource(Connection conn, Statement st, ResultSet rs) {
		closeResultSet(rs);
		closeStatement(st);
		closeConn(conn);
	}

	/**
	 * �ͷ�����
	 * 
	 * @param conn
	 *            ����
	 */
	public static void closeConn(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}

	}

	/**
	 * �ͷ����ִ����
	 * 
	 * @param st
	 *            ���ִ����
	 */
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			st = null;
		}

	}

	/**
	 * �ͷŽ����
	 * 
	 * @param rs
	 *            �����
	 */
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}

	}
}
