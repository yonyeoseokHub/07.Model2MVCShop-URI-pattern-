package com.model2.mvc.service.product.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductDao;

@Repository("productDaoImpl")
public class ProductDaoImpl implements ProductDao {
	
//	Field
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void insertProduct(Product product) throws Exception {
		System.out.println("insertProduct 시작");
		sqlSession.insert("ProductMapper.addProduct", product);
		System.out.println("insertProduct 끝");

	}

	@Override
	public Product findProduct(int prodNo) throws Exception {
		return sqlSession.selectOne("ProductMapper.getProduct", prodNo);
	}


	@Override
	public void updateProduct(Product product) throws Exception {
		System.out.println("updateProduct 시작");
		sqlSession.update("ProductMapper.updateProduct", product);
		System.out.println("updateProduct끝");
	}

	@Override
	public List<Product> getProductList(Search search) throws Exception {
		System.out.println("getProductList 시작");
		return sqlSession.selectList("ProductMapper.getProductList", search); 
	}
	
	@Override
	public int getTotalCount(Search search) throws Exception {
		System.out.println("getTotalCount 시작");
		return sqlSession.selectOne("ProductMapper.getTotalCount", search);
	}

}
