/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Plesac;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nada
 */
public class ModelTabelePlesac extends AbstractTableModel{

    private List<Plesac> lista;
    private final String[] kolone;

    public ModelTabelePlesac(List<Plesac> lista) {
        this.lista = lista;
        this.kolone = new String[] {"id", "ime", "prezime", "broj godina", "pozicija"};
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
        Plesac pl = lista.get(rowIndex);
        switch(columnIndex){
            case 0: return pl.getPlesacID()+"";
            case 1: return pl.getIme();
            case 2: return pl.getPrezime();
            case 3: return pl.getBrojGodina()+"";
            case 4: return pl.getPozicija();
            default: return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    
    
    public Plesac getRed(int i) {
        return lista.get(i);
    }

    public void setLista(List<Plesac> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }
    
}
