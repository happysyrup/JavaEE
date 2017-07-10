package com.itheima.service;

import java.sql.SQLException;

import com.itheima.dao.UserDao;
import com.ithema.domain.User;

public class UserService {

	public User getUserByUsernameAndPwd(String username, String password) throws SQLException {
		return new UserDao().getUserByUsernameAndPwd(username, password);
	}

}
