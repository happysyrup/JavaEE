package com.itheima.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.itheima.dao.AccountDao;
import com.itheima.dao.AccountDao4tl;
import com.itheima.utils.DataSourceUtils;
import com.itheima.utils.JdbcUtils;

public class AccountService4tl {
	/**
	 * ת��
	 * @param fromUser ת����
	 * @param toUser ת�뷽
	 * @param money ���
	 * @throws Exception 
	 */
	public void account(String fromUser, String toUser, String money) throws Exception  {
		AccountDao4tl dao = new AccountDao4tl();
		
		try {
			//0.��������
			DataSourceUtils.startTransaction();
			//1.ת��
			dao.accountOut(fromUser,money);
			
			int i = 1/0;
			
			//2.ת��
			dao.accountIn(toUser,money);
			
			//3.�����ύ
			DataSourceUtils.commitAndClose();
		} catch (Exception e) {
			e.printStackTrace();
			
			// ����ع�
			DataSourceUtils.rollbackAndClose();
			
			throw e;
		}
	}

}
