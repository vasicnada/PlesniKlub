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
public class UcitavanjeTakmicenjaSO extends OpstaSistemskaOperacija{

    @Override
    public ServerskiOdgovor izvrsiKonkretnuOperaciju(IOpstiDomenskiObjekat odo) throws Exception {
        try {
            ServerskiOdgovor so = new ServerskiOdgovor();
            List<IOpstiDomenskiObjekat> rez = DBBroker.getInstance().select(odo);
            if(rez.isEmpty()){
                so.setUspesno(false);
                so.setPoruka("Sistem ne moze da ucita podatke o takmicenju. ");
            }else{
                Takmicenje tak=  (Takmicenje)rez.get(0);
                Koreografija k = new Koreografija();
                k.setTakmicenje(tak);
                tak.setListaKoreografija((List<Koreografija>)(Object)DBBroker.getInstance().select(k));
                so.setOdgovor(tak);                
                so.setUspesno(true);
                so.setPoruka("Sistem je uspesno ucitao podatke o takmicenju. ");
            }
            return so;
        } catch (SQLException ex) {
            Logger.getLogger(UcitavanjeTakmicenjaSO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Sistem ne moze da ucita podatke o takmicenju. ");
        }
    }
    
}
