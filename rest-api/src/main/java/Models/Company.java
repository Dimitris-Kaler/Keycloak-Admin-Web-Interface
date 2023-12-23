package Models;

public class Company {
	String name;
	String catchPhrase;
	String hs;
	
	public Company() {
		
	}
	
	public Company(String name,String catchPhrase,String hs) {
		this.name=name;
		this.catchPhrase=catchPhrase;
		this.hs=hs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCatchPhrase() {
		return catchPhrase;
	}

	public void setCatchPhrase(String catchPhrase) {
		this.catchPhrase = catchPhrase;
	}

	public String getHs() {
		return hs;
	}

	public void setHs(String hs) {
		this.hs = hs;
	}
	

}
