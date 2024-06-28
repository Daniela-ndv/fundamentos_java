package excecoes;

/*
 * Classe que exemplifica exceções do tipo Unchecked (não é obrigatório o tratamento)  
 */
public class UncheckedException {
	
	public static void main(String[] args) {
		try {
			// Trecho onde a exceção pode ocorrer

			 int val = 10 /0;
			 
			 int[] valores = new int[3]; System.out.println(valores[4]);

			String nome = null;
			System.out.println(nome.length());

			int numero = Integer.parseInt("zero");

		} catch (ArithmeticException e) {
			// Tratamento da exceção
			System.out.println("Não é possível realizar uma divisão por zero.");

			// Mensagem com a lista de erros
			System.out.println(e.getMessage());
			// Imprime a pilha de erro da exceção
			e.printStackTrace();

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Não é possível acessar a posição 4 do Array.");

		} catch (NullPointerException e) {
			System.out.println("Não é possível retornar o lenght, variável nome não instanciada.");

		} catch (NumberFormatException e) {
			System.out.println("Não é possível realizar a conversão.");

		} catch (Exception e) {
			System.out.println("Erro na execução do programa");

		}

		finally {
			System.out.println("Sempre passará aqui");
		}

	}
}
