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
	 * 查询所有商品
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
	 * 添加商品
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
	 * 删除商品
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
	 * 通过商品id 获取
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
	 * 修改商品信息
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
	 * 多条件查询
	 * @param name
	 * @param kw
	 * @return
	 * @throws SQLException 
	 */
	public static List<Product> findProductByCondition(String name, String kw) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where 1=1 ";
		
		//存放参数
		ArrayList<String> params = new ArrayList<>();
		
		//判断参数是否为空，拼接sql
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
	 * 查询第几页的数据
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
	 * 查询总条数
	 * @return
	 * @throws SQLException 
	 */
	public int getCount() throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from product";
		//包装类 转整数
		return ((Long)qr.query(sql,new ScalarHandler())).intValue();
	}

}
