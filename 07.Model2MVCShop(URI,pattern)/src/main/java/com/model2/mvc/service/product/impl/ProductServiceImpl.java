package com.model2.mvc.service.product.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.ProductDao;

@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService{
	
//	Field
	@Autowired
	@Qualifier("productDaoImpl")
	private ProductDao productDao;
	public void setProducDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	public ProductServiceImpl() {
		System.out.println(this.getClass());   // 생성자 메서드가 실행되었는지 디버깅용도, 
	}

	public void addProduct(Product product) throws Exception {
		System.out.println("addProduct ServiceImpl 시작");
		productDao.insertProduct(product);
		System.out.println("addProduct ServiceImpl 완료");
	}

	public Product getProduct(int prodNo) throws Exception {
		return productDao.findProduct(prodNo);
	}

	public Map<String,Object> getProductList(Search search) throws Exception {
		System.out.println("ProductServiceImpl시작");
		List<Product> list= productDao.getProductList(search);
		int totalCount = productDao.getTotalCount(search);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list );
		map.put("totalCount", new Integer(totalCount));
		
		return map;
	}

	public void updateProduct(Product product) throws Exception {
		productDao.updateProduct(product);
	}

}


