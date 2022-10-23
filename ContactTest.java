import org.junit.Before;
import org.junit.Test;

import javax.naming.directory.InvalidAttributesException;

import static org.junit.Assert.*;

public class ContactTest {

    private String firstName = null;
    private String lastName = null;
    private String phoneNumber = null;
    private String address = null;

    @Before
    public void setUp() {
        firstName = "Steven";
        lastName = "Cognata";
        phoneNumber = "9085551270";
        address = "StreetName";
    }

	@Test
	public void testContact() throws InvalidAttributesException {
		Contact contact = new Contact(firstName, lastName, phoneNumber, address);
		assertTrue(contact.GetFirstName().equals("Steven"));
		assertTrue(contact.GetLastName().equals("Cognata"));
		assertTrue(contact.GetPhoneNumber().equals("9085551270"));
		assertTrue(contact.GetAddress().equals("StreetName"));

	}

	@Test
	public void testValidateName() throws InvalidAttributesException {
        firstName = "InvalidFirstnameLength";
		try {
            Contact contact = new Contact(firstName, lastName, phoneNumber, address);
        } catch (InvalidAttributesException e) {
		    assertEquals(e.getMessage(), "Invalid Arguments");
        }
	}
	
	

}