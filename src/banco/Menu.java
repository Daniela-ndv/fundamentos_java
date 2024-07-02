package banco;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	
	static Scanner scanner = new Scanner(System.in); 
	static ArrayList<Conta> contas; 
	
	public static void main(String[] args) {
		contas = new ArrayList<Conta>();
		 operacoes();
	}
	
	public static void operacoes() {
		
		System.out.println("================ MENU ================" +
				"\n[1] Criar conta" +
				"\n[2] Depositar" +
				"\n[3] Sacar" +
				"\n[4] Transferir" +
				"\n[5] Listar" +
				"\n[6] Sair" );
		
		int opcao = scanner.nextInt();
		
		//System.out.println("Opção: " + opcao);
		 
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
				listar();
				break;
			case 6:
				System.out.println("Volte sempre!");
				System.exit(0); // Sair do programa, o break sai do laço switch
				break; 
			default: 
				System.out.println("Opção inválida!");
				operacoes();
				break; 
		}
		
	}
	
	public static void criarConta() {
				
		int idPessoa = 0;
		
		scanner.nextLine();  // Limpa o buffer
		
		System.out.println("\nNome: ");
		String nome = scanner.nextLine();
		
		System.out.println("\nCPF: ");
		String cpf = scanner.nextLine();
		
		System.out.println("\nE-mail: ");
		String email = scanner.nextLine();
		
		System.out.println("\nNúmero da conta: ");
		int numeroConta = scanner.nextInt();
		
		System.out.println("\nAgência: ");
		int agencia = scanner.nextInt();
		
		Pessoa pessoa = new Pessoa(idPessoa, nome, cpf, email);
		
		Conta conta = new Conta(pessoa, numeroConta, agencia); 
		
		contas.add(conta); 
		
		System.out.println("Conta criada com sucesso!");
		
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
			}
		}
		
		operacoes();
	}
	
	public static void listar() {
		if(contas.size() > 0) {
			for(Conta conta: contas) {
				System.out.println("\nNúmero conta: " + conta.getNumeroConta());
				System.out.println("Titular: " + conta.getPessoa().getNome());
				System.out.println("Saldo: " + conta.getSaldo());
			}
		} else {
			System.out.println("Não há contas cadastradas!");
		}
		
		operacoes();
	}
	
}
