//import java.io.IOException;

public class ClienteSync extends Thread {
	
	private ContoCorrente conto;
	private String nome;
	private String valore;
	
	public ClienteSync() {
		super();
	}
	public ClienteSync(String nome, Integer valore) {
		super();
		
		this.conto = new ContoCorrente();
		
		this.setNome(nome);
		this.setValore(valore.toString());
		
		String mes = this.conto.creaSaldo(nome, valore.toString());
		System.out.println(mes);

	}

	public String getNome() {
		return nome;
	}

	private void setNome(String nome) {
		this.nome = nome;
	}

	public String getValore() {
		return valore;
	}
	public void setValore(String valore) {
		this.valore = valore;
	}
	
	public ContoCorrente getConto() {
		return conto;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " arriva al bancomat");
		System.out.println("Quando arriva " + Thread.currentThread().getName() + " il saldo è: " + this.conto.);
		System.out.println("La somma che vuole prelevare " + Thread.currentThread().getName() + " è: " + sommaDaPrelevare);
		
		try {
			ContoCorrente.getInstance().prelievo(sommaDaPrelevare);
			System.out.println(Thread.currentThread().getName() + " TUTTO OK PRELIEVO EFFETTUATO");
		} catch (Exception e) {
			System.out.println(Thread.currentThread().getName() + " NOOOOOOOOOOO NON HAI SOLDI!!!");
			e.printStackTrace();
		}
	}
}