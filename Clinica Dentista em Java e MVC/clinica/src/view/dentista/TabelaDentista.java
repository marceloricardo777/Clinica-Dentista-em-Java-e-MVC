package view.dentista;

import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import odonto.model.Dentista;

public class TabelaDentista extends AbstractTableModel {

    private List<Dentista> dentistas;
    private List<String> colunas;

    public TabelaDentista(List<Dentista> dentistas) {
        this.dentistas = dentistas;
        colunas = Arrays.asList("id", "Nome", "Rg", "Cpf", "Endereço", "Telefone", "Sexo");

    }

    @Override
    public String getColumnName(int column) {
        return colunas.get(column);
    }

    @Override
    public int getRowCount() {
        return dentistas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.size();
    }

    @Override
    public Object getValueAt(int indLinha, int indColuna) {
        Dentista dentista = dentistas.get(indLinha);
        switch (indColuna) {
            case 0:
                return dentista.getId();
            case 1:
                return dentista.getNome();
            case 2:
                return dentista.getRg();
            case 3:
                return dentista.getCpf();
            case 4:
                return dentista.getEndereco();
            case 5:
                return dentista.getTelefone();
            case 6:
                return dentista.getSexo();
        }
        return null;
    }

    public List<Dentista> getDentista() {
        return dentistas;
    }

    public void setDentista(List<Dentista> dentistas) {
        this.dentistas = dentistas;
    }

}
