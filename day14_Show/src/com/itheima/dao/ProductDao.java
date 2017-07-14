package com.itheima.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.itheima.domain.Product;
import com.itheima.utils.DataSourceUtils;

public class ProductDao {
	/**
	 * ��ѯ������Ʒ
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Product> findAll() throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());

		String sql = "select * from product";
		return qr.query(sql, new BeanListHandler<>(Product.class));

	}

	/**
	 * �����Ʒ
	 * 
	 * @param p
	 * @throws SQLException
	 */
	public void addProduct(Product p) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		/*
		 * `pid` varchar (96), `pname` varchar (150), `market_price` double ,
		 * `shop_price` double , `pimage` varchar (600), `pdate` date , `pdesc`
		 * varchar (765)
		 */
		String sql = "insert into product(pid,pname,market_price,shop_price,pdate,pdesc) values(?,?,?,?,?,?)";

		qr.update(sql, p.getPid(), p.getPname(), p.getMarket_price(), p.getShop_price(), p.getPdate(), p.getPdesc());

	}

	/**
	 * ɾ����Ʒ
	 * 
	 * @param pid
	 * @throws SQLException
	 */
	public void deleteProduct(String pid) throws SQLException {

		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from product where pid = ?";

		qr.update(sql, pid);
	}

	/**
	 * ͨ����Ʒid ��ȡ
	 * 
	 * @param pid
	 * @return
	 * @throws SQLException
	 */
	public Product getProductById(String pid) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());

		String sql = "select * from product where pid = ?";
		return qr.query(sql, new BeanHandler<>(Product.class), pid);
	}

	/**
	 * �޸���Ʒ��Ϣ
	 * 
	 * @param p
	 * @throws SQLException 
	 */
	public void updateProduct(Product p) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		/*
		 * `pid` varchar (96), `pname` varchar (150), `market_price` double ,
		 * `shop_price` double , `pimage` varchar (600), `pdate` date , `pdesc`
		 * varchar (765)
		 */
		String sql = "update product set pname=?,market_price=?,shop_price=?,pdesc=? where pid = ?";

		qr.update(sql, p.getPname(), p.getMarket_price(), p.getShop_price(), p.getPdesc(),p.getPid());

	}

	/**
	 * ��������ѯ
	 * @param name
	 * @param kw
	 * @return
	 * @throws SQLException 
	 */
	public static List<Product> findProductByCondition(String name, String kw) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where 1=1 ";
		
		//��Ų���
		ArrayList<String> params = new ArrayList<>();
		
		//�жϲ����Ƿ�Ϊ�գ�ƴ��sql
		if(name != null && name.trim().length()>0){
			sql += " and pname like ? "; //pname like %sss%
			params.add("%"+name+"%");
		}
		if(kw != null && kw.trim().length()>0){
			sql += " and pdesc like ? "; //pname like %sss%
			params.add("%"+kw+"%");
		}

		return qr.query(sql,new BeanListHandler<>(Product.class), params.toArray());
	}
	/**
	 * ��ѯ�ڼ�ҳ������
	 * @param currPage
	 * @param pageSize
	 * @return
	 * @throws SQLException 
	 */
	public List<Product> findProductByPage(int currPage, int pageSize) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product limit ?,?";
		
		return qr.query(sql, new BeanListHandler<>(Product.class), (currPage-1)*pageSize, pageSize);
	}
	
	/**
	 * ��ѯ������
	 * @return
	 * @throws SQLException 
	 */
	public int getCount() throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from product";
		//��װ�� ת����
		return ((Long)qr.query(sql,new ScalarHandler())).intValue();
	}

}
