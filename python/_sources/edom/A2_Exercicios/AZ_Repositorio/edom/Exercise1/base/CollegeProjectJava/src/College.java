import java.util.ArrayList;
import java.util.Scanner;

public class College {
	
	public static String days(int i) {
		String dayName = "";
		
		switch (i) {
			case 0: 
				dayName = "Segunda-feira";
				break;
			case 1:
				dayName = "Terça-feira";
				break;
			case 2:
				dayName = "Quarta-feira";
				break;
			case 3:
				dayName = "Quinta-feira";
				break;
			case 4:
				dayName = "Sexta-feira";
				break;
			case 5:
				dayName = "Sábado";
				break;
			case 6:
				dayName = "Domingo";
				break;
		}
		
		return dayName;
	}
	
	public static String periods (int j) {
		String type = "";
		
		switch (j) {
			case 0:
				type = "OT - 18h10/19h";
				break;
			case 1:
				type = "T - 19h10/20h";
				break;
			case 2:
				type = "T - 20h10/21h";
				break;
			case 3:
				type = "PL - 21h40/23h30";
				break;
		}
		
		return type;
	}

	public static void main(String[] args) {
		// Assuming the data before schedule is already in the system...
		// Program
		Program p = new Program();
		p.setName("Mestrado em Engenharia Informática - Engenharia de Software");
		
		// Plan of Study
		PlanOfStudy pos = new PlanOfStudy();
		
		// Course aka Disciplina
		Course edom = new Course();
		edom.setName("EDOM");
		
		Course odsoft = new Course();
		edom.setName("ODSOFT");
		
		ArrayList<Course> cadeiras = new ArrayList<Course>();
		cadeiras.add(edom);
		cadeiras.add(odsoft);
		pos.setCourses(cadeiras);
		
		// CourseEdition aka Edições de uma Disciplina
		CourseEdition ce2017 = new CourseEdition();
		ce2017.setEdition(2017);
		
		ArrayList<CourseEdition> edicoes = new ArrayList<CourseEdition>();
		edicoes.add(ce2017);
		edom.setCourseEdition(edicoes);
		
		// ClassSection aka Turmas
		ClassSection m1a = new ClassSection();
		m1a.setName("M1A");
		
		ClassSection m1b = new ClassSection();
		m1b.setName("M1B");
		
		ArrayList<ClassSection> cs = new ArrayList<ClassSection>();
		cs.add(m1a);
		cs.add(m1b);
		ce2017.setClassSection(cs);
		
		// We will be adding schedules to a class section from 2017 edom
		System.out.println("Bem-vindo ao Gestor de Horários Universitários!");
		System.out.println("Responda com true para SIM e false para NÃO");
		
		Schedule h = new Schedule();
		boolean horario[][] = new boolean[7][4];
		Scanner scan = new Scanner(System.in);
		boolean value;
		boolean atribui;
		
		int ot = 1;
		int t = 2;
		int pl = 1;
		
		// Faz a leitura do horário
		for (int i = 0; i < 5; i++) {
			String dayName = days(i);
			for (int j = 0; j < 4; j++) {
				atribui = false;
				String type = periods(j);
				System.out.println(dayName + " - " + type + "? ");
				value = scan.nextBoolean();
				// Vê se já marcou todas as sessões daquele tipo ou se ainda pode marcar
				if (value == true) {
					if (j == 0 && ot == 1) { atribui = true; ot--; }
					if ((j == 1 || j == 2) && t > 0) { atribui = true; t--; }
					if (j == 3 && pl == 1) { atribui = true; pl --; }
					if (atribui == true) { horario[i][j] = value; }
					else { System.out.println("Já não pode marcar mais aulas deste tipo."); }
				}
			}
		}
		
		h.setSchedule(horario);
		m1a.setSchedule(h);
		
		// Apresenta o horário
		for (int i = 0; i < 5; i++) {
			String dayName = days(i);
			for (int j = 0; j < 4; j++) {
				String type = periods(j);
				if (horario[i][j] == true) {
					System.out.println(dayName + " - " + type);
				}
			}
		}
		
		// De notar que este horário não controla o início nem o fim do semestre, assim como feriados.
		// Teria que ser questionado ao utilizador pelo início e fim do semestre/aulas, assim como feriados, para que o horário
		// pudesse ser mostrado pelas semanas.
		// Não está a validar atropelamentos.
		// Não está a validar os quartos.
		// Incluir try catch.
		// Regra para OT 1 período, T 2, PL 1.
	}
}
