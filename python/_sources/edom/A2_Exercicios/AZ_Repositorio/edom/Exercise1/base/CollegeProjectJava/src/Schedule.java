import java.util.ArrayList;

public class Schedule {
	boolean horario[][] = new boolean[7][4];
	
	public void setSchedule(boolean[][] horario) {
		this.horario = horario;
	}

	public boolean[][] getSchedule() {
		return horario;
	}
}
