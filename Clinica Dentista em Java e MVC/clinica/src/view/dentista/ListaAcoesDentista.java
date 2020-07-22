/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.dentista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import odonto.model.Dentista;
import odonto.model.servicos.Dentistaservico;


public class ListaAcoesDentista implements ActionListener , ListSelectionListener{
    private FrmDentista frm;
    private Dentistaservico servico;
    private TabelaDentista tb;
          
    
    public ListaAcoesDentista(FrmDentista frm  ) {
        this.frm = frm;
        servico = new Dentistaservico();
        addListener();
        iniciarTabela();
        
    }
 
    public void iniciarTabela(){
    
    List<Dentista> dentistas = servico.getDentistas();
    tb = new TabelaDentista(dentistas);
    frm.getTabelaD().setModel(tb);
    frm.getTabelaD().getSelectionModel().addListSelectionListener(this);
       
                                                                            
    
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
    //System.out.println(evento);
    }
    private void add(){
    habilitarBotaoSalvar();
    }
    private void salvar(){
    servico.salvar(mapFrmDentista());
        JOptionPane.showMessageDialog(frm, "Salvo com sucesso", "Salvar" , JOptionPane.INFORMATION_MESSAGE);
    desabilitarBotaoSalvar();
    }
   private void excluir (){
  
  if(servico.excluir(mapFrmDentista()) == 1){
  JOptionPane.showMessageDialog(frm, "Excluido com sucesso", "Excluir" , JOptionPane.INFORMATION_MESSAGE);

  
  
  }else{
  JOptionPane.showMessageDialog(frm, "Não excluido", "Excluir" , JOptionPane.INFORMATION_MESSAGE);
  }    
  }
  
    private Dentista mapFrmDentista(){
        Dentista dentista = new Dentista();
        if( !"".equals(frm.getlId().getText())){
        dentista.setId(Long.parseLong(frm.getlId().getText()));
        
        }
        dentista.setNome(frm.getTxtnome().getText());
        dentista.setRg(frm.getTxtrg().getText());
        dentista.setCpf(frm.getTxtcpf().getText());
        dentista.setEndereco(frm.getTxtendereco().getText());
        dentista.setTelefone(frm.getTxttelefone().getText());
        dentista.setSexo((String) frm.getTxtSexo().getSelectedItem());
        
        return dentista;
    }
   private void dentistaPreencer(Dentista dentista) {
        
        frm.getlId().setText( Long.toString ( dentista.getId() ) );
        frm.getTxtnome().setText( dentista.getNome());
        frm.getTxtrg().setText( dentista.getRg() );
        frm.getTxtcpf().setText( dentista.getCpf() );
        frm.getTxtendereco().setText( dentista.getEndereco() );
        frm.getTxttelefone().setText( dentista.getTelefone() );
        frm.getTxtSexo().setSelectedItem(dentista.getSexo());
    
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
       Dentista selecdentista = tb.getDentista().get(frm.getTabelaD().getSelectedRow());
       dentistaPreencer(selecdentista);
        System.out.println(selecdentista);
    }
     
}