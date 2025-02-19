public class Volo {
	
	private String nome;
	private String partenza;
	private String arrivo;
	private Aereo aereo;
	private String decollo;
	private String atteraggio;
	private Boolean imbarco;
	
	

	public Volo() {
		super();
	}

	public Volo(String nome, String partenza, String arrivo, Aereo aereo, String decollo, String atteraggio) {
		super();
		this.setNome(nome);
		this.setPartenza(partenza);
		this.setArrivo(arrivo);
		this.setAereo(aereo);
		this.setDecollo(decollo);
		this.setAtteraggio(atteraggio);
		this.setImbarco(true);
	}
	
	public Volo(String nome, String partenza, String arrivo, Aereo aereo, String decollo, String atteraggio, Boolean imbarco) {
		super();
		this.setNome(nome);
		this.setPartenza(partenza);
		this.setArrivo(arrivo);
		this.setAereo(aereo);
		this.setDecollo(decollo);
		this.setAtteraggio(atteraggio);
		this.setImbarco(imbarco);
	}


	public Aereo getAereo() {
		return aereo;
	}

	public void setAereo(Aereo aereo) {
		this.aereo = aereo;
	}

	public String getDecollo() {
		return decollo;
	}
	public void setDecollo(String decollo) {
		this.decollo = decollo;
	}

	public String getAtteraggio() {
		return atteraggio;
	}
	public void setAtteraggio(String atteraggio) {
		this.atteraggio = atteraggio;
	}

	public Boolean getImbarco() {
		return imbarco;
	}
	public void setImbarco(Boolean imbarco) {
		this.imbarco = imbarco;
	}
	
	public String getPartenza() {
		return partenza;
	}
	public void setPartenza(String partenza) {
		this.partenza = partenza;
	}

	public String getArrivo() {
		return arrivo;
	}
	public void setArrivo(String arrivo) {
		this.arrivo = arrivo;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void PrenotaVolo(Integer posti, String nomeVolo) {
		
		if (imbarco) {
			aereo.ControllaPosti(posti, true);
		}else {
			System.out.println("\nL'Imbarco del volo " + nomeVolo + " è chiuso.");
			System.out.println("\nPosti non prenotati.");
		}
	}
	
	public void CancellaPrenotazione(Integer posti, String nomeVolo) {
		
		if (imbarco) {
			aereo.ControllaPosti(posti, false);
		}else {
			System.out.println("\nL'Imbarco del volo " + nomeVolo + " è chiuso.");
			System.out.println("\nPosti non prenotati.");
		}
	}

	@Override
	public String toString() {
		return "Volo [nome=" + nome + ", partenza=" + partenza + ", arrivo=" + arrivo + ", aereo=" + aereo
				+ ", decollo=" + decollo + ", atteraggio=" + atteraggio + ", imbarco=" + imbarco + "]";
	}

	
	
}
