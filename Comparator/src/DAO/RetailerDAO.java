package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Objects.Retailer;

public class RetailerDAO extends DBConnection {

	public Retailer getRetailerbyID(int id) {
		this.initConnection();
		Retailer r = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		}
		try (Connection connexion = DriverManager.getConnection(this.getUrl_(),
				this.getUser_(), this.getPass_())) {
			String sqlQuery = "SELECT * FROM Retailer where idRetailer=?";
			PreparedStatement state = connexion.prepareStatement(sqlQuery);
			state.setInt(1, id);
			ResultSet rs = state.executeQuery();

			while (rs.next()) {
				int idRetailer = rs.getInt("idRetailer");
				String name = rs.getString("name");
				float distance = rs.getFloat("distance");
				r = new Retailer(idRetailer, name, distance);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			this.closeAll();
		}

		return r;
	}

	public ArrayList<Retailer> getRetailerList() {
		ArrayList<Retailer> listRetailer = new ArrayList<Retailer>();
		Retailer r = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		}
		try (Connection connexion = DriverManager.getConnection(this.getUrl_(),
				this.getUser_(), this.getPass_())) {
			String sqlQuery = "SELECT * FROM Retailer";
			PreparedStatement state = connexion.prepareStatement(sqlQuery);
			ResultSet rs = state.executeQuery();

			while (rs.next()) {
				int idRetailer = rs.getInt("idRetailer");
				String name = rs.getString("name");
				float distance = rs.getFloat("distance");
				r = new Retailer(idRetailer, name, distance);
				listRetailer.add(r);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			this.closeAll();
		}
		return listRetailer;
	}

	public void DeleteRetailer(int id) {
		this.initConnection();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		}
		try (Connection connexion = DriverManager.getConnection(this.getUrl_(),
				this.getUser_(), this.getPass_())) {
			String sqlQuery = "delete FROM retailer where idRetailer=?";
			PreparedStatement state = connexion.prepareStatement(sqlQuery);
			state.setInt(1, id);
			state.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			this.closeAll();
		}

	}

	public void AddRetailer(int id, String nameR, float rDistance) {
		this.initConnection();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		}
		try (Connection connexion = DriverManager.getConnection(this.getUrl_(),
				this.getUser_(), this.getPass_())) {

			String sqlQuery = "insert into retailer (idRetailer,name,distance) values(?,?,?)";
			PreparedStatement state = connexion.prepareStatement(sqlQuery);
			state.setInt(1, id);
			state.setString(2, nameR);
			state.setFloat(3, rDistance);
			state.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			this.closeAll();
		}

	}

	// public boolean updateRetailer() {
	// boolean success;
	// try {
	// Class.forName("com.mysql.jdbc.Driver");
	// } catch (ClassNotFoundException e) {
	// System.out.println("Class not found");
	// }
	// try (Connection connexion = DriverManager.getConnection(this.getUrl_(),
	// this.getUser_(), this.getPass_())) {
	// String sqlQuery = "update product set name = ? where barcode=9;";
	// PreparedStatement state = connexion.prepareStatement(sqlQuery);
	// state.setString(1, "Bananeuh");
	// int rowCount = state.executeUpdate();
	// state.close();
	// connexion.close();
	//
	// } catch (SQLException e) {
	// System.out.println(e.getMessage());
	// }
	// return listRetailer;
	// }

}
