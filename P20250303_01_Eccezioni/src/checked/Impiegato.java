package checked;

public class Impiegato {

	private String nome;
	private int salario;
	
	public Impiegato(String nome, int salario) {
		super();
		this.nome = nome;
		this.salario = salario;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getSalario() {
		return salario;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}
	
	@Override
	public String toString() {
		return "Impiegato [nome=" + nome + ", salario=" + salario + "]";
	}

	public void incrementaDalario(int incremento) throws IncrementoNegativoException {
		
		if (incremento > 0) {
			this.salario += incremento;
		}else {
			throw new IncrementoNegativoException();
		}
		
	}
}
