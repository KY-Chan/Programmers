package a_other;

public class EtcDTO {
	String id;
	String name;
	String email;
	String address;
	
	public EtcDTO(String id, String name, String email, String address) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	public String getEmail() {
		return email;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + id + " / " + name + " / " + email + " / " + address + "]";
	}
}
