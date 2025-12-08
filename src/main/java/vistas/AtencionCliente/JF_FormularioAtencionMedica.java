/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas.AtencionCliente;

import java.util.List;
import javax.swing.JOptionPane;

import controladores.Controller.ManagerController;
import controladores.Validador.Validador;
import modelos.AtencionMedica;
import modelos.CitaMedica;
import utilidades.ComboBox.ComboBoxControl;
import utilidades.Table.ControlTable.ControlTable;
import vistas.IReceptorEntityJFrame;

public class JF_FormularioAtencionMedica extends javax.swing.JFrame implements IReceptorEntityJFrame<AtencionMedica>{

    private boolean isEdit;
    private ControlTable controlTable;
    private ManagerController managerController;
    private ComboBoxControl comboBoxControl;
    private int idAtencionActualizar;
    private List<CitaMedica> citasMedicas;
    public JF_FormularioAtencionMedica() {
        initComponents();
        controlTable = new ControlTable();
        managerController = ManagerController.getInstance();
        comboBoxControl = new ComboBoxControl();
        llenarCitasMedicas();
        
        
    }

     private void llenarCitasMedicas() {
        citasMedicas = comboBoxControl.LlenarDatos(CitaMedica.class, cbx_citasMedicas);         
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_sintomas = new javax.swing.JTextField();
        txt_diagnostico = new javax.swing.JTextField();
        txt_recetas = new javax.swing.JTextField();
        btn_aceptar = new javax.swing.JButton();
        btn_resetear = new javax.swing.JButton();
        cbx_citasMedicas = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("   Citas Medicas");

        jLabel2.setText("  Observaciones");

        jLabel3.setText("    Receta");

        txt_sintomas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sintomasActionPerformed(evt);
            }
        });

        btn_aceptar.setText("Aceptar");
        btn_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptarActionPerformed(evt);
            }
        });

        btn_resetear.setText("Resetear");
        btn_resetear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetearActionPerformed(evt);
            }
        });

        cbx_citasMedicas.setBackground(new java.awt.Color(30, 30, 30));
        cbx_citasMedicas.setEditable(true);
        cbx_citasMedicas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("  Diagnostico");

        jLabel5.setText("Sintomas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(cbx_citasMedicas, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_sintomas, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_diagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(txt_recetas, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btn_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btn_resetear, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(cbx_citasMedicas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(txt_sintomas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(txt_diagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(txt_recetas, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_resetear, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptarActionPerformed
        if (!verificarCampos()) {
            return;
        }

        if (isEdit) {
            AtencionMedica atencionActualizada = actualizarAtencionDesdeFormulario();
            boolean actualizadoExitoso = managerController.put(atencionActualizada);

            if (actualizadoExitoso) {
                JOptionPane.showMessageDialog(null, "Atención médica actualizada con éxito");
                controlTable.refrescarTodasTablas();
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar la atención médica");
            }
        } else {
            AtencionMedica nuevaAtencion = generarAtencionNueva();
            boolean guardadoExitoso = managerController.post(nuevaAtencion);
            if(guardadoExitoso){
                JOptionPane.showMessageDialog(null, "Atención médica guardado con éxito");
                 controlTable.refrescarTodasTablas();
            }else{
                JOptionPane.showMessageDialog(null, "Atención médica no fue guardado con éxito");
            }
        }
    }//GEN-LAST:event_btn_aceptarActionPerformed

    private void btn_resetearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetearActionPerformed
        // TODO add your handling code here:
        txt_diagnostico.setText("");
        txt_recetas.setText("");
        txt_sintomas.setText("");
    }//GEN-LAST:event_btn_resetearActionPerformed

    private void txt_sintomasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sintomasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sintomasActionPerformed

    private boolean verificarCampos() {
        Validador validador = new Validador();
        validador.agregarCampo(txt_sintomas.getText(), "Ingrese los síntomas");
        validador.agregarCampo(txt_recetas.getText(), "Ingrese el diagnóstico");
        return validador.validarTodos();
    }

    private AtencionMedica generarAtencionNueva() {
        AtencionMedica atencion = new AtencionMedica(0); 
        return llenarAtencionDesdeFormulario(atencion);
    }

    private AtencionMedica actualizarAtencionDesdeFormulario() {
        AtencionMedica atencion = new AtencionMedica(this.idAtencionActualizar);
        return llenarAtencionDesdeFormulario(atencion);
    }
    

    private AtencionMedica llenarAtencionDesdeFormulario(AtencionMedica atencion) {
        int indexCitaSeleccionada = cbx_citasMedicas.getSelectedIndex();
        atencion.citaMedica = citasMedicas.get(indexCitaSeleccionada);
        atencion.sintomas = txt_sintomas.getText();
        atencion.diagnostico = txt_diagnostico.getText();
        atencion.receta = txt_recetas.getText();
        return atencion;
    }

    @Override
    public void setEntidad(AtencionMedica entidad) {
        isEdit = true;
        btn_aceptar.setText("Actualizar");
        rellenarFormulario(entidad);
        idAtencionActualizar =  entidad.getId();
    }
    
    private void rellenarFormulario(AtencionMedica entidad){
        cbx_citasMedicas.setEnabled(false);
        txt_diagnostico.setText(entidad.diagnostico);
        txt_recetas.setText(entidad.receta);
        txt_sintomas.setText(entidad.sintomas);
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_aceptar;
    private javax.swing.JButton btn_resetear;
    private javax.swing.JComboBox<String> cbx_citasMedicas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txt_diagnostico;
    private javax.swing.JTextField txt_recetas;
    private javax.swing.JTextField txt_sintomas;
    // End of variables declaration//GEN-END:variables
}
