package arquivo;

// Pacote Java IO: contém as classes para manipulação de arquivos
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class EscritaELeituraArquivo {
	
	public static void main(String[] args) {
		String nomeArquivo = "estoque.csv";
		String diretorio = System.getProperty("user.home");
		String caminho = diretorio + "\\" + nomeArquivo;
		
		List<String> conteudo = new ArrayList<>();
		conteudo.add("Produto; Quantidade; Unidade de Medida; Valor da Unidade;");
		conteudo.add("Pera; 200; pct; R$ 5,40;");
		conteudo.add("Morango; 400; cx; R$ 6,50");
		
		//gravarEstoque(nomeArquivo, caminho, conteudo);
		
		lerEstoque(caminho);
		
		
		// Objeto File permite verificar o arquivo
		File arquivo = new File(caminho);
		
		if(arquivo.exists()) {
			System.out.println("O arquivo existe!" + 
					"\nPode ser lido: " + arquivo.canRead() +
					"\nPode ser gtavano: " + arquivo.canWrite() +
					"\nTamanho: " + arquivo.length()+
					"\nCaminho: " + arquivo.getPath());
		} else {
			// Cria o arquivo
			try {
				if(arquivo.createNewFile())
					System.out.println("Arquivo criado!");
				else
					System.out.println("Arquivo não criado!");
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		File fDiretorio = new File(diretorio);
		
		if(fDiretorio.exists()) {
			System.out.println("O diretório existe!");
		} else {
			if(fDiretorio.mkdir())
				System.out.println("Diretório criado!");
			else
				System.out.println("Diretório não criado!");
		} 
	}
	
	/*
	 * Método que gera o arquivo e escreve
	 */
	public static void gravarEstoque(String nomeArquivo, String caminho, List<String> conteudo) {
		FileWriter stream;
		PrintWriter print; 
		
		try {
			// É uma conexão de escrita
			stream = new FileWriter(caminho);
			// Escreve no arquivo 
			print = new PrintWriter(stream);
			
			for(String linha: conteudo) {
				print.println(linha);
			}
			
			print.close();
			stream.close();
			
			System.out.println("O arquivo " + nomeArquivo + " foi salvo em " + caminho);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	 * Método que lê o arquivo
	 */
	public static void lerEstoque(String caminho) {
		try {
			// Abre o arquivo
			FileReader stream = new FileReader(caminho);
			
			// BufferedReader possui o método ReadLine()
			// Lê e retorna uma String com o calor lido ou null
			BufferedReader reader = new BufferedReader(stream);
			
			// Lê uma linha
			String linha = reader.readLine();
			
			while(linha != null) {
				System.out.println(linha);
				
				// Lê a próxima linha
				linha = reader.readLine();
			}
			reader.close();
			// Fecha o arquivo
			stream.close(); 
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}


