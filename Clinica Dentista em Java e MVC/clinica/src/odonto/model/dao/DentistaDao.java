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
import odonto.controler.dao.DaoGeneric;
import odonto.controler.dao.DeleteDaoException;
import odonto.controler.dao.ExceptionCreateDados;
import odonto.controler.dao.MapaQuery;
import odonto.controler.dao.UpdateDaoException;
import odonto.model.Dentista;

public class DentistaDao {

    private DaoGeneric daogeneric;

    public DentistaDao() {
        daogeneric = new DaoGeneric();
    }

    public void inserir(Dentista dentista) throws ExceptionCreateDados {

       //Connection conne = null;
        try {

            daogeneric.Transaction();
            long id = daogeneric.executePrepaUpdReturnGenKeys("insert into dentista (nome, rg , cpf , endereco , telefone , sexo) values (? , ? , ? ,? ,? , ?)",
                     dentista.getNome(),
                     dentista.getRg(),
                     dentista.getCpf(),
                     dentista.getEndereco(),
                     dentista.getTelefone(),
                     dentista.getSexo());

            dentista.setId(id);

            daogeneric.FimTransaction();

        } catch (SQLException e) {
            daogeneric.rollbackTransaction();
            throw new ExceptionCreateDados("Não foi possivel realizar essa operação", e);
        }
    }

    public void atualizar(Dentista dentista) throws UpdateDaoException {
        try {
            daogeneric.Transaction();
            String query = "update dentista set nome = ?, rg = ? , cpf = ? , endereco = ? , telefone = ? , sexo = ?  where id  = ? ";
            daogeneric.executePrepaUpdate(query,
                     dentista.getNome(),
                     dentista.getRg(),
                     dentista.getCpf(),
                     dentista.getEndereco(),
                     dentista.getTelefone(),
                     dentista.getSexo(),
                     dentista.getId());
            daogeneric.FimTransaction();
        } catch (SQLException e) {
            daogeneric.rollbackTransaction();
            throw new UpdateDaoException("Não foi possivel atualizar dentista", e);
        }
    }

    public void delete(Dentista dentista) throws DeleteDaoException {
        try {
            daogeneric.Transaction();
            String query = "delete from dentista  where id = ?";
            daogeneric.executePrepaUpdate(
                    query,
                     dentista.getId());
            daogeneric.FimTransaction();
        } catch (SQLException e) {
            daogeneric.rollbackTransaction();
            throw new DeleteDaoException("Não foi possivel excluir dentista", e);
        }
    }

    public List< Dentista> listallDentista() {
        final List< Dentista> dentistas = new ArrayList< Dentista>();
        try {
            daogeneric.executeQuery("select * from dentista ", new MapaQuery<Dentista>() {
                @Override
                public void mapping(ResultSet rs) throws SQLException {
                    while (rs.next()) {
                        Dentista dentista = new Dentista();
                        dentista.setId(rs.getInt("id"));
                        dentista.setNome(rs.getString("nome"));
                        dentista.setRg(rs.getString("rg"));
                        dentista.setCpf(rs.getString("cpf"));
                        dentista.setEndereco(rs.getString("endereco"));
                        dentista.setTelefone(rs.getString("telefone"));
                        dentista.setSexo(rs.getString("sexo"));
                        dentistas.add(dentista);

                    }
                }

            });
        } catch (SQLException e) {

        }
        return dentistas;
    }

}
