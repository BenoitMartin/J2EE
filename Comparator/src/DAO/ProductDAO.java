package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Objects.Product;

public class ProductDAO {

	public Product getProductbyID(int id) {
		Product p = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		}
		try {
			Connection connexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/comparator", "root", "root");
			String sqlQuery = "SELECT * FROM Product where barcode=?";
			PreparedStatement state = connexion.prepareStatement(sqlQuery);
			state.setInt(1, id);
			ResultSet rs = state.executeQuery();

			while (rs.next()) {
				int barcode = rs.getInt("barcode");
				String name = rs.getString("name");
				p = new Product(barcode, name);
			}
			state.close();
			connexion.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return p;
	}
	
}
