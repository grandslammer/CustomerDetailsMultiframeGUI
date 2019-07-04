
public class Customer {
	private String ID;
	private String name;
	private String address1;
	private String address2;
	private String phoneNumber;

	Customer(String strID, String strName, String strA1, String strA2, String strPhone) {
		ID = strID;
		name = strName;
		address1 = strA1;
		address2 = strA2;
		phoneNumber = strPhone;
	}

	public Customer() {
	}

	public String getFullDetails() {
		return ID + " "+ name + " " + address1 + "  "+ address2 + " " + phoneNumber + "\n";
	}

	// Setters
	public void setID(String i) {
		ID = i;
	}

	public void setName(String n) {
		name = n;
	}

	public void setAddress1(String a) {
		address1 = a;
	}

	public void setAddress2(String a) {
		address2 = a;
	}

	public void setPhoneNumber(String p) {
		phoneNumber = p;
	}

	// Getters
	public String getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public String getAddress1() {
		return address1;
	}

	public String getAddress2() {
		return address2;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
}
