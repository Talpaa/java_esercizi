
public class Esercizio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double c1 = 45.3;
		double c2 = 67.2;
		
		System.out.println();
		System.out.println("L'ipotenusa del triangolo rettangolo i cui cateti misurano rispettivamente " + c1 + " e " + c2 + " metri è: ");
		
		double c1q = c1 * c1;
		double c2q = c2 * c2;
		
		double i = Math.sqrt(c1q + c2q);
		System.out.println(i + " metri");
		
		
		System.out.println();
		System.out.println("L'area del triangolo rettangolo i cui cateti misurano rispettivamente " + c1 + " e " + c2 + " metri è: ");
		
		double at = (c1 * c2)/2;
		
		System.out.println(at + " metri");
		
		
		System.out.println();
		System.out.println("Il perimetro del triangolo rettangolo i cui cateti misurano rispettivamente " + c1 + " e " + c2 + " metri è: ");
		
		double p = c1 + c2 + i;
		
		System.out.println(p + " metri");
		
		
		System.out.println();
		double rc = 3 * (i / 4);
		double d = rc * 2;
		System.out.println("La circonferenza del cerchio con diametro pari a " + d + " metri è: ");
		
		double cc = (d * Math.PI);
		System.out.println(cc + " metri");
		
		System.out.println();
		
		System.out.println("L'area del cerchio con raggio pari a " + rc + " metri è: ");
		
		double ac = (rc * rc) * Math.PI;
		System.out.println(ac + " metri");
		
		System.out.println();
		
		TriangoloRettangolo tr = new TriangoloRettangolo(3, 4);
		
		System.out.println("Ipotenusa: " + tr.getHyp());
		System.out.println("Area: " + tr.getArea());
		
		tr.SetCat1(6);
		tr.SetCat2(8);
		
		System.out.println("Ipotenusa: " + tr.getHyp());
		System.out.println("Area: " + tr.getArea());
		
		TriangoloRettangolo tr1 = new TriangoloRettangolo(900, 0.2);
		
		System.out.println("Ipotenusa: " + tr1.getHyp());
		System.out.println("Area: " + tr1.getArea());
	}

}
