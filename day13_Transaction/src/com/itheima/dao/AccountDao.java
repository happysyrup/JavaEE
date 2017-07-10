package com.itheima.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.itheima.utils.JdbcUtils;

public class AccountDao {

	public void accountOut(Connection conn,String fromUser, String money) throws SQLException {
		//Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			// 获取链接
			//conn = JdbcUtils.getConnection();
			// 编写sql
			String sql = "update account set money = money - ? where name = ?";
			// 创建语句执行者
			st = conn.prepareStatement(sql);
			// 设置参数
			st.setString(1, money);
			st.setString(2, fromUser);
			// 执行sql
			int i = st.executeUpdate();
			// 处理
			System.out.println("出:" + i);

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			//JdbcUtils.closeResource(conn, st, rs);
			JdbcUtils.closeStatement(st);
		}
	}

	public void accountIn(Connection conn,String toUser, String money) throws SQLException {
		//Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			// 获取链接
			//conn = JdbcUtils.getConnection();
			// 编写sql
			String sql = "update account set money = money + ? where name = ?";
			// 创建语句执行者
			st = conn.prepareStatement(sql);
			// 设置参数
			st.setString(1, money);
			st.setString(2, toUser);
			// 执行sql
			int i = st.executeUpdate();
			// 处理
			System.out.println("入:" + i);

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			//JdbcUtils.closeResource(conn, st, rs);
			JdbcUtils.closeStatement(st);
		}
	}
	
	
	
	
	//////////////////////////////////
	public void accountOut_(String fromUser, String money) throws SQLException {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			// 获取链接
			conn = JdbcUtils.getConnection();
			// 编写sql
			String sql = "update account set money = money - ? where name = ?";
			// 创建语句执行者
			st = conn.prepareStatement(sql);
			// 设置参数
			st.setString(1, money);
			st.setString(2, fromUser);
			// 执行sql
			int i = st.executeUpdate();
			// 处理
			System.out.println("出:" + i);

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			JdbcUtils.closeResource(conn, st, rs);
		}
	}

	public void accountIn_(String toUser, String money) throws SQLException {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			// 获取链接
			conn = JdbcUtils.getConnection();
			// 编写sql
			String sql = "update account set money = money + ? where name = ?";
			// 创建语句执行者
			st = conn.prepareStatement(sql);
			// 设置参数
			st.setString(1, money);
			st.setString(2, toUser);
			// 执行sql
			int i = st.executeUpdate();
			// 处理
			System.out.println("入:" + i);

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			JdbcUtils.closeResource(conn, st, rs);
		}
	}

}
