package com.itheima.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.dao.ProductDao;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;

public class ProductService {
	/**
	 * 查询所有商品
	 * @return list
	 * @throws SQLException 
	 */
	public List<Product> findAll() throws SQLException {
		return new ProductDao().findAll();
	}
	/**
	 * 添加商品
	 * @param p
	 * @throws SQLException 
	 */
	public void addProduct(Product p) throws SQLException {
		new ProductDao().addProduct(p);
		
	}
	
	/**
	 * 删除商品
	 * @param pid
	 * @throws SQLException 
	 */
	public void deleteProduct(String pid) throws SQLException {
		new ProductDao().deleteProduct(pid);
	}
	
	/**
	 * 通过pid查找商品
	 * @param pid
	 * @return
	 * @throws SQLException 
	 */
	public Product getProductById(String pid) throws SQLException {
		// TODO Auto-generated method stub
		return new ProductDao().getProductById(pid);
	}
	/**
	 * 修改商品信息
	 * @param p
	 * @throws SQLException 
	 */
	public void updateProduct(Product p) throws SQLException {
		new ProductDao().updateProduct(p);
	}
	
	/**
	 * 删除多个商品
	 * @param ids
	 * @throws SQLException 
	 */
	public void deleteManyProduct(String[] ids) throws SQLException {
		if(ids!=null){
			ProductDao pDao = new ProductDao();
			for(String pid:ids){
				pDao.deleteProduct(pid);
			}
		}
	}
	/**
	 * 多条件查询
	 * @param name
	 * @param kw
	 * @return
	 * @throws SQLException 
	 */
	public List<Product> findProductByCondition(String name, String kw) throws SQLException {

		return ProductDao.findProductByCondition(name,kw);
	}
	
	/**
	 * 分页查询商品
	 * @param currPage 第几页
	 * @param pageSize 每页显示的条数
	 * @return pagebean
	 * @throws SQLException 
	 */
	public PageBean<Product> showProductsByPage(int currPage, int pageSize) throws SQLException {
		ProductDao dao = new ProductDao();
		//查询当前页数据  limit m,n  [limit (当前页-1)*每页显示条数，每页显示条数]
		List<Product> list = dao.findProductByPage(currPage,pageSize);
		
		//查询总条数
		int totalCount = dao.getCount();
		
		return new PageBean<>(list, currPage, pageSize, totalCount);
	}
	

}
