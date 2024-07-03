package banco;

import java.io.Serializable;

import utilitarios.Utils;

/**
 * Classe que abstrai um usuário da conta
 */

//Classe serializável: objetos gerados a partir da classe terão as informações serializáveis, transformadas em pacotes de bits para trafegar na rede
public class Pessoa implements Serializable{

    /**
	 * serialVersionUID: para identificação dos objetos de modo a evitar conflito no ambiente de memória
	 * Controle de versão
	 */
	private static final long serialVersionUID = 1L; 
	
	private static int contadorPessoa = 1; 
	
	private int idPessoa; 
    private String nome; 
	private String email;
    
	public Pessoa() { }

	/*
	 * Método construtor
	 */
	public Pessoa(int idPessoa, String nome, String email) {
		this.idPessoa = idPessoa;
		this.nome = nome;
		this.email = email;
		Pessoa.contadorPessoa += 1;
	}

	/*
     * Métodos Getters e Setters dos atributos
     */
	
    public int getIdPessoa() {
		return idPessoa;
	}
    
    public void setIdPessoa(int idPessoa) {
    	this.idPessoa = idPessoa;
    }

	public String getNome() {
        return nome;
    }

	public void setNome(String nome) {                                                   
        this.nome = nome;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static int getContadorPessoa() {
		return contadorPessoa;
	}

	
	
}
