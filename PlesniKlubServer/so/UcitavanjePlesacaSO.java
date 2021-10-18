/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import domen.IOpstiDomenskiObjekat;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Nada
 */
public class UcitavanjePlesacaSO extends OpstaSistemskaOperacija {
    
    @Override
    public ServerskiOdgovor izvrsiKonkretnuOperaciju(IOpstiDomenskiObjekat odo) throws Exception {
        try {
            ServerskiOdgovor so = new ServerskiOdgovor();
            List<IOpstiDomenskiObjekat> rez = DBBroker.getInstance().select(odo);
            if (rez.isEmpty()) {
                so.setUspesno(false);
                so.setPoruka("Sistem ne moze da ucita podatke o plesacu. ");                
            } else {
                so.setOdgovor(rez.get(0));
                so.setUspesno(true);
                so.setPoruka("Sistem je uspesno ucitao podatke o plesacu. ");
            }
            return so;
        } catch (SQLException ex) {
            Logger.getLogger(UcitavanjePlesacaSO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Sistem ne moze da ucita podatke o plesacu. ");
        }
    }
    
}
