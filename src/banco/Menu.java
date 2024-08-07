package banco;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe principal que invoca os métodos e salva os parâmetros
 */

public class Menu {
	
	static Scanner scanner = new Scanner(System.in); 
	static ArrayList<Conta> contas; 
	static ArrayList<Movimento> movimentos; 
	
	static String nomeArquivo = "contas.csv";
	static String diretorio = System.getProperty("user.dir");
	static String caminho = diretorio + "\\src\\banco" + "\\" + nomeArquivo;
	
	/**
	 * Método main
	 */
	public static void main(String[] args) {
		
		contas = new ArrayList<Conta>();
		movimentos = new ArrayList<Movimento>();	
				
		operacoes();
		
	}
	
	/**
	 * Método com o menu de opções e chamamento dos métodos das operações da conta
	 */
	public static void operacoes() {
		
		System.out.println("\n================ MENU ================" +
				"\n[1] Criar conta" +
				"\n[2] Depositar" +
				"\n[3] Sacar" +
				"\n[4] Transferir" +
				"\n[5] Listar Contas" +
				"\n[6] Visualizar extrato" +
				"\n[7] Sair" );
		
		int opcao = scanner.nextInt();
		 
		switch(opcao) {
			case 1: 
				criarConta();
				break;
			case 2: 
				depositar();
				break;
			case 3:
				sacar();
				break;
			case 4: 
				transferir();
				break;
			case 5:
				listarContas();
				break;
			case 6:
				visualizarExtrato();
			case 7:
				System.out.println("=> Volte sempre!");
				System.exit(0); // Sair do programa, o break sai apenas do laço switch
				break; 
			default: 
				System.out.println("\n*** Opção inválida! ***");
				operacoes();
				break; 
		}
		
	}
	
	/**
	 * Método para criar uma conta nova para pesoa física ou jurídica
	 */
	public static void criarConta() {

		int idPessoa = 1; 
		
		if(Pessoa.getContadorPessoa() > 1) {
			idPessoa += 1; 
		} 
		
		System.out.println("=> Informa o titpo de titular da conta: ");
		System.out.println("[1] Pessoa Física");
		System.out.println("[2] Pessoa Jurídica");
		System.out.println("[3] Retornar ao menu");
		int opcaoPessoa = scanner.nextInt();
		
		scanner.nextLine();  // Limpa o buffer
		
		if (opcaoPessoa == 1) {
			System.out.println("\n### Conta para Pessoa Física ###");

			System.out.println("\nNome: ");
			String nome = scanner.nextLine();

			System.out.println("\nCPF: ");
			String cpf = scanner.nextLine();

			System.out.println("\nRG: ");
			String rg = scanner.nextLine();

			System.out.println("\nE-mail: ");
			String email = scanner.nextLine();
			
			System.out.println("\nAgência: ");
			int agencia = scanner.nextInt();

			System.out.println("\nNúmero da conta: ");
			int numeroConta = scanner.nextInt();

			Fisica pessoa = new Fisica(idPessoa, nome, email, cpf, rg);

			Conta conta = new Conta(pessoa, numeroConta, agencia);

			contas.add(conta);

		} else if (opcaoPessoa == 2) {
			System.out.println("\n### Conta para Pessoa Jurídica ###");
			
			System.out.println("\nNome: ");
			String nome = scanner.nextLine();
			
			System.out.println("\nCNPJ: ");
			String cnpj = scanner.nextLine();
			
			System.out.println("\nE-mail: ");
			String email = scanner.nextLine();
			
			System.out.println("\nAgência: ");
			int agencia = scanner.nextInt();
			
			System.out.println("\nNúmero da conta: ");
			int numeroConta = scanner.nextInt();
			
			Juridica pessoa = new Juridica(idPessoa, nome, email, cnpj);
			
			Conta conta = new Conta(pessoa, numeroConta, agencia); 
			
			contas.add(conta); 
			
		} else if(opcaoPessoa == 3) {
			System.out.println("\nRetornando ao menu...");
			operacoes();
			
		} else {
			System.out.println("\n*** Tipo de titular inválido! Digite uma opção válida! ***");
			criarConta();
		}

		System.out.println("\n********* Conta criada com sucesso! *********");
		
		operacoes();
	}
	
