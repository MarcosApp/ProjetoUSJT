/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queriesaux;

/**
 *
 * @author Marcos
 */
public class QuerysAux {
    
    public static String Listar = "SELECT * FROM empregados";
    
    public static String NovoLogin = "INSERT INTO loginsistema("
            + "Login,"
            + "Senha,"
            + "Perfil)"
            + "VALUES(?,?,?)";
    
    public static String NovoEmpregado = "INSERT INTO empregados("
            + "Nome,"
            + "Cpf,"
            + "Rg,"
            + "DataNascimento,"
            + "Cargo,"
            + "LoginSistema_idLoginSistema,"
            + "ChefeImediato)"
            + "VALUES(?,?,?,?,?,?,?)";
    
    public static String NovaPrestacao = "INSERT INTO prestacaoconta("
            + "MesRef,"
            + "CartaoC,"
            + "Despesas,"
            + "Descricao,"
            + "Adiantamento,"
            + "ValorPrest,"
            + "Empregados_idEmpregados)"
            + "VALUES(?,?,?,?,?,?,?)";
    
    public static String NovoChefe = "INSERT INTO chefeimediato("
            + "Nome,ChefedoChefe_idChefedoChefe,LoginSistema_idLoginSistema)"
            + "VALUES(?,?,?)";
    
    public static String NovoChefedoChefe = "INSERT INTO chefedochefe("
            + "Nome,LoginSistema_idLoginSistema)"
            + "VALUES(?,?)";
    public static String NovoReembolso = "INSERT INTO reembolso("
            + "MesRef,"
            + "ValorRembolso,"
            + "Descricao,"
            + "Empregados_idEmpregados)"
            + "VALUES(?,?,?,?)";
    
    public static String ConsultaPedidoPrest = "SELECT distinct T1.idEmpregados,Nome,Rg,Cpf,Cargo,CartaoC,Despesas,Descricao,Adiantamento, T2.Resultado,T3.MesRef,Despesas,ValorPrest "
            + "FROM empregados T1 inner join prestacaoconta T3 on T3.Empregados_idEmpregados = T1.idEmpregados "
            + "inner join statuspedido T2 on T3.Empregados_idEmpregados = "
            + "T2.idEmpregado WHERE Resultado = 'Aprovado' And MesRef = ?";
    
    public static String ConsultaPedidoRembo = "SELECT distinct T1.idEmpregados,Nome,Rg,Cpf,Cargo, T2.Resultado, "
            + "T3.MesRef,Descricao,ValorRembolso FROM empregados T1 "
            + "inner join reembolso T3 on T3.Empregados_idEmpregados = "
            + "T1.idEmpregados inner join statuspedido T2 on T3.Empregados_idEmpregados = "
            + "T2.idEmpregado where Resultado = 'Aprovado' AND MesRef = ?";
    
    public static String InserirIDPrest = "INSERT INTO departamentocontaspagar ("
            +"PrestacaoConta_idSolictPrestacaoConta)"
            + "VALUES(?)";
    
    public static String InserirIDRemmbolso = "INSERT INTO departamentocontaspagar ("
            +"Reembolso_idReembolso)"
            + "VALUES(?)";
    
    public static String InserirStatusPedido = "INSERT INTO statuspedido ("
            + "Resultado,"
            + "idEmpregado,"
            + "ChefeImediato_idChefeImediato,"
            + "DepartamentoContasPagar_idDepartamentoContaPagar)"
            + "VALUES(?,?,?,?)";
    
    public static String StatusQueryPref = "SELECT distinct T1.idEmpregados,Nome,Rg,Cpf,Cargo, T2.Resultado, T3.MesRef,Despesas,ValorPrest FROM empregados T1 " +
                "inner join prestacaoconta T3 on T3.Empregados_idEmpregados = T1.idEmpregados " +
                "inner join statuspedido T2 on T3.Empregados_idEmpregados = " +
                "T2.idEmpregado where Resultado = ? and idEmpregados = ?";
    
    public static String StatusQueryReembolso = "SELECT distinct T1.idEmpregados,Nome,Rg,Cpf,Cargo, T2.Resultado,T3.MesRef,Descricao,ValorRembolso FROM empregados T1 inner join reembolso T3 on T3.Empregados_idEmpregados = T1.idEmpregados inner join statuspedido T2 on T3.Empregados_idEmpregados = T2.idEmpregado where Resultado = ? and idEmpregados = ?";
    
    public static String QueryAprovar = "UPDATE statuspedido SET Resultado = 'Aprovado' WHERE idEmpregado = ?";
    public static String QueryReprovar = "UPDATE statuspedido SET Resultado = 'Reprovado' WHERE idEmpregado = ?";
    
