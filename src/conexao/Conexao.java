/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Marcos
 */
public class Conexao {
        
    private final Connection conexao;
    
     public Connection getConexao() {
        return conexao;
    }
    
    public Conexao() throws SQLException{
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.exit(0);
        }
        
        this.conexao = conectar(); 
    }
    public Connection conectar() throws SQLException{
        String servidor = "127.0.0.1";
        String porta = "3306";
        String banco = "projetousjt";
        String usuario = "root";
        String senha = "";
        return DriverManager.getConnection("jdbc:mysql://" + servidor + ":" + porta + "/"+banco,
                usuario, senha);
    }
    
    public void desconectar() throws SQLException{
        conexao.close();
    }
    
    
}
