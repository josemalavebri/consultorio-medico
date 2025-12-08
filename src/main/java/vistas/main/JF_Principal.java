package vistas.main;

import Data.SQLite.DBConnection;
import Data.SQLite.DBDAOEjemplo;
import InstallBD.InstallDB;
import java.awt.BorderLayout;
import vistas.AtencionCliente.Pnl_AtencionMedica;
import vistas.citasMedicas.Pnl_CitaMedica;
import vistas.medico.Pnl_GestionMedico;
import vistas.paciente.Pnl_GestorPaciente;

public class JF_Principal extends javax.swing.JFrame {

    public JF_Principal ()  {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_citasMedicas = new javax.swing.JButton();
        pnl_principal = new javax.swing.JPanel();
        btn_medico = new javax.swing.JButton();
        btn_paciente1 = new javax.swing.JButton();
        btn_medico1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_citasMedicas.setText("Citas Medicas");
        btn_citasMedicas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_citasMedicasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_principalLayout = new javax.swing.GroupLayout(pnl_principal);
        pnl_principal.setLayout(pnl_principalLayout);
        pnl_principalLayout.setHorizontalGroup(
            pnl_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 808, Short.MAX_VALUE)
        );
        pnl_principalLayout.setVerticalGroup(
            pnl_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
        );

        btn_medico.setText("Medico");
        btn_medico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_medicoActionPerformed(evt);
            }
        });

        btn_paciente1.setText("Paciente");
        btn_paciente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_paciente1ActionPerformed(evt);
            }
        });

        btn_medico1.setText("Atencion Cliente");
        btn_medico1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_medico1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_citasMedicas, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(btn_medico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_paciente1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_medico1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(pnl_principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(btn_citasMedicas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_paciente1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_medico, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_medico1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_citasMedicasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_citasMedicasActionPerformed
        pnl_principal.removeAll();
        Pnl_CitaMedica panelCitasMedica = new Pnl_CitaMedica();
        pnl_principal.setLayout(new BorderLayout());
        pnl_principal.add(panelCitasMedica, BorderLayout.CENTER);
        pnl_principal.revalidate();
        pnl_principal.repaint();
        setVisible(true);
    }//GEN-LAST:event_btn_citasMedicasActionPerformed

    private void btn_medicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_medicoActionPerformed
        pnl_principal.removeAll();
        Pnl_GestionMedico panelGestorMedico = new Pnl_GestionMedico();
        pnl_principal.setLayout(new BorderLayout());
        pnl_principal.add(panelGestorMedico, BorderLayout.CENTER);
        pnl_principal.revalidate();
        pnl_principal.repaint();
        setVisible(true);
    }//GEN-LAST:event_btn_medicoActionPerformed

    private void btn_paciente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_paciente1ActionPerformed
        // TODO add your handling code here:
        
        pnl_principal.removeAll();
        Pnl_GestorPaciente panelGestorPaciente = new Pnl_GestorPaciente();
        pnl_principal.setLayout(new BorderLayout());
        pnl_principal.add(panelGestorPaciente, BorderLayout.CENTER);
        pnl_principal.revalidate();
        pnl_principal.repaint();
        setVisible(true);
    }//GEN-LAST:event_btn_paciente1ActionPerformed

    private void btn_medico1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_medico1ActionPerformed

        pnl_principal.removeAll();
        Pnl_AtencionMedica panelAtencionMedica = new Pnl_AtencionMedica();
        pnl_principal.setLayout(new BorderLayout());
        pnl_principal.add(panelAtencionMedica, BorderLayout.CENTER);
        pnl_principal.revalidate();
        pnl_principal.repaint();
        setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_medico1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JF_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            JF_Principal frame = new JF_Principal();
            frame.setVisible(true);
            // Centrar la ventana
            frame.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_citasMedicas;
    private javax.swing.JButton btn_medico;
    private javax.swing.JButton btn_medico1;
    private javax.swing.JButton btn_paciente1;
    private javax.swing.JPanel pnl_principal;
    // End of variables declaration//GEN-END:variables
}
