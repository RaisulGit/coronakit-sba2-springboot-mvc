package com.eval.coronakit.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eval.coronakit.dao.ProductMasterRepository;
import com.eval.coronakit.entity.ProductMaster;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductMasterRepository repository;

	@Override
	@Transactional
	public ProductMaster addNewProduct(ProductMaster product) {
		if(product!=null) {
			if(repository.existsById(product.getId())) {
				//throw new ContactException("Contact Id already in use!");
			}
			//if(repository.existsByMobile(product.getMobile())) {
			//	throw new ContactException("Mobile Number is already in use!");
			//}
			repository.save(product);
		}
		return product;
	}

	@Override
	public List<ProductMaster> getAllProducts() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public ProductMaster deleteProduct(int productId) {
		if(!repository.existsById(productId)) {
			//throw new ContactException("Contact Id is not found!");
		}
		repository.deleteById(productId);
		ProductMaster product=null;
		return product;
	}

	@Override
	public ProductMaster getProductById(int productId) {
		return repository.findById(productId).orElse(null);
	}

}
