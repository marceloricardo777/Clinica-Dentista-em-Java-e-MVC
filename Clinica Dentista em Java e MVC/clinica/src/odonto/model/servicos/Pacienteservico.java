/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odonto.model.servicos;

import java.util.List;
import javax.swing.JOptionPane;
import odonto.model.Paciente;
import odonto.model.dao.PacienteDao;


public class Pacienteservico {
 
 private PacienteDao dao;
 public Pacienteservico(){
  dao = new PacienteDao();
  }
    public void salvar (Paciente paciente){
  if (paciente.getId() != 0){
      dao.atualizar(paciente);
  } else {
      dao.inserir(paciente);
  
  }
    }
    public int excluir(Paciente paciente) {

      int resposta;
        resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?");
        dao.delete(paciente);

        if (resposta == JOptionPane.YES_OPTION) {
           return 1;
        }
        else{       
            return 2;
            }
        }

    public List<Paciente> getPacientes(){
    return dao.listallPacientes();
    }
}
