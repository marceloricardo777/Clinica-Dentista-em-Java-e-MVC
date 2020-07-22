/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.consulta;
import view.dentista.FrmDentista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import odonto.model.Consulta;
import odonto.model.servicos.Consultaservico;

import view.dentista.TabelaDentista;
import view.paciente.FrmPaciente;
import view.paciente.TabelaPaciente;


public class ListaAcoesConsulta implements ActionListener , ListSelectionListener{
    private FrmConsulta frm;
    private FrmPaciente fp;
    private FrmDentista fd;
    private Consultaservico servico;
    private TabelaConsulta tb;
    private TabelaPaciente tp;
    private TabelaDentista td;     
    
    public ListaAcoesConsulta(FrmConsulta frm  ) {
        this.frm = frm;
        servico = new Consultaservico();
        addListener();
        iniciarTabela();
        
    }
 
    public void iniciarTabela(){
    
    List<Consulta> consultas = servico.getConsultas();
    tb = new TabelaConsulta(consultas);
    frm.getTabelaC().setModel(tb);
    frm.getTabelaC().getSelectionModel().addListSelectionListener(this);
       
                                                                            
    
    }
   
    
    
    
    public void addListener(){
    frm.getButAdd().addActionListener(this);
    frm.getButMudar().addActionListener(this);
    frm.getButExcluir().addActionListener(this);
    frm.getButSalvar().addActionListener(this);
    frm.getButCancelar().addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent evento) {
      if(evento.getActionCommand().equals("Adicionar")){
        add();
        
        }else if (evento.getActionCommand().equals("Mudar")){
        }else if (evento.getActionCommand().equals("Excluir")){
            excluir();
        }else if (evento.getActionCommand().equals("Salvar")){
            salvar();
        }else if (evento.getActionCommand().equals("Cancelar")){
               
     }
habilitarBotaoSalvar();
    
    }
    private void add(){
    habilitarBotaoSalvar();
    }
    private void salvar(){
    servico.salvar(mapFrmConsulta());
        JOptionPane.showMessageDialog(frm, "Salvo com sucesso", "Salvar" , JOptionPane.INFORMATION_MESSAGE);
        desabilitarBotaoSalvar();
    
    }
  private void excluir (){
  
  if(servico.excluir(mapFrmConsulta()) == 1){
  JOptionPane.showMessageDialog(frm, "Excluido com sucesso", "Excluir" , JOptionPane.INFORMATION_MESSAGE);

  
  
  }else{
  JOptionPane.showMessageDialog(frm, "Não excluido", "Excluir" , JOptionPane.INFORMATION_MESSAGE);
  }    
  }
    private Consulta mapFrmConsulta(){
         //Date date = new Date();
        Consulta consulta = new Consulta();
        if( !"".equals(frm.getlId().getText())){
        consulta.setId(Long.parseLong(frm.getlId().getText()));
        
        }
        consulta.setDentista( frm.getTxtdentista().getText());
        consulta.setPaciente(frm.getTxtpaciente().getText());
        consulta.setValor(frm.getTxtvalor().getText() );
        consulta.setDatadaconsulta(frm.getTxtdataconsulta().getText());
        consulta.setSituacaopag((String) frm.getTxtsituacao().getSelectedItem());
        
        return consulta;
    }
   private void consultaPreencer (Consulta consulta) {
        
        frm.getlId().setText( Long.toString ( consulta.getId() ) );
        frm.getTxtdentista().setText(consulta.getDentista());
       frm.getTxtpaciente().setText(consulta.getPaciente());
        frm.getTxtvalor().setText(( consulta.getValor() ));
        frm.getTxtdataconsulta().setText((consulta.getDatadaconsulta()));
        frm.getTxtsituacao().setSelectedItem(consulta.getSituacaopag());
       
    
   } 

  
    
    
    private void habilitarBotaoSalvar(){
    habedesBotaoEdit(true);
    }
     private void desabilitarBotaoSalvar(){
    habedesBotaoEdit(false);
    }
     private void habedesBotaoEdit( boolean habilitar){
     frm.getButAdd().setEnabled(!habilitar);
     frm.getButMudar().setEnabled(!habilitar);
     frm.getButExcluir().setEnabled(!habilitar);
     frm.getButSalvar().setEnabled(habilitar);
     frm.getButCancelar().setEnabled(habilitar);
     }

    @Override
    public void valueChanged(ListSelectionEvent e) {
       Consulta selectconsulta = tb.getConsulta().get(frm.getTabelaC().getSelectedRow());
       consultaPreencer(selectconsulta);
        //System.out.println(selectconsulta);
    }
     
}
