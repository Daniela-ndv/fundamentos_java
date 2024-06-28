package banco;

import java.io.Serializable;

/**
 * Classe que abstrai um usuário da conta
 */

//Classe serializável: objetos gerados a partir da classe terão as informações serializáveis, transformadas em pacotes de bits para trafegar na rede
public class Pessoa implements Serializable{

    /**
	 * Para identificação dos objetos de modo a evitar conflito no ambiente de memória
	 * Controle de versão
	 */
	private static final long serialVersionUID = 1L;
	
	private static int contadorPessoa = 1; 
	
	private String nome; 
    private String telefone;
    private String endereco; 
    private int id; 
    
    public Pessoa() {
		
	}

	public Pessoa(String nome, String telefone, String endereco, int id) {
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.id = id;
		contadorPessoa += 1; 
	}

	/*
     * Métodos Getters e Setters dos atributos
     */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {                                                   
        this.nome = nome;
    }

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
