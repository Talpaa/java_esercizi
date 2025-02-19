import java.util.LinkedList;
import java.util.Scanner;

public class CompagniaAerea {

	private LinkedList<Aereo> aerei = new LinkedList<Aereo>();	
	private LinkedList<Volo> voli = new LinkedList<Volo>();
	
	
	public CompagniaAerea() {
		super();
	}
	
	public CompagniaAerea(LinkedList<Aereo> aerei, LinkedList<Volo> voli) {
		super();
		this.aerei = aerei;
		this.voli = voli;
	}


	public LinkedList<Aereo> getAerei() {
		return aerei;
	}
	public void setAerei(LinkedList<Aereo> aerei) {
		this.aerei = aerei;
	}
	public LinkedList<Volo> getVoli() {
		return voli;
	}
	public void setVoli(LinkedList<Volo> voli) {
		this.voli = voli;
	}
	
	public Volo CreaVolo(String nome, String partenza, String arrivo, Aereo aereo, String decollo, String atteraggio){
		
		Volo volo = new Volo(nome, partenza, arrivo, aereo, decollo, atteraggio);
		voli.add(volo);
		return volo;
		
	}
	public void CancellaVolo(String nomeVolo){
		
		for (Volo volo : voli) {
			
			if (volo.getNome() == nomeVolo) {
				voli.remove(volo);
			}
		}
	}
	
	public Aereo CreaAereo(String nomeAereo, Integer posti){
		
		Aereo aereo = new Aereo(nomeAereo, posti);
		aerei.add(aereo);
		System.out.println("\n Aereo creato.");
		return aereo;
	}
	public void EliminaAereo(String nomeAereo){
		Boolean flag = true;
		
		for (Aereo aereo : aerei) {
			
			if (aereo.getNome().equals(nomeAereo)) {
				
				for (Volo volo : voli) {
					
					if (volo.getAereo() == aereo) {
						
						
						voli.remove(volo);
					}
				}
				flag = false;
				aerei.remove(aereo);

				System.out.println("\nAereo cancellato e tutti i voli a lui associato.");
			}
		}
		if(flag) {
			System.out.println("\nNessun aereo con quel nome");
		}
	}

	private void EliminaVolo(String nomeVolo) {
		Boolean flag = true;
		
		for (Volo volo : voli) {
			
			if (volo.getNome().equals(nomeVolo)) {
				
				flag = false;
				voli.remove(volo);
				System.out.println("\nVolo cancellato.");
				}
		}
		if(flag) {
			System.out.println("\nNessun volo con quel nome");
		}
		
	}
	
	public void PrenotaVolo(String nomeVolo, Integer posti) {
		
		for (Volo volo : voli) {
			
			if (volo.getNome().equals(nomeVolo)) {
				
				volo.PrenotaVolo(posti, nomeVolo);
			}
		}
	}
	public void CancellaPrenotazione(String nomeVolo, Integer posti) {
		
		for (Volo volo : voli) {
			
			if (volo.getNome().equals(nomeVolo)) {
				
				volo.CancellaPrenotazione(posti, nomeVolo);
			}
		}
	}
	
	public Aereo TrovaAereo(String nomeAereo) {
		
		for (Aereo aereo : aerei) {
			if (aereo.getNome().equals(nomeAereo)) {
				return(aereo);
			}
		}
		
		return null;
		 
	}
	
	public Volo TrovaVolo(String nomeVolo) {
		
		for (Volo volo: voli) {
			if (volo.getNome().equals(nomeVolo)) {
				return(volo);
			}
		}
		
		return null;
		 
	}
	
