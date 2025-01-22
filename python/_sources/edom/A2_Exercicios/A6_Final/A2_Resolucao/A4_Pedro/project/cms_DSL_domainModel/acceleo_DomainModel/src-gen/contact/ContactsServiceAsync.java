package contact;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.ArrayList;

interface ContactsServiceAsync {
	
	void addContact(Contact contact, AsyncCallback<Contact> callback);

	void deleteContact(String id, AsyncCallback<Boolean> callback);

	void deleteContacts(ArrayList<String> ids, AsyncCallback<ArrayList<ContactDetails>> callback);

	void getContactDetails(AsyncCallback<ArrayList<ContactDetails>> callback);

	void getContact(String id, AsyncCallback<Contact> callback);

	void updateContact(Contact contact, AsyncCallback<Contact> callback);

}
