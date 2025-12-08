package vistas.citasMedicas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import controladores.Controller.ManagerController;
import controladores.Validador.MsgValidacion;
import controladores.Validador.Validador;
import modelos.BaseEntity;
import modelos.CitaMedica;
import modelos.Medico;
import modelos.Paciente;
import modelos.Turno;
import utilidades.ComboBox.ComboBoxControl;
import utilidades.Table.ControlTable.ControlTable;
import utilidades.Table.CreateTable.ObjectTableModel;
import vistas.IReceptorEntityJFrame;

public class JF_NuevaCitaMedica extends javax.swing.JFrame implements IReceptorEntityJFrame<CitaMedica> {
    private ArrayList<Medico> listaMedicos;
    private ArrayList<Paciente> listaPacientes;
    private ControlTable controlTable;
    private ComboBoxControl comboControl;
    private boolean isEdit;
    private ManagerController managerController;
    private int idCitaMedicaActualizar = 0;
    private Turno turnoSeleccionado;

    public JF_NuevaCitaMedica() {
        initComponents();
        inicializarComponentesLogicos();
        cargarDatosComboBox();
        mostrarTurnosEnTabla();
        eventoClickFila();

    }

    private void mostrarTurnosEnTabla() {
        controlTable.llenarTablaDatos(Turno.class, tb_turnos);
    }

    private void inicializarComponentesLogicos() {
        comboControl = new ComboBoxControl();
        controlTable = new ControlTable();
        managerController = ManagerController.getInstance();
    }

    private void cargarDatosComboBox() {
        listaMedicos = (ArrayList<Medico>) comboControl.LlenarDatos(Medico.class, cbx_medicos);
        listaPacientes = (ArrayList<Paciente>) comboControl.LlenarDatos(Paciente.class, cbx_paciente);
    }

