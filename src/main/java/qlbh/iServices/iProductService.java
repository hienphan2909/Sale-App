package qlbh.iServices;

import java.util.List;

import qlbh.Models.ProductModel;

public interface iProductService {
	public List<ProductModel> findAll();
	public List<ProductModel> findByCountry(String country);
	public int createOne(ProductModel productModel);
}
