package banco;

import java.io.Serializable;

/**
 * Classe que abstrai uma conta bancária
 * Padrão JavaBean
 * @author Daniela Dalla Vecchia
 * @version 1.0
 */

public class Conta implements Serializable {

    // private static final long serialversionUID = 1L; //Controle de versão de uma serializável

    /*
     * Atributos que representam agência, número e saldo da conta
     */
    private int agencia;
    private int numero;
    private double saldo;

    /*
     * Construtor padrão (algumas APIs Java esperam o construtor padrão)
     */
    public Conta(){

    }

    /*
     * Construtor de classe com parâmetros
     */
    public Conta(int agencia, int numero, double saldo){
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
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
        return this.saldo; 
    }

    // Métodos

    /*
     * Acrescenta valor ao saldo da conta
     * @param valor que será depositado
     */
    public void depositar(double valor){
        this.saldo += valor; 
    }

    /*
     * Retira um valor do saldo da conta
     * @param valor que será retirado
     * @see depositar
     */
    public void sacar(double valor){
        this.saldo -= valor;
    }

    
}

