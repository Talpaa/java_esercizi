import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class NumeroPariTest {
	private int numeroTestato;
	private boolean risultatoAtteso;

	public NumeroPariTest(int numeroTestato, boolean risultatoAtteso) {
		this.numeroTestato = numeroTestato;
		this.risultatoAtteso = risultatoAtteso;
	}

	@Parameterized.Parameters
	public static Collection dataset() {
		return Arrays.asList(new Object[][] { { 1, false }, { 2, true }, { 3, false }, { 4, true }, { 5, false } });
	}

	@Test
	public void testNumeroPari() {
		NumeroPari n = new NumeroPari();
		System.out.println("Test con il numero : " + numeroTestato + " eseguito");
		assertEquals("Il numero " + numeroTestato + " è dispari ", risultatoAtteso, n.numeroPari(numeroTestato));
	}
}