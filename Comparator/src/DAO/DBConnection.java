package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public abstract class DBConnection {

	private String user = "root";
	private String pass = "root";
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/comparator";
	protected PreparedStatement state = null;
	protected ResultSet rs = null;

	/**
	 * Try to initiate the connection with the database
	 */
	protected void initConnection() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Close the statement et ResultSet instances
	 */
	public void closeAll() {
		try {
			if (!(state == null))
				state.close();
			if (!(rs == null))
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the user_
	 */
	public String getUser_() {
		return user;
	}

	/**
	 * @param user_
	 *            the user_ to set
	 */
	public void setUser_(String user_) {
		this.user = user_;
	}

	/**
	 * @return the pass_
	 */
	public String getPass_() {
		return pass;
	}

	/**
	 * @param pass_
	 *            the pass_ to set
	 */
	public void setPass_(String pass_) {
		this.pass = pass_;
	}

	/**
	 * @return the driver_
	 */
	public String getDriver_() {
		return driver;
	}

	/**
	 * @param driver_
	 *            the driver_ to set
	 */
	public void setDriver_(String driver_) {
		this.driver = driver_;
	}

	/**
	 * @return the url_
	 */
	public String getUrl_() {
		return url;
	}

	/**
	 * @param url_
	 *            the url_ to set
	 */
	public void setUrl_(String url_) {
		this.url = url_;
	}

	/**
	 * @return the state
	 */
	public PreparedStatement getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(PreparedStatement state) {
		this.state = state;
	}

	/**
	 * @return the rs
	 */
	public ResultSet getRs() {
		return rs;
	}

	/**
	 * @param rs
	 *            the rs to set
	 */
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

}
