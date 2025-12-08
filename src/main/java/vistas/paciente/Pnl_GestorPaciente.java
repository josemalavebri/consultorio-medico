package vistas.paciente;

import javax.swing.JFrame;
import modelos.Paciente;
import utilidades.Table.ControlTable.ControlTable;

public class Pnl_GestorPaciente extends javax.swing.JPanel {
    
    private final ControlTable controlTable;
    
    public Pnl_GestorPaciente() {
        initComponents();
        controlTable = new ControlTable();
        llenarDatosTabla();
        controlTable.registrarTabla(Paciente.class,tb_paciente);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_nuevo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_paciente = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(808, 425));
        setMinimumSize(new java.awt.Dimension(808, 425));
        setPreferredSize(new java.awt.Dimension(808, 425));

        btn_nuevo.setText("Nuevo");
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });

        tb_paciente.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_paciente.setMaximumSize(new java.awt.Dimension(300, 80));
        tb_paciente.setMinimumSize(new java.awt.Dimension(300, 80));
        jScrollPane1.setViewportView(tb_paciente);

        jLabel1.setText("Pacientes Agregados:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(299, 299, 299)
                        .addComponent(btn_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btn_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        JF_FormularioPaciente formularioPaciente = new JF_FormularioPaciente();
        formularioPaciente.setLocationRelativeTo(null);
        formularioPaciente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        formularioPaciente.setVisible(true);
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void llenarDatosTabla(){
        controlTable.llenarTablaDatos(Paciente.class , tb_paciente);
        controlTable.eventosTabla(tb_paciente, new JF_FormularioPaciente());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_paciente;
    // End of variables declaration//GEN-END:variables
}