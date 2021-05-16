package app.users;

public class User implements java.io.Serializable {
	private String username;
	private String name;
	private String surname;

	public User(String username) {
		this.setUsername(username);
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}

	
}
