/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Plesac;
import domen.Pozicija;
import forme.modovi.ModDomenske;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import kontroler.Kontroler;

/**
 *
 * @author Nada
 */
public class FrmPlesac extends javax.swing.JDialog {
    
    private ModDomenske mod;
    private Plesac plesac;

    /**
     * Creates new form FrmPlesac
     */
    private FrmPlesac(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public FrmPlesac(java.awt.Frame parent, boolean modal, Plesac plesac, ModDomenske mod) {
        this(parent, modal);
        this.plesac = plesac;
        setujMod(mod);
        popuniPozicije();
        if (mod == ModDomenske.PRIKAZ) {
            try {
                this.plesac = Kontroler.getInstance().ucitavanjePlesaca(plesac);
            } catch (Exception ex) {
                //Logger.getLogger(FrmPlesac.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
            popuniPolja();
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPlesacID = new javax.swing.JTextField();
        txtIme = new javax.swing.JTextField();
        txtPrezime = new javax.swing.JTextField();
        txtBrojGodina = new javax.swing.JTextField();
        cbPozicija = new javax.swing.JComboBox<>();
        btnNazad = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        btnSacuvaj = new javax.swing.JButton();
        lblPlesacID = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        errIme = new javax.swing.JLabel();
        errBrojGodina = new javax.swing.JLabel();
        errPrezime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        txtPlesacID.setEnabled(false);

        cbPozicija.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnNazad.setText("Nazad");
        btnNazad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNazadActionPerformed(evt);
            }
        });

        btnIzmeni.setText("Izmeni");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obrisi");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        btnSacuvaj.setText("Sacuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        lblPlesacID.setText("Plesac ID");
        lblPlesacID.setToolTipText("");

        jLabel2.setText("Ime");

        jLabel3.setText("Prezime");

        jLabel4.setText("Broj godina");

        jLabel5.setText("Pozicija");

        errIme.setForeground(new java.awt.Color(255, 51, 51));
        errIme.setText("Obavezno polje!");

        errBrojGodina.setForeground(new java.awt.Color(255, 51, 51));
        errBrojGodina.setText("Mora biti unet broj!");

        errPrezime.setForeground(new java.awt.Color(255, 51, 51));
        errPrezime.setText("Obavezno polje!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btnNazad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                .addComponent(btnIzmeni)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnObrisi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSacuvaj)
                .addGap(33, 33, 33))
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPlesacID)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPrezime)
                    .addComponent(txtBrojGodina)
                    .addComponent(cbPozicija, 0, 143, Short.MAX_VALUE)
                    .addComponent(txtPlesacID)
                    .addComponent(txtIme))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(errIme)
                    .addComponent(errBrojGodina)
                    .addComponent(errPrezime))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPlesacID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPlesacID))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(errIme))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(errPrezime))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBrojGodina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(errBrojGodina))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbPozicija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSacuvaj)
                    .addComponent(btnObrisi)
                    .addComponent(btnIzmeni)
                    .addComponent(btnNazad))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNazadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNazadActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnNazadActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        ((FrmGlavna) getParent()).pretraga();
    }//GEN-LAST:event_formWindowClosed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        setujMod(ModDomenske.IZMENA);
    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        try {
            Kontroler.getInstance().brisanjePlesaca(plesac);
            JOptionPane.showMessageDialog(this, "Sistem je uspesno obrisao podatke o plesacu. ");
            this.setVisible(false);
            this.dispose();
        } catch (Exception ex) {
            //Logger.getLogger(FrmPlesac.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        errIme.setVisible(false);
        errPrezime.setVisible(false);
        errBrojGodina.setVisible(false);
        boolean ok = true;
        String ime = txtIme.getText().trim();
        if (ime.isEmpty()) {
            ok = false;
            errIme.setVisible(true);
        }
        String prezime = txtPrezime.getText().trim();
        if (prezime.isEmpty()) {
            ok = false;
            errPrezime.setVisible(true);
        }
        int brojGodina = -1;
        try {
            brojGodina = Integer.parseInt(txtBrojGodina.getText().trim());
        } catch (Exception ex) {
            ok = false;
            errBrojGodina.setVisible(true);
        }
        Pozicija pozicija = (Pozicija) cbPozicija.getSelectedItem();
        if (!ok) {
            return;
        }
        Plesac pl = new Plesac(-1, ime, prezime, brojGodina, pozicija);
        if (mod == ModDomenske.IZMENA) {
            pl.setPlesacID(plesac.getPlesacID());
            try {
                plesac = Kontroler.getInstance().izmenaPlesaca(pl);
                popuniPolja();
                setujMod(ModDomenske.PRIKAZ);
                JOptionPane.showMessageDialog(this, "Sistem je uspesno zapamtio izmene podataka o plesacu. ");
            } catch (Exception ex) {
                //Logger.getLogger(FrmPlesac.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }else if (mod == ModDomenske.UNOS) {            
            try {
                plesac = Kontroler.getInstance().noviPlesac(pl);
                popuniPolja();
                setujMod(ModDomenske.PRIKAZ);
                JOptionPane.showMessageDialog(this, "Sistem je uspesno sacuvao podatke o plesacu. ");
            } catch (Exception ex) {
                //Logger.getLogger(FrmPlesac.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnSacuvajActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnNazad;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox<Object> cbPozicija;
    private javax.swing.JLabel errBrojGodina;
    private javax.swing.JLabel errIme;
    private javax.swing.JLabel errPrezime;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblPlesacID;
    private javax.swing.JTextField txtBrojGodina;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtPlesacID;
    private javax.swing.JTextField txtPrezime;
    // End of variables declaration//GEN-END:variables

    private void setujMod(ModDomenske mod) {
        this.mod = mod;
        switch(mod){
            case UNOS:
                lblPlesacID.setVisible(false);
                txtPlesacID.setVisible(false);
                txtIme.setEnabled(true);
                txtPrezime.setEnabled(true);
                txtBrojGodina.setEnabled(true);
                cbPozicija.setEnabled(true);
                
                btnIzmeni.setEnabled(false);
                btnObrisi.setEnabled(false);
                btnSacuvaj.setEnabled(true);                
                break;                
            case IZMENA:
                lblPlesacID.setVisible(true);
                txtPlesacID.setVisible(true);
                txtIme.setEnabled(true);
                txtPrezime.setEnabled(true);
                txtBrojGodina.setEnabled(true);
                cbPozicija.setEnabled(true);
                
                btnIzmeni.setEnabled(false);
                btnObrisi.setEnabled(false);
                btnSacuvaj.setEnabled(true);
                break;
            case PRIKAZ:
                lblPlesacID.setVisible(true);
                txtPlesacID.setVisible(true);
                txtIme.setEnabled(false);
                txtPrezime.setEnabled(false);
                txtBrojGodina.setEnabled(false);
                cbPozicija.setEnabled(false);
                
                btnIzmeni.setEnabled(true);
                btnObrisi.setEnabled(true);
                btnSacuvaj.setEnabled(false);
                break;
        }
    }
    
    private void popuniPolja() {
        txtPlesacID.setText(plesac.getPlesacID() + "");
        txtIme.setText(plesac.getIme());
        txtPrezime.setText(plesac.getPrezime());
        txtBrojGodina.setText(plesac.getBrojGodina() + "");
        cbPozicija.setSelectedItem(plesac.getPozicija());        
    }
    
    private void popuniPozicije() {
        try {
            List<Pozicija> lista = Kontroler.getInstance().ucitajPozicije();
            cbPozicija.removeAllItems();
            for (Pozicija poz : lista) {
                cbPozicija.addItem(poz);
            }
        } catch (Exception ex) {
            //Logger.getLogger(FrmPlesac.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    
}