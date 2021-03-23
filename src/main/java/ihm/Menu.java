package ihm;

import chine.ihm.ChineIHM;
import france.ihm.FranceIHM;
import lombok.SneakyThrows;
import senegal.ihm.SenegalIHM;

import java.io.IOException;

public class Menu extends javax.swing.JFrame {

    /** Creates new form Menu */
    public Menu() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {
        ChineButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        senegalButton = new javax.swing.JButton();
        AngleterreButton = new javax.swing.JButton();
        FranceButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ChineButton.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        ChineButton.setText("Chine");
        ChineButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChineButtonActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jButton3.setText("Principale");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        senegalButton.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        senegalButton.setText("Senegal");
        senegalButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senegalButtonActionPerformed(evt);
            }
        });

        AngleterreButton.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        AngleterreButton.setText("Angleterre");
        AngleterreButton.addActionListener(new java.awt.event.ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AngleterreButtonActionPerformed(evt);
            }
        });

        FranceButton.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        FranceButton.setText("France");
        FranceButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FranceButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                        .add(FranceButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(AngleterreButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(senegalButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                                        .add(jButton3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                                        .add(org.jdesktop.layout.GroupLayout.LEADING, ChineButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .add(101, 101, 101))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(109, Short.MAX_VALUE)
                                .add(jButton3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 58, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(51, 51, 51)
                                .add(senegalButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 58, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(AngleterreButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 58, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(FranceButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 58, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(22, 22, 22)
                                .add(ChineButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 58, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(41, 41, 41))
        );

        pack();
    }

    private void ChineButtonActionPerformed(java.awt.event.ActionEvent evt) {
        ChineIHM chine = new ChineIHM();
        chine.setSize(750, 800);
        chine.setVisible(true);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void senegalButtonActionPerformed(java.awt.event.ActionEvent evt) {
        SenegalIHM senegal = new SenegalIHM();
        senegal.setSize(750, 800);
        senegal.setVisible(true);
    }

    private void AngleterreButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        AngleterreIHM2 angleterre = new AngleterreIHM2();
        angleterre.setSize(750, 800);
        angleterre.setVisible(true);
    }

    private void FranceButtonActionPerformed(java.awt.event.ActionEvent evt) {
        FranceIHM france = new FranceIHM();
        france.setSize(750, 800);
        france.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    private javax.swing.JButton AngleterreButton;
    private javax.swing.JButton ChineButton;
    private javax.swing.JButton FranceButton;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton senegalButton;

}