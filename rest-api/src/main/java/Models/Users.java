package Models;

public class Users {
	String id;
	String username;
	String firstName;
	String lastName;
	String email;
	
	Attributes attributes;
	Credentials credentials;
	
	public Users(String id,String username,String firstName,String lastName,String email) {
		this.id=id;
		this.username=username;
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.attributes=new Attributes();
		this.credentials=new Credentials();
		
		
	}
	public Users(String username,String firstName,String lastName,String email) {
		
		this.username=username;
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.attributes=new Attributes();
		this.credentials=new Credentials();
		
		
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", attributes=" + attributes + "]";
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Attributes getAttributes() {
		return attributes;
	}

	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}

}