package vistas.paciente;

import javax.swing.JOptionPane;

import controladores.Controller.ManagerController;
import modelos.Paciente;
import utilidades.Table.RefreshTable.RefreshTable;
import vistas.IReceptorEntityJFrame;

public class JF_FormularioPaciente extends javax.swing.JFrame implements IReceptorEntityJFrame<Paciente> {
    private final ManagerController managerController;
    private final RefreshTable tableRefresh;
    private boolean isEdit = false;
    private Paciente paciente;

    public JF_FormularioPaciente() {
        initComponents();
        managerController = ManagerController.getInstance();
        tableRefresh = RefreshTable.getInstance();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtEdad = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        lblCedula = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        lblApellido = new javax.swing.JLabel();
        btnResetear = new javax.swing.JButton();
        lblEdad = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        lblTelefono1 = new javax.swing.JLabel();
        cbx_Genero = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtEdad.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(
                null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.BOTTOM)));

        txtCorreo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(
                null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.BOTTOM)));

        lblCedula.setText("Cedula");

        txtTelefono.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(
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

        lblEdad.setText("Edad");

        lblCorreo.setText("Correo");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Formulario");

        lblTelefono.setText("Telefono");

        txtCedula.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(
                null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.BOTTOM)));

        txtNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(
                null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.BOTTOM)));

        txtApellido.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(
                null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.BOTTOM)));

        lblTelefono1.setText("Genero ");

        cbx_Genero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addComponent(lblCedula)
                                                .addGap(43, 43, 43)
                                                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 93,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addComponent(lblNombre)
                                                .addGap(36, 36, 36)
                                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 93,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addComponent(lblApellido)
                                                .addGap(36, 36, 36)
                                                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 93,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addComponent(lblEdad)
                                                .addGap(54, 54, 54)
                                                .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 93,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addComponent(lblCorreo)
                                                .addGap(44, 44, 44)
                                                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 93,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 97,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(23, 23, 23)
                                                .addComponent(btnResetear, javax.swing.GroupLayout.PREFERRED_SIZE, 92,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblTelefono)
                                                        .addComponent(lblTelefono1))
                                                .addGap(34, 34, 34)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(cbx_Genero,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 101,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtTelefono,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 93,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(36, 36, 36))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(lblCedula))
                                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblNombre)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblApellido)
                                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblEdad)
                                        .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblCorreo)
                                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addComponent(lblTelefono1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cbx_Genero, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblTelefono)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnResetear, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAceptarActionPerformed

        if (isEdit) {
            Paciente pacienteActualizado = getPacienteFormularioActualizado();
            boolean actualizadoExitoso = managerController.put(pacienteActualizado);
            if (actualizadoExitoso) {
                JOptionPane.showMessageDialog(null, "Paciente Actualizado con exito");
                tableRefresh.refrescarTodas();
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar paciente");
            }
        } else {
            Paciente paciente = getPacienteFormulario();
            boolean guadadoExitoso = managerController.post(paciente);

            if (guadadoExitoso) {
                JOptionPane.showMessageDialog(null, "Paciente guardado con exito");
                tableRefresh.refrescarTodas();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar paciente");
            }
        }
    }// GEN-LAST:event_btnAceptarActionPerformed

    private Paciente getPacienteFormularioActualizado() {
        paciente.setCedula(Integer.parseInt(txtCedula.getText()));
        paciente.setNombre(txtNombre.getText());
        paciente.setApellido(txtApellido.getText());
        paciente.setEdad(Integer.parseInt(txtEdad.getText()));
        paciente.setCorreo(txtCorreo.getText());
        paciente.setTelefono(Integer.parseInt(txtTelefono.getText()));
        paciente.setGenero(cbx_Genero.getSelectedItem().toString());
        return paciente;
    }

    private Paciente getPacienteFormulario() {
        paciente = new Paciente();

        if (txtCedula.getText().trim().isEmpty()) {
            paciente.setCedula(0);
        } else {
            paciente.setCedula(Integer.parseInt(txtCedula.getText().trim()));
        }

        if (txtEdad.getText().trim().isEmpty()) {
            paciente.setEdad(0);
        } else {
            paciente.setEdad(Integer.parseInt(txtEdad.getText().trim()));
        }

        if (txtTelefono.getText().trim().isEmpty()) {
            paciente.setTelefono(0);
        } else {
            paciente.setTelefono(Integer.parseInt(txtTelefono.getText().trim()));
        }

        paciente.setNombre(txtNombre.getText().trim());
        paciente.setApellido(txtApellido.getText().trim());
        paciente.setCorreo(txtCorreo.getText().trim());
        paciente.setGenero(cbx_Genero.getSelectedItem().toString());

        return paciente;
    }

    private void llenarFormularioConObjeto(Paciente paciente) {
        if (paciente != null) {
            txtCedula.setText(String.valueOf(paciente.getCedula()));
            txtEdad.setText(String.valueOf(paciente.getEdad()));
            txtNombre.setText(paciente.getNombre());
            txtApellido.setText(paciente.getApellido());
            txtCorreo.setText(paciente.getCorreo());
            txtTelefono.setText(String.valueOf(paciente.getTelefono()));

            // Buscar el índice correspondiente al género
            for (int i = 0; i < cbx_Genero.getItemCount(); i++) {
                if (cbx_Genero.getItemAt(i).equalsIgnoreCase(paciente.getGenero())) {
                    cbx_Genero.setSelectedIndex(i);
                    break;
                }
            }
        }
    }

    private void btnResetearActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnResetearActionPerformed
        txtCedula.setText("");
        txtEdad.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
        cbx_Genero.setSelectedIndex(0);
    }// GEN-LAST:event_btnResetearActionPerformed
     // Variables declaration - do not modify//GEN-BEGIN:variables

    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnResetear;
    private javax.swing.JComboBox<String> cbx_Genero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTelefono1;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setEntidad(Paciente entidad) {
        btnAceptar.setText("Actualizar");
        this.isEdit = true;
        llenarFormularioConObjeto(entidad);
        this.paciente = entidad;
    }
}
