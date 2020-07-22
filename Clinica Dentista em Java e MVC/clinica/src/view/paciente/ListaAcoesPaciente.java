/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.paciente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import odonto.model.Paciente;
import odonto.model.servicos.Pacienteservico;


public class ListaAcoesPaciente implements ActionListener , ListSelectionListener{
    private FrmPaciente frm;
    private Pacienteservico servico;
    private TabelaPaciente tb;
          
    
    public ListaAcoesPaciente(FrmPaciente frm  ) {
        this.frm = frm;
        servico = new Pacienteservico();
        addListener();
        iniciarTabela();
        
    }
 
    public void iniciarTabela(){
    
    List<Paciente> pacientes = servico.getPacientes();
    tb = new TabelaPaciente(pacientes);
    frm.getTabelaP().setModel(tb);
    frm.getTabelaP().getSelectionModel().addListSelectionListener(this);
       
                                                                            
    
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
    servico.salvar(mapFrmPaciente());
        JOptionPane.showMessageDialog(frm, "Salvo com sucesso", "Salvar" , JOptionPane.INFORMATION_MESSAGE);
    desabilitarBotaoSalvar();
    }
       private void excluir (){

  
  if( servico.excluir(mapFrmPaciente()) == 1){
  JOptionPane.showMessageDialog(frm, "Excluido com sucesso", "Excluir" , JOptionPane.INFORMATION_MESSAGE);

  
  
  }else{
  JOptionPane.showMessageDialog(frm, "Não excluido", "Excluir" , JOptionPane.INFORMATION_MESSAGE);
  }    
  }
  
    private Paciente mapFrmPaciente(){
        Paciente paciente = new Paciente();
        if( !"".equals(frm.getlId().getText())){
        paciente.setId(Long.parseLong(frm.getlId().getText()));
        
        }
        paciente.setNome(frm.getTxtnome().getText());
        paciente.setRg(frm.getTxtrg().getText());
        paciente.setCpf(frm.getTxtcpf().getText());
        paciente.setEndereco(frm.getTxtendereco().getText());
        paciente.setTelefone(frm.getTxttelefone().getText());
        paciente.setDatanascimento(frm.getTxtdatanascimento().getText());
        paciente.setSexo((String) frm.getTxtSexo().getSelectedItem());
        return paciente;
    }
   private void pacientePreencer(Paciente paciente) {
        
        frm.getlId().setText( Long.toString ( paciente.getId() ) );
        frm.getTxtnome().setText( paciente.getNome());
        frm.getTxtrg().setText( paciente.getRg() );
        frm.getTxtcpf().setText( paciente.getCpf() );
        frm.getTxtendereco().setText( paciente.getEndereco() );
        frm.getTxttelefone().setText( paciente.getTelefone() );
        frm.getTxtdatanascimento().setText(paciente.getDatanascimento());
        frm.getTxtSexo().setSelectedItem(paciente.getSexo());
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
       Paciente selecpaciente = tb.getPacientes().get(frm.getTabelaP().getSelectedRow());
       pacientePreencer(selecpaciente);
        System.out.println(selecpaciente);
    }
     
}
