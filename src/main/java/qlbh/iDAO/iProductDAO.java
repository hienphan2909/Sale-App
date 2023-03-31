package qlbh.iDAO;

import java.util.List;

import qlbh.Models.ProductModel;

public interface iProductDAO {
	List<ProductModel> findAll();
	List<ProductModel> findByCountry(String country);
	int createOne(ProductModel productModel);
}
