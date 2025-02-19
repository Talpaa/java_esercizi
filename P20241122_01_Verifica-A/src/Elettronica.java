public class Elettronica extends Prodotto{

	
	
	public Elettronica() {
		super();
	}

	public Elettronica(String name, Double price, String categoria) {
		
		super(name, price, categoria);
		this.price = calculateDiscount(price);
	}

	public void setPrice(Double price) {
		
		this.price = calculateDiscount(price);
		
	}

	@Override
	public Double calculateDiscount(Double price) {
		
		if(price > 500.0) {
			Double sconto = (price/100) * 10;
			
			return price - sconto;
		}else {
			return price;
		}
	}

}
