package Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name="User")
@Table(name="Users")

public class User {

	@Column(name="id",
            table="Users")
	@Id
	private int id;
	@Column(name="login",
            table="Users")
	private String login;
	@Column(name="password",
            table="Users")
	private String password;
	@Column(name="isAdmin",
            table="Users")
	private boolean isAdmin;
	
	public User(int id, String l, String p,boolean b){
		this.id=id;
		this.login=l;
		this.password=p;
		this.isAdmin=b;
	}


	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the isAdmin
	 */
	public boolean isAdmin() {
		return isAdmin;
	}

	/**
	 * @param isAdmin the isAdmin to set
	 */
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public String toString(){
		return "Id : "+this.id+"\n Login : "+this.login+"\n Password : "+this.password+"\n isAdmin"+this.isAdmin;
		
	}
	
}
