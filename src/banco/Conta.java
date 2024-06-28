package banco;

import java.io.Serializable;

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

    /*
     * Atributos que representam agência, número, cliente e saldo da conta
     */
    private int agencia;
    private int numero;
    private int cliente; 
    private double saldo;
    public int contadorDepositar;
    public int contadotSacar;

    /*
     * Construtor padrão (algumas APIs Java esperam o construtor padrão)
     */
    public Conta(){

    }

    /*
     * Construtor de classe com parâmetros
     */
    public Conta(int agencia, int numero, double saldo, int cliente){
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = cliente; 
    }

    /*
     * Métodos Getters e Setters
     */
    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public double getSaldo() {
        return saldo; 
    }
    
    public void setSaldo(double saldo) {
    	this.saldo = saldo;
    }
    
    public int getCliente() {
		return cliente;
	}

    /*
     * Acrescenta valor ao saldo da conta
     * @param valor que será depositado
     */
    public void depositar(double valor){
        this.saldo += valor; 
        contadorDepositar++;
    }

    /*
     * Retira um valor do saldo da conta
     * @param valor que será retirado
     * @see depositar
     */
    public void sacar(double valor){
        this.saldo -= valor;
        contadotSacar++;
    }

    
}

