package banco;

import java.util.ArrayList;

public class Banco {
	
	ArrayList<Integer> contas = new ArrayList<>();
	
	public void listarContas() {
	
		for(Integer num: contas) {
			System.out.println(num);
		}
		
		for(int i=0; i < contas.size(); i++) {
			System.out.println(contas.get(i));
			
		}	
	}
}
