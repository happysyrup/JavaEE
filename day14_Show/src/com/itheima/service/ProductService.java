package com.itheima.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.dao.ProductDao;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;

public class ProductService {
	/**
	 * ��ѯ������Ʒ
	 * @return list
	 * @throws SQLException 
	 */
	public List<Product> findAll() throws SQLException {
		return new ProductDao().findAll();
	}
	/**
	 * �����Ʒ
	 * @param p
	 * @throws SQLException 
	 */
	public void addProduct(Product p) throws SQLException {
		new ProductDao().addProduct(p);
		
	}
	
	/**
	 * ɾ����Ʒ
	 * @param pid
	 * @throws SQLException 
	 */
	public void deleteProduct(String pid) throws SQLException {
		new ProductDao().deleteProduct(pid);
	}
	
	/**
	 * ͨ��pid������Ʒ
	 * @param pid
	 * @return
	 * @throws SQLException 
	 */
	public Product getProductById(String pid) throws SQLException {
		// TODO Auto-generated method stub
		return new ProductDao().getProductById(pid);
	}
	/**
	 * �޸���Ʒ��Ϣ
	 * @param p
	 * @throws SQLException 
	 */
	public void updateProduct(Product p) throws SQLException {
		new ProductDao().updateProduct(p);
	}
	
	/**
	 * ɾ�������Ʒ
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
	 * ��������ѯ
	 * @param name
	 * @param kw
	 * @return
	 * @throws SQLException 
	 */
	public List<Product> findProductByCondition(String name, String kw) throws SQLException {

		return ProductDao.findProductByCondition(name,kw);
	}
	
	/**
	 * ��ҳ��ѯ��Ʒ
	 * @param currPage �ڼ�ҳ
	 * @param pageSize ÿҳ��ʾ������
	 * @return pagebean
	 * @throws SQLException 
	 */
	public PageBean<Product> showProductsByPage(int currPage, int pageSize) throws SQLException {
		ProductDao dao = new ProductDao();
		//��ѯ��ǰҳ����  limit m,n  [limit (��ǰҳ-1)*ÿҳ��ʾ������ÿҳ��ʾ����]
		List<Product> list = dao.findProductByPage(currPage,pageSize);
		
		//��ѯ������
		int totalCount = dao.getCount();
		
		return new PageBean<>(list, currPage, pageSize, totalCount);
	}
	

}
