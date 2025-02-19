
public class ProductApp {

	public static void main(String[] args) {
		
		ProductManager manager = new ProductManager();
		
		ProductManager.AddProduct(new Abbigliamento("Guanti", 26.9, "Abbigliamento Invernale"));
		ProductManager.AddProduct(new Abbigliamento("Ciabatte", 18.0, "Abbigliamento Estivo"));
		ProductManager.AddProduct(new Abbigliamento("Sciarpa", 34.7, "Abbigliamento Autunnale"));
		ProductManager.AddProduct(new Abbigliamento("Cappello", 45.9, "Abbigliamento Primaverile"));
		ProductManager.AddProduct(new Abbigliamento("Scalda Collo", 13.5, "Abbigliamento Invernale"));

		ProductManager.AddProduct(new Elettronica("YAGOPAL Power-Bank", 29.22, "Accessori per Cellulari"));
		ProductManager.AddProduct(new Elettronica("INIU Cavo USB Type-C", 9.10, "Accessori per TV, video e Home Cinema"));
		ProductManager.AddProduct(new Elettronica("SMALLRIG Mini Side Handle", 30.50, "Accessori per Videocamere"));
		ProductManager.AddProduct(new Elettronica("JMGO N1S Pro", 1699.00, "Proiettori"));
		ProductManager.AddProduct(new Elettronica("Insta360", 604.0, "Action camera"));
		
		ProductManager.ShowProducts();
		
		System.out.println();
		manager.sortByPrice();
		System.out.println();
		
		ProductManager.ShowProducts();
	}

}
