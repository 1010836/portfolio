package student;

import java.util.ArrayList;

interface StudentsService {
	
	Student addStudent(Student student);

	Boolean deleteStudent(String id);

	ArrayList<StudentDetails> deleteStudents(ArrayList<String> ids);

	ArrayList<StudentDetails> getStudentDetails();

	Student getStudent(String id);

	Student updateStudent(Student student);

}
