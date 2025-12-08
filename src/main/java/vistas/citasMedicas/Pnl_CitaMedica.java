package vistas.citasMedicas;

import javax.swing.JFrame;
import modelos.CitaMedica;
import utilidades.Table.ControlTable.ControlTable;
import vistas.IReceptorEntityJFrame;

public class Pnl_CitaMedica extends javax.swing.JPanel {
    
    private ControlTable controlTable = new ControlTable();
    
    public Pnl_CitaMedica() {
        initComponents();
        llenarDatosTablaInstanciarMetodo();
        controlTable.registrarTabla(CitaMedica.class, tb_citasMedicas);
    }
    
    
    private void llenarDatosTablaInstanciarMetodo(){
        controlTable.llenarTablaDatos(CitaMedica.class, tb_citasMedicas);
        IReceptorEntityJFrame frame = new JF_NuevaCitaMedica();
        controlTable.eventosTabla(tb_citasMedicas, frame);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_citasMedicas = new javax.swing.JTable();
        btn_nuevaCita = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(808, 425));

        jLabel1.setText("Citas Registradas:");

        tb_citasMedicas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tb_citasMedicas);

        btn_nuevaCita.setText("Nueva Cita");
        btn_nuevaCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevaCitaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 762, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addComponent(btn_nuevaCita, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btn_nuevaCita, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void btn_nuevaCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevaCitaActionPerformed
       JFrame jframe = new JF_NuevaCitaMedica();
       jframe.setLocationRelativeTo(null);
       jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       jframe.setVisible(true);
    }//GEN-LAST:event_btn_nuevaCitaActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_nuevaCita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_citasMedicas;
    // End of variables declaration//GEN-END:variables
 
}