    private void eventoClickFila() {
        tb_turnos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = tb_turnos.getSelectedRow();
                if (fila != -1) { // -1 significa que no hay fila seleccionada
                    ObjectTableModel modeloTablaTurno = (ObjectTableModel) tb_turnos.getModel();
                    Turno turno = (Turno) modeloTablaTurno.getObjetoAt(fila);
                    txt_turnoSeleccionado.setText(turno.getFecha() + " - " + turno.getHora());
                    turnoSeleccionado = turno;
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbx_paciente = new javax.swing.JComboBox<>();
        btn_resetear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_turnos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        btn_guardar1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txta_descripcion = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbx_medicos = new javax.swing.JComboBox<>();
        txt_turnoSeleccionado = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbx_paciente.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn_resetear.setText("Resetear");
        btn_resetear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetearActionPerformed(evt);
            }
        });

        tb_turnos.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null }
                },
                new String[] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }));
        jScrollPane1.setViewportView(tb_turnos);

        jLabel5.setText("Turnos:");

        btn_guardar1.setText("Guardar");
        btn_guardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardar1ActionPerformed(evt);
            }
        });

        txta_descripcion.setColumns(20);
        txta_descripcion.setRows(5);
        jScrollPane2.setViewportView(txta_descripcion);

        jLabel3.setText("Paciente:");

        jLabel2.setText("Medicos:");

        jLabel4.setText("Descripcion");

        cbx_medicos.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txt_turnoSeleccionado.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 554,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(jLabel4)
                                                                        .addComponent(jLabel5))
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(61, 61, 61)
                                                                                .addGroup(layout.createParallelGroup(
                                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                                        false)
                                                                                        .addComponent(jScrollPane2,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                298,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addGroup(layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(layout
                                                                                                        .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addComponent(
                                                                                                                cbx_medicos,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                161,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addComponent(
                                                                                                                cbx_paciente,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                161,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addPreferredGap(
                                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                        Short.MAX_VALUE)
                                                                                                .addComponent(
                                                                                                        btn_resetear,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                        105,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(113, 113, 113)
                                                                                .addComponent(txt_turnoSeleccionado,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        165,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btn_guardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 105,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(cbx_paciente,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(cbx_medicos,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(btn_resetear, javax.swing.GroupLayout.PREFERRED_SIZE, 55,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jScrollPane2,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11,
                                                        Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btn_guardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 55,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(31, 31, 31)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(txt_turnoSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_resetearActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_resetearActionPerformed
        cbx_paciente.setSelectedIndex(0);
        cbx_medicos.setSelectedIndex(0);
        txta_descripcion.setText("");
        txt_turnoSeleccionado.setText("Turno Seleccionado");
    }// GEN-LAST:event_btn_resetearActionPerformed

    private void btn_guardar1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_guardar1ActionPerformed
        if (isEdit) {
            actualizarCitaMedica();
            controlTable.refrescarTodasTablas();
        } else {
            guardarCitaMedica();
            controlTable.refrescarTodasTablas();
        }
    }// GEN-LAST:event_btn_guardar1ActionPerformed

    private void actualizarCitaMedica() {
        CitaMedica citaMedica = actualizarCitaDesdeFormulario();
        if (managerController.put(citaMedica)) {
            JOptionPane.showMessageDialog(null, "CitaMedica actualizada con exito");
        } else {
            JOptionPane.showMessageDialog(null, "CitaMedica no fue actualizada con exito");
        }
    }

    private void guardarCitaMedica() {

        CitaMedica citaMedica = generarCitaNueva();
        boolean guadadoExitoso = managerController.post(citaMedica);

        if (guadadoExitoso) {
            JOptionPane.showMessageDialog(null, "Cita Medica guardada con exito");
        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar la cita médica");
        }
    }

    private CitaMedica generarCitaNueva() {
        CitaMedica citaMedica = new CitaMedica();
        return llenarCitaDesdeFormulario(citaMedica);
    }

    private CitaMedica actualizarCitaDesdeFormulario() {
        CitaMedica citaMedica = new CitaMedica();
        citaMedica.setId(this.idCitaMedicaActualizar);
        return llenarCitaDesdeFormulario(citaMedica);
    }

    private CitaMedica llenarCitaDesdeFormulario(CitaMedica citaMedica) {
        int indexSeleccionadoMedico = cbx_medicos.getSelectedIndex();
        int indexSeleccionadoPaciente = cbx_paciente.getSelectedIndex();
        citaMedica.setMedico(listaMedicos.get(indexSeleccionadoMedico));
        citaMedica.setPaciente(listaPacientes.get(indexSeleccionadoPaciente));
        citaMedica.setDescripcion(txta_descripcion.getText());
        citaMedica.setTurno(turnoSeleccionado);
        return citaMedica;
    }

    @Override
    public void setEntidad(CitaMedica entidad) {
        int idMedico = entidad.getMedico().getId();
        int idPaciente = entidad.getPaciente().getId();
        int indiceMedico = obtenerIndicePorId(idMedico, listaMedicos);
        int indicePaciente = obtenerIndicePorId(idPaciente, listaPacientes);

        cbx_medicos.setSelectedIndex(indiceMedico);
        cbx_paciente.setSelectedIndex(indicePaciente);
        txta_descripcion.setText(entidad.getDescripcion());
        isEdit = true;
        btn_guardar1.setText("Actualizar");
        this.idCitaMedicaActualizar = entidad.getId();
    }

    private <T extends BaseEntity> int obtenerIndicePorId(int idEntidad, List<T> entidadesLista) {
        for (int i = 0; i < entidadesLista.size(); i++) {
            if (entidadesLista.get(i).getId() == idEntidad)
                return i;
        }
        return -1;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_guardar1;
    private javax.swing.JButton btn_resetear;
    private javax.swing.JComboBox<String> cbx_medicos;
    private javax.swing.JComboBox<String> cbx_paciente;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tb_turnos;
    private javax.swing.JTextField txt_turnoSeleccionado;
    private javax.swing.JTextArea txta_descripcion;
    // End of variables declaration//GEN-END:variables

}
