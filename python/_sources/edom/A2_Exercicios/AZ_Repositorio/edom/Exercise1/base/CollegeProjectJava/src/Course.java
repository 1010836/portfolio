import java.util.ArrayList;

public class Course {
	
	private String name;
	private ArrayList<CourseEdition> edicoes;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCourseEdition(ArrayList<CourseEdition> edicoes) {
		this.edicoes = edicoes;
	}

	public ArrayList<CourseEdition> getCourseEdition() {
		return edicoes;
	}
}





