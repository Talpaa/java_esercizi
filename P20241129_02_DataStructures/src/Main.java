import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		//Set, Map, List, Queue, Stack, Array, ...
		
		//I Set
		HashSet<Prova> hsp = new HashSet<Prova>();
		TreeSet<Prova> tsp = new TreeSet<Prova>();
		
		//Le Mappe
		HashMap<Prova, Integer> hmp = new HashMap<Prova, Integer>();
		TreeMap<Prova, Integer> tmp = new TreeMap<Prova, Integer>();

		for (int i = 0; i<100; i++) {
			
			hsp.add(new Prova(i));
			//tsp.add(new Prova(i));
		}
		
		System.out.println(hsp.contains(10));
		
		Prova unaProva = new Prova(987);
		hsp.add(unaProva);
		System.out.println(hsp.contains(unaProva));
		
		System.out.println();
		
		hsp.clear();
		hsp.add(new Prova(1));
		System.out.println(hsp);
		hsp.add(new Prova(2));
		System.out.println(hsp);
		hsp.add(new Prova(3));
		System.out.println(hsp);
		hsp.add(new Prova(4));
		System.out.println(hsp);
		hsp.add(new Prova(5));
		System.out.println(hsp);
		hsp.add(new Prova(6));
		System.out.println(hsp);
		
		System.out.println();
	
		var it = hsp.iterator();
		
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println();
		
		tsp.add(new Prova(987));
		System.out.println(tsp.contains(unaProva));
		System.out.println(hsp.contains(unaProva));
		
		//Ora HashMap
		
		for (int i=0; i<100; i++){
			
			hmp.put(new Prova(i), i);
			tmp.put(new Prova(i), i);
		}
		
		System.out.println();
		
		System.out.println(hmp.get(new Prova(10)));
		System.out.println(tmp.get(new Prova(10)));
		
		//Conclusioni
		System.out.println();System.out.println();System.out.println();
		
		
		Queue<String> qs = new LinkedList<String>();
		qs.add("uno");
		qs.add("due");
		qs.add("tre");
		
		System.out.println(qs.poll()); 
		System.out.println(qs);
		
		Stack<String> ss = new Stack<String>();
		ss.push("uno");
		ss.push("due");
		ss.push("tre");
		ss.push("quattro");
		
		System.out.println(ss.pop());
		System.out.println(ss);
		
		System.out.println();
		
		Vector<String> vs = new Vector<String>();
		vs.add("uno");
		vs.add("due");
		vs.add("tre");
		
		System.out.println(vs.removeFirst());
		System.out.println(vs);
		}

}

class Prova implements Comparable<Prova>{
	public String uno;
	public Integer due;
	
	public Prova(int n) {
		uno = "UNO";
		due = n;
	}
	
	public String toString() {
		return ""+due;
	}
	
	@Override
	public int compareTo(Prova o) {
		return (due-o.due);
	}
}