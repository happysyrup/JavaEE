package com.itheima.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.itheima.dao.AccountDao;
import com.itheima.utils.JdbcUtils;

public class AccountService {
	/**
	 * ת��
	 * @param fromUser ת����
	 * @param toUser ת�뷽
	 * @param money ���
	 * @throws Exception 
	 */
	public void account(String fromUser, String toUser, String money) throws Exception  {
		AccountDao dao = new AccountDao();
		Connection conn = null;
		try {
			//0.��������
			conn = JdbcUtils.getConnection();
			conn.setAutoCommit(false);		
			//1.ת��
			dao.accountOut(conn,fromUser,money);
			
			//int i = 1/0;
			
			//2.ת��
			dao.accountIn(conn,toUser,money);
			
			//3.�����ύ
			conn.commit();
			JdbcUtils.closeConn(conn);
		} catch (Exception e) {
			e.printStackTrace();
			
			// ����ع�
			conn.rollback();
			JdbcUtils.closeConn(conn);
			
			throw e;
		}
	}

}