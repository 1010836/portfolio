package student;

import java.util.ArrayList;

public class StudentsServiceImpl implements StudentsService {
	private ArrayList<Student> students;
	
	public Student addStudent(Student student) {
		return student;
	}

	public Boolean deleteStudent(String id) {
		return true;
	}

	public ArrayList<StudentDetails> deleteStudents(ArrayList<String> ids) {
		return null;
	}

	public ArrayList<StudentDetails> getStudentDetails() {
		return null;
	}

	public Student getStudent(String id) {
		return null;
	}

	public Student updateStudent(Student student) {
		return student;
	}

}
