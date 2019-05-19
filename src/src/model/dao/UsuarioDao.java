/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.model.dao;

import src.bancoDeDados.ConnectionFactory;
import src.model.entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author savio
 */
public class UsuarioDao {

    public static boolean validar(Usuario user) {
        Usuario usuario = new Usuario();

        try {
            // cria uma variavel de conexao com o banco

            Connection con = ConnectionFactory.getConnection();

            // Criar uma variavel para pesquisa no banco
            String query = "SELECT * FROM usuario WHERE email = ? and senha = ? ";

            //cria um comando
            PreparedStatement cmd;

            cmd = con.prepareStatement(query);

            // inseri os dados do usuario para pesquisar 
            cmd.setString(1, "" + user.getEmail());
            cmd.setString(2, "" + user.getSenha());

            //Cria uma variavel para receber os resultados da pesquisa no banco de dados
            ResultSet rs;

            //insere os dados recebidos do banco na varivel
            rs = cmd.executeQuery();

            if (rs.next()) {
                usuario = new Usuario(Integer.parseInt(rs.getString("id")), rs.getString("nome"), rs.getString("email"), rs.getString("senha"));
            }

            // fecha o comando e a conecção com o banco
            con.close();

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro de SQL" + ex.getMessage());
            return false;
        }

        if (user.getEmail().equals(usuario.getEmail()) && user.getSenha().equals(usuario.getSenha())) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean inserir(Usuario user) {

        try {
            // cria uma variavel

            Connection con = ConnectionFactory.getConnection();

            // Criar uma variavel para inserção no banco
            String query = "INSERT INTO usuario (nome, email, senha) VALUES(?,?,?)";

            //cria um comando
            PreparedStatement stmt = con.prepareStatement(query);

            //set os valores na string de inserção
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getSenha());

            //executa o comando no banco de dados 
            stmt.executeUpdate();

            // fecha o comando e a conecção com o banco
            stmt.close();
            con.close();

            return true;

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro de SQL" + ex.getMessage());
            return false;
        }
    }

    public static List<Usuario> consultarTodos() {
        List<Usuario> listUsuario = new ArrayList<>();
        //Cria uma List para retonar uma lista de Usuarios
        try {

            // cria uma variavel
            Connection connec = ConnectionFactory.getConnection();

            // Criar uma variavel para busca no banco
            String query = "SELECT * FROM usuario ";

            //cria um comando
            PreparedStatement cmd;

            cmd = connec.prepareStatement(query);

            ResultSet rs;
            //cria uma variavel auxiliar para adicionar a list
            rs = cmd.executeQuery();

            while (rs.next()) {
                Usuario user = new Usuario(Integer.parseInt(rs.getString("Id")), rs.getString("nome"), rs.getString("email"), rs.getString("senha"));
                listUsuario.add(user);
            }

            cmd.close();
            connec.close();

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro de SQL" + ex.getMessage());
        }

        return listUsuario;
    }

    public static boolean update(Usuario user) {

        try {
            // cria uma variavel

            Connection con = ConnectionFactory.getConnection();

            // Criar uma variavel para inserção no banco
            String query = "UPDATE usuario set Nome = ? , Email = ?, Senha = ? where id = ?";

            //cria um comando
            PreparedStatement stmt = con.prepareStatement(query);

            //set os valores na string de inserção
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getSenha());
            stmt.setString(4, "" + user.getId());

            //executa o comando no banco de dados 
            stmt.executeUpdate();

            // fecha o comando e a conecção com o banco
            stmt.close();
            con.close();

            return true;

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro de SQL" + ex.getMessage());
            return false;
        }
    }

    public static boolean delete(Usuario user) {

        try {
            // cria uma variavel

            Connection con = ConnectionFactory.getConnection();

            // Criar uma variavel para inserção no banco
            String query = "DELETE FROM usuario where id = ?";

            //cria um comando
            PreparedStatement stmt = con.prepareStatement(query);

            //set os valores na string de inserção
            stmt.setString(1, ""+user.getId());

            //executa o comando no banco de dados 
            stmt.executeUpdate();

            // fecha o comando e a conecção com o banco
            stmt.close();
            con.close();

            return true;

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro de SQL" + ex.getMessage());
            return false;
        }
    }
}
