package qlbh.DAO;

import java.util.List;

import qlbh.Models.ProductModel;
import qlbh.iDAO.iProductDAO;

public class ProductDAO extends AbstractDAO<ProductModel> implements iProductDAO {

	public List<ProductModel> findAll() {
		StringBuffer sql = new StringBuffer("SELECT *");
		sql.append(" FROM SANPHAM");
		List<ProductModel> data = query(sql.toString(), null);
		return data;
	}

	public List<ProductModel> findByCountry(String country) {
		StringBuffer sql = new StringBuffer("SELECT *");
		sql.append(" FROM SANPHAM");
		sql.append(" WHERE NUOCSX = ?");
		List<ProductModel> data = query(sql.toString(), country);
		return data;
	}

	public int createOne(ProductModel productModel) {
		StringBuffer sql = new StringBuffer("INSERT INTO");
		sql.append(" sanpham(masp, tensp, dvt, nuocsx, gia)");
		sql.append(" VALUES (?, ?, ?, ?, ?)");
		update(sql.toString(), productModel.getMasp(), productModel.getTensp(), productModel.getDvt(),
				productModel.getNuocsx(), productModel.getGia());
		System.out.println("tao thanh cong");
		System.out.println();
		return 1;
	}

}
