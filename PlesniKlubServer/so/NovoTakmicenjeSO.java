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
public class NovoTakmicenjeSO extends OpstaSistemskaOperacija{

    @Override
    public ServerskiOdgovor izvrsiKonkretnuOperaciju(IOpstiDomenskiObjekat odo) throws Exception {
        try {
            ServerskiOdgovor so = new ServerskiOdgovor();
            long id = 1 + DBBroker.getInstance().max(odo);
            Takmicenje tak = (Takmicenje)odo;
            tak.setTakmicenjeID(id);
            DBBroker.getInstance().insert(tak);
            int rb = 0;
            for(Koreografija k : tak.getListaKoreografija()){
                k.setTakmicenje(tak);
                k.setRb(++rb);
                DBBroker.getInstance().insert(k);
            }
            so.setUspesno(true);
            so.setPoruka("Sistem je uspesno sacuvao podatke o novom takmicenju. ");
            so.setOdgovor(tak);
            return so;
        } catch (SQLException ex) {
            Logger.getLogger(NovoTakmicenjeSO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("");
        }
    }
    
}
