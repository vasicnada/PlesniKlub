/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;


import domen.IOpstiDomenskiObjekat;
import domen.Plesac;
import domen.Pozicija;
import domen.Trener;
import domen.Takmicenje;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import komunikacija.KomunikacijaSaServerom;
import konstante.Operacije;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Nada
 */
public class Kontroler {
   
    private static Kontroler instance;
    private Trener ulogovan;
    private final SimpleDateFormat sdf;
    
    
    public Kontroler() {
        sdf = new SimpleDateFormat("dd.MM.yyyy.");
    }

    public static Kontroler getInstance() {
        if(instance == null)
            instance = new Kontroler();
        return instance;
    }
    
    public void setUlogovan(Trener ulogovan) {
        this.ulogovan = ulogovan;
    }
    public Trener getUlogovan() {
        return ulogovan;
    }
    
    public String formatDatum(Date datum) {
        return sdf.format(datum);
    }
    public Date parseDatum(String datum) throws Exception{
        return sdf.parse(datum);
    }

    public Trener prijava(Trener trener) throws Exception{
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacije.PRIJAVA, trener);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        if(so.isUspesno())
            return (Trener)so.getOdgovor();
        throw new Exception(so.getPoruka());
    }
    
    public List<Plesac> pretragaPlesaca(Plesac plesac) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacije.PRETRAGA_PLESACA, plesac);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        if(so.isUspesno())
            return (List<Plesac>)so.getOdgovor();
        throw new Exception(so.getPoruka());
    }
    
    public List<Takmicenje> pretragaTakmicenja(Takmicenje takmicenje) throws Exception{
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacije.PRETRAGA_TAKMICENJA, takmicenje);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        if(so.isUspesno())
            return (List<Takmicenje>)so.getOdgovor();
        throw new Exception(so.getPoruka());
  }
   
    public List<Pozicija> ucitajPozicije() throws Exception{
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacije.UCITAVANJE_POZICIJA, null);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        if(so.isUspesno())
            return (List<Pozicija>)so.getOdgovor();
        throw new Exception(so.getPoruka());
    }

    public void brisanjePlesaca(Plesac plesac) throws Exception{
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacije.BRISANJE_PLESACA, plesac);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        if(so.isUspesno())
            return;
        throw new Exception(so.getPoruka());
    }

    public Plesac izmenaPlesaca(Plesac plesac) throws Exception{
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacije.IZMENA_PLESACA, plesac);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        if(so.isUspesno())
            return (Plesac)so.getOdgovor();
        throw new Exception(so.getPoruka());
    }

    public Plesac noviPlesac(Plesac plesac) throws Exception{
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacije.NOVI_PLESAC, plesac);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        if(so.isUspesno())
            return (Plesac)so.getOdgovor();
        throw new Exception(so.getPoruka());
    }

    public Takmicenje ucitavanjeTakmicenja(Takmicenje takmicenje) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacije.UCITAVANJE_TAKMICENJA, takmicenje);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        if(so.isUspesno())
            return (Takmicenje)so.getOdgovor();
        throw new Exception(so.getPoruka());
    }

    public Plesac ucitavanjePlesaca(Plesac plesac) throws Exception{
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacije.UCITAVANJE_PLESACA, plesac);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        if(so.isUspesno())
            return (Plesac)so.getOdgovor();
        throw new Exception(so.getPoruka());
    }

    public void brisanjeTakmicenja(Takmicenje takmicenje) throws Exception{
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacije.BRISANJE_TAKMICENJA, takmicenje);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        if(so.isUspesno())
            return;
        throw new Exception(so.getPoruka());
    }

    public Takmicenje izmenaTakmicenja(Takmicenje takmicenje) throws Exception{
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacije.IZMENA_TAKMICENJA, takmicenje);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        if(so.isUspesno())
            return (Takmicenje)so.getOdgovor();
        throw new Exception(so.getPoruka());
    }
    
    public Takmicenje novoTakmicenje(Takmicenje takmicenje) throws Exception{
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacije.NOVO_TAKMICENJE, takmicenje);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        if(so.isUspesno())
            return (Takmicenje)so.getOdgovor();
        throw new Exception(so.getPoruka());
    }

    
    
   
}
