import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.platform.engine.UniqueId;

import javax.naming.directory.InvalidAttributesException;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ContactServiceTest {
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

	/* Feature: Happy Path
	 * Given: All valid inputs for a new contact
	 * When: Creating a new contact
	 * Then: Contact is added to contact list
	 */
	@Test
    public void createNewAppointmentTest() throws InvalidAttributesException {
      ContactService service = new ContactService();
      service.addContact(firstName, lastName, phoneNumber, address);
      assertNotNull(service.GetContactList().get(0).GetContactId());
      assertNotNull(service.GetContactList().get(0).GetContactId());
    }

	@Test
    public void removeContactTest(String uniqueId) throws Exception {
         ContactService service = new ContactService();
         service.addContact(firstName, lastName, phoneNumber, address);
         assertEquals(1, service.GetContactList().size());
         service.deleteContact(uniqueId);
     }


}