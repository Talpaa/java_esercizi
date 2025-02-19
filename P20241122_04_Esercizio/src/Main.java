import java.util.LinkedList;
import java.util.Scanner;
import java.util.Collections;
public class Main {

	
	public static void main(String[] args) {
		
		LinkedList<Studente> lstud = new LinkedList<Studente>();
		
		//lstud.add((Studente)ParseClass.Parse(Studente.class));
		//lstud.add((Studente)ParseClass.Parse(Studente.class));
		lstud.add(new Studente("Mario", "Rossi", 24, "Informatica", "2024/2025"));
		lstud.add(new Studente("Luigi", "Verdi", 27, "Elettronica", "2024/2025"));
		lstud.add(new Studente("Francesco", "Bianchi", 27, "Giurisprudenza", "2024/2025"));
		lstud.add(new Studente("Mario", "Rossi", 24, "Informatica", "2024/2025"));
		
		System.out.println("Studenti creati finora: " + lstud.getFirst().studentiCreati);
		
		System.out.println(lstud);
		
		System.out.println();
		
		LinkedList<Integer> li = new LinkedList<Integer>();
		li.add(10);
		li.add(20);
		li.add(1);
		System.out.println(li);
		
		Collections.sort(li);
		
		System.out.println(li);
		
		Collections.reverse(li);
		
		System.out.println(li);
		
		System.out.println(Collections.max(li));
		System.out.println(Collections.min(li));
		
		Collections.sort(lstud);
		
		System.out.println(lstud);
		
		int result = lstud.get(1).compareTo(lstud.get(2));
		
		
		System.out.println(result);
		
		
		
		
		
		
		
		
		
		
		
		
		
		if(false) {
			//Persona p1 = (Persona)ParseClass.Parse("Persona");
			//Persona p1 = (Persona)ParseClass.Parse(Persona.class);
			//System.out.println(p1);
			
			Studente s1 = (Studente)ParseClass.Parse("Studente");
			
			System.out.println(s1);
			
			Paziente paz1 = (Paziente)ParseClass.Parse("Paziente");
			
			System.out.println(paz1);
			
			EssereVivente ev1 = new EssereVivente() {
				
				@Override
				public void SetColoreOcchi(String s) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public String GetColoreOcchi(String s) {
					// TODO Auto-generated method stub
					return null;
				}
			};
		}
	}
}
