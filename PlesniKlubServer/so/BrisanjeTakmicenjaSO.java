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
public class BrisanjeTakmicenjaSO extends OpstaSistemskaOperacija{

    @Override
    public ServerskiOdgovor izvrsiKonkretnuOperaciju(IOpstiDomenskiObjekat odo) throws Exception {
        try {
            ServerskiOdgovor so = new ServerskiOdgovor();
            Takmicenje tak = (Takmicenje)odo;
            for(Koreografija k : tak.getListaKoreografija()){
                DBBroker.getInstance().delete(k);
            }
            DBBroker.getInstance().delete(tak);
            so.setUspesno(true);
            so.setPoruka("Sistem je uspesno obrisao podatke o takmicenju. ");
            so.setOdgovor(tak);
            return so;
        } catch (SQLException ex) {
            Logger.getLogger(BrisanjeTakmicenjaSO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Sistem ne moze da obrise podatke o takmicenju. ");
        }
    }
    
}
