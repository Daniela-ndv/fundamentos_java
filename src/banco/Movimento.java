package banco;

public class Movimento{
	
	Conta conta1 = new Conta();
	
	private int tipo;
	private String data;
	private String hora;
	private int conta;
	private double valor;
	
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
		System.out.println("Quantidade de depósitos: " + conta1.contadorDepositar);
		System.out.println("Quantidade de saques: " + conta1.contadotSacar);
	}	
	
	
	
}
