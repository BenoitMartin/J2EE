package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Objects.Offer;

public class OfferDAO extends DBConnection {

	public ArrayList<Offer> getOffersbybarcode(int id) {
		this.initConnection();

		Offer o = null;
		ArrayList<Offer> OfferList = new ArrayList<Offer>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		}
		try (Connection connexion = DriverManager.getConnection(this.getUrl_(),
				this.getUser_(), this.getPass_())) {
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

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			this.closeAll();
		}
		return OfferList;
	}
	
	
	public Offer getOffersbyKey(int barcode, int idRet) {
		this.initConnection();

		Offer o = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		}
		try (Connection connexion = DriverManager.getConnection(this.getUrl_(),
				this.getUser_(), this.getPass_())) {
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

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			this.closeAll();
		}
		return o;
	}
	

	public void DeleteOfferByBarcode(int id){
		this.initConnection();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		}
		try (Connection connexion = DriverManager.getConnection(this.getUrl_(),
				this.getUser_(), this.getPass_())) {
			String sqlQuery = "delete FROM Link where barcode=?";
			PreparedStatement state = connexion.prepareStatement(sqlQuery);
			state.setInt(1, id);
			state.executeUpdate();
			this.closeAll();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			this.closeAll();
		}
		
	}
	
	public void DeleteOfferByRetailerID(int id){
		this.initConnection();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		}
		try (Connection connexion = DriverManager.getConnection(this.getUrl_(),
				this.getUser_(), this.getPass_())) {
			String sqlQuery = "delete FROM Link where idRetailer=?";
			PreparedStatement state = connexion.prepareStatement(sqlQuery);
			state.setInt(1, id);
			state.executeUpdate();
			this.closeAll();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			this.closeAll();
		}
		
	}
	
	
}
