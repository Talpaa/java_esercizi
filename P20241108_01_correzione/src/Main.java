import java.util.LinkedList;
//import java.util.Scanner;
import java.util.Collections;
public class Main {

	
	public static void main(String[] args) {
		
		LinkedList<Studente> lstud1 = new LinkedList<Studente>();
		LinkedList<Studente> lstud2 = new LinkedList<Studente>();
		LinkedList<Studente> lstud3 = new LinkedList<Studente>();
		LinkedList<Studente> lstud4 = new LinkedList<Studente>();
		
		//lstud1.add((Studente)ParseClass.Parse(Studente.class));
		//lstud1.add((Studente)ParseClass.Parse(Studente.class));
		/*lstud1.add(new Studente("Mario", "Rossi", 25, "Informatica", "2024/2025"));
		lstud1.add(new Studente("Maria", "Rossi", 24, "Informatica", "2024/2025"));
		lstud1.add(new Studente("Mario", "Rossi", 24, "Informatica", "2024/2025"));
		lstud1.add(new Studente("Mario", "Rossi", 24, "Elettronica", "2024/2025"));
		lstud1.add(new Studente("Martino", "Rossi", 24, "Informatica", "2024/2026"));
		lstud1.add(new Studente("Martino", "Rossi", 24, "Elettronica", "2024/2026"));*/
		
		lstud1.add(new Studente("Mario", "", 0, "", ""));
		lstud1.add(new Studente("Marco", "", 0, "", ""));
		lstud1.add(new Studente("Maria", "", 0, "", ""));
		
		System.out.println("Studenti creati finora: " + lstud1.getFirst().studentiCreati);
		System.out.println("Studenti non ordinati: ");
		
		System.out.println(lstud1);
		System.out.println();
		
		Collections.sort(lstud1);
		
		System.out.println("Studenti ordinati: ");
		
		System.out.println();
		System.out.println(lstud1);
		
		lstud2.add(new Studente("", "", 19, "", ""));
		lstud2.add(new Studente("", "", 17, "", ""));
		lstud2.add(new Studente("", "", 18, "", ""));
		
		System.out.println();
		System.out.println();
		
		System.out.println("Studenti creati finora: " + lstud2.getFirst().studentiCreati);
		System.out.println("Studenti non ordinati: ");
		
		System.out.println(lstud2);
		System.out.println();
		
		Collections.sort(lstud2);

		System.out.println("Studenti ordinati: ");
		
		System.out.println();
		System.out.println(lstud2);
		
		lstud3.add(new Studente("", "", 0, "Informatica", ""));
		lstud3.add(new Studente("", "", 0, "Lettere", ""));
		lstud3.add(new Studente("", "", 0, "Elettronica", ""));
		
		System.out.println();
		System.out.println();
		
		System.out.println("Studenti creati finora: " + lstud3.getFirst().studentiCreati);
		System.out.println("Studenti non ordinati: ");
		
		System.out.println(lstud3);
		System.out.println();
		
		Collections.sort(lstud3);

		System.out.println("Studenti ordinati: ");
		
		System.out.println();
		System.out.println(lstud3);
		
		lstud4.add(new Studente("", "", 0, "", "2024/2025"));
		lstud4.add(new Studente("", "", 0, "", "2022/2023"));
		lstud4.add(new Studente("", "", 0, "", "2023/2024"));
		
		System.out.println();
		System.out.println();
		
		System.out.println("Studenti creati finora: " + lstud4.getFirst().studentiCreati);
		System.out.println("Studenti non ordinati: ");
		
		System.out.println(lstud4);
		System.out.println();
		
		Collections.sort(lstud4);		

		System.out.println("Studenti ordinati: ");
		
		System.out.println();
		System.out.println(lstud4);
	}
}
