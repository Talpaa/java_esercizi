
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i<10; i++) {
		System.out.println(Math.random());
		}
		
		System.out.println();
		
		for (int i = 0; i<10; i++) {
			
			if (i<9) {
				System.out.print(Math.random() + ", ");
			}else {
				System.out.println(Math.random());
			}
		}
		
		System.out.println();
		
		for (int i = 1; i<11; i++) {
			
			System.out.println( ((i<10)?" ":"")+ i + ") " + Math.random() );
			}
		
	}

}