	/**
	 * Método que localiza se a conta existe no Array de contas
	 * @param numero da conta para encontrar 
	 * @return número da conta ou null se a conta não existir
	 */
	public static Conta encontrarConta(int numero) {
		Conta conta = null;
		if(contas.size() > 0) {
			for (Conta c: contas) {
				if(c.getNumeroConta() == numero) {
					conta = c; 
				} 
			}
		} 
		return conta;
	} 
	
	/**
	 * Método para depositar 
	 */
    public static void depositar(){
    	System.out.println("Número da conta: ");
    	int numero = scanner.nextInt();
    	
    	Conta conta = encontrarConta(numero);
    	
    	if(conta != null) {
    		System.out.println("Valor para depositar: ");
    		Double valorDeposito = scanner.nextDouble();
    		conta.depositar(valorDeposito);
    		
    		int tipo = 1;
    		String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    		String hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    		Double valor = valorDeposito; 
    		Double saldo = conta.getSaldo(); 
    		
    		if(conta.sucesso == true) {
    			Movimento movimento = new Movimento(tipo, data, hora, valor, saldo, conta);    		
        		movimentos.add(movimento); 
        		gravarEstoque(nomeArquivo, caminho, movimentos);
    		}	
    		
    	} else {
    		System.out.println("\n*** Conta não encontrada! ***");
    	}
    	
    	operacoes();
    	
    }
	
    /**
     * Método para sacar 
     */
    public static void sacar() {
    	System.out.println("Número da conta: ");
    	int numero = scanner.nextInt();
    	
    	Conta conta = encontrarConta(numero);
    	
    	if(conta != null) {
    		System.out.println("Valor para sacar: ");
    		Double valorSaque = scanner.nextDouble();
    		conta.sacar(valorSaque);
    		
    		int tipo = 2;
    		String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    		String hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    		Double valor = valorSaque; 
    		Double saldo = conta.getSaldo(); 
    		
    		if(conta.sucesso == true) {
    			Movimento movimento = new Movimento(tipo, data, hora, valor, saldo, conta);    		
        		movimentos.add(movimento); 
        		gravarEstoque(nomeArquivo, caminho, movimentos);
    		}	
    		
    	} else {
    		System.out.println("\n*** Conta não encontrada! ***");
    	}
    	
    	operacoes();
    	
	}

    /**
     * Método para transferir 
     */
	public static void transferir() {
		System.out.println("Número conta remetente: ");
		int numeroContaRemetente = scanner.nextInt();
		
		Conta contaRemetente = encontrarConta(numeroContaRemetente);
		
		if(contaRemetente != null) {
			System.out.println("Número conta destinatário: ");
			int numeroContaDestinatatrio = scanner.nextInt();
			
			Conta contaDestinatario = encontrarConta(numeroContaDestinatatrio);
			
			if(contaDestinatario != null) { 
				System.out.println("Valor para transferir: ");
				Double valor = scanner.nextDouble();
				
				contaRemetente.transferir(contaDestinatario, valor);
				
				String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	    		String hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
	    		Double saldoRemetente = contaRemetente.getSaldo(); 
	    		Double saldoDestinatario = contaDestinatario.getSaldo();
	    		
	    		if(contaRemetente.sucesso == true) {
	    			int tipo = 3;
	    			Movimento movimento = new Movimento(tipo, data, hora, valor, saldoRemetente, contaRemetente);    	
		    		movimentos.add(movimento); 
		    		gravarEstoque(nomeArquivo, caminho, movimentos);
	    		}
	    		
	    		if(contaDestinatario.sucesso == true) {		
	    			int tipo = 4;
		    		Movimento movimentoTransferido = new Movimento(tipo, data, hora, valor, saldoDestinatario, contaDestinatario); 
		    		movimentos.add(movimentoTransferido); 
		    		gravarEstoque(nomeArquivo, caminho, movimentos);
	    		}
	    		   
			} else {
				System.out.println("\n*** Conta de destinatário não encontrada! ***");
			}
		} else {
			System.out.println("\n*** Conta de remetente não encontrada! ***");
		}
		
		operacoes();
	}
	
