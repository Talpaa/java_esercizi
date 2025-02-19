import java.io.IOException;
import java.util.LinkedList;

public class ContoCorrente {
	
	private static String contiSync = "contiSync.txt";
	private static String contiNonSync = "contiNonSync.txt";
	
	public ContoCorrente() {
		super();
	}
	
	public String creaSaldo(String nome, String saldo) {
		
		try {
			LinkedList<String[]> conti = new LinkedList<String[]>();
			var fileRC = Util.OpenFileForReading(contiSync);
		
			String riga;
			while ((riga = fileRC.readLine()) != null) {
				
				String[] items = riga.split(",");
				
				if (items[0].equals(nome)) {
					
					return "Conto già esistente.";
					
				}else {
					conti.add(items);
				}
			}
	
			fileRC.close();
			
			String[] newSaldo = {nome, saldo};
			
			conti.add(newSaldo);
			
			var fileWA = Util.OpenFileForWriting(contiSync);
			
			for (String[] x : conti) {
				
				String a = String.format("%s,%s\n", x[0], x[1]);
					fileWA.write(a);
				
			}
			
			fileWA.close();
			
			return "Conto creato";
			
		}catch (Exception e) {
				return "Conto non creato.";
		}
	}
	
	public String[] saldo(String nome, int prelievo) {

		try {

			var fileRC = Util.OpenFileForReading(contiSync);
		
			String riga;
			while ((riga = fileRC.readLine()) != null) {
				
				String[] items = riga.split(",");
				
				if (items[0].equals(nome)) {
					
					return items;
				}
			}

			fileRC.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String[] ret = {"None", "None"};
		return ret;
	}
	
	public synchronized String prelievoSync(String nome, int prelievo) {
		
		try {

			LinkedList<String[]> conti = new LinkedList<String[]>();
			var fileRC = Util.OpenFileForReading(contiSync);
		
			String riga;
			while ((riga = fileRC.readLine()) != null) {
				
				String[] items = riga.split(",");
				
				if (items[0].equals(nome)) {
					
					Integer conto = Integer.parseInt(items[1]);
					
					if ( (conto - prelievo) >= 0 ) {
						
						conto -= prelievo;
						
						items[1] = conto.toString();
						conti.add(items);
						
					}else {
						return "Prelievo non riuscito.";
					}
				}else {
					conti.add(items);
				}
			}

			fileRC.close();
			
			var fileWA = Util.OpenFileForWriting(contiSync);
			
			for (String[] x : conti) {
				
				String a = String.format("%s,%s\n", x[0], x[1]);
					fileWA.write(a);
				
			}
			
			fileWA.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return "Prelievo riuscito";
		
	}
	
	public String prelievoNonSync(String nome, int prelievo) {
		
		try {

			LinkedList<String[]> conti = new LinkedList<String[]>();
			var fileRC = Util.OpenFileForReading(contiNonSync);
		
			String riga;
			while ((riga = fileRC.readLine()) != null) {
				
				String[] items = riga.split(",");
				
				if (items[0].equals(nome)) {
					
					Integer conto = Integer.parseInt(items[1]);
					
					if ( (conto - prelievo) >= 0 ) {
						
						conto -= prelievo;
						
						items[1] = conto.toString();
						conti.add(items);
						
					}else {
						return "Prelievo non riuscito.";
					}
				}else {
					conti.add(items);
				}
			}

			fileRC.close();
			
			var fileWA = Util.OpenFileForWriting(contiNonSync);
			
			for (String[] x : conti) {
				
				String a = String.format("%s,%s\n", x[0], x[1]);
					fileWA.write(a);
				
			}
			
			fileWA.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return "Prelievo riuscito";
		
	}
	

}