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
	private static final long serialVersionUID = -403695969897229171L;
	
	private String nome; 
    private String telefone;
    private String cidade;
    private String endereco; 

    /*
     * Métodos Get e Set dos atributos
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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
    
    

}
