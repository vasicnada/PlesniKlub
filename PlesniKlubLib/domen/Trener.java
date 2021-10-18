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
public class Trener implements IOpstiDomenskiObjekat {

    private long trenerID = -1l;
    private String imePrezime;
    private String email;
    private String lozinka;

    public Trener() {
    }

    public Trener(long trenerID, String imePrezime, String email, String lozinka) {
        this.trenerID = trenerID;
        this.imePrezime = imePrezime;
        this.email = email;
        this.lozinka = lozinka;
    }

    /**
     * @return the trenerID
     */
    public long getTrenerID() {
        return trenerID;
    }

    /**
     * @param trenerID the trenerID to set
     */
    public void setTrenerID(long trenerID) {
        this.trenerID = trenerID;
    }

    /**
     * @return the imePrezime
     */
    public String getImePrezime() {
        return imePrezime;
    }

    /**
     * @param imePrezime the imePrezime to set
     */
    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the lozinka
     */
    public String getLozinka() {
        return lozinka;
    }

    /**
     * @param lozinka the lozinka to set
     */
    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
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
        final Trener other = (Trener) obj;
        if (this.trenerID != other.trenerID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return imePrezime;
    }

    @Override
    public String nazivTabele() {
        return " trener ";
    }

    @Override
    public String alijas() {
        return " t ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public String selectWhere() {
        if (email != null && lozinka != null) {
            return " WHERE email = '" + email + "' AND lozinka = '" + lozinka + "' ";
        } else {
            return " WHERE trenerID = " + trenerID + " ";
        }
    }

    @Override
    public List<IOpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        List<IOpstiDomenskiObjekat> lista = new ArrayList<>();        
        while (rs.next()) {
            Trener t = new Trener();
            t.setTrenerID(rs.getLong("trenerID"));
            t.setImePrezime(rs.getString("imePrezime"));
            t.setEmail(rs.getString("email"));
            t.setLozinka(rs.getString("lozinka"));
            lista.add(t);
        }
        return lista;

    }

    @Override
    public String koloneInsert() {
        return "(trenerID, imePrezime, email, lozinka)";
    }

    @Override
    public String vrednostPrimarniKljuc() {
        return " trenerID=" + trenerID + " ";
    }

    @Override
    public String vrednostiInsert() {
        return " " + trenerID + ", '" + imePrezime + "', '" + email + "', '" + lozinka + "' " ;
    }

    @Override
    public String vrednostiUpdate() {
        return  " imePrezime='" + imePrezime + "', email='" + email + "', lozinka='" + lozinka + "' " ;
    }

    @Override
    public String vratiMax() {
        return"trenerID";
    }

}
