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
public class StatusPedido {
    
    private String Resultado;
    private int Empregados_idEmpregados;
    private int ChefeImediato_idChefeImediato;
    private int DepartamentoContasPagar_idDepartamentoContaPagar;

    public String getResultado() {
        return Resultado;
    }

    public void setResultado(String Resultado) {
        this.Resultado = Resultado;
    }

    public int getEmpregados_idEmpregados() {
        return Empregados_idEmpregados;
    }

    public void setEmpregados_idEmpregados(int Empregados_idEmpregados) {
        this.Empregados_idEmpregados = Empregados_idEmpregados;
    }

    public int getChefeImediato_idChefeImediato() {
        return ChefeImediato_idChefeImediato;
    }

    public void setChefeImediato_idChefeImediato(int ChefeImediato_idChefeImediato) {
        this.ChefeImediato_idChefeImediato = ChefeImediato_idChefeImediato;
    }

    public int getDepartamentoContasPagar_idDepartamentoContaPagar() {
        return DepartamentoContasPagar_idDepartamentoContaPagar;
    }

    public void setDepartamentoContasPagar_idDepartamentoContaPagar(int DepartamentoContasPagar_idDepartamentoContaPagar) {
        this.DepartamentoContasPagar_idDepartamentoContaPagar = DepartamentoContasPagar_idDepartamentoContaPagar;
    }
 
}
