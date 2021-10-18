/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nada
 */
public class Takmicenje implements IOpstiDomenskiObjekat{
    private long takmicenjeID = -1l;
    private Date termin;
    private String mesto;
    private Trener trener;
    private List <Koreografija> listaKoreografija;

    public Takmicenje() {
    }

    public Takmicenje(long takmicenjeID, Date termin, String mesto, Trener trener, List<Koreografija> listaKoreografija) {
        this.takmicenjeID = takmicenjeID;
        this.termin = termin;
        this.mesto = mesto;
        this.trener = trener;
        this.listaKoreografija = listaKoreografija;
    }
    

    /**
     * @return the takmicenjeID
     */
    public long getTakmicenjeID() {
        return takmicenjeID;
    }

    /**
     * @param takmicenjeID the takmicenjeID to set
     */
    public void setTakmicenjeID(long takmicenjeID) {
        this.takmicenjeID = takmicenjeID;
    }

    /**
     * @return the termin
     */
    public Date getTermin() {
        return termin;
    }

    /**
     * @param termin the termin to set
     */
    public void setTermin(Date termin) {
        this.termin = termin;
    }

    /**
     * @return the mesto
     */
    public String getMesto() {
        return mesto;
    }

    /**
     * @param mesto the mesto to set
     */
    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    /**
     * @return the trener
     */
    public Trener getTrener() {
        return trener;
    }

    /**
     * @param trener the trener to set
     */
    public void setTrener(Trener trener) {
        this.trener = trener;
    }

    /**
     * @return the listaKoreografija
     */
    public List <Koreografija> getListaKoreografija() {
        return listaKoreografija;
    }

    /**
     * @param listaKoreografija the listaKoreografija to set
     */
    public void setListaKoreografija(List <Koreografija> listaKoreografija) {
        this.listaKoreografija = listaKoreografija;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Takmicenje other = (Takmicenje) obj;
        if (this.takmicenjeID != other.takmicenjeID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return mesto;
    }

    @Override
    public String nazivTabele() {
        return " takmicenje ";
    }

    @Override
    public String alijas() {
        return " tak ";
    }

    @Override
    public String join() {
        return " JOIN trener t ON tak.trenerID=t.trenerID ";
    }

    @Override
    public String selectWhere() {
        if(takmicenjeID != -1){
            return " WHERE takmicenjeID="+takmicenjeID+" ";
        }
        if(mesto != null && termin == null){
            return " WHERE mesto LIKE'%"+mesto+"%' ";
        }
        if(mesto == null && termin != null){
            return " WHERE termin='"+new java.sql.Date(termin.getTime())+"' ";
        }
        if(mesto != null && termin != null){
            return " WHERE mesto LIKE'%"+mesto+"%' AND termin='"+new java.sql.Date(termin.getTime())+"' ";
        }
        return "";
    }

    @Override
    public List<IOpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        List<IOpstiDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            Takmicenje tak = new Takmicenje();
            Trener t = new Trener();
            tak.setTrener(t);
            t.setTrenerID(rs.getLong("t.trenerID"));
            t.setImePrezime(rs.getString("t.imePrezime"));
            t.setEmail(rs.getString("t.email"));
            t.setLozinka(rs.getString("t.lozinka"));
            tak.setTakmicenjeID(rs.getLong("tak.takmicenjeID"));
            tak.setTermin(new java.util.Date(rs.getDate("tak.termin").getTime()));
            tak.setMesto(rs.getString("tak.mesto"));
            tak.setListaKoreografija(new ArrayList<>());
            lista.add(tak);
        }
        return lista;
    }

    @Override
    public String koloneInsert() {
        return " (takmicenjeID, termin, mesto, trenerID) ";
    }

    @Override
    public String vrednostPrimarniKljuc() {
        return " takmicenjeID="+takmicenjeID+" ";
    }

    @Override
    public String vrednostiInsert() {
        return " "+takmicenjeID+", '"+new java.sql.Date(termin.getTime())+"', '"+mesto+"', "+trener.getTrenerID()+" ";
    }

    @Override
    public String vrednostiUpdate() {
return " termin='"+new java.sql.Date(termin.getTime())+"', mesto='"+mesto+"', trenerID="+trener.getTrenerID()+" ";
    }

    @Override
    public String vratiMax() {
        return "takmicenjeID";
    }
    
    
    
    
    
}
