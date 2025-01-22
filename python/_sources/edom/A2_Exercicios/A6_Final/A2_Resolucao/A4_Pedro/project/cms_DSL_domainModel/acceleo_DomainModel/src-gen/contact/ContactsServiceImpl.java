package contact;

import java.util.ArrayList;

public class ContactsServiceImpl implements ContactsService {
	private ArrayList<Contact> contacts;
	
	public Contact addContact(Contact contact) {
		return contact;
	}

	public Boolean deleteContact(String id) {
		return true;
	}

	public ArrayList<ContactDetails> deleteContacts(ArrayList<String> ids) {
		return null;
	}

	public ArrayList<ContactDetails> getContactDetails() {
		return null;
	}

	public Contact getContact(String id) {
		return null;
	}

	public Contact updateContact(Contact contact) {
		return contact;
	}

}
