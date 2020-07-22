/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odonto.model.servicos;

import java.util.List;
import javax.swing.JOptionPane;
import odonto.model.Consulta;
import odonto.model.dao.ConsultaDao;

public class Consultaservico {
    
    private ConsultaDao dao;
    
    public Consultaservico() {
        dao = new ConsultaDao();
    }

    public void salvar(Consulta consulta) {
        if (consulta.getId() != 0) {
            dao.atualizar(consulta);
        } else {
            dao.inserir(consulta);
        }
    }

    public int excluir(Consulta consulta) {

      int resposta;
        resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?");
        dao.delete(consulta);

        if (resposta == JOptionPane.YES_OPTION) {
           return 1;
        }
        else{       
            return 2;
            }
        }
        
      
    
     
    
        
      
   
    public List<Consulta> getConsultas() {
        return dao.listallConsulta();
    }
}
