package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Objects.Product;

public class ProductDAO extends DBConnection {

	public Product getProductbyID(int id) {
		this.initConnection();
		Product p = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		}
		try (Connection connexion = DriverManager.getConnection(this.getUrl_(),
				this.getUser_(), this.getPass_())) {
			String sqlQuery = "SELECT * FROM Product where barcode=?";
			PreparedStatement state = connexion.prepareStatement(sqlQuery);
			state.setInt(1, id);
			ResultSet rs = state.executeQuery();

			while (rs.next()) {
				int barcode = rs.getInt("barcode");
				String name = rs.getString("name");
				p = new Product(barcode, name);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			this.closeAll();
		}
		return p;
	}

	public ArrayList<Product> getAllProducts() {
		this.initConnection();
		ArrayList<Product> p = new ArrayList<Product>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		}
		try (Connection connexion = DriverManager.getConnection(this.getUrl_(),
				this.getUser_(), this.getPass_())) {
			String sqlQuery = "SELECT * FROM Product";
			PreparedStatement state = connexion.prepareStatement(sqlQuery);
			ResultSet rs = state.executeQuery();

			while (rs.next()) {
				int barcode = rs.getInt("barcode");
				String name = rs.getString("name");
				p.add(new Product(barcode, name));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			this.closeAll();
		}
		return p;
	}

	public void DeleteProduct(int id) {
		this.initConnection();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		}
		try (Connection connexion = DriverManager.getConnection(this.getUrl_(),
				this.getUser_(), this.getPass_())) {
			String sqlQuery = "delete FROM Product where barcode=?";
			PreparedStatement state = connexion.prepareStatement(sqlQuery);
			state.setInt(1, id);
			state.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			this.closeAll();
		}

	}
}
