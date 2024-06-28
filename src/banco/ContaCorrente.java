package banco;

import utilitarios.Utils;

/**
 * Classe que abstrai uma Conta Corrente, subclasse de Conta
 * @see Conta
 */
public class ContaCorrente extends Conta{
    
	private static final long serialVersionUID = 1L;
	
	private double chequeEspecial;

    /*
     * Método Get e Set do atributo chequeEspecial
     */
    public double getChequeEspecial() {
        return chequeEspecial;
    }
    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    /*
     * Método que calcula o saldo disponível
     */
    public double getSaldoDisponivel(){
        return super.getSaldo() + chequeEspecial;
    }

    /*
     * Método sobrescrito
     */
    @Override
    public void sacar(double valor){
        valor += 10;
        super.sacar(valor); 
    }
    
    /*
     * Método toString (formatar)
     */
    public String toString() {
		return "\nNúmero da conta: " + this.getAgencia() + 
				"\nAgência: " + this.getAgencia() +
				"\nCliente:" + this.getCliente() +  
				"\nCheque especial: " + this.getChequeEspecial() +
				"\nSaldo:" + Utils.doubleToString(this.getSaldo()) +
				"\n"; 
	}

}
