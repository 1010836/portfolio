import java.util.ArrayList;

public class CourseEdition {
	private int startYear;
	private ArrayList<ClassSection> turmas;
	
	public int getStartYear() {
		return startYear;
	}
	
	public void setEdition(int startYear) {
		this.startYear = startYear;
	}
	
	public void setClassSection(ArrayList<ClassSection> turmas) {
		this.turmas = turmas;
	}

	public ArrayList<ClassSection> getClassSection() {
		return turmas;
	}
}





