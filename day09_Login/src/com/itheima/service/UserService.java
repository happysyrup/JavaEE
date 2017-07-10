package com.itheima.service;

import java.sql.SQLException;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;

public class UserService {
	/**
	 * �û���¼
	 * @param username �û���
	 * @param password ����
	 * @return User �û�
	 * @throws SQLException 
	 */
	public User login(String username, String password) throws SQLException {
		//����dao
		UserDao dao = new UserDao();
		
		return dao.getUserByUsernameAndPwd(username,password);
	}
	/**
	 * �û�ע��
	 * @param user �û�
	 * @return
	 * @throws SQLException 
	 */
	public int regist(User user) throws SQLException {
		UserDao dao = new UserDao();
		return dao.addUser(user);
	}
}
