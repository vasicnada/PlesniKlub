/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.IOpstiDomenskiObjekat;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstante.Operacije;
import kontroler.Kontroler;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Nada
 */
public class ObradaZahtevaNit extends Thread {

    Socket s;
    boolean kraj = false;

    public ObradaZahtevaNit(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        while (!kraj) {
            KlijentskiZahtev kz = primiZahtev();
            ServerskiOdgovor so = new ServerskiOdgovor();
            System.out.println("Operacija: " + kz.getOperacija());            
            switch (kz.getOperacija()) {
                case Operacije.PRIJAVA:
                    so = Kontroler.getInstance().prijava((IOpstiDomenskiObjekat)kz.getParametar());
                    break;
                case Operacije.NOVI_PLESAC:
                    so = Kontroler.getInstance().noviPlesac((IOpstiDomenskiObjekat)kz.getParametar());
                    break;
                case Operacije.IZMENA_PLESACA:
                    so = Kontroler.getInstance().izmenaPlesaca((IOpstiDomenskiObjekat)kz.getParametar());
                    break;
                case Operacije.BRISANJE_PLESACA:
                    so = Kontroler.getInstance().brisanjePlesaca((IOpstiDomenskiObjekat)kz.getParametar());
                    break;
                case Operacije.PRETRAGA_PLESACA:
                    so = Kontroler.getInstance().pretragaPlesaca((IOpstiDomenskiObjekat)kz.getParametar());
                    break;
                case Operacije.UCITAVANJE_PLESACA:
                    so = Kontroler.getInstance().ucitavanjePlesaca((IOpstiDomenskiObjekat)kz.getParametar());
                    break;
                case Operacije.NOVO_TAKMICENJE:
                    so = Kontroler.getInstance().novoTakmicenje((IOpstiDomenskiObjekat)kz.getParametar());
                    break;
                case Operacije.IZMENA_TAKMICENJA:
                    so = Kontroler.getInstance().izmenaTakmicenja((IOpstiDomenskiObjekat)kz.getParametar());
                    break;
                case Operacije.BRISANJE_TAKMICENJA:
                    so = Kontroler.getInstance().brisanjeTakmicenja((IOpstiDomenskiObjekat)kz.getParametar());
                    break;
                case Operacije.PRETRAGA_TAKMICENJA:
                    so = Kontroler.getInstance().pretragaTakmicenja((IOpstiDomenskiObjekat)kz.getParametar());
                    break;
                case Operacije.UCITAVANJE_TAKMICENJA:
                    so = Kontroler.getInstance().ucitavanjeTakmicenja((IOpstiDomenskiObjekat)kz.getParametar());
                    break;
                case Operacije.UCITAVANJE_POZICIJA:
                    so = Kontroler.getInstance().ucitavanjePozicija();
            }

            posaljiOdgovor(so);
        }
    }

    private KlijentskiZahtev primiZahtev() {
        KlijentskiZahtev kz = new KlijentskiZahtev();

        try {
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            kz = (KlijentskiZahtev) ois.readObject();
        } catch (Exception ex) {
            Logger.getLogger(ObradaZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
        }

        return kz;
    }

    private void posaljiOdgovor(ServerskiOdgovor so) {
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(so);
        } catch (IOException ex) {
            Logger.getLogger(ObradaZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
