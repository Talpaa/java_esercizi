import java.lang.reflect.InvocationTargetException;

public class Esempio5Reflection {

	public static void main(String[] args) {
		
		try {
			Class data = Class.forName("java.util.Date");
			Object oggetto = data.getDeclaredConstructor().newInstance();
			
			System.out.println("Nome della classe = " + data.getName());
			System.out.println("Nome dell'oggetto = " + oggetto.toString());
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