    public static String QueryValoresRem = "select SUM(T3.ValorRembolso)  as ValorRembolso FROM (SELECT T1.Nome,Rg,Cpf,Cargo, T2.Resultado, T3.MesRef,ValorRembolso FROM empregados T1 inner join reembolso T3 on T3.Empregados_idEmpregados = T1.idEmpregados inner join statuspedido T2 on T3.Empregados_idEmpregados = T2.idEmpregado where Resultado = 'Aprovado' and MesRef = ?) T3";
    public static String QueryValoresPref = "select SUM(T3.ValorPrest)  as ValorPrestacao FROM (SELECT T1.Nome,Rg,Cpf,Cargo, T2.Resultado,Date, T3.MesRef,Despesas,ValorPrest FROM empregados T1 inner join prestacaoconta T3 on T3.Empregados_idEmpregados = T1.idEmpregados inner join statuspedido T2 on T3.Empregados_idEmpregados = T2.idEmpregado where Resultado = 'Aprovado' and MesRef = ?) T3";
    
    public static String StatusQueryPrefChef = "SELECT distinct T1.idEmpregados,Nome,Rg,Cpf,Cargo, T2.Resultado,T3.MesRef,Despesas,ValorPrest FROM empregados T1 " +
            "inner join prestacaoconta T3 on T3.Empregados_idEmpregados = T1.idEmpregados " +
            "inner join statuspedido T2 on T3.Empregados_idEmpregados = T2.idEmpregado where Resultado = ?" +
            "and ValorPrest <= 250000 and ChefeImediato_idChefeImediato = ?";
    
    public static String StatusQueryReembolsoChef = "SELECT distinct T1.idEmpregados,Nome,Rg,Cpf,Cargo, T2.Resultado," +
            "T3.MesRef,Descricao,ValorRembolso FROM empregados T1 " +
            "inner join reembolso T3 on T3.Empregados_idEmpregados = T1.idEmpregados " +
            "inner join statuspedido T2 on T3.Empregados_idEmpregados = " +
            "T2.idEmpregado where Resultado = ? and ValorRembolso <= 250000 and ChefeImediato_idChefeImediato = ?";
  
    public static String combBoxPrest = "SELECT distinct T1.idEmpregados FROM empregados T1 inner join prestacaoconta T3 on T3.Empregados_idEmpregados = T1.idEmpregados inner join statuspedido T2 on T3.Empregados_idEmpregados = T2.idEmpregado where Resultado = ? and ValorPrest <= 250000";
    public static String combBoxRemb = "SELECT distinct T1.idEmpregados FROM empregados T1 inner join reembolso T3 on T3.Empregados_idEmpregados = T1.idEmpregados inner join statuspedido T2 on T3.Empregados_idEmpregados = T2.idEmpregado where Resultado = ? and ValorRembolso <= 250000;";
    
    public static String combBoxPrestChef = "SELECT distinct T1.idEmpregados FROM empregados T1 inner join prestacaoconta T3 on T3.Empregados_idEmpregados = T1.idEmpregados inner join statuspedido T2 on T3.Empregados_idEmpregados = T2.idEmpregado where Resultado = ? and ValorPrest <= 250000 and ChefeImediato_idChefeImediato = ?";
    public static String combBoxReembChef = "SELECT distinct T1.idEmpregados FROM empregados T1 inner join reembolso T3 on T3.Empregados_idEmpregados = T1.idEmpregados inner join statuspedido T2 on T3.Empregados_idEmpregados = T2.idEmpregado where Resultado =  ? and ValorRembolso <= 250000 and ChefeImediato_idChefeImediato = ?";
    
    public static String StatusQueryPrefChefdoChefe = "SELECT distinct T1.idEmpregados,Nome,Rg,Cpf,Cargo, T2.Resultado,T3.MesRef,Despesas,ValorPrest FROM empregados T1 " +
            "inner join prestacaoconta T3 on T3.Empregados_idEmpregados = T1.idEmpregados " +
            "inner join statuspedido T2 on T3.Empregados_idEmpregados = T2.idEmpregado where Resultado = ?" +
            "and ValorPrest > 250000";
    
    public static String StatusQueryReembolsoChefdoChefe = "SELECT distinct T1.idEmpregados,Nome,Rg,Cpf,Cargo, T2.Resultado," +
            "T3.MesRef,Descricao,ValorRembolso FROM empregados T1 " +
            "inner join reembolso T3 on T3.Empregados_idEmpregados = T1.idEmpregados " +
            "inner join statuspedido T2 on T3.Empregados_idEmpregados = " +
            "T2.idEmpregado where Resultado = ? and ValorRembolso > 250000 ";
    
    public static String combBoxPrestChefdoChefe = "SELECT distinct T1.idEmpregados FROM empregados T1 inner join prestacaoconta T3 on T3.Empregados_idEmpregados = T1.idEmpregados inner join statuspedido T2 on T3.Empregados_idEmpregados = T2.idEmpregado where Resultado = ? and ValorPrest > 250000";
    public static String combBoxReembChefdoChefe = "SELECT distinct T1.idEmpregados FROM empregados T1 inner join reembolso T3 on T3.Empregados_idEmpregados = T1.idEmpregados inner join statuspedido T2 on T3.Empregados_idEmpregados = T2.idEmpregado where Resultado =  ? and ValorRembolso > 250000";

}
