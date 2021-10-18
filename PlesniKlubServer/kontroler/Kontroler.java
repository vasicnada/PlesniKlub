/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;


import domen.IOpstiDomenskiObjekat;
import domen.Pozicija;
import so.BrisanjePlesacaSO;
import so.BrisanjeTakmicenjaSO;
import so.IzmenaPlesacaSO;
import so.IzmenaTakmicenjaSO;
import so.NovoTakmicenjeSO;
import so.NoviPlesacSO;
import so.PretragaPlesacaSO;
import so.PretragaTakmicenjaSO;
import so.PrijavaSO;
import so.UcitavanjePlesacaSO;
import so.UcitavanjePozicijaSO;
import so.UcitavanjeTakmicenjaSO;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Nada
 */
public class Kontroler {
    private static Kontroler instance;

    private Kontroler() {
    }

    public static Kontroler getInstance() {
        if(instance == null)
            instance = new Kontroler();
        return instance;
    }

    public ServerskiOdgovor prijava(IOpstiDomenskiObjekat odo) {
        return new PrijavaSO().izvrsiOperaciju(odo);
    }

    public ServerskiOdgovor noviPlesac(IOpstiDomenskiObjekat odo) {
        return new NoviPlesacSO().izvrsiOperaciju(odo);
    }

    public ServerskiOdgovor izmenaPlesaca(IOpstiDomenskiObjekat odo) {
        return new IzmenaPlesacaSO().izvrsiOperaciju(odo);
    }

    public ServerskiOdgovor brisanjePlesaca(IOpstiDomenskiObjekat odo) {
        return new BrisanjePlesacaSO().izvrsiOperaciju(odo);
    }

    public ServerskiOdgovor pretragaPlesaca(IOpstiDomenskiObjekat odo) {
        return new PretragaPlesacaSO().izvrsiOperaciju(odo);
    }

    public ServerskiOdgovor ucitavanjePlesaca(IOpstiDomenskiObjekat odo) {
        return new UcitavanjePlesacaSO().izvrsiOperaciju(odo);
    }

    public ServerskiOdgovor novoTakmicenje(IOpstiDomenskiObjekat odo) {
        return new NovoTakmicenjeSO().izvrsiOperaciju(odo);
    }

    public ServerskiOdgovor izmenaTakmicenja(IOpstiDomenskiObjekat odo) {
        return new IzmenaTakmicenjaSO().izvrsiOperaciju(odo);
    }

    public ServerskiOdgovor brisanjeTakmicenja(IOpstiDomenskiObjekat odo) {
        return new BrisanjeTakmicenjaSO().izvrsiOperaciju(odo);
    }

    public ServerskiOdgovor pretragaTakmicenja(IOpstiDomenskiObjekat odo) {
        return new PretragaTakmicenjaSO().izvrsiOperaciju(odo);
    }

    public ServerskiOdgovor ucitavanjeTakmicenja(IOpstiDomenskiObjekat odo) {
        return new UcitavanjeTakmicenjaSO().izvrsiOperaciju(odo);
    }

    public ServerskiOdgovor ucitavanjePozicija() {
        return new UcitavanjePozicijaSO().izvrsiOperaciju(new Pozicija());
    }

    
    
    
    
    
}