	public void Menu() {
		//Menu per compagnia aerea
			//crea aereo
			//elimina aereo
		@SuppressWarnings("resource")//viene chiuso nel main.
		Scanner input = new Scanner(System.in);
		
		Integer operazione = 0;
		Boolean ris = true;
		
		do {
			
			//Menu Generale
			System.out.println("\n1) Crea aereo;");
			System.out.println("2) Elimina aereo;");
			System.out.println("3) Crea volo;");
			System.out.println("4) Elimina volo;");
			System.out.println("5) Exit");
			System.out.print("Quale operazione vuoi eseguire(Digitare il numero associato): ");
			operazione = input.nextInt(); 
			
			switch (operazione) {
			case 1: {
				System.out.print("\nQuale è il nome dell'aereo che vuoi creare: ");
				String nomeAereo = input.next();
				
				System.out.print("\nQuale è il numero di posti disponibili sull'aereo che vuoi creare: ");
				Integer posti = input.nextInt();
				
				CreaAereo(nomeAereo, posti);
				break;
			}
			case 2: {

				System.out.print("\nQuale è il nome dell'aereo che vuoi eliminare: ");
				String nomeAereo = input.next();
				
				EliminaAereo(nomeAereo);
				break;
			}
			case 3: {
				
				if (aerei.getFirst() != null) {

					System.out.print("\nQuale è il nome del volo che vuoi creare: ");
					String nomeVolo = input.next();
					
					System.out.print("\nQuale è il luogo della partenza del volo che vuoi creare: ");
					String partenza = input.next();
					
					System.out.print("\nQuale è il luogo di arrivo del volo che vuoi creare: ");
					String arrivo = input.next();
					
					Boolean flag = false;
					Integer oraP = null;
					Integer min = null;
					String oraS = null;
					do {
						
						if(flag) {
							System.out.println("\nOra non valida");
							}
						
						flag = false;
						System.out.print("\nQuale è il valore dell'ora dell'orario di partenza del volo che vuoi creare: ");
						oraS = input.next();
						
						try {
							if (oraS.length() == 1) {
								oraS = "0" + oraS;
							}
							oraP = Integer.valueOf(oraS);
							
							if ( (oraP<0)||(oraP>24) ) {
								flag = true;
								
							}
							
							
						} catch (Exception e) {
							flag = true;
						}
						
						oraS = String.valueOf(oraP);
						
						if (oraS.length() == 1) {
							oraS = "0" + oraS;
						}
						
					}while(flag);
					
					String minS = null;
					
					do {
						
						if(flag) {
							System.out.println("\nMinuti non validi");
							}
						
						flag = false;
						System.out.print("\nQuale è il valore dei minuti dell'orario di partenza del volo che vuoi creare: ");
						minS = input.next();
						
						try {
							
							if (minS.length() == 1) {
								minS = "0" + minS;
							}
							
							min = Integer.valueOf(minS);
							
							if ( (min<0)||(min>59) ) {
								flag = true;
								
							}
						} catch (Exception e) {
							flag = true;
						}
						
						minS = String.valueOf(min);
						
						if (minS.length() == 1) {
							minS = "0" + minS;
						}
						
					}while(flag);
					
					String decollo = String.format("%s:%s", oraS,minS);
					Integer oraA = null;
					String oraAS = null;
					
					do {
						
						if(flag) {
							System.out.println("\nOra non valida");
							}
						
						flag = false;
						System.out.print("\nQuale è il valore dell'ora dell'orario di arrivo del volo che vuoi creare: ");
						oraAS = input.next();
						
						try {
							if (oraAS.length() == 1) {
								oraAS = "0" + oraAS;
							}
							oraA = Integer.valueOf(oraAS);
							
							if ( (oraA<0)||(oraA>24) ) {
								flag = true;
								
							}else if (oraA <= oraP) {
								flag = true;
								System.out.println("\nL'ora di arrivo non può essere più piccola di quella di partenza.");
							}
							
						} catch (Exception e) {
							flag = true;
						}
						
						oraAS = String.valueOf(oraP);
						
						if (oraAS.length() == 1) {
							oraAS = "0" + oraAS;
						}
						
					}while(flag);
					
					String minAS = null;
					
					do {
						
						if(flag) {
							System.out.println("\nMinuti non validi");
							}
						
						flag = false;
						System.out.print("\nQuale è il valore dei minuti dell'orario di arrivo del volo che vuoi creare: ");
						minAS = input.next();
						
						try {
							
							if (minAS.length() == 1) {
								minAS = "0" + minAS;
							}
							
							min = Integer.valueOf(minAS);
							
							if ( (min<0)||(min>59) ) {
								flag = true;
								
							}
						} catch (Exception e) {
							flag = true;
						}
						
						minAS = String.valueOf(min);
						
						if (minAS.length() == 1) {
							minAS = "0" + minAS;
						}
						
					}while(flag);
					
					String atterraggio = String.format("%s:%s", oraAS,minAS);
					
					Aereo aereo = null;
					
					do {
						System.out.print("\nQuale è in nome dell'aereo asscociato al volo che stai creando: ");
						String nomeAereo = input.next();
						
						aereo = TrovaAereo(nomeAereo);
						if (aereo == null) {
							System.out.println("\nL'aereo " + nomeAereo + " non esiste.");
						}
						
					}while(aereo == null);
					
					Volo volo = new Volo(nomeVolo,partenza,arrivo,aereo,decollo,atterraggio);
					voli.add(volo);
				}else {
					
					System.out.println("\nNon esistono aerei da poter associare il volo.");
					System.out.println("\nCrea almeno un aereo prima di creare un volo.");
				}
				break;
			}
			case 4: {

				System.out.print("\nQuale è il nome del volo che vuoi eliminare: ");
				String nomeVolo = input.next();
				
				EliminaVolo(nomeVolo);
				break;
			}
			case 5: {

				ris = false;
				//input.close();
				break;
			}
			default:
				System.out.println("\nIl menu " + operazione + " non esiste.");;
			}
			
		}while(ris);
		
	}

	@Override
	public String toString() {
		return "CompagniaAerea [aerei=" + aerei + ", voli=" + voli + "]";
	}
	
	
}
