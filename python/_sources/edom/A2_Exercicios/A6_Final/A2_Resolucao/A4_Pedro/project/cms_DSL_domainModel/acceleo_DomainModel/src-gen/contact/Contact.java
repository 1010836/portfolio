package contact;

public class Contact {
    private String name;

	private ArrayList<Student> students;

	private ContactDetails details;

	public ContactDetails getLightWeightContact() {
		return details;
	}

}
