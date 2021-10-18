/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import domen.IOpstiDomenskiObjekat;
import domen.Koreografija;
import domen.Takmicenje;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Nada
 */
public class IzmenaTakmicenjaSO extends OpstaSistemskaOperacija{

    @Override
    public ServerskiOdgovor izvrsiKonkretnuOperaciju(IOpstiDomenskiObjekat odo) throws Exception {
       try {
            ServerskiOdgovor so = new ServerskiOdgovor();
            DBBroker.getInstance().update(odo);
            Takmicenje tak = (Takmicenje)odo;
            Koreografija k = new Koreografija();
            k.setTakmicenje(tak);
            DBBroker.getInstance().delete(k);
            int rb = 0;
            for(Koreografija koreografija : tak.getListaKoreografija()){
                koreografija.setTakmicenje(tak);
                koreografija.setRb(++rb);
                DBBroker.getInstance().insert(koreografija);
            }
            so.setUspesno(true);
            so.setPoruka("Sistem je uspesno zapamtio izmene podataka o takmicenju. ");
            so.setOdgovor(tak);
            return so;
        } catch (SQLException ex) {
            Logger.getLogger(IzmenaTakmicenjaSO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Sistem ne moze da zapamti izmene podataka o takmicenju. ");
        }
    }
    
}
