import java.util.*;

public class ProductManager implements Ordinabile{

	static LinkedList<Prodotto> prodotti = new LinkedList<Prodotto>();
	public ProductManager() {
		super();
	}

	public static void AddProduct(Prodotto p) {
		
		prodotti.add(p);
	}
	
	public static void ShowProducts() {
		
		for(Prodotto product: prodotti) {
			System.out.println(product);
		}
		
	}

	@Override
	public List<Prodotto> sortByPrice() {
		Collections.sort(prodotti);
		
		return prodotti;
	}

}
