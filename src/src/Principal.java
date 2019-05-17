/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import src.view.TelaLogin;
import src.view.TelaPrincipal;


/**
 *
 * @author savio
 */
public class Principal {
    
    public static void main(String[] args) {
        
        TelaLogin.telaLogin = new TelaLogin();
        TelaLogin.telaPrincipal = new TelaPrincipal();
        
        TelaLogin.telaLogin.setVisible(true);
        // teste web
       
    }    
}
