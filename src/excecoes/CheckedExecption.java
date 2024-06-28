package excecoes;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * Classe que exemplifica exceções do tipo Checked ()
 */
public class CheckedExecption {

	/*
	 * A cláusula throws declara exceções que podem ocorrer em um métodom forçando o tratamento da exceção no método chamador
	 */
	public static void main(String[] args) throws IOException  {
		
		// Exceções Checked
		
		FileWriter fw = new FileWriter("C:\nota.txt");
		
		PrintWriter print = new PrintWriter(fw);
		
		print.println("Maça: R$ 4,00");
		print.println("Morango: R$ 6,00");
		print.println("Total = R$ 10,50");
		print.close();
		fw.close();
		
		
	}
}
