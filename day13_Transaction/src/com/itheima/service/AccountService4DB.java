package com.itheima.service;

import com.itheima.dao.AccountDao4DB;
import com.itheima.utils.DataSourceUtils;

public class AccountService4DB {
	/**
	 * ת��
	 * @param fromUser ת����
	 * @param toUser ת�뷽
	 * @param money ���
	 * @throws Exception 
	 */
	public void account(String fromUser, String toUser, String money) throws Exception  {
		AccountDao4DB dao = new AccountDao4DB();
		
		try {
			//0.��������
			DataSourceUtils.startTransaction();
			//1.ת��
			dao.accountOut(fromUser,money);
			
			//int i = 1/0;
			
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
