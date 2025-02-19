public class Aereo {

	private String nome;
	private Integer posti;
	private Integer postiDis;
	
	
	
	public Aereo() {
		super();
	}
	
	public Aereo(String nome, Integer posti) {
		super();
		this.setNome(nome);
		this.setPosti(posti);
		this.setPostiDis(posti);
	}
	
	public Aereo(String nome, Integer posti, Integer postiDis) {
		super();
		this.setNome(nome);
		this.setPosti(posti);
		this.setPostiDis(postiDis);
	}

	public Integer getPosti() {
		return posti;
	}
	public void setPosti(Integer posti) {
		this.posti = posti;
	}
	
	public Integer getPostiDis() {
		return postiDis;
	}
	public void setPostiDis(Integer postiDis) {
		this.postiDis = postiDis;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void ControllaPosti(Integer posti, Boolean n){
		
		if(n) {
			if (posti <= postiDis) {
				
				postiDis -= posti;
				System.out.println("\nPosti prenotati.");
			}else {
				System.out.println("\nNon sono presenti abbastanza posti.");
				System.out.println("\nPosti rimasti: " + postiDis);
				System.out.println("\nPosti non prenotati.");
			}
		}else {
			
			if ((posti+postiDis)<=this.posti) {
				
				postiDis += posti;
				System.out.println("\nPosti cancellati");
			}else {
				System.out.println("\nStai cancellando troppi posti.");
				System.out.println("\nPosti rimasti da cancellare: " + (this.posti - postiDis));
				System.out.println("\nPosti non prenotati.");
			}
		}
	}

	@Override
	public String toString() {
		return "Aereo [nome=" + nome + ", posti=" + posti + ", postiDis=" + postiDis + "]";
	}
	
}
