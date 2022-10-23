import javax.naming.directory.InvalidAttributesException;
import java.util.ArrayList;
import java.util.List;


public class ContactService {
	
	private List<Contact> contactList = new ArrayList<>();

	public void addContact(String firstname, String lastname, String phonenumber, String address) throws InvalidAttributesException {
		Contact contact = new Contact(firstname, lastname, phonenumber, address);
		contactList.add(contact);
	}

	public void deleteContact(String uniqueId) {
		for (Contact contact : this.contactList) {
			if (uniqueId.equals(contact.GetContactId())) {
				contactList.remove(contact);
			}
		}
	}

	public void updateContact(String uniqueId, String firstname, String lastname, String phonenumber, String address) throws InvalidAttributesException {
		for (Contact contact : this.contactList) {
			if (uniqueId.equals(contact.GetContactId())) {
				contact.updateAll(firstname, lastname, phonenumber, address);
			}
		}
	}

	public List<Contact> GetContactList() {
		return this.contactList;
	}

	public void SetContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}




}