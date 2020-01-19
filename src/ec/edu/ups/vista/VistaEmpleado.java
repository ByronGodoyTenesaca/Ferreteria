package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorCargo;
import ec.edu.ups.controlador.ControladorEmpleado;
import ec.edu.ups.modelo.Cargo;
import ec.edu.ups.modelo.Empleado;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ronal
 */
public class VistaEmpleado extends javax.swing.JInternalFrame {

    private ControladorEmpleado controladorEmpleado;
    private ControladorCargo controladorCargo;
    private Empleado empleado;
    private List<Cargo> lista;
    private int codigo;

    public VistaEmpleado(ControladorEmpleado controlador, ControladorCargo controladorCargo) {
        initComponents();
        this.controladorEmpleado = controlador;
        this.controladorCargo=controladorCargo;
        lista=new ArrayList<>();
        llenarCargo();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Genero = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblCedula = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        lblApellido = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblContraseña = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JTextField();
        lblCargo = new javax.swing.JLabel();
        lblCelular = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        lblCelular1 = new javax.swing.JLabel();
        rbtnMasculino = new javax.swing.JRadioButton();
        rbtnFemenino = new javax.swing.JRadioButton();
        lblEmail1 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        lblBuscarE = new javax.swing.JLabel();
        lblBuscarE1 = new javax.swing.JLabel();
        txtValorBuscar = new javax.swing.JTextField();
        cbxBuscar = new javax.swing.JComboBox<>();
        cbxCargo = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
            .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información Empleado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        lblCedula.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCedula.setText("Cédula/Ruc :");

        lblNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNombre.setText("Nombre :");

        lblApellido.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblApellido.setText("Apellido :");

        lblEmail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblEmail.setText("E-mail :");

        lblContraseña.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblContraseña.setText("Contraseña :");

        lblCargo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCargo.setText("Cargo :");

        lblCelular.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCelular.setText("Telefono:");

        lblCelular1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCelular1.setText("Género :");

        Genero.add(rbtnMasculino);
        rbtnMasculino.setText("Masculino");

        Genero.add(rbtnFemenino);
        rbtnFemenino.setText("Femenino");

        lblEmail1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblEmail1.setText("Dirección :");

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblBuscarE.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblBuscarE.setText("Buscar por :");

        lblBuscarE1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblBuscarE1.setText("Valor a buscar :");

        txtValorBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtValorBuscarKeyPressed(evt);
            }
        });

        cbxBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escoja una Opcion", "Nombre", "Cedula", "Puesto Trabajo" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBuscarE1)
                            .addComponent(lblBuscarE, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtValorBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                            .addComponent(cbxBuscar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblBuscarE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBuscarE1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtValorBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cbxCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escoja una opcion" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCedula)
                    .addComponent(lblNombre)
                    .addComponent(lblApellido)
                    .addComponent(lblEmail)
                    .addComponent(lblEmail1))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                            .addComponent(txtNombre)
                            .addComponent(txtApellido)
                            .addComponent(txtEmail))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCelular)
                                    .addComponent(lblCelular1))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addComponent(rbtnMasculino)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbtnFemenino))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblContraseña)
                                    .addComponent(lblCargo))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                    .addComponent(cbxCargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(6, 6, 6))
                    .addComponent(txtDireccion))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCedula)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblContraseña)
                            .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre)
                            .addComponent(lblCargo)
                            .addComponent(cbxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblApellido)
                            .addComponent(lblCelular)
                            .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmail)
                            .addComponent(lblCelular1)
                            .addComponent(rbtnMasculino)
                            .addComponent(rbtnFemenino))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmail1)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cédula/Ruc", "Nombre", "Apellido", "E-mail", "Contraseña", "Cargo", "Celular", "Género", "Dirección"
            }
        ));
        tblEmpleados.setRowHeight(30);
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpleados);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(309, 309, 309))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        
        limpiar();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        Empleado e = new Empleado();
        e.setCedula(txtCedula.getText());
        e.setNombres(txtNombre.getText());
        e.setApellidos(txtApellido.getText());
        e.setEmail(txtEmail.getText());
        e.setDireccion(txtDireccion.getText());
        e.setContraseña(txtContrasena.getText());
        e.setCargo(BuscarCargo((String)cbxCargo.getSelectedItem()));
        e.setTelefono(txtCelular.getText());
        String genero="";
        if(rbtnFemenino.isSelected()){
           genero = "Femenino";
       }else{
           genero = "Masculino";
       }
        e.setGenero(genero);
        controladorEmpleado.crear(e);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
       
        Empleado e = new Empleado();
        e.setCedula(txtCedula.getText());
        e.setNombres(txtNombre.getText());
        e.setApellidos(txtApellido.getText());
        e.setEmail(txtEmail.getText());
        e.setDireccion(txtDireccion.getText());
        e.setContraseña(txtContrasena.getText());
        e.setCargo(BuscarCargo((String)cbxCargo.getSelectedItem()));
        e.setTelefono(txtCelular.getText());
        String genero="";
        if(rbtnFemenino.isSelected()){
           genero = "Femenino";
       }else{
           genero = "Masculino";
       }
        e.setGenero(genero);
        e.setCodigo(codigo);
        controladorEmpleado.actualizar(e);
        if((String)cbxBuscar.getSelectedItem()=="Cedula"){
                buscarCedula();
            }else if((String)cbxBuscar.getSelectedItem()=="Nombre"){
                BuscarNombre();
            }else{
                BuscarPuesto();
            }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        controladorEmpleado.eliminar(codigo);
        if((String)cbxBuscar.getSelectedItem()=="Cedula"){
                buscarCedula();
            }else if((String)cbxBuscar.getSelectedItem()=="Nombre"){
                BuscarNombre();
            }else{
                BuscarPuesto();
            }
        limpiar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtValorBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorBuscarKeyPressed
        if(evt.getKeyCode()==10){
            if((String)cbxBuscar.getSelectedItem()=="Cedula"){
                buscarCedula();
            }else if((String)cbxBuscar.getSelectedItem()=="Nombre"){
                BuscarNombre();
            }else{
                BuscarPuesto();
            }
        }
    }//GEN-LAST:event_txtValorBuscarKeyPressed

    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked
        int seleccion =tblEmpleados.getSelectedRow();
        codigo=(int) tblEmpleados.getValueAt(seleccion, 0);
        txtApellido.setText(String.valueOf(tblEmpleados.getValueAt(seleccion, 3)));
        txtCedula.setText(String.valueOf(tblEmpleados.getValueAt(seleccion, 1)));
        txtCelular.setText(String.valueOf(tblEmpleados.getValueAt(seleccion, 7)));
        txtContrasena.setText(String.valueOf(tblEmpleados.getValueAt(seleccion, 5)));
        txtDireccion.setText(String.valueOf(tblEmpleados.getValueAt(seleccion, 9)));
        txtEmail.setText(String.valueOf(tblEmpleados.getValueAt(seleccion, 4)));
        txtNombre.setText(String.valueOf(tblEmpleados.getValueAt(seleccion, 2)));
        cbxCargo.setSelectedItem(tblEmpleados.getValueAt(seleccion, 6));
        if (tblEmpleados.getValueAt(seleccion, 9)=="Masculino"){
            rbtnMasculino.setSelected(false);
            rbtnFemenino.setSelected(true);
        }else{
             rbtnMasculino.setSelected(true);
            rbtnFemenino.setSelected(false);
        }
                
    }//GEN-LAST:event_tblEmpleadosMouseClicked

    public void buscarCedula(){
        Empleado e=controladorEmpleado.buscarXCedula(txtValorBuscar.getText());
        DefaultTableModel modelo= (DefaultTableModel) tblEmpleados.getModel();
        modelo.setRowCount(0);
       Object[] dato ={
           e.getCodigo(),
           e.getCedula(),
           e.getNombres(),
           e.getApellidos(),
           e.getEmail(),
           e.getContraseña(),
           BuscarCargoN(e.getCargo()),
           e.getTelefono(),
           e.getGenero(),
           e.getDireccion()
       };
       modelo.addRow(dato);
    }
    
    public void BuscarNombre(){
        List<Empleado> lista=controladorEmpleado.buscarXNombre(txtValorBuscar.getText());
        DefaultTableModel modelo= (DefaultTableModel) tblEmpleados.getModel();
        modelo.setRowCount(0);
        for (Empleado e : lista) {
           Object[] dato ={
           e.getCodigo(),
           e.getCedula(),
           e.getNombres(),
           e.getApellidos(),
           e.getEmail(),
           e.getContraseña(),
           BuscarCargoN(e.getCargo()),
           e.getTelefono(),
           e.getGenero(),
           e.getDireccion()
           };
           modelo.addRow(dato);
        }
    }
    
    public void BuscarPuesto(){
        List<Empleado> lista=controladorEmpleado.buscarXTrabajo(BuscarCargo(txtValorBuscar.getText()));
        DefaultTableModel modelo= (DefaultTableModel) tblEmpleados.getModel();
        modelo.setRowCount(0);
        for (Empleado e : lista) {
           Object[] dato ={
           e.getCodigo(),
           e.getCedula(),
           e.getNombres(),
           e.getApellidos(),
           e.getEmail(),
           e.getContraseña(),
           BuscarCargoN(e.getCargo()),
           e.getTelefono(),
           e.getGenero(),
           e.getDireccion()
           };
           modelo.addRow(dato);
        }
    }
    
    
    public void llenarCargo(){
        List<Cargo> lista=controladorCargo.listar();
        this.lista=lista;
        for (Cargo c : lista) {
            cbxCargo.addItem(c.getCargo());
        }
    }
    public String BuscarCargoN(int Cargo){
        for (Cargo c : lista) {
            
            if(Cargo==c.getCodigo()){
                
                return c.getCargo();
            }
        }
        return null;
    }
    
    public int BuscarCargo(String Cargo){
        for (Cargo c : lista) {
            
            if(Cargo.equals(c.getCargo()) ){
                System.out.println(c.getCodigo());
                return c.getCodigo();
            }
        }
        return 0;
    }
    public void limpiar() {
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtCelular.setText("");
        txtEmail.setText("");
        txtContrasena.setText("");
        txtDireccion.setText("");
        Genero.clearSelection();
        cbxCargo.setSelectedIndex(0); 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Genero;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxBuscar;
    private javax.swing.JComboBox<String> cbxCargo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblBuscarE;
    private javax.swing.JLabel lblBuscarE1;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblCelular1;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmail1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JRadioButton rbtnFemenino;
    private javax.swing.JRadioButton rbtnMasculino;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtValorBuscar;
    // End of variables declaration//GEN-END:variables
}
