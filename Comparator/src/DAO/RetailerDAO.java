package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Objects.Retailer;

public class RetailerDAO {

	public Retailer getRetailerbyID(int id) {
		Retailer r = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		}
		try {
			Connection connexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/comparator", "root", "root");
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
			state.close();
			connexion.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
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
		try {
			Connection connexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/comparator", "root", "root");
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
			state.close();
			connexion.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return listRetailer;
	}
	
//	public boolean updateRetailer() {
//		boolean success; 
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			System.out.println("Class not found");
//		}
//		try {
//			Connection connexion = DriverManager.getConnection(
//					"jdbc:mysql://localhost:3306/comparator", "root", "root");
//			String sqlQuery = "update product set name = ? where barcode=9;";
//			PreparedStatement state = connexion.prepareStatement(sqlQuery);
//			state.setString(1, "Bananeuh");
//			int rowCount =  state.executeUpdate();
//			state.close();
//			connexion.close();
//
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}
//		return listRetailer;
//	}
	

}
