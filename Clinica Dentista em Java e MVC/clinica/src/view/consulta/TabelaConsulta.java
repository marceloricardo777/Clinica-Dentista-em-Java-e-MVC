package view.consulta;

import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import odonto.model.Consulta;

/**
 *
 * @author Ana
 */
public class TabelaConsulta extends AbstractTableModel {

    private List<Consulta> consultas;
    private List<String> colunas;

    public TabelaConsulta(List<Consulta> consultas) {
        this.consultas = consultas;
        colunas = Arrays.asList("id", "Dentista", "Paciente", "Valor", "Datadaconsulta", "Situacaopag");

    }

    @Override
    public String getColumnName(int column) {
        return colunas.get(column);
    }

    @Override
    public int getRowCount() {
        return consultas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.size();
    }

    @Override
    public Object getValueAt(int indLinha, int indColuna) {

        Consulta consulta = consultas.get(indLinha);
        switch (indColuna) {
            case 0:
                return consulta.getId();
            case 1:
                return consulta.getDentista();
            case 2:
                return consulta.getPaciente();
            case 3:
                return consulta.getValor();
            case 4:
                return consulta.getDatadaconsulta();
            case 5:
                return consulta.getSituacaopag();

        }
        return null;
    }

    public List<Consulta> getConsulta() {
        return consultas;
    }

    public void setConsulta(List<Consulta> consultas) {
        this.consultas = consultas;
    }

}
