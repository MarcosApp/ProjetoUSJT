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
public class PrestacaoConta {
    private String MesRef;
    private String CartaoC;
    private String Despesas;
    private String Descricao;
    private String Adiantamento;
    private String ValorPrest;
    private int EmpregadosId;

    public String getMesRef() {
        return MesRef;
    }

    public void setMesRef(String MesRef) {
        this.MesRef = MesRef;
    }

    public String getCartaoC() {
        return CartaoC;
    }

    public void setCartaoC(String CartaoC) {
        this.CartaoC = CartaoC;
    }

    public String getDespesas() {
        return Despesas;
    }

    public void setDespesas(String Despesas) {
        this.Despesas = Despesas;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getAdiantamento() {
        return Adiantamento;
    }

    public void setAdiantamento(String Adiantamento) {
        this.Adiantamento = Adiantamento;
    }

    public int getEmpregadosId() {
        return EmpregadosId;
    }

    public void setEmpregadosId(int EmpregadosId) {
        this.EmpregadosId = EmpregadosId;
    }

    public String getValorPrest() {
        return ValorPrest;
    }

    public void setValorPrest(String ValorPrest) {
        this.ValorPrest = ValorPrest;
    }
    
    
}
