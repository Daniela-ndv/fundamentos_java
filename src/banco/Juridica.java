package banco;

/**
 * Classe que abstrai uma pessoa jurídica, subclasse de Pessoa
 * @see Pessoa
 */
public class Juridica extends Pessoa{

	private static final long serialVersionUID = 1L;
	
	private String cnpj;
	
	/*
	 * Contrutor com atributos da superclasse 
	 * @param idPessoa, nome e email da superclasse Pessoa
	 * @param cnpj da subclasse Juridica
	 */
	public Juridica(int idPessoa, String nome, String email, String cnpj) {
		super(idPessoa, nome, email);
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}

