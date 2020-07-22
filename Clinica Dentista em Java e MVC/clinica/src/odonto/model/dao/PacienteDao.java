/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odonto.model.dao;

import odonto.model.Paciente;
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

public class PacienteDao {

    private DaoGeneric daogeneric;

    public PacienteDao() {
        daogeneric = new DaoGeneric();
    }

    public void inserir(Paciente paciente) throws ExceptionCreateDados {

        Connection conne = null;
        try {

            daogeneric.Transaction();
            long id = daogeneric.executePrepaUpdReturnGenKeys("insert into paciente (nome, rg , cpf , endereco , telefone , datanascimento,sexo) values (? , ? , ? ,? ,? ,?, ?)",
                    paciente.getNome(),
                    paciente.getRg(),
                    paciente.getCpf(),
                    paciente.getEndereco(),
                    paciente.getTelefone(),
                    paciente.getDatanascimento(),
                    paciente.getSexo());
            paciente.setId(id);

            daogeneric.FimTransaction();

        } catch (SQLException e) {
            daogeneric.rollbackTransaction();
            throw new ExceptionCreateDados("Não foi possivel realizar essa operação", e);
        }
    }

    public void atualizar(Paciente paciente) throws UpdateDaoException {
        try {
            daogeneric.Transaction();
            String query = "update paciente set nome = ?, rg = ? , cpf = ? , endereco = ? , telefone = ? ,datanascimento = ? , sexo = ? where id  = ? ";
            daogeneric.executePrepaUpdate(
                    query,
                    paciente.getNome(),
                    paciente.getRg(),
                    paciente.getCpf(),
                    paciente.getEndereco(),
                    paciente.getTelefone(),
                    paciente.getDatanascimento(),
                     paciente.getSexo(),
                     paciente.getId()
            );
            daogeneric.FimTransaction();
        } catch (SQLException e) {
            daogeneric.rollbackTransaction();
            throw new UpdateDaoException("Não foi possivel atualizar paciente", e);
        }
    }

    public void delete(Paciente paciente) throws DeleteDaoException {
        try {
            daogeneric.Transaction();
            String query = "delete from paciente  where id = ?";
            daogeneric.executePrepaUpdate(
                    query,
                    paciente.getId());
            daogeneric.FimTransaction();
        } catch (SQLException e) {
            daogeneric.rollbackTransaction();
            throw new DeleteDaoException("Não foi possivel excluir paciente", e);
        }
    }

    public List< Paciente> listallPacientes() {
        final List< Paciente> pacientes = new ArrayList< Paciente>();
        try {
            daogeneric.executeQuery("select * from paciente ", new MapaQuery<Paciente>() {
                @Override
                public void mapping(ResultSet rs) throws SQLException {
                    while (rs.next()) {
                        Paciente paciente = new Paciente();
                        paciente.setId(rs.getInt("id"));
                        paciente.setNome(rs.getString("nome"));
                        paciente.setRg(rs.getString("rg"));
                        paciente.setCpf(rs.getString("cpf"));
                        paciente.setEndereco(rs.getString("endereco"));
                        paciente.setTelefone(rs.getString("telefone"));
                        paciente.setDatanascimento(rs.getString("datanascimento"));
                        paciente.setSexo(rs.getString("sexo"));
                        pacientes.add(paciente);

                    }
                }

            });
        } catch (SQLException e) {

        }
        return pacientes;
    }

}
