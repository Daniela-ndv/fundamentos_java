package banco;

/*
 * Classe que lista o histórico de transações
 */
public class Movimento{
		
	private int tipo;
	private String data;
	private String hora;
	private double valor;
	private Conta conta; 
	
	public Movimento(int tipo, String data, String hora, double valor, Conta conta) {
		this.tipo = tipo;
		this.data = data;
		this.hora = hora;
		this.valor = valor;
		this.conta = conta; 
	}
	
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

	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	
	
	
}
