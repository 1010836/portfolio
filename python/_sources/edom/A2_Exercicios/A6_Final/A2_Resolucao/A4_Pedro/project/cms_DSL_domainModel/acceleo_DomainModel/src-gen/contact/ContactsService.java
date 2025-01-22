package contact;

import java.util.ArrayList;

interface ContactsService {
	
	Contact addContact(Contact contact);

	Boolean deleteContact(String id);

	ArrayList<ContactDetails> deleteContacts(ArrayList<String> ids);

	ArrayList<ContactDetails> getContactDetails();

	Contact getContact(String id);

	Contact updateContact(Contact contact);

}
