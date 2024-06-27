package banco;

/**
 * Classe que abstrai uma pessoa jurídica, subclasse de Pessoa
 * @see Pessoa
 */
public class Juridica extends Pessoa{

	private static final long serialVersionUID = 1L;
	
	private int cnpj;

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}

}
