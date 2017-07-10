package com.itheima.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.utils.DataSourceUtils;
import com.ithema.domain.Product;

public class ProductDao {

	public List<Product> findAll() throws SQLException {
		//¥¥Ω®queryrunner
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		//±‡–¥sql
		String sql = "select * from product";
		
		//÷¥––sql
		return qr.query(sql, new BeanListHandler<>(Product.class));
	}

}
