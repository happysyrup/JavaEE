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
			// ��ȡ����
			//conn = JdbcUtils.getConnection();
			// ��дsql
			String sql = "update account set money = money - ? where name = ?";
			// �������ִ����
			st = conn.prepareStatement(sql);
			// ���ò���
			st.setString(1, money);
			st.setString(2, fromUser);
			// ִ��sql
			int i = st.executeUpdate();
			// ����
			System.out.println("��:" + i);

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
			// ��ȡ����
			//conn = JdbcUtils.getConnection();
			// ��дsql
			String sql = "update account set money = money + ? where name = ?";
			// �������ִ����
			st = conn.prepareStatement(sql);
			// ���ò���
			st.setString(1, money);
			st.setString(2, toUser);
			// ִ��sql
			int i = st.executeUpdate();
			// ����
			System.out.println("��:" + i);

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
			// ��ȡ����
			conn = JdbcUtils.getConnection();
			// ��дsql
			String sql = "update account set money = money - ? where name = ?";
			// �������ִ����
			st = conn.prepareStatement(sql);
			// ���ò���
			st.setString(1, money);
			st.setString(2, fromUser);
			// ִ��sql
			int i = st.executeUpdate();
			// ����
			System.out.println("��:" + i);

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
			// ��ȡ����
			conn = JdbcUtils.getConnection();
			// ��дsql
			String sql = "update account set money = money + ? where name = ?";
			// �������ִ����
			st = conn.prepareStatement(sql);
			// ���ò���
			st.setString(1, money);
			st.setString(2, toUser);
			// ִ��sql
			int i = st.executeUpdate();
			// ����
			System.out.println("��:" + i);

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			JdbcUtils.closeResource(conn, st, rs);
		}
	}

}
