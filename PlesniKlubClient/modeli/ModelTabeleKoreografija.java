/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Plesac;
import domen.Koreografija;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nada
 */
public class ModelTabeleKoreografija extends AbstractTableModel {

    private List<Koreografija> lista;
    private final String[] kolone;

    public ModelTabeleKoreografija(List<Koreografija> lista) {
        this.lista = lista;
        this.kolone = new String[]{"ime", "prezime", "broj godina", "pozicija"};
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
        Plesac pl = lista.get(rowIndex).getPlesac();
        switch (columnIndex) {
            case 0:
                return pl.getIme();
            case 1:
                return pl.getPrezime();
            case 2:
                return pl.getBrojGodina() + "";
            case 3:
                return pl.getPozicija();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public Koreografija getRed(int i) {
        return lista.get(i);
    }

    public void setLista(List<Koreografija> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

    public List<Koreografija> getLista() {
        return lista;
    }

    public void dodajRed(Koreografija koreografija) {
        lista.add(koreografija);
        fireTableDataChanged();
    }

    public void izbaciRed(int i) {
        lista.remove(i);
        fireTableDataChanged();
    }
}
