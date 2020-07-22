package view.paciente;


import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import odonto.model.Paciente;


/**
 *
 * @author Ana
 */
public class TabelaPaciente extends AbstractTableModel {

    private List<Paciente> pacientes;
    private List<String> colunas;
    public TabelaPaciente (List<Paciente> pacientes){
    this.pacientes = pacientes;
    colunas = Arrays.asList("id","Nome","Rg", "Cpf","Endereço", "Telefone", "Data de Nascimento", "Sexo" );
    
    
    }
    @Override
    public String getColumnName(int column){
    return colunas.get(column);
    }
        
    @Override
    public int getRowCount() {
        return pacientes.size();
    }

    @Override
    public int getColumnCount() {
    return colunas.size();
    }
    @Override
    public Object getValueAt(int indLinha, int indColuna) {
        Paciente paciente = pacientes.get(indLinha);
        switch(indColuna){
            case 0: return paciente.getId();
            case 1: return paciente.getNome();
            case 2: return paciente.getRg();
            case 3: return paciente.getCpf();
            case 4: return paciente.getEndereco();
            case 5: return paciente.getTelefone();
            case 6 : return paciente.getDatanascimento();
            case 7 :return paciente.getSexo();
           
        }
        return null;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    
}
