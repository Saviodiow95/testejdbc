/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.model.entidades;

/**
 *
 * @author savio
 */
public class Usuario {
    
    private int id;
    private String nome;
    private String email;
    private String senha;
    
    
    public Usuario() {
    }

    public Usuario(int id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    
    
    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario" + "\nid: " + id + ",\nnome: " + nome + ",\nemail: " + email + ",\nsenha: " + senha;
    }

    
    
    
}
