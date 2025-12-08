package vistas.AtencionCliente;

import javax.swing.JFrame;
import modelos.AtencionMedica;
import utilidades.Table.ControlTable.ControlTable;


public class Pnl_AtencionMedica extends javax.swing.JPanel {

  private final ControlTable controlTable;
  
    public Pnl_AtencionMedica() {
        initComponents();
        controlTable = new ControlTable();

        llenarDatosTabla();
        controlTable.registrarTabla(AtencionMedica.class, tb_atencionMedica);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_atencionCliente = new javax.swing.JButton();
        Jl_atencionCliente = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_atencionMedica = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(808, 425));

        btn_atencionCliente.setText("Nuevo");
        btn_atencionCliente.setPreferredSize(new java.awt.Dimension(65, 23));
        btn_atencionCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atencionClienteActionPerformed(evt);
            }
        });

        Jl_atencionCliente.setText("Atencion Medica");

        tb_atencionMedica.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tb_atencionMedica);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(304, 304, 304)
                        .addComponent(btn_atencionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(Jl_atencionCliente)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btn_atencionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Jl_atencionCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_atencionClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atencionClienteActionPerformed
       JF_FormularioAtencionMedica formularioAtencionCliente = new JF_FormularioAtencionMedica();
       formularioAtencionCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       formularioAtencionCliente.setVisible(true);       
    }//GEN-LAST:event_btn_atencionClienteActionPerformed

    private void llenarDatosTabla(){
        controlTable.llenarTablaDatos(AtencionMedica.class , tb_atencionMedica);
        controlTable.eventosTabla(tb_atencionMedica, new JF_FormularioAtencionMedica());
    }

        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Jl_atencionCliente;
    private javax.swing.JButton btn_atencionCliente;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tb_atencionMedica;
    // End of variables declaration//GEN-END:variables
}
