package qlbh.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import qlbh.Mapper.ProductMapper;
import qlbh.Mapper.rowMapper;

public class AbstractDAO<T> {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/qlbh";
			String user = "root";
			String password = "123456";
			return DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public List<T> query(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement prestm = null;
		ResultSet resultSet = null;
		List result = new ArrayList<T>();
		try {
			connection = getConnection();
			prestm = connection.prepareStatement(sql);
			setParameter(prestm, parameters);
			resultSet = prestm.executeQuery();
			while (resultSet.next()) {
				rowMapper mapper = new ProductMapper();
				result.add(mapper.ProductMapper(resultSet));
			}

			return result;

		} catch (Exception e) {
			System.out.println("loi trong abstractDAO" + e.getMessage());
			return null;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (prestm != null) {
					prestm.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (Exception e) {
				e.getMessage();
				return null;
			}

		}
	}

	public int update(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement preparedStm = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			preparedStm = connection.prepareStatement(sql);

			setParameter(preparedStm, parameters);
			preparedStm.executeUpdate();
			
			connection.commit();
			return 1;

		} catch (Exception e) {
			System.out.println("loi update trong abstractDAO " + e.getMessage());
			return 0;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStm != null) {
					preparedStm.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (Exception e) {
				e.getMessage();
				return 0;
			}

		}
	}

	public void setParameter(PreparedStatement prestm, Object... parameters) {
		try {
			for (int i = 0; i < parameters.length; i++) {
				Object parameter = parameters[i];
				int index = i + 1;
				if (parameter instanceof String) {
					prestm.setString(index, (String) parameter);
				}
				if (parameter instanceof Integer) {
					prestm.setInt(index, (Integer) parameter);
				}
				if (parameter instanceof Long) {
					prestm.setLong(index, (Long) parameter);
				}
			}

		} catch (Exception e) {
			System.out.println("loi trong setParameter" + e.getMessage());
		}
	}
}
