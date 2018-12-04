/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Marcos
 */
public class ChefeImediato {
    private String Nome;
    private int idChefeImediato;
    private int idLogin;

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getIdChefeImediato() {
        return idChefeImediato;
    }

    public void setIdChefeImediato(int idChefeImediato) {
        this.idChefeImediato = idChefeImediato;
    }
    
    
}
