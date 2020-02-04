package ec.edu.ups.vista;

import ec.edu.ups.controlador.ConexionBD;
import ec.edu.ups.controlador.ControladorCliente;
import ec.edu.ups.controlador.ControladorFactura;
import ec.edu.ups.controlador.ControladorFacturaDetalle;
import ec.edu.ups.controlador.ControladorProducto;
import ec.edu.ups.controlador.ControladorProfesion;
import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.Factura;
import ec.edu.ups.modelo.FacturaDetalle;
import ec.edu.ups.modelo.Producto;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Facturas extends javax.swing.JInternalFrame {

    private ControladorCliente cliente;
    private ControladorFactura controladorFactura;
    private ControladorProducto controladorProducto;
    private ControladorProfesion controladorProfesion;
    private ControladorFacturaDetalle facturaDetalle;
    private  DefaultTableModel modelo;
    private FacturaDetalle fdetalle;
    private AgregarProductos agregar;
    private int fila;
    private double iva=0;
    private double suma=0;
    private int stock;
    private int empleado;
    private double descuento;
    private double totalPagar;
    private int codigoCliente;
    private  ConexionBD conexion;
   
    public Facturas(ControladorCliente cliente, ControladorFactura controladorFactura,ControladorProducto controladorProducto,ControladorProfesion controladorProfesion,ControladorFacturaDetalle facturaDetalle,int empleado) {
        initComponents();
        this.cliente=cliente;
        this.controladorFactura=controladorFactura;
        this.controladorProducto=controladorProducto;
        this.controladorProfesion=controladorProfesion;
        this.facturaDetalle=facturaDetalle;
        this.empleado=empleado;
        conexion= new ConexionBD();
        fecha();
        txtNfactura.setText(String.valueOf(controladorFactura.numeroFactura()));
        txtIva.setText("0");
        fdetalle=new FacturaDetalle();
    }

    public Facturas() {
         initComponents();
    }
    
    public void llenarFactura(int codigo,int cantidad,int nuevoStock){
        
        if(tblDetallefactura.getRowCount()==0){
            
            this.stock=nuevoStock;
                Producto p=controladorProducto.buscarProductoFactura(codigo);
                double total=cantidad*p.getPrecioVenta();
                modelo=(DefaultTableModel) tblDetallefactura.getModel();

                Object[] dato={
                    p.getCodigo(),
                    p.getDescripcion(),
                    cantidad,
                    p.getPrecioVenta(),
                    total
                };
                modelo.addRow(dato);

                //controladorProducto.ActualizarMercaderia(codigo,nuevoStock);
                fdetalle.setCantidad(cantidad);
                fdetalle.setCodigoProducto(codigo);
                fdetalle.setPrecioTotal(total);
                fdetalle.setPrecioUnitario(p.getPrecioVenta());
                fdetalle.setCodigoFactura(controladorFactura.numeroFactura());
                facturaDetalle.crearFactura(fdetalle);
                verificarIva(p,cantidad);
                sumar(total);
        }else{
            int cod=0;
            boolean estado=false;
            for(int i=0;i<tblDetallefactura.getRowCount();i++){
                cod=(int)tblDetallefactura.getValueAt(i, 0);
                if(cod==codigo){
                    estado=true;
                }
            }
           
           
           if(!estado){
                this.stock=nuevoStock;
                Producto p=controladorProducto.buscarProductoFactura(codigo);
                double total=cantidad*p.getPrecioVenta();
                modelo=(DefaultTableModel) tblDetallefactura.getModel();

                Object[] dato={
                    p.getCodigo(),
                    p.getDescripcion(),
                    cantidad,
                    p.getPrecioVenta(),
                    total
                };
                modelo.addRow(dato);

                //controladorProducto.ActualizarMercaderia(codigo,nuevoStock);
                fdetalle.setCantidad(cantidad);
                fdetalle.setCodigoProducto(codigo);
                fdetalle.setPrecioTotal(total);
                fdetalle.setPrecioUnitario(p.getPrecioVenta());
                fdetalle.setCodigoFactura(controladorFactura.numeroFactura());
                facturaDetalle.crearFactura(fdetalle);
                verificarIva(p,cantidad);
                sumar(total);
           }else{
               JOptionPane.showMessageDialog(this, "El Producto ya existe");
               
           }
            
         }
        
    }
    public void sumar(Double t){
         if(tblDetallefactura.getRowCount()<=1){
         suma=suma+t;
         totalPagar=suma;
         txtSubtotal.setText(String.valueOf(suma-iva));
         double des=(suma*descuento/100);
         suma=suma-des;
         txtTotal.setText(String.valueOf(suma));
         
         }else{
            totalPagar=totalPagar+t;
            txtSubtotal.setText(String.valueOf(totalPagar-iva));
            
            double des=(totalPagar*descuento/100);
            suma=totalPagar-des;
            txtTotal.setText(String.valueOf(suma));
         }
    }
    
    public void verificarIva(Producto p,int cantidad){
        
        if(p.getIva()){
                iva=(p.getPrecioVenta()*0.12)*cantidad;

                double ivaAnterior=Double.parseDouble(txtIva.getText().trim());
                iva=iva+ivaAnterior;
                txtIva.setText(String.valueOf(iva));
        }
    }
    public void fecha(){
        Date fecha=new Date();
            SimpleDateFormat formato=new SimpleDateFormat("dd-MM-YYYY");
            txtFecha.setText(formato.format(fecha));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JLabel();
        txtNfactura = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetallefactura = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtSubtotal = new javax.swing.JLabel();
        txtIva = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtProfesion = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cbxFormaPago = new javax.swing.JComboBox<>();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("FACTURA No");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("FERRETERIA \"AL PASO\"");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Dirección: El Quiteño Libre y Zurriago ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Teléfono: 4199945");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("E-mail: alpaso92@hotmail.com");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 227, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNfactura, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtNfactura, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblDetallefactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descripción", "Cantidad", "P. Unitario", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDetallefactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDetallefacturaMouseClicked(evt);
            }
        });
        tblDetallefactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblDetallefacturaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblDetallefactura);
        if (tblDetallefactura.getColumnModel().getColumnCount() > 0) {
            tblDetallefactura.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblDetallefactura.getColumnModel().getColumn(1).setPreferredWidth(300);
            tblDetallefactura.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblDetallefactura.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblDetallefactura.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("SubTotal :");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(441, 21, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Iva :");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(441, 57, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Total :");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(441, 129, -1, -1));

        btnConfirmar.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        jPanel4.add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 120, 70));

        btnCancelar.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel4.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 120, 70));
        jPanel4.add(txtSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(524, 15, 141, 30));
        jPanel4.add(txtIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(526, 52, 141, 29));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Descuento:");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, -1, -1));
        jPanel4.add(txtDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(526, 88, 141, 29));
        jPanel4.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(526, 124, 141, 29));

        btnAgregar.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel4.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 130, 70));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Datos Personales"));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("C.I. Cliente: ");

        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCedulaKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Nombre:");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Apellido:");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Forma Pago:");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Telefono:");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Dirección:");

        txtNombre.setEditable(false);

        txtTelefono.setEditable(false);

        txtDireccion.setEditable(false);

        txtApellido.setEditable(false);

        txtEmail.setEditable(false);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Email:");

        txtProfesion.setEditable(false);

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setText("Profesion:");

        cbxFormaPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contado", "Tarjeta" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                    .addComponent(txtNombre)
                    .addComponent(txtApellido)
                    .addComponent(txtDireccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxFormaPago, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel16)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtProfesion, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel10)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(cbxFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12)))
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtProfesion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCedulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyPressed
        if(evt.getKeyCode()==10){
            Cliente c=cliente.ListarCedula(txtCedula.getText());
            txtApellido.setText(c.getApellidos());
            txtNombre.setText(c.getNombres());
            txtDireccion.setText(c.getDireccion());
            txtTelefono.setText(c.getTelefono());
            txtEmail.setText(c.getEmail());
            txtProfesion.setText(c.getProfesion());
            txtDescuento.setText(String.valueOf(controladorProfesion.buscarDescuento(txtProfesion.getText()))+" %");
            descuento=controladorProfesion.buscarDescuento(txtProfesion.getText());
            codigoCliente=c.getCodigo();
        }
    }//GEN-LAST:event_txtCedulaKeyPressed

    
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
        if(agregar==null){
            agregar=new AgregarProductos(this, new ControladorProducto());
             Secundaria.desktopPane.add(agregar);
             agregar.setVisible(true);
        }else{
            agregar.setVisible(false);
            agregar=new AgregarProductos(this, new ControladorProducto());
            agregar.setVisible(true);
            Secundaria.desktopPane.add(agregar);
             
        }
        
       
       
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tblDetallefacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetallefacturaMouseClicked
        fila=tblDetallefactura.getSelectedRow();
    }//GEN-LAST:event_tblDetallefacturaMouseClicked

    private void tblDetallefacturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDetallefacturaKeyPressed
        if(evt.getKeyCode()==127){
            
            int nuevoStock=stock+(int)tblDetallefactura.getValueAt(fila, 2);
            int codigo=(int)tblDetallefactura.getValueAt(fila, 0);
            Producto p=controladorProducto.buscarProductoFactura(codigo);
            menorarIva((Double)tblDetallefactura.getValueAt(fila, 3),(int)tblDetallefactura.getValueAt(fila, 2),p);
            controladorProducto.ActualizarMercaderia(codigo, nuevoStock);
            facturaDetalle.eliminarDetalle(codigo);
            
            modelo.removeRow(fila);
            suma=0;
            for(int i=0;i<=tblDetallefactura.getRowCount()-1;i++){
                suma=suma+(double)tblDetallefactura.getValueAt(i, 4);
            }
            double des=(suma*descuento/100);
            txtSubtotal.setText(String.valueOf(suma-iva));
            suma=suma-des;
            //txtTotal.setText(String.valueOf(suma));
            txtTotal.setText(String.valueOf(suma));
            
            
        }
    }//GEN-LAST:event_tblDetallefacturaKeyPressed

    public void menorarIva(double precio,int cantidad,Producto p){
            
        if(p.getIva()){
            iva=(precio*0.12)*cantidad;
            double ivaAnterior=Double.parseDouble(txtIva.getText().trim());
            iva=ivaAnterior-iva;
            txtIva.setText(String.valueOf(iva));
            
        }
    }
    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        Factura f=new Factura();
        f.setDescuento(descuento);
        f.setFecha(new Date());
        f.setTotal(Double.parseDouble(txtTotal.getText()));
        f.setIva(Double.parseDouble(txtIva.getText()));
        f.setSubtotal(Double.parseDouble(txtSubtotal.getText()));
        f.setFormaPago((String)cbxFormaPago.getSelectedItem());
        f.setCodigoEmpleado(empleado);
        f.setCodigoCliente(codigoCliente);
        controladorFactura.crearFactura(f);
        
        JOptionPane.showMessageDialog(this, "Factura Creada");
        generarPDF();
        
    }//GEN-LAST:event_btnConfirmarActionPerformed

    public void generarPDF(){
        try {
            conexion.Conectar();
            File reporteArchivo = new File("src/ec/edu/ups/reporte/ReporteFactura.jasper");
            JasperReport reporteJasper = (JasperReport) JRLoader.loadObject(reporteArchivo);
            Map parametro=new HashMap();
            int codigo=controladorFactura.numeroFactura()-1;
            parametro.put("codFAc", codigo);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporteJasper, parametro, conexion.getConexion()); 
          
            JasperExportManager.exportReportToPdfFile(jasperPrint, "Factura.pdf");
            
            JasperViewer.viewReport(jasperPrint,false);
            
            conexion.Desconectar();
        } catch (JRException ex) {
           ex.printStackTrace();
        }
    }
    public void actualizarDetalleFactura(int codigoP,int codigoF){
        
        facturaDetalle.actualizarCodFactura(codigoP, codigoF);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JComboBox<String> cbxFormaPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JTable tblDetallefactura;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JLabel txtDescuento;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JLabel txtFecha;
    private javax.swing.JLabel txtIva;
    private javax.swing.JLabel txtNfactura;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtProfesion;
    private javax.swing.JLabel txtSubtotal;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
}
