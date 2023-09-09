package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectionpool.ConnectionPool;

public class ProductDao {
	private static String url = "jdbc:postgresql://localhost:5432/productuser";
	private static String user = "postgres";
	private static String password = "root";

	void saveProduct(Product product) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = ConnectionPool.getConnectionObject();
			
			PreparedStatement preparedStatement = connection.prepareStatement("insert into product values(?,?,?,?)");
			preparedStatement.setInt(1, product.getId());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setString(3, product.getType());
			preparedStatement.setDouble(4, product.getCost());
			preparedStatement.execute();
			connection.close();
			ConnectionPool.receiveConnectionObject(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void updateProduct(Product product) {
		Product exsitingProduct = findById(product.getId());
		System.out.println(exsitingProduct.getCost());
		System.out.println(exsitingProduct.getType());
		System.out.println(exsitingProduct.getName());
		if (exsitingProduct != null) {
			if (product.getName() != null) {
				exsitingProduct.setName(product.getName());
			}
			if (product.getType() != null) {
				exsitingProduct.setType(product.getType());
			}
			if (product.getCost() != 0) {
				exsitingProduct.setCost(product.getCost());
			}

			
			try {
				Class.forName("org.postgresql.Driver");
				Connection connection = ConnectionPool.getConnectionObject();

				PreparedStatement preparedStatement = connection
						.prepareStatement("update product set name=?,type=?,cost=?  where id=?");
				preparedStatement.setString(1, exsitingProduct.getName());
				preparedStatement.setString(2, exsitingProduct.getType());
				preparedStatement.setDouble(3, exsitingProduct.getCost());
				preparedStatement.setInt(4, exsitingProduct.getId());

				preparedStatement.executeUpdate();
				connection.close();
				ConnectionPool.receiveConnectionObject(connection);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		System.out.println(exsitingProduct.getCost());
		System.out.println(exsitingProduct.getType());
		System.out.println(exsitingProduct.getName());

	}

	Product findById(int id) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = ConnectionPool.getConnectionObject();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from product where id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
			//resultSet.next();
				int id1 = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String type = resultSet.getString(3);
				double cost = resultSet.getDouble(4);
				resultSet.next();
				connection.close();
				ConnectionPool.receiveConnectionObject(connection);
				return new Product(id1, name, type, cost);
				
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	List<Product> displayAll() {
		List<Product> list = new ArrayList<Product>();

		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = ConnectionPool.getConnectionObject();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from product");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String type = resultSet.getString(3);
				double cost = resultSet.getDouble(4);
				Product product = new Product(id, name, type, cost);
				list.add(product);
				connection.close();
				ConnectionPool.receiveConnectionObject(connection);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	void deleteByID(int id) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = ConnectionPool.getConnectionObject();
			PreparedStatement preparedStatement = connection.prepareStatement("delete from product where id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
			System.out.println("Data deleted ");

			connection.close();
			ConnectionPool.receiveConnectionObject(connection);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
