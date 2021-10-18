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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Nada
 */
public class PretragaTakmicenjaSO extends OpstaSistemskaOperacija{

    @Override
    public ServerskiOdgovor izvrsiKonkretnuOperaciju(IOpstiDomenskiObjekat odo) throws Exception {
        try {
            ServerskiOdgovor so = new ServerskiOdgovor();
            List<IOpstiDomenskiObjekat> rez = DBBroker.getInstance().select(odo);
            Koreografija k = new Koreografija();            
            so.setOdgovor(rez);
            so.setUspesno(true);
            so.setPoruka("Sistem je uspesno pronasao takmicenja.");
            return so;
        } catch (SQLException ex) {
            Logger.getLogger(PretragaTakmicenjaSO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Sistem ne moze da pronadje takmicenja. ");
        }
    }
    
}
