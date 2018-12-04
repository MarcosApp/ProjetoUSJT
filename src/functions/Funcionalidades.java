/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

import conexao.Conexao;
import formsview.FormularioRelatorio;
import formsview.Principal;
import formsview.StatusPedidos;
import formsview.StatusPedidosChef;
import formsview.StatusPedidosChefeChefe;
import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.sql.Statement.RETURN_GENERATED_KEYS;
import java.util.ArrayList;
import javafx.scene.control.ComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import models.ChefeImediato;
import models.ChefedoChefe;
import models.PrestacaoConta;
import models.Reembolso;
import models.StatusPedido;
import models.UserEmpregado;
import models.UserLogin;
import queriesaux.QuerysAux;

/**
 *
 * @author Marcos
 */
public class Funcionalidades {
    
    public boolean cadastrarEmpregado(UserEmpregado empregado){
        String sql = QuerysAux.NovoEmpregado;
        
        Conexao conexao;
        try {
            conexao = new Conexao();
        }catch(SQLException e){
            return false;
        }
        try 
            (PreparedStatement ps = 
                conexao.getConexao().prepareStatement(sql);)
        {
            ps.setString(1, empregado.getNome());
            ps.setString(2, empregado.getCpf());
            ps.setString(3, empregado.getRg());
            ps.setString(4, empregado.getDataNascimento());
            ps.setString(5, empregado.getCargo());
            ps.setInt(6, empregado.getLoginSistema());
            ps.setInt(7, empregado.getChefeImediato());
            
            ps.execute();
            
            
        } catch(SQLException e){
            try{
            conexao.getConexao().rollback();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
            return false;
        }
        return true;
    }
    public boolean cadastrarPrestacao(PrestacaoConta conta){
        String sql = QuerysAux.NovaPrestacao;
        
        Conexao conexao;
        try {
            conexao = new Conexao();
        }catch(SQLException e){
            return false;
        }
        try 
            (PreparedStatement ps = 
                conexao.getConexao().prepareStatement(sql);)
            
        {
            ps.setString(1, conta.getMesRef());
            ps.setString(2, conta.getCartaoC());
            ps.setString(3, conta.getDespesas());
            ps.setString(4, conta.getDescricao());
            ps.setString(5, conta.getAdiantamento());
            ps.setString(6, conta.getValorPrest());
            ps.setInt(7, conta.getEmpregadosId());
            
            ps.execute();
            
            
        } catch(SQLException e){
            try{
            conexao.getConexao().rollback();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
            return false;
        }
        return true;
        
    }
    public boolean cadastrarReembolso(Reembolso contaRemb){
        String sql = QuerysAux.NovoReembolso;
        
        Conexao conexao;
        try {
            conexao = new Conexao();
        }catch(SQLException e){
            return false;
        }
        try 
            (PreparedStatement ps = 
                conexao.getConexao().prepareStatement(sql);)
        {
            ps.setString(1, contaRemb.getMesRef());
            ps.setString(2, contaRemb.getValorReembolso());
            ps.setString(3, contaRemb.getDescricao());
            ps.setInt(4, contaRemb.getEmpregadoId());
           
            ps.execute();
            
            
        } catch(SQLException e){
            try{
            conexao.getConexao().rollback();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
            return false;
        }
        return true;
    }
    public boolean cadastrarChefe(ChefeImediato chefe){
        String sql = QuerysAux.NovoChefe;
        
        Conexao conexao;
        try {
            conexao = new Conexao();
        }catch(SQLException e){
            return false;
        }
        try 
            (PreparedStatement ps = 
                conexao.getConexao().prepareStatement(sql);)
        {
            ps.setString(1, chefe.getNome());           
            ps.setInt(2, chefe.getIdChefeImediato());           
            ps.setInt(3, chefe.getIdLogin());           
            ps.execute();
            
            
        } catch(SQLException e){
            try{
            conexao.getConexao().rollback();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
            return false;
        }
        return true;
    }
    public boolean cadastrarChefedoChefe(ChefedoChefe chefe){
        String sql = QuerysAux.NovoChefedoChefe;
        
        Conexao conexao;
        try {
            conexao = new Conexao();
        }catch(SQLException e){
            return false;
        }
        try 
            (PreparedStatement ps = 
                conexao.getConexao().prepareStatement(sql);)
        {
            ps.setString(1, chefe.getNome());           
            ps.setInt(2, chefe.getLogin());           
            ps.execute();
            
            
        } catch(SQLException e){
            try{
            conexao.getConexao().rollback();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
            return false;
        }
        return true;
    }

    public int cadastrarLogin(UserLogin login) throws SQLException{
        String sql = QuerysAux.NovoLogin;
        int idObjeto = 0;
        Conexao conexao = null;
        try {
            conexao = new Conexao();
        }catch(SQLException e){
               e.printStackTrace();
        }
        try 

        {
           PreparedStatement ps = conexao.getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, login.getLogin());           
            ps.setString(2, login.getSenha());           
            ps.setString(3, login.getPerfil());           
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            while(rs.next()){
               idObjeto = rs.getInt(1);
              }
            conexao.desconectar();
        } catch(SQLException e){
            try{
            conexao.getConexao().rollback();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return idObjeto;
    }

    public static void Listar(){
        DefaultTableModel modelo = (DefaultTableModel)Principal.jTableEmrpegados.getModel();
        String sql = QuerysAux.Listar;
        String dados[] = new String[6];
        
        Conexao conexao;
        try {
            conexao = new Conexao();
        }catch(SQLException e){
            return;
        }
        try{
            Statement st = conexao.getConexao().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                dados[0] = rs.getString("idEmpregados");
                dados[1] = rs.getString("Nome");
                dados[2] = rs.getString("Cpf");
                dados[3] = rs.getString("Rg");
                dados[4] = rs.getString("DataNascimento");
                dados[5] = rs.getString("Cargo");
                modelo.addRow(dados);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static String IDMax(){
        String sql = "SELECT MAX(idEmpregados) AS valor FROM empregados";
        
      Conexao conexao = null;
      int id = 0;
        try {
            conexao = new Conexao();
        }catch(SQLException e){
            e.printStackTrace();
        }
        try{
            Statement st = conexao.getConexao().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if(rs.next()){
                id = rs.getInt("valor");
            }
            if (id == 0) {
                id = 1;
            }
            return String.valueOf(id);
        }
        catch(SQLException e){
            return null;
        }
        
    }
    public PrestacaoConta ConsultaPedidoPrest(String mesRef){
        DefaultTableModel modelo = (DefaultTableModel)FormularioRelatorio.TabelaRelatorioPrest.getModel();
        modelo.setNumRows(0);
         String sqlSelect = QuerysAux.ConsultaPedidoPrest;
        String dados[] = new String[13];
        
        //Chamo Conexao
         Conexao conexao;
         
         //Tratar se houve algum erro de Conexao
        try {
            conexao = new Conexao();
        }catch(SQLException e){
            return null;
            //Caso tenha retorna null
        }
        try 
            //Prepando Query (PreparedStatement)
            (PreparedStatement ps = 
                    //Incluindo Query
                conexao.getConexao().prepareStatement(sqlSelect);)
        {
            //Setando na Query Where passando o Codigo digitado
            ps.setString(1, mesRef);
            
            ResultSet rs;
            try{
                rs = ps.executeQuery();
                
            while(rs.next()){
                dados[0] = rs.getString("idEmpregados");
                dados[1] = rs.getString("Nome");
                dados[2] = rs.getString("Rg");
                dados[3] = rs.getString("Cpf");
                dados[4] = rs.getString("Cargo");
                dados[5] = rs.getString("CartaoC");
                dados[6] = rs.getString("Despesas");
                dados[7] = rs.getString("Descricao");
                dados[8] = rs.getString("Adiantamento");
                dados[9] = rs.getString("Resultado");
                dados[10] = rs.getString("MesRef");
                dados[11] = rs.getString("Despesas");
                dados[12] = rs.getString("ValorPrest");
                modelo.addRow(dados);
                }
                
            }catch(SQLException ex){
                ex.printStackTrace();
            }
            ps.executeQuery();
            
        } catch(SQLException e){
            try{
            conexao.getConexao().rollback();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return null;
    }
    public Reembolso ConsultaPedidoReembo(String mesRef){
        DefaultTableModel modelo = (DefaultTableModel)FormularioRelatorio.TableRelatorioReembolso.getModel();
        modelo.setNumRows(0);
         String sqlSelect = QuerysAux.ConsultaPedidoRembo;
        String dados[] = new String[9];
        
        //Chamo Conexao
         Conexao conexao;
         
         //Tratar se houve algum erro de Conexao
        try {
            conexao = new Conexao();
        }catch(SQLException e){
            return null;
            //Caso tenha retorna null
        }
        try 
            //Prepando Query (PreparedStatement)
            (PreparedStatement ps = 
                    //Incluindo Query
                conexao.getConexao().prepareStatement(sqlSelect);)
        {
            //Setando na Query Where passando o Codigo digitado
            ps.setString(1, mesRef);
            
            ResultSet rs;
            try{
                rs = ps.executeQuery();
                
            while(rs.next()){
                dados[0] = rs.getString("idEmpregados");
                dados[1] = rs.getString("Nome");
                dados[2] = rs.getString("Cpf");
                dados[3] = rs.getString("Rg");
                dados[4] = rs.getString("Cargo");
                dados[5] = rs.getString("Resultado");
                dados[6] = rs.getString("MesRef");
                dados[7] = rs.getString("Descricao");
                dados[8] = rs.getString("ValorRembolso");
                modelo.addRow(dados);
                }
                
            }catch(SQLException ex){
                ex.printStackTrace();
            }
            ps.executeQuery();
            
        } catch(SQLException e){
            try{
            conexao.getConexao().rollback();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return null;
    }
    public static String IDMaxRembolso(){
        String sql = "SELECT MAX(idReembolso) AS idReembolso FROM reembolso";
        
      Conexao conexao = null;
      int id = 0;
        try {
            conexao = new Conexao();
        }catch(SQLException e){
            e.printStackTrace();
        }
        try{
            Statement st = conexao.getConexao().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if(rs.next()){
                id = rs.getInt("idReembolso");
            }
            if (id == 0) {
                id = 1;
            }else {
                id = id + 1;
            }
            return String.valueOf(id);
        }
        catch(SQLException e){
            return null;
        }
        
    }
    
    public static String IDMaxPrest(){
        String sql = "SELECT MAX(idSolictPrestacaoConta) AS idPConta  FROM prestacaoconta";
        
      Conexao conexao = null;
      int id = 0;
        try {
            conexao = new Conexao();
        }catch(SQLException e){
            e.printStackTrace();
        }
        try{
            Statement st = conexao.getConexao().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if(rs.next()){
                id = rs.getInt("idPConta");
            }
            if (id == 0) {
                id = 1;
            }else{
                id = id + 1;
            }
            return String.valueOf(id);
        }
        catch(SQLException e){
            return null;
        }
        
    }
    
    public static String IDMaxDP(){
    String sql = "SELECT MAX(idDepartamentoContaPagar) AS idDP  FROM departamentocontaspagar";

  Conexao conexao = null;
  int id = 0;
    try {
        conexao = new Conexao();
    }catch(SQLException e){
        e.printStackTrace();
    }
    try{
        Statement st = conexao.getConexao().createStatement();
        ResultSet rs = st.executeQuery(sql);

        if(rs.next()){
            id = rs.getInt("idDP");
        }
        if (id == 0) {
            id = 1;
        }else{
            id = id + 1;
        }
        return String.valueOf(id);
    }
    catch(SQLException e){
        return null;
    }
        
    }
    
    public static String enviaDPP(String id){
        String enviaDP = QuerysAux.InserirIDPrest;
        
        Conexao conexao = null;
        try {
            conexao = new Conexao();
        }catch(SQLException e){
            e.printStackTrace();
        }
        try 
            (PreparedStatement ps = 
                conexao.getConexao().prepareStatement(enviaDP);)
            
        {
            ps.setString(1, id);
           
            
            ps.execute();
            
            
        } catch(SQLException e){
            try{
            conexao.getConexao().rollback();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return null;
        
    }

    public static int enviaDPR(int id) {
        String enviaDP = QuerysAux.InserirIDRemmbolso;
        
        Conexao conexao = null;
        try {
            conexao = new Conexao();
        }catch(SQLException e){
            e.printStackTrace();
        }
        try 
            (PreparedStatement ps = 
                conexao.getConexao().prepareStatement(enviaDP);)
            
        {
            ps.setInt(1, id);
           
            
            ps.execute();
            
            
        } catch(SQLException e){
            try{
            conexao.getConexao().rollback();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return 0;
    }

    public static String enviarStatus(StatusPedido sp){
       String sql = QuerysAux.InserirStatusPedido;
        
        Conexao conexao = null;
        try {
            conexao = new Conexao();
        }catch(SQLException e){
            e.printStackTrace();
        }
        try 
            (PreparedStatement ps = 
                conexao.getConexao().prepareStatement(sql);)
        {
            ps.setString(1, sp.getResultado());
            ps.setInt(2, sp.getEmpregados_idEmpregados());
            ps.setInt(3, sp.getChefeImediato_idChefeImediato());
            ps.setInt(4, sp.getDepartamentoContasPagar_idDepartamentoContaPagar());            
            ps.execute();
            
            
        } catch(SQLException e){
            try{
            conexao.getConexao().rollback();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return null;
    }
    
    
    public StatusPedido ConsultaGeralPrest(String result, int idUser){
        DefaultTableModel modelo = (DefaultTableModel)StatusPedidos.TableStatusPref.getModel();
        modelo.setNumRows(0);
         String sqlSelect = QuerysAux.StatusQueryPref;
        String dados[] = new String[9];
        
        //Chamo Conexao
         Conexao conexao;
         
         //Tratar se houve algum erro de Conexao
        try {
            conexao = new Conexao();
        }catch(SQLException e){
            return null;
            //Caso tenha retorna null
        }
        try 
            //Prepando Query (PreparedStatement)
            (PreparedStatement ps = 
                    //Incluindo Query
                conexao.getConexao().prepareStatement(sqlSelect);)
        {
            //Setando na Query Where passando o Codigo digitado
            ps.setString(1, result);
            ps.setInt(2, idUser);
            
            ResultSet rs;
            try{
                rs = ps.executeQuery();
                
            while(rs.next()){
                dados[0] = rs.getString("idEmpregados");
                dados[1] = rs.getString("Nome");
                dados[2] = rs.getString("Rg");
                dados[3] = rs.getString("Cpf");
                dados[4] = rs.getString("Cargo");
                dados[5] = rs.getString("Resultado");
                dados[6] = rs.getString("MesRef");
                dados[7] = rs.getString("Despesas");
                dados[8] = rs.getString("ValorPrest");
                modelo.addRow(dados);
                }
                
            }catch(SQLException ex){
                ex.printStackTrace();
            }
            ps.executeQuery();
            
        } catch(SQLException e){
            try{
            conexao.getConexao().rollback();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return null;
    }
    public StatusPedido ConsultaGeralReembolso(String result, int idUser){
        DefaultTableModel modelo = (DefaultTableModel)StatusPedidos.TableStatusReembolso.getModel();
        modelo.setNumRows(0);
         String sqlSelect = QuerysAux.StatusQueryReembolso;
        String dados[] = new String[9];
        
        //Chamo Conexao
         Conexao conexao;
         
         //Tratar se houve algum erro de Conexao
        try {
            conexao = new Conexao();
        }catch(SQLException e){
            return null;
            //Caso tenha retorna null
        }
        try 
            //Prepando Query (PreparedStatement)
            (PreparedStatement ps = 
                    //Incluindo Query
                conexao.getConexao().prepareStatement(sqlSelect);)
        {
            //Setando na Query Where passando o Codigo digitado
            ps.setString(1, result);
            ps.setInt(2, idUser);
            
            ResultSet rs;
            try{
                rs = ps.executeQuery();
                
            while(rs.next()){
                dados[0] = rs.getString("idEmpregados");
                dados[1] = rs.getString("Nome");
                dados[2] = rs.getString("Rg");
                dados[3] = rs.getString("Cpf");
                dados[4] = rs.getString("Cargo");
                dados[5] = rs.getString("Resultado");
                dados[6] = rs.getString("MesRef");
                dados[7] = rs.getString("Descricao");
                dados[8] = rs.getString("ValorRembolso");
                modelo.addRow(dados);
                }
                
            }catch(SQLException ex){
                ex.printStackTrace();
            }
            ps.executeQuery();
            
        } catch(SQLException e){
            try{
            conexao.getConexao().rollback();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return null;
    }
    
    public boolean AprovarPedido(int aprova){
        String sql = QuerysAux.QueryAprovar;
        
        Conexao conexao;
        try {
            conexao = new Conexao();
        }catch(SQLException e){
            return false;
        }
        try 
            (PreparedStatement ps = 
                conexao.getConexao().prepareStatement(sql);)
        {
            ps.setInt(1, aprova);            
            ps.execute();
            
            
        } catch(SQLException e){
            try{
            conexao.getConexao().rollback();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
            return false;
        }
        return true;
    }
    public boolean ReprovarPedido(int reprova){
        String sql = QuerysAux.QueryReprovar;
        
        Conexao conexao;
        try {
            conexao = new Conexao();
        }catch(SQLException e){
            return false;
        }
        try 
            (PreparedStatement ps = 
                conexao.getConexao().prepareStatement(sql);)
        {
            ps.setInt(1, reprova);            
            ps.execute();
            
            
        } catch(SQLException e){
            try{
            conexao.getConexao().rollback();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
            return false;
        }
        return true;
    }

    public static String ValorPrestacao(String mes){
        String sql = QuerysAux.QueryValoresPref;
        
      Conexao conexao = null;
  int id = 0;
    try {
        conexao = new Conexao();
    }catch(SQLException e){
        e.printStackTrace();
    }
    try{
        PreparedStatement ps = (PreparedStatement) conexao.getConexao().prepareStatement(sql);
        ps.setString(1, mes);
        ResultSet rs = ps.executeQuery();

        if(rs.next()){
            id = rs.getInt("ValorPrestacao");
        }
       
        return String.valueOf(id);
    }
    catch(SQLException e){
        return null;
    }
    }
    public static String valorRembolso(String mes){
        String sql = QuerysAux.QueryValoresRem;
        
      Conexao conexao = null;
  int id = 0;
    try {
        conexao = new Conexao();
    }catch(SQLException e){
        e.printStackTrace();
    }
    try{
        PreparedStatement ps = (PreparedStatement) conexao.getConexao().prepareStatement(sql);
        ps.setString(1, mes);
        ResultSet rs = ps.executeQuery();

        if(rs.next()){
            id = rs.getInt("ValorRembolso");
        }
        
        return String.valueOf(id);
    }
    catch(SQLException e){
        return null;
    }
    }

    public StatusPedido ConsultaGeralPrestChef(String result, int idChefe){
        DefaultTableModel modelo = (DefaultTableModel)StatusPedidosChef.TableChefPrest.getModel();
        modelo.setNumRows(0);
         String sqlSelect = QuerysAux.StatusQueryPrefChef;
        String dados[] = new String[9];
        
        //Chamo Conexao
         Conexao conexao;
         
         //Tratar se houve algum erro de Conexao
        try {
            conexao = new Conexao();
        }catch(SQLException e){
            return null;
            //Caso tenha retorna null
        }
        try 
            //Prepando Query (PreparedStatement)
            (PreparedStatement ps = 
                    //Incluindo Query
                conexao.getConexao().prepareStatement(sqlSelect);)
        {
            //Setando na Query Where passando o Codigo digitado
            ps.setString(1, result);
            ps.setInt(2, idChefe);
            
            ResultSet rs;
            try{
                rs = ps.executeQuery();
                
            while(rs.next()){
                dados[0] = rs.getString("idEmpregados");
                dados[1] = rs.getString("Nome");
                dados[2] = rs.getString("Rg");
                dados[3] = rs.getString("Cpf");
                dados[4] = rs.getString("Cargo");
                dados[5] = rs.getString("Resultado");
                dados[6] = rs.getString("MesRef");
                dados[7] = rs.getString("Despesas");
                dados[8] = rs.getString("ValorPrest");
                modelo.addRow(dados);
                }
                
            }catch(SQLException ex){
                ex.printStackTrace();
            }
            ps.executeQuery();
            
        } catch(SQLException e){
            try{
            conexao.getConexao().rollback();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return null;
    }
    public StatusPedido ConsultaGeralReembolsoChef(String result, int idChefe){
        DefaultTableModel modelo = (DefaultTableModel)StatusPedidosChef.TableChefReemb.getModel();
        modelo.setNumRows(0);
         String sqlSelect = QuerysAux.StatusQueryReembolsoChef;
        String dados[] = new String[9];
        
        //Chamo Conexao
         Conexao conexao;
         
         //Tratar se houve algum erro de Conexao
        try {
            conexao = new Conexao();
        }catch(SQLException e){
            return null;
            //Caso tenha retorna null
        }
        try 
            //Prepando Query (PreparedStatement)
            (PreparedStatement ps = 
                    //Incluindo Query
                conexao.getConexao().prepareStatement(sqlSelect);)
        {
            //Setando na Query Where passando o Codigo digitado
            ps.setString(1, result);
            ps.setInt(2, idChefe);
            
            ResultSet rs;
            try{
                rs = ps.executeQuery();
                
            while(rs.next()){
                dados[0] = rs.getString("idEmpregados");
                dados[1] = rs.getString("Nome");
                dados[2] = rs.getString("Rg");
                dados[3] = rs.getString("Cpf");
                dados[4] = rs.getString("Cargo");
                dados[5] = rs.getString("Resultado");
                dados[6] = rs.getString("MesRef");
                dados[7] = rs.getString("Descricao");
                dados[8] = rs.getString("ValorRembolso");
                modelo.addRow(dados);
                }
                
            }catch(SQLException ex){
                ex.printStackTrace();
            }
            ps.executeQuery();
            
        } catch(SQLException e){
            try{
            conexao.getConexao().rollback();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return null;
    }

    public static String IDMaxChefe(){
        String sql = "SELECT MAX(idChefeImediato) AS id FROM chefeimediato";
        
      Conexao conexao = null;
      int id = 0;
        try {
            conexao = new Conexao();
        }catch(SQLException e){
            e.printStackTrace();
        }
        try{
            Statement st = conexao.getConexao().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if(rs.next()){
                id = rs.getInt("id");
            }
           
            return String.valueOf(id);
        }
        catch(SQLException e){
            return null;
        }
        
    }

    public void ConsultaGeralPrestChefs(String resultado) {
    DefaultTableModel modelo = (DefaultTableModel)StatusPedidosChefeChefe.TablePrestacaoChefedoChef.getModel();
        modelo.setNumRows(0);
         String sqlSelect = QuerysAux.StatusQueryPrefChefdoChefe;
        String dados[] = new String[9];
        
        //Chamo Conexao
         Conexao conexao;
         
         //Tratar se houve algum erro de Conexao
        try {
            conexao = new Conexao();
        }catch(SQLException e){
            return;
            //Caso tenha retorna null
        }
        try 
            //Prepando Query (PreparedStatement)
            (PreparedStatement ps = 
                    //Incluindo Query
                conexao.getConexao().prepareStatement(sqlSelect);)
        {
            //Setando na Query Where passando o Codigo digitado
            ps.setString(1, resultado);
            
            ResultSet rs;
            try{
                rs = ps.executeQuery();
                
            while(rs.next()){
                dados[0] = rs.getString("idEmpregados");
                dados[1] = rs.getString("Nome");
                dados[2] = rs.getString("Rg");
                dados[3] = rs.getString("Cpf");
                dados[4] = rs.getString("Cargo");
                dados[5] = rs.getString("Resultado");
                dados[6] = rs.getString("MesRef");
                dados[7] = rs.getString("Descricao");
                dados[8] = rs.getString("ValorRembolso");
                modelo.addRow(dados);
                }
                
            }catch(SQLException ex){
                ex.printStackTrace();
            }
            ps.executeQuery();
            
        } catch(SQLException e){
            try{
            conexao.getConexao().rollback();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return;
    }

    public void ConsultaGeralReembolsoChefs(String resultado) {
        DefaultTableModel modelo = (DefaultTableModel)StatusPedidosChefeChefe.TableReembolsosChefe.getModel();
        modelo.setNumRows(0);
         String sqlSelect = QuerysAux.StatusQueryReembolsoChefdoChefe;
        String dados[] = new String[9];
        
        //Chamo Conexao
         Conexao conexao;
         
         //Tratar se houve algum erro de Conexao
        try {
            conexao = new Conexao();
        }catch(SQLException e){
            return;
            //Caso tenha retorna null
        }
        try 
            //Prepando Query (PreparedStatement)
            (PreparedStatement ps = 
                    //Incluindo Query
                conexao.getConexao().prepareStatement(sqlSelect);)
        {
            //Setando na Query Where passando o Codigo digitado
            ps.setString(1, resultado);
            
            ResultSet rs;
            try{
                rs = ps.executeQuery();
                
            while(rs.next()){
                dados[0] = rs.getString("idEmpregados");
                dados[1] = rs.getString("Nome");
                dados[2] = rs.getString("Rg");
                dados[3] = rs.getString("Cpf");
                dados[4] = rs.getString("Cargo");
                dados[5] = rs.getString("Resultado");
                dados[6] = rs.getString("MesRef");
                dados[7] = rs.getString("Descricao");
                dados[8] = rs.getString("ValorRembolso");
                modelo.addRow(dados);
                }
                
            }catch(SQLException ex){
                ex.printStackTrace();
            }
            ps.executeQuery();
            
        } catch(SQLException e){
            try{
            conexao.getConexao().rollback();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return;
    }

}