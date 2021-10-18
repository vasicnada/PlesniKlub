/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nada
 */
public class Pozicija implements IOpstiDomenskiObjekat{
    private long pozicijaID = -1l;
    private String naziv;

    public Pozicija() {
    }

    public Pozicija(long pozicijaID, String naziv) {
        this.pozicijaID = pozicijaID;
        this.naziv = naziv;
    }

    /**
     * @return the pozicijaID
     */
    public long getPozicijaID() {
        return pozicijaID;
    }

    /**
     * @param pozicijaID the pozicijaID to set
     */
    public void setPozicijaID(long pozicijaID) {
        this.pozicijaID = pozicijaID;
    }

    /**
     * @return the naziv
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * @param naziv the naziv to set
     */
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pozicija other = (Pozicija) obj;
        if (this.pozicijaID != other.pozicijaID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String nazivTabele() {
        return " pozicija ";
    }

    @Override
    public String alijas() {
        return " poz ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public String selectWhere() {
        return "";
    }

    @Override
    public List<IOpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        List<IOpstiDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            Pozicija p = new Pozicija();
            p.setPozicijaID(rs.getLong("pozicijaID"));
            p.setNaziv(rs.getString("naziv"));
            lista.add(p);
        }
        return lista;
    }

    @Override
    public String koloneInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vrednostPrimarniKljuc() {
        return " pozicijaID="+pozicijaID+" ";
    }

    @Override
    public String vrednostiInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vrednostiUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiMax() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
