package banco;

import java.io.Serializable;

/**
 * Classe que abstrai ums pessoa 
 * Padrão JavaBean
 * @author Daniela Dalla Vecchia
 * @version 1.0
 */

/*
 * Classe serializável: objetos gerados a partir da classe terão as informações serializáveis, transformadas em pacotes de bits para trafegar na rede
 */
public class Pessoa implements Serializable{

    // private static final long serialversionUID = 1L; //Identificação dos objetos de modo a evitar conflito do bite no ambiente de memória

    private String nome; //Atributo encapsulado 

    /*
     * Métodos Get e Set do atributo nome
     */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
