package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorCategoria;
import ec.edu.ups.controlador.ControladorMedida;
import ec.edu.ups.controlador.ControladorProducto;
import ec.edu.ups.controlador.ControladorProductoProveedor;
import ec.edu.ups.controlador.ControladorProveedor;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Medida;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.modelo.ProductoProveedor;
import ec.edu.ups.modelo.Proveedor;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Productos extends javax.swing.JInternalFrame {

    private ControladorCategoria controladorCategoria;
    private ControladorMedida controladorMedida;
    private ControladorProducto controladorProducto;
    private ControladorProveedor controladorProveedor;
    private ControladorProductoProveedor cpp;
    private List<Medida>listaMedida;
    private List<Categoria>listaCategoria;
    private List<Proveedor>listaProveedor;
    private List<ProductoProveedor>listaPP;
    private int codigo;
    public Productos(ControladorCategoria controladorCategoria,ControladorMedida controladorMedida,ControladorProducto controladorProducto,ControladorProveedor controladorProveedor,ControladorProductoProveedor cpp) {
        initComponents();
        this.controladorCategoria=controladorCategoria;
        this.controladorMedida=controladorMedida;
        this.controladorProducto=controladorProducto;
        this.controladorProveedor=controladorProveedor;
        this.cpp=cpp;
        llenarMedida();
        llenarCategoria();
        llenarProveedor();
        llenarProductoProveedor();
    }

    public void llenarProductoProveedor(){
        listaPP=cpp.listar();
    }
    public void llenarCategoria(){
       List<Categoria> lista= controladorCategoria.Listar();
       listaCategoria=lista;
        for (Categoria c : lista) {
            cbxCategoria.addItem(c.getCategoria());
        }
    }
    
    public void llenarProveedor(){
       List<Proveedor>lista=controladorProveedor.listar();
       listaProveedor=lista;
        for (Proveedor p : lista) {
            cbxProveedor.addItem(p.getNombres());
        }
    }
    
    public void llenarMedida(){
        List<Medida> lista=controladorMedida.Listar();
        listaMedida=lista;
        for (Medida m : lista) {
            cbxMedida.addItem(m.getTipo());
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbtnIva = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnIngresar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        cbxCategoria = new javax.swing.JComboBox<>();
        txtNombre = new javax.swing.JTextField();
        cbxProveedor = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtPrecioCompra = new javax.swing.JTextField();
        txtPrecioVenta = new javax.swing.JTextField();
        cbxMedida = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cbxFabricacion = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        rbtSi = new javax.swing.JRadioButton();
        rbtNo = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cbxBuscar = new javax.swing.JComboBox<>();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new javax.swing.JTable();

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

        btnIngresar.setText("Ingresar Stock");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
            .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Informacion Producto"));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Categoria:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 14, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Nombre:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 54, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Proveedor:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Descripcion:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 149, -1, -1));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 149, 362, 70));

        cbxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elija una Opcion" }));
        jPanel3.add(cbxCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 15, 258, 30));
        jPanel3.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 56, 350, 30));

        cbxProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elija una Opcion" }));
        cbxProveedor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxProveedorItemStateChanged(evt);
            }
        });
        jPanel3.add(cbxProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 104, 266, 36));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("Cantidad:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("Precio Compra:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("Medida");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setText("Empresa:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setText("Origen de Fabricacion:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(484, 189, -1, -1));
        jPanel3.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(573, 14, 130, 25));
        jPanel3.add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 150, 30));
        jPanel3.add(txtPrecioCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 47, 80, 30));
        jPanel3.add(txtPrecioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, 80, 30));

        cbxMedida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elija una Opcion" }));
        jPanel3.add(cbxMedida, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, 160, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel11.setText("Precio Venta:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, -1, -1));

        cbxFabricacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elija una Opcion", "Nacional", "Extranjero" }));
        jPanel3.add(cbxFabricacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 190, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Tiene iva:");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        rbtnIva.add(rbtSi);
        rbtSi.setText("Si");
        jPanel3.add(rbtSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, -1, -1));

        rbtnIva.add(rbtNo);
        rbtNo.setText("No");
        jPanel3.add(rbtNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, -1, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel10.setText("Buscar por:");

        cbxBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elija una Opcion", "Empresa", "Producto", "Categoria" }));

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel10))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxBuscar, 0, 182, Short.MAX_VALUE)
                            .addComponent(txtBuscar))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(cbxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))
                .addContainerGap())
        );

        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Categoria", "Nombre", "Empresa", "Cantidad", "Precio Compra", "Precio Venta", "Proveedor", "Descripcion", "Lugar Fabricacion", "Iva", "Medida"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblProducto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed

        txtBuscar.setText("");
        txtCantidad.setText("");
        txtDescripcion.setText("");
        txtMarca.setText("");
        txtNombre.setText("");
        txtPrecioCompra.setText("");
        txtPrecioVenta.setText("");
        cbxCategoria.setSelectedIndex(0);
        cbxBuscar.setSelectedIndex(0);
        cbxFabricacion.setSelectedIndex(0);
        cbxMedida.setSelectedIndex(0);
        cbxProveedor.setSelectedIndex(0);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        Producto p=new Producto();
        ProductoProveedor pp=new ProductoProveedor();
        p.setCantidad(Integer.parseInt(txtCantidad.getText()));
        p.setDescripcion(txtDescripcion.getText());
        p.setLugarFabricacion((String)cbxFabricacion.getSelectedItem());
        p.setNombre(txtNombre.getText());
        p.setPrecioCompra(Double.parseDouble(txtPrecioCompra.getText()));
        p.setPrecioVenta(Double.parseDouble(txtPrecioVenta.getText()));
        if(rbtSi.isSelected()){
            p.setIva(true);
        }else{
            p.setIva(false);
        }
        for (Medida m : listaMedida) {
            if(m.getTipo()== (String)cbxMedida.getSelectedItem()){
                p.setCodigoMedida(m.getCodigo());
                break;
            }
        }
        
        for (Categoria c : listaCategoria) {
            if(c.getCategoria()==(String)cbxCategoria.getSelectedItem()){
                p.setCodigoCategoria(c.getCodigo());
            }
        }

        controladorProducto.Crear(p);
        
        pp.setCantidad(Integer.parseInt(txtCantidad.getText()));
        pp.setCodigoProducto(controladorProducto.buscarcodproducto(txtNombre.getText()));
        pp.setCodigoProveedor(buscarCodigoProv());
        cpp.CrearProductoProveedor(pp);
        
        btnNuevoActionPerformed(evt);
    }//GEN-LAST:event_btnGuardarActionPerformed

    public int buscarCodigoProv(){
        int codigo=0;
        for (Proveedor p : listaProveedor) {
            if(p.getNombres()==(String)cbxProveedor.getSelectedItem()){
                codigo=p.getCodigo();
                break;
            }
            
        }
        return codigo;
    }
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        
        Producto p=new Producto();
        p.setCodigo(codigo);
        p.setCantidad(Integer.parseInt(txtCantidad.getText()));
        p.setDescripcion(txtDescripcion.getText());
        p.setLugarFabricacion((String)cbxFabricacion.getSelectedItem());
        p.setNombre(txtNombre.getText());
        p.setPrecioCompra(Double.parseDouble(txtPrecioCompra.getText()));
        p.setPrecioVenta(Double.parseDouble(txtPrecioVenta.getText()));
        if(rbtSi.isSelected()){
            p.setIva(true);
        }else{
            p.setIva(false);
        }
        for (Medida m : listaMedida) {
            if(m.getTipo()== (String)cbxMedida.getSelectedItem()){
                p.setCodigoMedida(m.getCodigo());
                break;
            }
        }
        
        for (Categoria c : listaCategoria) {
            if(c.getCategoria()==(String)cbxCategoria.getSelectedItem()){
                p.setCodigoCategoria(c.getCodigo());
            }
        }

        controladorProducto.Actualizar(p);
        if((String)cbxBuscar.getSelectedItem()=="Categoria"){
                for (Categoria c : listaCategoria) {
                    if(c.getCategoria().equals(txtBuscar.getText())){
                        codigo=c.getCodigo();
                        break;
                    }
                }
                
                actualizarCategoria();
            }else if((String)cbxBuscar.getSelectedItem()=="Producto"){
                actualizarProducto();
            }else{
                actualizarEmpresa();
            }
        btnNuevoActionPerformed(evt);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        cpp.Eliminar(codigo);
        controladorProducto.Eliminar(codigo);
        if((String)cbxBuscar.getSelectedItem()=="Categoria"){
                for (Categoria c : listaCategoria) {
                    if(c.getCategoria().equals(txtBuscar.getText())){
                        codigo=c.getCodigo();
                        break;
                    }
                }
                
                actualizarCategoria();
            }else if((String)cbxBuscar.getSelectedItem()=="Producto"){
                actualizarProducto();
            }else{
                actualizarEmpresa();
            }
        btnNuevoActionPerformed(evt);

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
        //new Secundaria().setVisible(true);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        
        if (evt.getKeyCode()==10){
            if((String)cbxBuscar.getSelectedItem()=="Categoria"){
                for (Categoria c : listaCategoria) {
                    if(c.getCategoria().equals(txtBuscar.getText())){
                        codigo=c.getCodigo();
                        break;
                    }
                }
                actualizarCategoria();
            }else if((String)cbxBuscar.getSelectedItem()=="Producto"){
                actualizarProducto();
            }else{
                actualizarEmpresa();
            }
            
        }
        txtCantidad.setEditable(false);
    }//GEN-LAST:event_txtBuscarKeyPressed

    public void actualizarEmpresa(){
        DefaultTableModel modelo=(DefaultTableModel) tblProducto.getModel();
        List<Producto>lista=controladorProducto.buscarEmpresa(txtBuscar.getText());
        modelo.setRowCount(0);
        for (Producto p : lista) {

            Object[] dato={
                p.getCodigo(),
                buscarCategoria(p.getCodigoCategoria()),
                p.getNombre(),
                buscarMarca(p.getCodigo()),
                p.getCantidad(),
                p.getPrecioCompra(),
                p.getPrecioVenta(),
                buscarProveedor(p.getCodigo()),
                p.getDescripcion(),
                p.getLugarFabricacion(),
                iva(p.getIva()),
                buscarMedida(p.getCodigoMedida())
            };
            modelo.addRow(dato);
        }
    }
    public void actualizarCategoria(){
        
        DefaultTableModel modelo=(DefaultTableModel) tblProducto.getModel();
        List<Producto>lista=controladorProducto.buscarCategoria(codigo);
        modelo.setRowCount(0);
        for (Producto p : lista) {

            Object[] dato={
                p.getCodigo(),
                buscarCategoria(p.getCodigoCategoria()),
                p.getNombre(),
                buscarMarca(p.getCodigo()),
                p.getCantidad(),
                p.getPrecioCompra(),
                p.getPrecioVenta(),
                buscarProveedor(p.getCodigo()),
                p.getDescripcion(),
                p.getLugarFabricacion(),
                iva(p.getIva()),
                buscarMedida(p.getCodigoMedida())
            };
            modelo.addRow(dato);
        }
    }
    
    public void actualizarProducto(){
        DefaultTableModel modelo=(DefaultTableModel) tblProducto.getModel();
        List<Producto>lista=controladorProducto.buscarProducto(txtBuscar.getText());
        modelo.setRowCount(0);
        for (Producto p : lista) {

            Object[] dato={
                p.getCodigo(),
                buscarCategoria(p.getCodigoCategoria()),
                p.getNombre(),
                buscarMarca(p.getCodigo()),
                p.getCantidad(),
                p.getPrecioCompra(),
                p.getPrecioVenta(),
                buscarProveedor(p.getCodigo()),
                p.getDescripcion(),
                p.getLugarFabricacion(),
                iva(p.getIva()),
                buscarMedida(p.getCodigoMedida())
            };
            modelo.addRow(dato);
        }
    }
    
    public String buscarCategoria(int co){
        for (Categoria c : listaCategoria) {
            if(c.getCodigo()==co){
                return c.getCategoria();
            }
        }
        return null;
    }
    
    public String iva(boolean iva){
        if(iva){
            return "Tiene iva";
        }else{
            return "No tiene iva";
        }
    }
    public String buscarMedida(int codigo){
        for (Medida m : listaMedida) {
            if(m.getCodigo()==codigo){
                return m.getTipo();
            }
        }
        return null;
    }
    public String buscarMarca(int codigo){
    
        for (ProductoProveedor pp : listaPP) {
            if(pp.getCodigoProducto()==codigo){
                for (Proveedor p : listaProveedor) {
                    if(p.getCodigo()==pp.getCodigoProveedor()){
                        return p.getEmpresa();
                        
                    }
                }
            }
        }
    return null;
    }
    
    
    public String buscarProveedor(int codigo){
        for (ProductoProveedor pp : listaPP) {
            if(pp.getCodigoProducto()==codigo){
                for (Proveedor p : listaProveedor) {
                    if(p.getCodigo()==pp.getCodigoProveedor()){
                        return p.getNombres();
                        
                    }
                }
            }
        }
        return null;
    }
    
    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
        int seleccion =tblProducto.getSelectedRow();
        codigo=(int)tblProducto.getValueAt(seleccion, 0);
        
        cbxCategoria.setSelectedItem(tblProducto.getValueAt(seleccion, 1));
        txtNombre.setText((String.valueOf(tblProducto.getValueAt(seleccion, 2))));
        txtMarca.setText(String.valueOf(tblProducto.getValueAt(seleccion, 3)));
        txtCantidad.setText(String.valueOf(tblProducto.getValueAt(seleccion, 4)));
        txtPrecioCompra.setText(String.valueOf(tblProducto.getValueAt(seleccion, 5)));
        txtPrecioVenta.setText(String.valueOf(tblProducto.getValueAt(seleccion, 6)));
        cbxProveedor.setSelectedItem(tblProducto.getValueAt(seleccion, 7));
        txtDescripcion.setText(String.valueOf(tblProducto.getValueAt(seleccion, 8)));
        cbxFabricacion.setSelectedItem(tblProducto.getValueAt(seleccion, 9));
        if(tblProducto.getValueAt(seleccion, 10)=="Tiene iva"){
            rbtSi.setSelected(true);
            rbtNo.setSelected(false);
        }else{
            rbtSi.setSelected(false);
            rbtNo.setSelected(true);
        }
        cbxMedida.setSelectedItem(tblProducto.getValueAt(seleccion, 11));
        
    }//GEN-LAST:event_tblProductoMouseClicked

    private void cbxProveedorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxProveedorItemStateChanged
       String proveedor=(String)cbxProveedor.getSelectedItem();
       
        for (Proveedor p : listaProveedor) {
            if(p.getNombres()==proveedor){
                txtMarca.setText(p.getEmpresa());
                break;
            }
        }
    }//GEN-LAST:event_cbxProveedorItemStateChanged

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        String numero=JOptionPane.showInputDialog("Cuantos articulos va a registrar");
        if(numero != null){
        ProductoProveedor pp=new ProductoProveedor();
        int num2=Integer.parseInt(numero);
        int num=Integer.parseInt(txtCantidad.getText());
        int suma=num+num2;
            
        for (Proveedor c : listaProveedor) {
            if(c.getNombres()==(String)cbxProveedor.getSelectedItem()){
                pp.setCodigoProveedor(c.getCodigo());
                System.out.println(c.getCodigo());
            }
        }
        controladorProducto.ingresarMercaderia(codigo, suma);
        pp.setCodigoProducto(codigo);
        pp.setCantidad(num2);
        cpp.CrearProductoProveedor(pp);
        actualizarCategoria();
        }
    }//GEN-LAST:event_btnIngresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxBuscar;
    private javax.swing.JComboBox<String> cbxCategoria;
    private javax.swing.JComboBox<String> cbxFabricacion;
    private javax.swing.JComboBox<String> cbxMedida;
    private javax.swing.JComboBox<String> cbxProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbtNo;
    private javax.swing.JRadioButton rbtSi;
    private javax.swing.ButtonGroup rbtnIva;
    private javax.swing.JTable tblProducto;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecioCompra;
    private javax.swing.JTextField txtPrecioVenta;
    // End of variables declaration//GEN-END:variables
}
