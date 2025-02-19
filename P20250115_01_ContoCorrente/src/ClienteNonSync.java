
public class ClienteNonSync extends Thread {
	
	private String nome;
	private int prelievo;
	
	public ClienteNonSync() {
		super();
	}
	public ClienteNonSync(String nome, int prelievo) {
		super();
		this.setNome(nome);
		this.setPrelievo(prelievo);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPrelievo() {
		return prelievo;
	}

	public void setPrelievo(int prelievo) {
		this.prelievo = prelievo;
	}

	public void run() {
		
	}
}
