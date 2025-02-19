import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String ris = "s";
		int pianoAttuale = 0;
		int pianoArrivo = 0;
		
		while (ris.equals("s")) {
			//System.out.println("Sei al piano " + pianoattuale);
			System.out.print("\nA che piano ti trovi: ");
			int pianoChiamata = input.nextInt();
			
			if ( (pianoChiamata > 3)||(pianoChiamata < 0) ){
				pianoArrivo = 12;
			}else {
				
				DentroAscensore(pianoChiamata, pianoAttuale);
				pianoAttuale = pianoChiamata;
				
				System.out.print("\nA che piano sei diretto: ");
				pianoArrivo = input.nextInt();
			}
			
			switch(pianoArrivo) {
			  case 0:
			    if (pianoChiamata == 0) {
			    	System.out.println("\nSei già al piano 0");
			    }else {
			    	DentroAscensore(pianoArrivo, pianoAttuale);
			    	pianoAttuale = pianoArrivo;
			    }
			    break;
			  case 1:
				  if (pianoChiamata == 1) {
				    	System.out.println("\nSei già al piano 1");
				    }else {
				    	DentroAscensore(pianoArrivo, pianoAttuale);
				    	pianoAttuale = pianoArrivo;
				    }
			    break;
			  case 2:
				  if (pianoChiamata == 2) {
				    	System.out.println("\nSei già al piano 2");
				    }else {
				    	DentroAscensore(pianoArrivo, pianoAttuale);
				    	pianoAttuale = pianoArrivo;
				    }
				    break;
			  case 3:
				  if (pianoChiamata == 3) {
				    	System.out.println("\nSei già al piano 3");
				    }else {
				    	DentroAscensore(pianoArrivo, pianoAttuale);
				    	pianoAttuale = pianoArrivo;
				    }
				    break;
			  default:
			    System.out.println("\nPiano inesistente.");
			}
			
			System.out.print("\nVuoi usare l'ascensore(s/n): ");
			ris = input.next();
		}
		

	}
	
	public static void DentroAscensore(int pa, int pp) {
		
		int calc = pa-pp;
		String piano = "piani";
		if ((calc == 1)||(calc == -1)) {
			piano = "piano";
		}
    	if (calc == 0) {
    		
    		System.out.println("\nL'ascensore è gia al piano " + pa);
    	}else if (calc > 0) {
    	
    		System.out.println("\nSto andando al piano " + pa + " verso l'alto per " + calc + " " + piano);
    	}else if (calc < 0){
    		System.out.println("\nSto andando al piano " + pa + " verso il basso per " + (calc * (-1)) + " " + piano);
    	}
	}

}