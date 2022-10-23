import javax.naming.directory.InvalidAttributesException;
import java.util.UUID;

public class Contact {
	private String contactId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	public Contact(String firstName, String lastName, String phoneNumber, String address) throws InvalidAttributesException {
		// If the parameters are not valid, throw exception.
		if (!IsValidContactInfo(firstName, lastName, phoneNumber, address)) {
			throw new InvalidAttributesException("Invalid Arguments");
		}
		this.contactId = UUID.randomUUID().toString().substring(0, 10);
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	private boolean IsValidContactInfo(String firstName, String lastName, String phoneNumber, String address) {

		if (firstName == null || firstName.length()>10) {
			return false;
		}

		if (lastName == null || lastName.length()>10) {
			return false;
		}

		if (phoneNumber == null || phoneNumber.length()>10) {
			return false;
		}

		if (address == null || address.length()>10) {
			return false;
		}

		return true;
	}

	public void updateAll(String firstname, String lastname, String phonenumber, String address) throws InvalidAttributesException {
		if (!IsValidContactInfo(firstname, lastname, phonenumber, address)) {
			throw new InvalidAttributesException("Invalid Arguments");
		}

		this.firstName = firstname;
		this.lastName = lastname;
		this.phoneNumber = phonenumber;
		this.address = address;
	}

	public String GetContactId(){
		return contactId;
	}
	
	public String GetFirstName(){
		return firstName;
	}

	public void SetFirstName(String firstName){
		this.firstName = firstName;
	}

	public String GetLastName(){
		return lastName;
	}

	public void SetLastName(String lastname){
		this.lastName = lastname;
	}

	public String GetPhoneNumber(){
		return phoneNumber;
	}

	public void SetPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}

	public String GetAddress(){
		return address;
	}

	public void SetAddress(String address){
		this.address = address;
	}

	@Override
	public boolean equals(Object obj) {

		// If the object is compared to itself then return true.
		if (this == obj) {
			return true;
		}

		// Verify that obj is an instance of Contact
		if (!(obj instanceof Contact)) {
			return false;
		}

		// Cast obj to Contact to compare
		Contact c = (Contact) obj;

		return this.GetFirstName().equals(c.GetFirstName())
				&& this.GetLastName().equals(c.GetLastName())
				&& this.GetPhoneNumber().equals(c.GetPhoneNumber())
				&& this.GetAddress().equals(c.GetAddress());
	}

}