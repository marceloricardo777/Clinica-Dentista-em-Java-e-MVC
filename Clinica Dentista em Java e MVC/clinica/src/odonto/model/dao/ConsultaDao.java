/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odonto.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import odonto.controler.dao.DeleteDaoException;
import odonto.controler.dao.ExceptionCreateDados;
import odonto.controler.dao.MapaQuery;
import odonto.controler.dao.UpdateDaoException;
import odonto.controler.dao.DaoGeneric;
import odonto.model.Consulta;

public class ConsultaDao {
    private DaoGeneric daogeneric;

    public ConsultaDao() {
        daogeneric = new DaoGeneric();
    }
    public void inserir(Consulta consulta) throws ExceptionCreateDados {

        Connection conne = null;
        try {
            
            daogeneric.Transaction();
            long id;
            id = daogeneric.executePrepaUpdReturnGenKeys("insert into consulta (dentista , paciente  , valor , datadaconsulta  ,  situacaopag) values (? , ? , ? ,? ,? )",
                    consulta.getDentista(),
                    consulta.getPaciente(),
                    consulta.getValor(),
                    consulta.getDatadaconsulta(),
                    consulta.getSituacaopag());

            consulta.setId(id);

            daogeneric.FimTransaction();
        } catch (SQLException e) {
            daogeneric.rollbackTransaction();
            throw new ExceptionCreateDados("Não foi possivel realizar essa operação de inserir", e);
        }
    }
    

    public void atualizar(Consulta consulta) throws UpdateDaoException {
        try {
            daogeneric.Transaction(); 
            String query = "update consulta set dentista = ?, paciente = ? , valor = ? , datadaconsulta = ? , situacaopag = ?    where id  = ? ";
            daogeneric.executePrepaUpdate(query,
                     consulta.getDentista(),
                     consulta.getPaciente(),
                     consulta.getValor(),
                   consulta.getDatadaconsulta(),
                     consulta.getSituacaopag(),
                     consulta.getId());
                   
                    
                   

            daogeneric.FimTransaction();
        } catch (SQLException e) {
            daogeneric.rollbackTransaction();
            throw new UpdateDaoException("Não foi possivel atualizar essa consulta", e);
        }
    }

    public void delete(Consulta consulta) throws DeleteDaoException {
        try {
            daogeneric.Transaction();
            String query = "delete from consulta  where id = ?";
            daogeneric.executePrepaUpdate(
                    query,
                     consulta.getId());
            daogeneric.FimTransaction();
        } catch (SQLException e) {
            daogeneric.rollbackTransaction();
            throw new DeleteDaoException("Não foi possivel excluir essa consulta", e);
        }
    }
  

    public List< Consulta> listallConsulta() {
        final List< Consulta> consultas = new ArrayList< Consulta>();
        try {
            daogeneric.executeQuery("select * from consulta ", new MapaQuery<Consulta>() {
                @Override
                public void mapping(ResultSet rs) throws SQLException {
                    while (rs.next()) {
                        Consulta consulta = new Consulta();
                        consulta.setId(rs.getInt("id"));
                      consulta.setDentista( rs.getString("dentista"));
                        consulta.setPaciente( rs.getString("paciente"));
                        consulta.setValor(rs.getString("valor"));
                        consulta.setDatadaconsulta(rs.getString("datadaconsulta"));
                        consulta.setSituacaopag(rs.getString("situacaopag"));
                        
                        consultas.add(consulta);

                    }
                }

            });
        } catch (SQLException e) {

        }
        return consultas;

  }
}

