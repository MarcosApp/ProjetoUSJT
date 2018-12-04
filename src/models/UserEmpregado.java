/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Calendar;

/**
 *
 * @author Marcos
 */
public class UserEmpregado {
    
    private String Nome;
    private String Cpf;
    private String Rg;
    private String DataNascimento;
    private String Cargo;
    private int LoginSistema;
    private int ChefeImediato;

    public int getChefeImediato() {
        return ChefeImediato;
    }

    public void setChefeImediato(int ChefeImediato) {
        this.ChefeImediato = ChefeImediato;
    }

    public int getLoginSistema() {
        return LoginSistema;
    }

    public void setLoginSistema(int LoginSistema) {
        this.LoginSistema = LoginSistema;
    }
    
    public String getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(String DataNascimento) {
        this.DataNascimento = DataNascimento;
    }

    

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }

    public String getRg() {
        return Rg;
    }

    public void setRg(String Rg) {
        this.Rg = Rg;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    
    
}
