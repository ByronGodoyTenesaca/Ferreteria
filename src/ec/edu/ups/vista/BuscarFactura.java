package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorCliente;
import ec.edu.ups.controlador.ControladorFactura;
import ec.edu.ups.controlador.ControladorFacturaDetalle;
import ec.edu.ups.controlador.ControladorProducto;
import ec.edu.ups.modelo.Factura;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class BuscarFactura extends javax.swing.JInternalFrame {
private ControladorFactura controladorFactura;

    public BuscarFactura(ControladorFactura controladorFactura) {
        initComponents();
        
        this.controladorFactura=controladorFactura;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCedula = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBuscar = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCedulaKeyPressed(evt);
            }
        });

        tblBuscar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBuscar.setRowHeight(30);
        tblBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBuscarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBuscar);
        if (tblBuscar.getColumnModel().getColumnCount() > 0) {
            tblBuscar.getColumnModel().getColumn(0).setResizable(false);
            tblBuscar.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Ingrese Cedula:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel2.setText("Buscar Factura");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCedulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyPressed
       if(evt.getKeyCode()==10){
           String cedula=txtCedula.getText();
           //Cliente c=controladorCliente.ListarCedula(cedula);
           DefaultTableModel modelo=(DefaultTableModel) tblBuscar.getModel();
           List<Factura> fa= controladorFactura.buscarFacturas(cedula);
           modelo.setRowCount(0);
           for (Factura f : fa) {
               Object [] dato={
                 f.getCodigo(),
                 f.getFecha()
               };
               modelo.addRow(dato);
           }
           
       }
    }//GEN-LAST:event_txtCedulaKeyPressed

    private void tblBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBuscarMouseClicked
        if(evt.getClickCount()==2){
            int seleccion=tblBuscar.getSelectedRow();
            int codigo=(int)tblBuscar.getValueAt(seleccion, 0);
            FacturaBuscada factura=new FacturaBuscada(codigo,new ControladorFactura(),new ControladorFacturaDetalle(),new ControladorCliente(),new ControladorProducto());
            factura.setVisible(true);
            Secundaria.desktopPane.add(factura);
        }
    }//GEN-LAST:event_tblBuscarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBuscar;
    private javax.swing.JTextField txtCedula;
    // End of variables declaration//GEN-END:variables
}
