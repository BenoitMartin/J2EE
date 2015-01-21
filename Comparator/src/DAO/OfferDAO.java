package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Objects.Offer;

public class OfferDAO {

	public ArrayList<Offer> getOffersbybarcode(int id) {
		Offer o = null;
		ArrayList<Offer> OfferList = new ArrayList<Offer>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		}
		try {
			Connection connexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/comparator", "root", "root");
			String sqlQuery = "SELECT * FROM Link where barcode=?";
			PreparedStatement state = connexion.prepareStatement(sqlQuery);
			state.setInt(1, id);
			ResultSet rs = state.executeQuery();

			while (rs.next()) {
				int idRetailer = rs.getInt("idRetailer");
				float price = rs.getFloat("price");
				RetailerDAO r = new RetailerDAO();
				o = new Offer(r.getRetailerbyID(idRetailer),price);
				OfferList.add(o);
			}
			state.close();
			connexion.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return OfferList;
	}
	
	
	public Offer getOffersbyKey(int barcode, int idRet) {
		Offer o = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		}
		try {
			Connection connexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/comparator", "root", "root");
			String sqlQuery = "SELECT * FROM Link where barcode=? and idRetailer=?";
			PreparedStatement state = connexion.prepareStatement(sqlQuery);
			state.setInt(1, barcode);
			state.setInt(2, idRet);
			ResultSet rs = state.executeQuery();

			while (rs.next()) {
				float price = rs.getFloat("price");
				RetailerDAO r = new RetailerDAO();
				o = new Offer(r.getRetailerbyID(idRet),price);
			}
			state.close();
			connexion.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return o;
	}
	

	
}
