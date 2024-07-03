package banco;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Classe que abstrai uma conta bancária
 * Padrão JavaBean
 * @author Daniela Dalla Vecchia
 * @version 1.0
 */

// Classe serializável: objetos gerados a partir da classe terão as informações serializáveis, transformadas em pacotes de bits para trafegar na rede
public class Conta implements Serializable {

    /**
	 * Controle de versão de uma serializável
	 */
	private static final long serialVersionUID = 1L; 
	
	private static int contadorContas = 1; 
    private Pessoa pessoa; 
    private int numeroConta;
	private int agencia; 
    private Double saldo = 0.0;

    /*
     * Construtor padrão (algumas APIs Java esperam o construtor padrão)
     */
    public Conta(){ }

    /*
     * Construtor de classe com parâmetros
     */
    public Conta(Pessoa pessoa, int numeroConta, int agencia){
    	this.numeroConta = numeroConta;
		this.agencia = agencia;
        this.pessoa = pessoa;
        this.updateSaldo(); 
        Conta.contadorContas += 1;
    }

    /*
     * Métodos Getters e Setters
     */    
    public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	
    public double getSaldo() {
        return saldo; 
    }
    
    public void setSaldo(double saldo) {
    	this.saldo = saldo;
    }
    
    public Pessoa getPessoa() {
		return pessoa;
	}
    
    public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
    
    private void updateSaldo() {
        this.saldo = this.getSaldo();
    }
    
    /*
     * Acrescenta valor ao saldo da conta
     * @param valor que será depositado
     */
    public void depositar(double valor){   	
    	if (valor > 0) {
    		setSaldo(getSaldo() + valor);
    		System.out.println("Depósito realizado com sucesso!");
    	} else {
    		System.out.println("A Operação não foi realizada!");
    	}	
    }
    
    /*
     * Retira um valor do saldo da conta
     * @param valor que será retirado
     */
    public void sacar(double valor){
    	if(valor > 0 && valor <= this.getSaldo()) {
    		setSaldo(getSaldo() - valor);
    		System.out.println("Saque realizado com sucesso!");
    	} else {
    		System.out.println("A Operação não foi realizada!");
    	}
    }
	
    /*
     * Transfere um valor do saldo da conta
     * @param conta para depósito e valor que será depositado
     */
    public void transferir(Conta contaDeposito, double valor) {
    	if(valor > 0 && valor <= this.getSaldo()) {
    		
    		setSaldo(getSaldo() - valor);
    		contaDeposito.setSaldo(contaDeposito.getSaldo() + valor); 
    		
    		System.out.println("Transferência realizada com sucesso!");
    	} else {
    		System.out.println("A Operação não foi realizada!");
    	}
    }
    
    
    
}

