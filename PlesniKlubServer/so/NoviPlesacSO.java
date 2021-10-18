/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import domen.IOpstiDomenskiObjekat;
import domen.Plesac;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Nada
 */
public class NoviPlesacSO extends OpstaSistemskaOperacija{

    @Override
    public ServerskiOdgovor izvrsiKonkretnuOperaciju(IOpstiDomenskiObjekat odo) throws Exception {
        try {
            ServerskiOdgovor so = new ServerskiOdgovor();
            long id = 1 + DBBroker.getInstance().max(odo);
            ((Plesac)odo).setPlesacID(id);
            DBBroker.getInstance().insert(odo);
            so.setOdgovor(odo);
            so.setUspesno(true);
            so.setPoruka("Sistem je uspesno sacuvao podatke o plesacu. ");
            return so;
        } catch (SQLException ex) {
            Logger.getLogger(NoviPlesacSO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Sistem ne moze da sacuva podatke o plesacu. ");
        }
    }
    
}