	/**
	 * Método para listar o Array de contas 
	 */
	public static void listarContas() {
				
		if (contas.size() > 0) {
			for (Conta conta : contas) {
				
				String valorFormatado = String.format("\nSaldo: R$%.3f", conta.getSaldo());
				
				System.out.println("\n--------------------------");
				System.out.println("\nNúmero conta: " + conta.getNumeroConta() + 
						"\nTitular: " + conta.getPessoa().getNome() + 
						valorFormatado);
			}
		} else {
			System.out.println("\n*** Não há contas cadastradas! ***");
		}

		operacoes();
	}
	
	/**
	 * Método para visualizar os movimentos de uma conta 
	 */
	public static void visualizarExtrato() {
		
		System.out.println("\nNúmero da conta: ");
		int numero = scanner.nextInt();
		
		Conta conta = encontrarConta(numero);
		
		if(conta != null) {
			if (movimentos.size() > 0) {
				for (Movimento movimento: movimentos) {
					
					String tipoMovimento = ""; 
					if(movimento.getTipo() == 1) { 
						tipoMovimento = "Depósito";
					} else if(movimento.getTipo() == 2) {
						tipoMovimento = "Saque";
					} else if(movimento.getTipo() == 3) {
						tipoMovimento = "Transferência - Remetente";
					} else if(movimento.getTipo() == 4) {
						tipoMovimento = "Transferência - Destinatário";
					}
					
					if (numero == movimento.getConta().getNumeroConta()) {
						String valorFormatado = String.format("\nValor: R$%.3f", movimento.getValor());
						String valorAposOp = String.format("\nSaldo após a operação: R$%.3f", movimento.getSaldo());
						
						System.out.println("\n--------------------------");
						System.out.println("Tipo: " + tipoMovimento + 
								"\nConta: " + movimento.getConta().getNumeroConta() + 
			    				"\nData: " + movimento.getData() + 
			    				"\tHora: " + movimento.getHora() + 
			    				valorFormatado + 
			    				valorAposOp);		
					} 
				}
			} else {
				System.out.println("\n*** Não há movimentos! ***");
			}
		} else {
			System.out.println("\n*** Conta não encontrada! ***");
		}
				
		operacoes();
	}
	
	/**
	 * Método para salvar os movimentos em um arquivo .csv
	 * @param nomeArquivo nome do arquivo que será gravado
	 * @param caminho diretório em que o arquivo se encontra
	 * @param movimentos Array que armazena os movimentos das contas (transações)
	 */
	public static void gravarEstoque(String nomeArquivo, String caminho, ArrayList<Movimento> movimentos) {
		
		File arquivo = new File(caminho);

		if (!arquivo.exists()) {
			// Se não existe, cria o arquivo
			try {
				arquivo.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
				
		File fDiretorio = new File(diretorio);
		
		if (!fDiretorio.exists()) {
			// Se não existe, cria o diretório
			try {
				fDiretorio.mkdir();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
		
		FileWriter stream;
		PrintWriter print; 
		
		try {
			stream = new FileWriter(caminho, StandardCharsets.ISO_8859_1); 
			// Escreve no arquivo 
			print = new PrintWriter(stream);
			
			FileReader content = new FileReader(caminho);
			BufferedReader reader = new BufferedReader(content);
			String linha = reader.readLine();
						
			if(linha == null) {
				print.println("Tipo Transação;Número Conta;Data;Hora;Valor da transação; Saldo;");
				
			} 
			
			if(contas.size() > 0) {
				for (Movimento movimento : movimentos) {
						
					String registro = movimento.getTipo() + ";" + movimento.getConta().getNumeroConta() + ";"
									+ movimento.getData() + ";" + movimento.getHora() + ";" + movimento.getValor() + ";"
									+ movimento.getSaldo() + ";";

					print.println(registro);
				}
			}
			
			reader.close(); 
			print.close();
			stream.close();
			
		} catch(IOException e) {
			
			e.printStackTrace();
		} 
	}
	
}

