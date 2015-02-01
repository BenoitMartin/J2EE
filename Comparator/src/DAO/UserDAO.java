package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Objects.User;

public class UserDAO extends DBConnection {

	public User getUserbyID(int id) {
		User u = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		}
		try {
			this.initConnection();
			Connection connexion = DriverManager.getConnection(this.getUrl_(),
					this.getUser_(), this.getPass_());
			String sqlQuery = "SELECT * FROM Users where id=?";
			PreparedStatement state;

			state = connexion.prepareStatement(sqlQuery);
			state.setInt(1, id);
			ResultSet rs = state.executeQuery();

			while (rs.next()) {
				String login = rs.getString("login");
				String password = rs.getString("password");
				boolean isAdmin = rs.getBoolean("isAdmin");
				u = new User(id, login, password, isAdmin);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return u;
	}

	public User getUserbyName(String name) {
		User u = null;
		this.initConnection();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		}
		try (Connection connexion = DriverManager.getConnection(this.getUrl_(),
				this.getUser_(), this.getPass_())) {
			String sqlQuery = "SELECT * FROM Users where login=?";
			PreparedStatement state = connexion.prepareStatement(sqlQuery);
			state.setString(1, name);
			ResultSet rs = state.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String password = rs.getString("password");
				boolean isAdmin = rs.getBoolean("isAdmin");
				u = new User(id, name, password, isAdmin);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			this.closeAll();
		}
		return u;
	}
}
