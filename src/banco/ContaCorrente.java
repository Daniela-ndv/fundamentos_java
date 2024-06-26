package banco;

public class ContaCorrente extends Conta{
    
    private String tipo;
    private double chequeEspecial;

    /*
     * Métodos Getters e Setters dos atributos Tipo e Cheque Especial
     */
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
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

}
