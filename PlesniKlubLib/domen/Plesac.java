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
public class Plesac implements IOpstiDomenskiObjekat {

    private long plesacID = -1l;
    private String ime;
    private String prezime;
    private int brojGodina;
    private Pozicija pozicija;

    public Plesac() {
    }

    public Plesac(long plesacID, String ime, String prezime, int brojGodina, Pozicija pozicija) {
        this.plesacID = plesacID;
        this.ime = ime;
        this.prezime = prezime;
        this.brojGodina = brojGodina;
        this.pozicija = pozicija;
    }

    /**
     * @return the plesacID
     */
    public long getPlesacID() {
        return plesacID;
    }

    /**
     * @param plesacID the plesacID to set
     */
    public void setPlesacID(long plesacID) {
        this.plesacID = plesacID;
    }

    /**
     * @return the ime
     */
    public String getIme() {
        return ime;
    }

    /**
     * @param ime the ime to set
     */
    public void setIme(String ime) {
        this.ime = ime;
    }

    /**
     * @return the prezime
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * @param prezime the prezime to set
     */
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    /**
     * @return the brojGodina
     */
    public int getBrojGodina() {
        return brojGodina;
    }

    /**
     * @param brojGodina the brojGodina to set
     */
    public void setBrojGodina(int brojGodina) {
        this.brojGodina = brojGodina;
    }

    /**
     * @return the pozicija
     */
    public Pozicija getPozicija() {
        return pozicija;
    }

    /**
     * @param pozicija the pozicija to set
     */
    public void setPozicija(Pozicija pozicija) {
        this.pozicija = pozicija;
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
        final Plesac other = (Plesac) obj;
        if (this.plesacID != other.plesacID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ime + " " + prezime + " " + brojGodina;
    }

    @Override
    public String nazivTabele() {
        return " plesac ";
    }

    @Override
    public String alijas() {
        return " pl ";
    }

    @Override
    public String join() {
        return " JOIN pozicija poz ON pl.pozicijaID = poz.pozicijaID ";
    }

    @Override
    public String selectWhere() {
        if (plesacID != -1) {
            return " WHERE plesacID=" + plesacID + " ";
        }
        if (ime != null && prezime != null) {
            return " WHERE CONCAT(pl.ime, CONCAT(' ', pl.prezime)) LIKE'%" + ime + "%' " + (brojGodina == -1 ? "" : "AND brojGodina=" + brojGodina + " ");
        }
        return " ";
    }

    @Override
    public List<IOpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        List<IOpstiDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Plesac pl = new Plesac();
            Pozicija p = new Pozicija();
            pl.setPozicija(p);
            p.setPozicijaID(rs.getLong("poz.pozicijaID"));
            p.setNaziv(rs.getString("poz.naziv"));
            pl.setPlesacID(rs.getLong("pl.plesacID"));
            pl.setIme(rs.getString("pl.ime"));
            pl.setPrezime(rs.getString("pl.prezime"));
            pl.setBrojGodina(rs.getInt("pl.brojGodina"));            
            lista.add(pl);
        }
        return lista;
    }

    @Override
    public String koloneInsert() {
        return " (plesacID, ime, prezime, brojGodina, pozicijaID) ";
    }

    @Override
    public String vrednostPrimarniKljuc() {
        return " plesacID="+plesacID+" ";
    }

    @Override
    public String vrednostiInsert() {
        return " "+plesacID+", '"+ime+"', '"+prezime+"', "+brojGodina+", "+pozicija.getPozicijaID()+" ";
    }

    @Override
    public String vrednostiUpdate() {
        return " ime='"+ime+"', prezime='"+prezime+"', brojGodina="+brojGodina+", pozicijaID="+pozicija.getPozicijaID()+" ";
    }

    @Override
    public String vratiMax() {
        return "plesacID";
    }

}

