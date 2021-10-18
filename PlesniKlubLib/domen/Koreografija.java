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
import java.util.Objects;

/**
 *
 * @author Nada
 */
public class Koreografija implements IOpstiDomenskiObjekat{
    private Takmicenje takmicenje;
    private int rb = -1;
    private Plesac plesac;

    public Koreografija() {
    }

    public Koreografija(Takmicenje takmicenje, int rb, Plesac plesac) {
        this.takmicenje = takmicenje;
        this.rb = rb;
        this.plesac = plesac;
    }

    /**
     * @return the takmicenje
     */
    public Takmicenje getTakmicenje() {
        return takmicenje;
    }

    /**
     * @param takmicenje the takmicenje to set
     */
    public void setTakmicenje(Takmicenje takmicenje) {
        this.takmicenje = takmicenje;
    }

    /**
     * @return the rb
     */
    public int getRb() {
        return rb;
    }

    /**
     * @param rb the rb to set
     */
    public void setRb(int rb) {
        this.rb = rb;
    }

    /**
     * @return the plesac
     */
    public Plesac getPlesac() {
        return plesac;
    }

    /**
     * @param plesac the plesac to set
     */
    public void setPlesac(Plesac plesac) {
        this.plesac = plesac;
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
        final Koreografija other = (Koreografija) obj;
        if (this.rb != other.rb) {
            return false;
        }
        if (!Objects.equals(this.takmicenje, other.takmicenje)) {
            return false;
        }
        return true;
    }

    @Override
    public String nazivTabele() {
        return " koreografija ";
    }

    @Override
    public String alijas() {
        return " k ";
    }

    @Override
    public String join() {
        return " JOIN plesac pl ON k.plesacID=pl.plesacID JOIN pozicija poz ON pl.pozicijaID=poz.pozicijaID ";
    }

    @Override
    public String selectWhere() {
        if(takmicenje != null){
            return " WHERE takmicenjeID="+takmicenje.getTakmicenjeID()+" ";
        }
        return " ";
    }

    @Override
    public List<IOpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        List<IOpstiDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            Koreografija koreografija = new Koreografija();
            Plesac pl = new Plesac();
            koreografija.setPlesac(pl);
            Pozicija poz = new Pozicija();
            pl.setPozicija(poz);
            poz.setPozicijaID(rs.getLong("poz.pozicijaID"));
            poz.setNaziv(rs.getString("poz.naziv"));
            pl.setPlesacID(rs.getLong("pl.plesacID"));
            pl.setIme(rs.getString("pl.ime"));
            pl.setPrezime(rs.getString("pl.prezime"));
            pl.setBrojGodina(rs.getInt("pl.brojGodina"));            
            koreografija.setRb(rs.getInt("k.rb"));            
            lista.add(koreografija);
        }
        return lista;
    }

    @Override
    public String koloneInsert() {
        return " (takmicenjeID, rb, plesacID) ";
    }

    @Override
    public String vrednostPrimarniKljuc() {
        return " takmicenjeID="+takmicenje.getTakmicenjeID()+(rb!=-1?" AND rb="+rb+" ":" ");
    }

    @Override
    public String vrednostiInsert() {
        return " "+takmicenje.getTakmicenjeID()+", "+rb+", "+plesac.getPlesacID()+" ";
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
