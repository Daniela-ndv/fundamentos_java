package banco;

/**
 * Classe que abstrai uma pessoa física, subclasse de Pessoa
 * @see Pessoa
 */
public class Fisica extends Pessoa {

	private static final long serialVersionUID = 1L;
	
	private String cpf;
	private String rg;
	
	/*
	 * Construtor com atributos da superclasse 
	 * @param idPessoa, nome e email da superclasse Pessoa
	 * @param cpf e rg da subclasse Fisica
	 */
	public Fisica(int idPessoa, String nome, String email, String cpf, String rg) {
		super(idPessoa, nome, email);
		this.cpf = cpf;
		this.rg = rg; 
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
}
