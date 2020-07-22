/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odonto.controler.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DaoGeneric {
    private static final ThreadLocal<Connection> cont = new ThreadLocal<Connection>();
    
    public Connection getConnection() throws SQLException{
     Connection conne = null;
     
        try {
        Class.forName("org.postgresql.Driver");
        conne = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clinica","marcelo","1234");
        } catch (ClassNotFoundException e) {
             e.printStackTrace();
        }
        return conne;
     
    }
    public void Transaction() throws SQLException{
    Connection conne = getConnection();
    conne.setAutoCommit(false);
    cont.set(conne);
    }
    public void FimTransaction()throws SQLException{
    commit (getConnectionDeCont());
    LancaTransaction();
    }
    public void LancaTransaction () throws SQLException{
    Connection conne = getConnectionDeCont();
    FechaConne(conne);
    cont.remove();
    }
      public void rollbackTransaction (){
    Connection conne;
 try{
          
    conne = getConnectionDeCont();
    rollback(conne);
    FechaConne(conne);
    } catch (SQLException e){
    e.printStackTrace();
    }
   
    cont.remove();
    }
    public void commit (Connection conne)throws SQLException{
    conne.commit();
    }    
    public void rollback(Connection conne) throws SQLException{
    if (conne != null) conne.rollback();
    }
    
    public Connection getConnectionDeCont()throws SQLException{
    Connection conne = cont.get();
    
    if (conne == null) 
        throw new SQLException ("Não é possivel realizar essa transação");
    
    if (conne.isClosed()) 
        throw new SQLException ("Não é possivel realizar essa transação, conexão fechada");
    return conne;

    }
    public <T> void executeQuery (String query, MapaQuery <T> queryMap) throws SQLException{
        executeQuery(getConnection(), query, queryMap);
        
    }
    public <T> void executeQuery (Connection conne,String query, MapaQuery <T> queryMap) throws SQLException{
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conne.createStatement();
            rs = stmt.executeQuery(query);
            queryMap.mapping(rs);
        }finally{
            FechaResult(rs);
            FechaStmt(stmt);
        }
 
       
    }  
    public <T>  void executePrepaQuery ( String query , MapaQuery <T> queryMap, Object... params ) throws SQLException {
        executePrepaQuery(getConnection(), query, queryMap, params);
    }
    
    public <T> void executePrepaQuery (Connection conne , String query ,MapaQuery <T> queryMap, Object... params  ) throws SQLException {
        PreparedStatement ptmt = conne.prepareStatement(query);
        ResultSet rs = null;
        
       
         try {
            ptmt = conne.prepareStatement(query);
            ArmPrepareStatemen(ptmt,params);
            rs = ptmt.executeQuery(query);
            queryMap.mapping(rs);
        }finally{
            FechaResult(rs);
            FechaStmt(ptmt);
        }
 
    
    }  
            
            
    public long executePrepaUpdReturnGenKeys(String query, Object... params)throws SQLException{
    return executePrepaUpdReturnGenKeys(getConnectionDeCont(), query, params);
    }
    
    public long executePrepaUpdReturnGenKeys(Connection conne,String query, Object... params)throws SQLException{
    
    PreparedStatement ptmt = null;
    ResultSet rs = null;
    long result = 01;
    try{
    ptmt = conne.prepareStatement(query , PreparedStatement.RETURN_GENERATED_KEYS);
    ArmPrepareStatemen(ptmt, params);
    ptmt.executeUpdate();
    rs = ptmt.getGeneratedKeys();
    if(rs.next()) 
        result = rs.getLong(1);
    } finally{
        FechaStmt(ptmt);
        FechaResult(rs);
    }
        return  result;
    }

    
   
    
     public void executePrepaUpdate(String query, Object... params)throws SQLException{
     executePrepaUpdate(getConnectionDeCont(), query, params);
     }
    public void executePrepaUpdate(Connection conne,String query, Object... params)throws SQLException{
    
    PreparedStatement ptmt = null;
   
   
    try{
    ptmt = conne.prepareStatement(query);
    ArmPrepareStatemen(ptmt, params);
    ptmt.executeUpdate();
    
    } finally{
        FechaStmt(ptmt);
        
    }
       
    }
    
 public void FechaStmt (Statement stmt){
 if (stmt == null) 
     return ;
       try {
         stmt.close();
     } catch (SQLException e) {
     }
        }
 public void FechaConne (Connection conne){
 if (conne == null)
     return ;
       try {
         conne.close();
     } catch (SQLException e) {
     }
        }
  public void FechaResult (ResultSet rs){
 if (rs == null)
     return ;
       try {
         rs.close();
     } catch (SQLException e) {
     }
        }
   public void FechaTodos (Connection conne, Statement stmt){
   FechaStmt(stmt);
   FechaConne(conne);
   }
   public void FechaTodos (Connection conne, Statement stmt , ResultSet rs){
   FechaResult(rs);
   FechaTodos(conne,stmt);
   }

    public void ArmPrepareStatemen(PreparedStatement ptmt, Object ... params)throws SQLException{
    int i  = 0;   
    for(Object param : params){
    ptmt.setObject (++i, param);
    }
    }

    
 }

