import java.util.Collections;
import java.util.LinkedList;
		/* 1) Creare una lista di Motociclo e una lista di Autovettura
         * 2) inserire almeno 10 elementi per lista
         * 3) Stampare le liste ordinate (per velocità e poi per consumo)
         * 4) Costruire una nuova lista che contiene contemporaneamente Motocicli e Autovetture
         * 6) Stampare la nuova lista ordinata (per velocità e poi per consumo)
         */
public class Main {
	
	public static void main(String[] args) {

		LinkedList<Motociclo> moto = new LinkedList<Motociclo>();
		
		moto.add(new Motociclo(2,30.0,50,30.0));
		moto.add(new Motociclo(2,35.0,50,29.0));
		moto.add(new Motociclo(2,40.0,50,28.0));
		moto.add(new Motociclo(2,45.0,50,31.0));
		moto.add(new Motociclo(2,50.0,50,32.0));
		
		for(Motociclo mezzo: moto) {
			System.out.println(mezzo);
		}
		
		Collections.sort(moto);
		System.out.println("\nMoto Ordinate: \n");
		for(Motociclo mezzo: moto) {
			System.out.println(mezzo);
		}
		
		System.out.println();
		

		LinkedList<Autovettura> auto = new LinkedList<Autovettura>();
		
		auto.add(new Autovettura(4,50.0,150,20.0));
		auto.add(new Autovettura(4,55.0,160,21.0));
		auto.add(new Autovettura(4,60.0,175,22.0));
		auto.add(new Autovettura(4,65.0,200,19.0));
		auto.add(new Autovettura(4,70.0,250,18.0));
	
		for(Autovettura mezzo: auto) {
			System.out.println(mezzo);
		}
		
		Collections.sort(auto);
		System.out.println("\nAuto Ordinate: \n");
		for(Autovettura mezzo: auto) {
			System.out.println(mezzo);
		}
		
		System.out.println();
		
		

		LinkedList<Automezzo> veicoli = new LinkedList<Automezzo>();
		
		veicoli.add(new Motociclo(2,30.0,50,30.0));
		veicoli.add(new Motociclo(2,35.0,50,29.0));
		veicoli.add(new Motociclo(2,40.0,50,28.0));
		veicoli.add(new Motociclo(2,45.0,50,31.0));
		veicoli.add(new Motociclo(2,50.0,49,32.0));
		veicoli.add(new Autovettura(4,50.0,150,20.0));
		veicoli.add(new Autovettura(4,55.0,160,21.0));
		veicoli.add(new Autovettura(4,60.0,175,22.0));
		veicoli.add(new Autovettura(4,65.0,200,19.0));
		veicoli.add(new Autovettura(4,70.0,250,18.0));
		
		for(Automezzo mezzo: veicoli) {
			System.out.println(mezzo);
		}
		
		Collections.sort(veicoli);
		System.out.println("\nVeicoli Ordinate: \n");
		for(Automezzo mezzo: veicoli) {
			System.out.println(mezzo);
		}
		
		System.out.println();
	}
}
