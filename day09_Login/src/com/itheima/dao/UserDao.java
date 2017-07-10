package com.itheima.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.domain.User;
import com.itheima.utils.DataSourceUtils;

public class UserDao {
	/**
	 * ��¼
	 * @param username
	 * @param password
	 * @return �û�
	 * @throws SQLException 
	 */
	public User getUserByUsernameAndPwd(String username, String password) throws SQLException {
		//����queryrunner
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		//��дsql
		String sql = "select * from user where username=? and password=?";
		//ִ��sql
		User user = qr.query(sql, new BeanHandler<>(User.class),username,password);
		return user;
	}

	/**
	 * ����û�
	 * @param user �û���Ϣ
	 * @return
	 * @throws SQLException 
	 */
	public int addUser(User user) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into user(username,password,email,name,sex,birthday,hobby) values (?,?,?,?,?,?,?)";
		return qr.update(sql, user.getUsername(),user.getPassword(),user.getEmail(),user.getName(),user.getSex(),user.getBirthday(),user.getHobby());
		
	}

}
