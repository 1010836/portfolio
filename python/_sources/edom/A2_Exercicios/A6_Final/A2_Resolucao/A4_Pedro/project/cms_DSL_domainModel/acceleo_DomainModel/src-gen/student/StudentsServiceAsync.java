package student;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.ArrayList;

interface StudentsServiceAsync {
	
	void addStudent(Student student, AsyncCallback<Student> callback);

	void deleteStudent(String id, AsyncCallback<Boolean> callback);

	void deleteStudents(ArrayList<String> ids, AsyncCallback<ArrayList<StudentDetails>> callback);

	void getStudentDetails(AsyncCallback<ArrayList<StudentDetails>> callback);

	void getStudent(String id, AsyncCallback<Student> callback);

	void updateStudent(Student student, AsyncCallback<Student> callback);

}
