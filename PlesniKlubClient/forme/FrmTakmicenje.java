/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Plesac;
import domen.Koreografija;
import domen.Takmicenje;
import forme.modovi.ModDomenske;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import modeli.ModelTabeleKoreografija;
import modeli.ModelTabelePlesac;

/**
 *
 * @author Nada
 */
public class FrmTakmicenje extends javax.swing.JDialog {

    private ModDomenske mod;
    private Takmicenje takmicenje;

    /**
     * Creates new form FrmTakmicenje
     */
    private FrmTakmicenje(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public FrmTakmicenje(java.awt.Frame parent, boolean modal, Takmicenje takmicenje, ModDomenske mod) {
        this(parent, modal);
        this.takmicenje = takmicenje;
        setujMod(mod);
        tblPlesaci.setModel(new ModelTabeleKoreografija(new ArrayList<>()));
        popuniKomboPlesaca();
        errMesto.setVisible(false);
        errTermin.setVisible(false);
        if (mod == ModDomenske.PRIKAZ) {
            try {
                this.takmicenje = Kontroler.getInstance().ucitavanjeTakmicenja(takmicenje);
            } catch (Exception ex) {
                //Logger.getLogger(FrmTakmicenje.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
            popuniPolja();
        } else {
            txtTrener.setText(Kontroler.getInstance().getUlogovan().toString());
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

        lblTakmicenjeID = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbPlesaci = new javax.swing.JComboBox<>();
        btnDodajPlesaca = new javax.swing.JButton();
        btnIzbaciPlesaca = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPlesaci = new javax.swing.JTable();
        btnNazad = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        btnSacuvaj = new javax.swing.JButton();
        txtTakmicenjeID = new javax.swing.JTextField();
        txtMesto = new javax.swing.JTextField();
        txtTermin = new javax.swing.JTextField();
        txtTrener = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        errMesto = new javax.swing.JLabel();
        errTermin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        lblTakmicenjeID.setText("Takmicenje ID:");

        jLabel2.setText("Mesto:");

        jLabel3.setText("Termin (dd.mm.gggg.):");

        jLabel4.setText("Trener:");

        cbPlesaci.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbPlesaci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPlesaciActionPerformed(evt);
            }
        });

        btnDodajPlesaca.setText("Dodaj plesaca");
        btnDodajPlesaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajPlesacaActionPerformed(evt);
            }
        });

        btnIzbaciPlesaca.setText("Izbaci plesaca");
        btnIzbaciPlesaca.setToolTipText("");
        btnIzbaciPlesaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzbaciPlesacaActionPerformed(evt);
            }
        });

        tblPlesaci.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblPlesaci);

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

        txtTakmicenjeID.setEnabled(false);

        txtTrener.setEnabled(false);

        jLabel5.setText("Plesaci:");

        errMesto.setForeground(new java.awt.Color(255, 81, 81));
        errMesto.setText("obavezno polje");

        errTermin.setForeground(new java.awt.Color(255, 81, 81));
        errTermin.setText("pogresan format");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(btnNazad)
                        .addGap(240, 240, 240)
                        .addComponent(btnIzmeni)
                        .addGap(37, 37, 37)
                        .addComponent(btnObrisi)
                        .addGap(39, 39, 39)
                        .addComponent(btnSacuvaj))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(lblTakmicenjeID))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTakmicenjeID, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cbPlesaci, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtTermin, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                            .addComponent(txtMesto)
                                            .addComponent(txtTrener))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(errTermin)
                                                    .addComponent(errMesto)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addComponent(btnDodajPlesaca)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnIzbaciPlesaca)))))))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTakmicenjeID)
                    .addComponent(txtTakmicenjeID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errMesto))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTermin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(errTermin)))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTrener, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPlesaci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDodajPlesaca)
                    .addComponent(btnIzbaciPlesaca)
                    .addComponent(jLabel5))
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNazad)
                    .addComponent(btnIzmeni)
                    .addComponent(btnObrisi)
                    .addComponent(btnSacuvaj))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbPlesaciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPlesaciActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPlesaciActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        ((FrmGlavna) getParent()).pretraga();
    }//GEN-LAST:event_formWindowClosed

    private void btnNazadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNazadActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnNazadActionPerformed

    private void btnDodajPlesacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajPlesacaActionPerformed
        Plesac plesac = (Plesac) cbPlesaci.getSelectedItem();
        ModelTabeleKoreografija mtk = (ModelTabeleKoreografija) tblPlesaci.getModel();
        for (Koreografija k : mtk.getLista()) {
            if (k.getPlesac().equals(plesac)) {
                JOptionPane.showMessageDialog(this, "Izabrani plesac je vec u koreografiji takmicenja. ");
                return;
            }
        }
        Koreografija koreografija = new Koreografija(takmicenje, -1, plesac);
        mtk.dodajRed(koreografija);
    }//GEN-LAST:event_btnDodajPlesacaActionPerformed

    private void btnIzbaciPlesacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzbaciPlesacaActionPerformed
        int i = tblPlesaci.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(this, "Niste izabrali plesaca iz tabele. ");
            return;
        }
        ((ModelTabeleKoreografija) tblPlesaci.getModel()).izbaciRed(i);
    }//GEN-LAST:event_btnIzbaciPlesacaActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        setujMod(ModDomenske.IZMENA);
    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        try {
            Kontroler.getInstance().brisanjeTakmicenja(takmicenje);
            JOptionPane.showMessageDialog(this, "Sistem je uspesno obrisao podatke o takmicenju. ");
            this.setVisible(false);
            this.dispose();
        } catch (Exception ex) {
            //Logger.getLogger(FrmTakmicenje.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        Takmicenje zaCuvanje = new Takmicenje();
        boolean ok = true;
        errMesto.setVisible(false);
        errTermin.setVisible(false);
        zaCuvanje.setMesto(txtMesto.getText().trim());
        if (zaCuvanje.getMesto().isEmpty()) {
            ok = false;
            errMesto.setVisible(true);
        }
        try {
            zaCuvanje.setTermin(Kontroler.getInstance().parseDatum(txtTermin.getText().trim()));
        } catch (Exception ex) {
            ok = false;
            errTermin.setVisible(true);
        }
        if (!ok) {
            return;
        }
        zaCuvanje.setListaKoreografija(((ModelTabeleKoreografija) tblPlesaci.getModel()).getLista());
        if (mod == ModDomenske.IZMENA) {
            zaCuvanje.setTrener(takmicenje.getTrener());
            zaCuvanje.setTakmicenjeID(takmicenje.getTakmicenjeID());
            try {
                takmicenje = Kontroler.getInstance().izmenaTakmicenja(zaCuvanje);
                JOptionPane.showMessageDialog(this, "Sistem je uspesno zapamtio izmene podataka o takmicenju. ");
            } catch (Exception ex) {
                //Logger.getLogger(FrmTakmicenje.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex.getMessage());
                return;
            }
        }
        if (mod == ModDomenske.UNOS) {
            zaCuvanje.setTrener(Kontroler.getInstance().getUlogovan());
            try {
                takmicenje = Kontroler.getInstance().novoTakmicenje(zaCuvanje);
                JOptionPane.showMessageDialog(this, "Sistem je uspesno sacuvao podatke o takmicenju. ");
            } catch (Exception ex) {
                //Logger.getLogger(FrmTakmicenje.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex.getMessage());
                return;
            }
        }
        popuniPolja();
        setujMod(ModDomenske.PRIKAZ);
    }//GEN-LAST:event_btnSacuvajActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajPlesaca;
    private javax.swing.JButton btnIzbaciPlesaca;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnNazad;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox<Object> cbPlesaci;
    private javax.swing.JLabel errMesto;
    private javax.swing.JLabel errTermin;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTakmicenjeID;
    private javax.swing.JTable tblPlesaci;
    private javax.swing.JTextField txtMesto;
    private javax.swing.JTextField txtTakmicenjeID;
    private javax.swing.JTextField txtTermin;
    private javax.swing.JTextField txtTrener;
    // End of variables declaration//GEN-END:variables

    private void setujMod(ModDomenske mod) {
        this.mod = mod;
        switch (mod) {
            case UNOS:
                lblTakmicenjeID.setVisible(false);
                txtTakmicenjeID.setVisible(false);
                txtMesto.setEnabled(true);
                txtTermin.setEnabled(true);

                cbPlesaci.setVisible(true);
                btnDodajPlesaca.setVisible(true);
                btnIzbaciPlesaca.setVisible(true);

                btnIzmeni.setEnabled(false);
                btnObrisi.setEnabled(false);
                btnSacuvaj.setEnabled(true);
                break;
            case IZMENA:
                lblTakmicenjeID.setVisible(true);
                txtTakmicenjeID.setVisible(true);
                txtMesto.setEnabled(true);
                txtTermin.setEnabled(true);

                cbPlesaci.setVisible(true);
                btnDodajPlesaca.setVisible(true);
                btnIzbaciPlesaca.setVisible(true);

                btnIzmeni.setEnabled(false);
                btnObrisi.setEnabled(false);
                btnSacuvaj.setEnabled(true);
                break;
            case PRIKAZ:
                lblTakmicenjeID.setVisible(true);
                txtTakmicenjeID.setVisible(true);
                txtMesto.setEnabled(false);
                txtTermin.setEnabled(false);

                cbPlesaci.setVisible(false);
                btnDodajPlesaca.setVisible(false);
                btnIzbaciPlesaca.setVisible(false);

                btnIzmeni.setEnabled(true);
                btnObrisi.setEnabled(true);
                btnSacuvaj.setEnabled(false);
                break;
        }
    }

    private void popuniPolja() {
        txtTakmicenjeID.setText(takmicenje.getTakmicenjeID() + "");
        txtMesto.setText(takmicenje.getMesto());
        txtTermin.setText(Kontroler.getInstance().formatDatum(takmicenje.getTermin()));
        txtTrener.setText(takmicenje.getTrener().toString());
        ((ModelTabeleKoreografija) tblPlesaci.getModel()).setLista(takmicenje.getListaKoreografija());

    }

    private void popuniKomboPlesaca() {
        cbPlesaci.removeAllItems();
        try {
            List<Plesac> lista = Kontroler.getInstance().pretragaPlesaca(new Plesac());
            for (Plesac plesac : lista) {
                cbPlesaci.addItem(plesac);
            }
        } catch (Exception ex) {
            //Logger.getLogger(FrmTakmicenje.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
}
