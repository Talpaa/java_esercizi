
public abstract class Prodotto implements Comparable<Prodotto>{

	protected String name;
	protected Double price;
	protected String categoria;

	public Prodotto() {
		super();
	}
	

	public Prodotto(String name, Double price, String categoria) {
		super();
		this.name = name;
		this.price = price;
		this.categoria = categoria;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	abstract public Double calculateDiscount(Double price);

	@Override
	public String toString() {
		return "Prodotto [name=" + name + ", price=" + price + " €, categoria=" + categoria + "]";
	}

	@Override
	public int compareTo(Prodotto p) {
		
		if ( (getPrice().compareTo(p.getPrice())) != 0 ){
			
			return (getPrice().compareTo(p.getPrice()));
			
		}else {return 0;}
	}
	
	
	
}
