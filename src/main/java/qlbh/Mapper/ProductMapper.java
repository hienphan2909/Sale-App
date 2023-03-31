package qlbh.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import qlbh.Models.ProductModel;

public class ProductMapper implements rowMapper<ProductModel>{

	public ProductModel ProductMapper(ResultSet resultSet) {
		try {
		ProductModel productModel = new ProductModel();
		productModel.setMasp(resultSet.getString("masp"));
		productModel.setTensp(resultSet.getString("tensp"));
		productModel.setDvt(resultSet.getString("dvt"));
		productModel.setNuocsx(resultSet.getString("nuocsx"));
		productModel.setGia(resultSet.getLong("gia"));

		return productModel;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	}

}
