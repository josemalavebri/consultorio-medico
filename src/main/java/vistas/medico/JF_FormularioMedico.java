package vistas.medico;

import javax.swing.JOptionPane;

import controladores.Controller.ManagerController;
import controladores.Validador.MsgValidacion;
import controladores.Validador.TipoValidacion;
import controladores.Validador.Validador;
import modelos.Medico;
import utilidades.Table.RefreshTable.RefreshTable;
import vistas.IReceptorEntityJFrame;

public class JF_FormularioMedico extends javax.swing.JFrame implements IReceptorEntityJFrame<Medico> {

    private final ManagerController managerController;
    private final RefreshTable tableRefresh;

    private boolean isEdit = false;
    private Medico medico;

    public JF_FormularioMedico() {
        initComponents();
        managerController = ManagerController.getInstance();
        tableRefresh = RefreshTable.getInstance();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        txt_Cedula = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        lblApellido = new javax.swing.JLabel();
        btnResetear = new javax.swing.JButton();
        lblCedula1 = new javax.swing.JLabel();
        lblTelefono1 = new javax.swing.JLabel();
        cbx_Genero = new javax.swing.JComboBox<>();
        txtNombre = new javax.swing.JTextField();
        lblCedula2 = new javax.swing.JLabel();
        txt_Edad = new javax.swing.JTextField();
        cbx_especialidad = new javax.swing.JComboBox<>();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
                jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE));
        jDialog1Layout.setVerticalGroup(
                jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE));

        setMinimumSize(new java.awt.Dimension(330, 500));
        setPreferredSize(new java.awt.Dimension(600, 400));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Formulario");

        lblTelefono.setText("Telefono");

        lblCedula.setText("Cedula");

        txt_Cedula.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(
                null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.BOTTOM)));

        txtTelefono.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(
                null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.BOTTOM)));

        txtApellido.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(
                null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.BOTTOM)));

        lblNombre.setText("Nombre");

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        lblApellido.setText("Apellido");

        btnResetear.setText("Resetear");
        btnResetear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetearActionPerformed(evt);
            }
        });

        lblCedula1.setText("Especialidad");

        lblTelefono1.setText("Genero ");

        cbx_Genero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));

        txtNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(
                null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.BOTTOM)));

        lblCedula2.setText("Edad");

        txt_Edad.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(
                null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.BOTTOM)));

        cbx_especialidad.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Traumatologia", "Pediatria", "Cardiologia" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(lblCedula)
                                                                .addGap(93, 93, 93)
                                                                .addComponent(txt_Cedula))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(lblCedula2)
                                                                .addGap(104, 104, 104)
                                                                .addComponent(txt_Edad))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
                                                                .createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(lblApellido,
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lblNombre,
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lblTelefono,
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lblCedula1,
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lblTelefono1,
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(btnAceptar,
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                92,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(38, 38, 38)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                        .addComponent(txtApellido,
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(txtTelefono)
                                                                        .addComponent(cbx_Genero,
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                0, 102, Short.MAX_VALUE)
                                                                        .addComponent(btnResetear,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(txtNombre)
                                                                        .addComponent(cbx_especialidad, 0, 102,
                                                                                Short.MAX_VALUE)))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(62, 62, 62)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 143,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 30, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txt_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout.createSequentialGroup()
                                                        .addGap(14, 14, 14)
                                                        .addComponent(lblCedula)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblCedula2)
                                        .addComponent(txt_Edad, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNombre)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblApellido))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblTelefono1)
                                        .addComponent(cbx_Genero, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblTelefono))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblCedula1)
                                        .addComponent(cbx_especialidad, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnResetear, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(62, 62, 62)));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAceptarActionPerformed
        if (isEdit) {
            Medico medicoActualizado = getMedicoFormularioActualizado();
            boolean actualizadoExitoso = managerController.put(medicoActualizado);
            if (actualizadoExitoso) {
                JOptionPane.showMessageDialog(null, "Medico Actualizado con exito");
                tableRefresh.refrescarTodas();
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar Medico");
            }
        } else {
            Medico medico = getMedicoFormulario();
            boolean guadadoExitoso = managerController.post(medico);

            if (guadadoExitoso) {
                JOptionPane.showMessageDialog(null, "Medico guardado con exito");
                tableRefresh.refrescarTodas();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar Medico");
            }
        }

    }// GEN-LAST:event_btnAceptarActionPerformed

    private Medico getMedicoFormulario() {
        medico = new Medico();
        medico.setCedula(Integer.parseInt(txt_Cedula.getText()));
        medico.setNombre(txtNombre.getText());
        medico.setApellido(txtApellido.getText());
        medico.setEspecialidad(cbx_especialidad.getSelectedItem().toString());
        medico.setGenero(cbx_Genero.getSelectedItem().toString());
        medico.setEdad(Integer.parseInt(txt_Edad.getText()));
        medico.setTelefono(Integer.parseInt(txtTelefono.getText()));
        return medico;
    }

    private Medico getMedicoFormularioActualizado() {
        medico.setCedula(Integer.parseInt(txt_Cedula.getText()));
        medico.setNombre(txtNombre.getText());
        medico.setApellido(txtApellido.getText());
        medico.setEspecialidad(cbx_especialidad.getSelectedItem().toString());
        medico.setGenero(cbx_Genero.getSelectedItem().toString());
        medico.setEdad(Integer.parseInt(txt_Edad.getText()));
        medico.setTelefono(Integer.parseInt(txtTelefono.getText()));
        return medico;
    }

    private void btnResetearActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnResetearActionPerformed
        txt_Cedula.setText("");
        txt_Edad.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        cbx_especialidad.setSelectedIndex(0);
        cbx_Genero.setSelectedIndex(-1);
        txtTelefono.setText("");
    }// GEN-LAST:event_btnResetearActionPerformed

    private void llenarFormularioConObjeto(Medico medico) {
        if (medico != null) {
            String cedula = "" + medico.getCedula();
            String telefono = "" + medico.getTelefono();
            String edad = "" + medico.getEdad();
            txt_Cedula.setText(cedula);
            txt_Edad.setText(edad);
            txtNombre.setText(medico.getNombre());
            txtApellido.setText(medico.getApellido());
            txtTelefono.setText(telefono);

            if (!medico.getEspecialidad().equals("")) {
                if (medico.getEspecialidad().equalsIgnoreCase("Traumatologia")) {
                    cbx_especialidad.setSelectedItem("Traumatologia");
                } else if (medico.getEspecialidad().equalsIgnoreCase("Pediatria")) {
                    cbx_especialidad.setSelectedItem("Pediatria");
                } else if (medico.getEspecialidad().equalsIgnoreCase("Cardiologia")) {
                    cbx_especialidad.setSelectedItem("Cardiologia");
                }
            }

            if (!medico.getGenero().equals("")) {
                if (medico.getGenero().equalsIgnoreCase("Masculino")) {
                    cbx_Genero.setSelectedItem("Masculino");
                } else if (medico.getGenero().equalsIgnoreCase("Femenino")) {
                    cbx_Genero.setSelectedItem("Femenino");
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnResetear;
    private javax.swing.JComboBox<String> cbx_Genero;
    private javax.swing.JComboBox<String> cbx_especialidad;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCedula1;
    private javax.swing.JLabel lblCedula2;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTelefono1;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txt_Cedula;
    private javax.swing.JTextField txt_Edad;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setEntidad(Medico entidad) {
        btnAceptar.setText("Actualizar");
        this.isEdit = true;
        llenarFormularioConObjeto(entidad);
        this.medico = entidad;
    }
}
