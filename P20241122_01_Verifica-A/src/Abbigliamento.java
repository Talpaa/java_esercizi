public class Abbigliamento extends Prodotto{

	
	public Abbigliamento() {
		super();
	}

	
	public Abbigliamento(String name, Double price, String categoria) {
		super(name, price, categoria);
		
		if(categoria == "Abbigliamento Invernale") {
			this.price = calculateDiscount(price);
		}
	}

	public void setPrice(Double price) {
		
		if(this.categoria == "Abbigliamento invernale") {
			this.price = calculateDiscount(price);
		}
		
	}
	
	@Override
	public Double calculateDiscount(Double price) {
		
		Double sconto = (price/100) * 15;
		return price - sconto;
	}

}
