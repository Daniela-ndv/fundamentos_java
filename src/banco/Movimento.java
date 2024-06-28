package banco;

/*
 * Classe que lista o histórico de transações
 */
public class Movimento{
	
	Conta conta1 = new Conta();
	
	private int tipo;
	private String data;
	private String hora;
	private double valor;
	private int conta;
	
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public int getConta() {
		return conta;
	}
	public void setConta(int conta) {
		this.conta = conta;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public void novoMovimento() {
		
	}
	
	public void consultar() {
		conta1.depositar(1000);
		conta1.sacar(100); 
	}	
	
	
	
}
