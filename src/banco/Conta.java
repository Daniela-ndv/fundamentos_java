package banco;

public class Conta {
    int agencia;
    int numero;
    double saldo;

    // Construtor padrão (algumas APIs Java esperam o construtor padrão)
    public Conta(){

    }

    // Construtor com parâmetros
    public Conta(int agencia, int numero, double saldo){
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
    }

    // getters e setters
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

    
}

