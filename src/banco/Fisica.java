package banco;

/**
 * Classe que abstrai uma pessoa física, subclasse de Pessoa
 * @see Pessoa
 */
public class Fisica extends Pessoa {

	private static final long serialVersionUID = 1L;
	
	private int cpf;
	private int rg;
	
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public int getRg() {
		return rg;
	}
	public void setRg(int rg) {
		this.rg = rg;
	}

}
