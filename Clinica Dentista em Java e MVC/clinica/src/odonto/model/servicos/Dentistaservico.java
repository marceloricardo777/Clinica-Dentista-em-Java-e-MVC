/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odonto.model.servicos;

import java.util.List;
import javax.swing.JOptionPane;
import odonto.model.Dentista;
import odonto.model.dao.DentistaDao;


public class Dentistaservico {
 
 private DentistaDao dao;
 public Dentistaservico(){
  dao = new DentistaDao();
  }
    public void salvar (Dentista dentista){
  if (dentista.getId() != 0){
      dao.atualizar(dentista);
  } else {
      dao.inserir(dentista);
  //System.out.print("Esse dentista não existe");
  }
  }
     public int excluir(Dentista dentista) {

      int resposta;
        resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?");
        dao.delete(dentista);

        if (resposta == JOptionPane.YES_OPTION) {
           return 1;
        }
        else{       
            return 2;
            }
        }
    public List<Dentista> getDentistas(){
    return dao.listallDentista();
    }
}
