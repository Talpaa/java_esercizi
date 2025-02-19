
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/*
Scrivere un programma java che data una stringa che contiene digit, 
può iniziare con il carattere + o - e può contenere un . seguito da
altri digit, la converte, se possibile, in numero reale
esempio: 
Corretto: -234243.432
Errato: --123
Errato: -123-11.1
Errato: 123.11.11.22
Corretto: 123
Corretto: 123.
Corretto: +123
Corretto: -123.
Corretto: -123.33333333333333333
Il codice deve essere realizzato secondo un modello Produttore/Consumatore
Dove il produttore scandisce la stringa di input carattere per carattere e, 
per ogni carattere chiama il Consumatore passandogli il carattere scandito.
Quando il produttore invia al consumatore il carattere '\n', il consumatore
quando riceve il carattere '\n', se il numero è stato formato correttamente
lo stampa, altrimenti stampa "Errore". Analogamente il consumatore stamperà errore
nel caso in cui si accorga di un errore nel numero letto. 
Esempio: +123.34. Stampa errore non appena riscontra il secondo carattere .
Esempio di implementazione:
void Produttore(String in) {
    for (int i=0; i<in.length(); i++) {
        Consumatore(in.charAt(i));
    }
}
static double numero=0.0;
void Consumatore(char c) {
    if (c == '\n') {
        System.out.println("Il numero è: " + numero); 
    } else {
        //Qui il codice per formare il numero
        //NB: se c è un digit tra 0 e 9, allora c-'0' è un numero tra 0 e 9 
    }
}
*/
