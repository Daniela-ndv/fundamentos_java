package banco;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	
	static Scanner scanner = new Scanner(System.in); 
	static ArrayList<Conta> contas; 
	static ArrayList<Movimento> movimentos; 
	
	public static void main(String[] args) {
		contas = new ArrayList<Conta>();
		
		movimentos = new ArrayList<Movimento>();
		
		operacoes();
	}
	
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
				System.out.println("Volte sempre!");
				System.exit(0); // Sair do programa, o break sai apenas do laço switch
				break; 
			default: 
				System.out.println("Opção inválida!");
				operacoes();
				break; 
		}
		
	}
	
	public static void criarConta() {

		int idPessoa = 1; 
		
		if(Pessoa.getContadorPessoa() > 1) {
			idPessoa += 1; 
		} 
		
		System.out.println("Informa o titpo de titular da conta: ");
		System.out.println("[1] Pessoa Física");
		System.out.println("[2] Pessoa Jurídica");
		System.out.println("[3] Retornar ao menu");
		int opcaoPessoa = scanner.nextInt();
		
		scanner.nextLine();  // Limpa o buffer
		
		if (opcaoPessoa == 1) {
			System.out.println("### Conta para Pessoa Física ###");

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

//			System.out.println("\nID: " + pessoa.getIdPessoa());
//			System.out.println("Nome: " + pessoa.getNome());
//			System.out.println("CPF: " + pessoa.getCpf());
//			System.out.println("RG: " + pessoa.getRg());
//			System.out.println("E-mail: " + pessoa.getEmail());
//			System.out.println("Agência: " + conta.getAgencia());
//			System.out.println("Número conta: " + conta.getNumeroConta());

		} else if (opcaoPessoa == 2) {
			System.out.println("### Conta para Pessoa Jurídica ###");
			
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
			
//			System.out.println("\nID: " + pessoa.getIdPessoa());
//			System.out.println("Nome: " + pessoa.getNome());
//			System.out.println("CNPJ: " + pessoa.getCnpj());
//			System.out.println("E-mail: " + pessoa.getEmail());
//			System.out.println("Agência: " + conta.getAgencia());
//			System.out.println("Número conta: " + conta.getNumeroConta());
			
		} else if(opcaoPessoa == 3) {
			System.out.println("\nRetornando ao menu...\n");
			operacoes();
			
		} else {
			System.out.println("Tipo de titular inválido! Digite uma opção válida!");
			criarConta();
		}

		System.out.println("\n********* Conta criada com sucesso! *********");
		
		operacoes();
	}
	
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
	
    public static void depositar(){
    	System.out.println("Número da conta: ");
    	int numero = scanner.nextInt();
    	
    	Conta conta = encontrarConta(numero);
    	
    	if(conta != null) {
    		System.out.println("Valor para depositar: ");
    		Double valorDeposito = scanner.nextDouble();
    		conta.depositar(valorDeposito);
    		
    		int tipo = 1;
    		String data = "03-07-2004";
    		String hora = "16:26";
    		Double valor = valorDeposito; 
    		
    		Movimento movimento = new Movimento(tipo, data, hora, valor, conta);    		
    		movimentos.add(movimento); 
    		
    		
    	} else {
    		System.out.println("Conta não encontrada!");
    	}
    	
    	operacoes();
    	
    }
	
    public static void sacar() {
    	System.out.println("Número da conta: ");
    	int numero = scanner.nextInt();
    	
    	Conta conta = encontrarConta(numero);
    	
    	if(conta != null) {
    		System.out.println("Valor para sacar: ");
    		Double valorSaque = scanner.nextDouble();
    		conta.sacar(valorSaque);
    		
    		int tipo = 2;
    		String data = "03-07-2004";
    		String hora = "16:26";
    		Double valor = valorSaque; 
    		
    		Movimento movimento = new Movimento(tipo, data, hora, valor, conta);    		
    		movimentos.add(movimento); 
    		
    	} else {
    		System.out.println("Conta não encontrada!");
    	}
    	
    	operacoes();
    	
	}

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
				
				int tipo = 3;
	    		String data = "03-07-2004";
	    		String hora = "16:26";
	    		
	    		Movimento movimento = new Movimento(tipo, data, hora, valor, contaRemetente);    		
	    		movimentos.add(movimento); 
			}
		}
		
		operacoes();
	}
	
	public static void listarContas() {
			
		if (contas.size() > 0) {
			for (Conta conta : contas) {
				
				String valorFormatado = String.format("\nSaldo: R$%.3f", conta.getSaldo());
				
				System.out.println("\nNúmero conta: " + conta.getNumeroConta() + 
						"\nTitular: " + conta.getPessoa().getNome() + 
						valorFormatado);
			}
		} else {
			System.out.println("Não há contas cadastradas!");
		}

		operacoes();
	}
	
	public static void visualizarExtrato() {
		
		System.out.println("\nNúmero da conta: ");
		int numero = scanner.nextInt();
				
		if (movimentos.size() > 0) {
			for (Movimento movimento: movimentos) {
				
				String tipoMovimento = ""; 
				if(movimento.getTipo() == 1) { 
					tipoMovimento = "Depósito";
				} else if(movimento.getTipo() == 2) {
					tipoMovimento = "Saque";
				} else if(movimento.getTipo() == 3) {
					tipoMovimento = "Transferir";
				}
				
				if (numero == movimento.getConta().getNumeroConta()) {
					String valorFormatado = String.format("\nValor: R$%.3f", movimento.getValor());
					
					System.out.println("\nTipo: " + tipoMovimento + 
							"\nConta: " + movimento.getConta().getNumeroConta() + 
		    				"\nData: " + movimento.getData() + 
		    				"\tHora: " + movimento.getHora() + 
		    				valorFormatado);
				} else {
					; 
				}
				
			}
		} else {
			System.out.println("Não há movimentos!");
		}
		
		operacoes();
	}
	
}



