package com.itheima.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.itheima.utils.DataSourceUtils;

public class AccountDao4DB {

	public void accountOut(String fromUser, String money) throws SQLException {
		// ����queryrunner
		QueryRunner qr = new QueryRunner();
		// ��дsql
		String sql = "update account set money = money - ? where name = ?";
		// ִ��sql
		qr.update(DataSourceUtils.getConnection(), sql, money, fromUser);
	}

	public void accountIn(String toUser, String money) throws SQLException {
		// ����queryrunner
		QueryRunner qr = new QueryRunner();
		// ��дsql
		String sql = "update account set money = money + ? where name = ?";
		// ִ��sql
		qr.update(DataSourceUtils.getConnection(), sql, money, toUser);

	}

}
