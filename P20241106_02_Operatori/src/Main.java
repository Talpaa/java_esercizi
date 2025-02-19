import java.util.Scanner; // import the Scanner class 

public class Main {

	public static void main(String[] args) {
		
		Studente studente = new Studente("nome", "cognome", 0, "matricola");
		String[] nomi = {"Emma", "Alice", "Giulia", "Elena", "Camilla", "Enea", "Gioele", "Lorenzo", "Andrea", "Marco"};
		String[] cognomi = {"Rossi", "Russo", "Ferrari", "Esposito", "Bianchi", "Romano", "Colombo", "Ricci", "Gallo", "Barbieri"};
		Studente studenti[] = new Studente[10];
		
		int i = 4;
		Scanner input = new Scanner(System.in);	
		
		do {
			
		    
			System.out.println("Selezionare una scelta:\n");
			System.out.println("	1)Creazione studente random");
			System.out.println("	2)Inserimento studente nell'array");
			System.out.println("	3)Stampa studenti");
			System.out.println("	4)Sostituisci studente");
			System.out.println("	5)EXIT\n"); 
			  System.out.print("	SCELTA: ");
		    i = input.nextInt();   
			
			
			// consente di creare nuovi studenti, di inserirli in un vettore di 10 studenti e di stamparli tutti
			switch(i) {
			
				case 1:
					System.out.println("\n\n	1)Creazione studente random");
			
					
					String nome = nomi[ (int)( Math.random() * 10) ];
					String cognome = cognomi[ (int)( Math.random() * 10) ];
					
					int età = (int)( Math.random() * 100);
					String matricola = CreaMatricola();
					
					studente = new Studente(nome, cognome, età, matricola);
					System.out.println("\n		" + studente + "\n\n");
				    break;
				case 2:
										
					if (studente.getNome() != "nome") {
					
						System.out.println("\n\n	2)Inserimento studente nell'array");
						
						boolean flag = true;
						
						for (int j = 0; j<10; j++) {
							
							if (studenti[j] == null) {
								
								studenti[j] = studente;
								flag = false;
								System.out.println("\n		Inserimento N." + (j+1) + " eseguito correttamente\n\n");
							}
							
							if (flag) {}else {break;}
							
						}
						
						if (flag) {
							System.out.println("\n		Spazio nell'array easurito\n\n");
						}
					}else {System.out.println("\n		Prima di inserire uno studente nell'array devi prima generarlo.");}
					
				    break;
				case 3:
					System.out.println("	3)Stampa studenti\n");
					
					System.out.println(studente.Stampa(studenti));

					System.out.println("\n");
				    break;
				    
				case 4:
					
					if (studente.getNome() != "nome") {
						
						if (studenti[9] != null) {
					
							System.out.println("	4)Sostituisci studente");
		
							System.out.print("		In quale posizione si trova lo studente che vuoi sostituire: ");
							int s = input.nextInt();
							
							System.out.println("\n");
							
							if ((s >= 0)&(s <= 10)) {
								
								studenti[s-1] = studente;
							}
							
						}else {System.out.println("\n		Prima di poter scambiare uno studente nell'array devi prima finirlo di riempire.\n\n");}
					}else {System.out.println("\n		Prima di poter scambiare uno studente devi prima crearlo.\n\n");}
				    break;

				case 5:
					System.out.println("\n\n\n\n\nArrivederci.");
					input.close();
				    break;
				default:
					System.out.println("Il valore inserito non rappresenta una scelta.");
			}
			
		}while(i != 5);
			

	}
	
	public static String  CreaMatricola() {
		
		String cifre[] = {"0", "1", "2", "3", "4", "5", "6", "8", "9"};
		String matricola = "";
		
		for (int i = 0; i<10; i++) {
			
			matricola += cifre[(int)(( Math.random() * 10)-1)];
		}
		
		return matricola;
	}

}
