package user;

public class User {
	private int id;
	private String username;
	private String password;
	private String email;
	private long phno;
		
	public User(int id, String username, String password, String email, long phno) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phno = phno;
	}
	public User()
	{
		
	}
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public long getPhno() {
		return phno;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	@Override
	public String toString() {
		return "id=" + id + "\nusername=" + username + "\npassword=" + password + "\nemail=" + email + "\nphno="
				+ phno;
	}
	
	

}
