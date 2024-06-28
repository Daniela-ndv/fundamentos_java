package excecoes;

public class TestException {
	
	public static void main(String[] args) throws DivisaoPorZeroCheckedException {
		try {
			int val = 10/0;
			System.out.println(val);
		} catch (Exception e) {
			
			//throw new DivisaoPorZeroUncheckedException();
			throw new DivisaoPorZeroCheckedException(); // Exige a declaração throws no método
			
		}
	}

}
