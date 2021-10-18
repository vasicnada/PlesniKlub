/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Takmicenje;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import kontroler.Kontroler;

/**
 *
 * @author Nada
 */
public class ModelTabeleTakmicenje extends AbstractTableModel{

    private List<Takmicenje> lista;
    private final String[] kolone;

    public ModelTabeleTakmicenje(List<Takmicenje> lista) {
        this.lista = lista;
        this.kolone = new String[]{"id", "termin", "mesto", "trener"};
    }
    
    
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Takmicenje tak = lista.get(rowIndex);
        switch(columnIndex){
            case 0: return tak.getTakmicenjeID()+"";
            case 1: return Kontroler.getInstance().formatDatum(tak.getTermin());
            case 2: return tak.getMesto();
            case 3: return tak.getTrener();
            default: return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    

    public Takmicenje getRed(int i) {
        return lista.get(i);
    }

    public void setLista(List<Takmicenje> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }
    
}
