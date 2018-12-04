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
public class Reembolso {
    
    private String MesRef;
    private String ValorReembolso;
    private String Descricao;
    private int EmpregadoId;

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getMesRef() {
        return MesRef;
    }

    public void setMesRef(String MesRef) {
        this.MesRef = MesRef;
    }

    public String getValorReembolso() {
        return ValorReembolso;
    }

    public void setValorReembolso(String ValorReembolso) {
        this.ValorReembolso = ValorReembolso;
    }

    public int getEmpregadoId() {
        return EmpregadoId;
    }

    public void setEmpregadoId(int EmpregadoId) {
        this.EmpregadoId = EmpregadoId;
    }

    
    
    
    
    
}
