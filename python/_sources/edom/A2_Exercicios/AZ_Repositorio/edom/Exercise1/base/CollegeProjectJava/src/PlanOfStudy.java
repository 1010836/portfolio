import java.util.ArrayList;

public class PlanOfStudy {
	private ArrayList<Course> cadeiras;
	
	public void setCourses(ArrayList<Course> cadeiras) {
		this.cadeiras = cadeiras;
	}

	public ArrayList<Course> getCourses() {
		return cadeiras;
	}
}
