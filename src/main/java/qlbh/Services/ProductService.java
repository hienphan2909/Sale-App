package qlbh.Services;

import java.util.List;

import qlbh.DAO.ProductDAO;
import qlbh.Models.ProductModel;
import qlbh.iDAO.iProductDAO;
import qlbh.iServices.iProductService;

public class ProductService implements iProductService {

	public List<ProductModel> findAll() {
		iProductDAO productDAO = new ProductDAO();
		return productDAO.findAll();
	}

	public List<ProductModel> findByCountry(String country) {
		iProductDAO productDAO = new ProductDAO();
		return productDAO.findByCountry(country);
	}

	public int createOne(ProductModel productModel) {
		iProductDAO productDAO = new ProductDAO();
		return productDAO.createOne(productModel);
	}

}
