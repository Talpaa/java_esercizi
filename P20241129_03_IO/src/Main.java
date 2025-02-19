import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Locale;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

	public static void main(String[] args) throws JsonProcessingException {
		
		//Locale.setDefault(Locale.US);

		// Create una lista con 10 elementi Wifi casuali
		LinkedList<WiFi> lwifi = new LinkedList<WiFi>();
		for (int i = 0; i < 10; i++) {
			lwifi.add(WiFi.MakeWifi());
		}

		//System.out.println(lwifi);

		// Domanda:La potreste stampare in formato CSV poiché
		// dobbiamo passarla al vostro collega Onisa?
		for (var x : lwifi) {
			String a = String.format("%s,%s,%s,%f\n", 
					x.getId(), x.getProtocollo(), x.getPassword(), x.getFrequenza());
			System.out.print(a);
			
			//System.out.printf("%s,%s,%s,%f\n", 
				//	x.getId(), x.getProtocollo(), x.getPassword(), x.getFrequenza());
		}
		
		//Scrittura su file in formato CSV
		var fileW = Util.OpenFileForWriting("wifi.dat");
		
		for (var x : lwifi) {
			
			try {
				String a = String.format("%s,%s,%s,%f\n", 
						x.getId(), x.getProtocollo(), x.getPassword(), x.getFrequenza());
				fileW.append(a);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		try {
			fileW.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		System.out.println();
		System.out.println();
		//Lettura da file in formato CSV
		var fileR = Util.OpenFileForReading("wifi.dat");
		
		lwifi.clear();
		
		try {

			String riga;
			while ((riga = fileR.readLine()) != null) {
				
				String[] items = riga.split(",");
				
				WiFi it = new WiFi(items[0], items[1], items[2], Double.parseDouble(items[3]));
				
				lwifi.add(it);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (WiFi riga : lwifi) {
			System.out.println(riga);
		}
		
			
		try {
			fileR.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println();System.out.println();
		
		
		//Scrittura su file in formato json
		WiFi appo = WiFi.MakeWifi();
		
		String jsonString;
		
		ObjectMapper objectMapper = new ObjectMapper();
		jsonString = objectMapper.writeValueAsString(appo);
		
		System.out.println(jsonString);
		System.out.println();System.out.println();
		WiFi nuovo = objectMapper.readValue(jsonString, WiFi.class);
		System.out.println(nuovo);
		
		var fileW1 = Util.OpenFileForWriting("wifi.txt");
		
		for (var x : lwifi) {
			
			try {
				String a = objectMapper.writeValueAsString(x);
				fileW1.append(a+"\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		try {
			fileW1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println();
		
		//Lettura da file in formato json
		var fileR1 = Util.OpenFileForReading("wifi.txt");
		
		lwifi.clear();
		
		try {

			String riga;
			while ((riga = fileR1.readLine()) != null) {
				
				WiFi it = objectMapper.readValue(riga, WiFi.class);				
				lwifi.add(it);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (WiFi riga : lwifi) {
			System.out.println(riga);
		}
		
			
		try {
			fileR.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		
		System.out.println();System.out.println();
		String  listaJson = objectMapper.writeValueAsString(lwifi);
		
//		for (WiFi wifi : lwifi) {
//			
//			System.out.println(wifi);
//		}
		
		
		System.out.println(listaJson);System.out.println();
		lwifi.clear();
		
		//lwifi = objectMapper.readValue(listaJson, lwifi.getClass());
		LinkedList<WiFi> pippo = new LinkedList<WiFi>(objectMapper.readValue(listaJson, new LinkedList<WiFi>().getClass()));
		System.out.println(pippo);
		
		var it = pippo.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
//		for (var wifi : pippo) {
//			System.out.println(wifi);
//		}
	}
}

/*
 * Exception in thread "main" java.lang.ClassCastException: class 
 * java.util.LinkedHashMap cannot be cast to class 
 * WiFi (java.util.LinkedHashMap is in module 
 * java.base of loader 'bootstrap'; 
 * WiFi is in unnamed module of loader 'app')
 */

