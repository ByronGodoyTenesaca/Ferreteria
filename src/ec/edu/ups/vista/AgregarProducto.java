package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorProducto;
import ec.edu.ups.modelo.Producto;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AgregarProducto extends javax.swing.JFrame {

    private ControladorProducto cp;
    public AgregarProducto() {
        initComponents();
        cp=new ControladorProducto();
        llenar();
        this.setLocation(750, 60);
        rbtnNombre.setSelected(true);
    }

    public void llenar(){
        List<Producto> lista=cp.buscarProducto(txtBuscar.getText());
        DefaultTableModel modelo=(DefaultTableModel) tblProductos.getModel();
        modelo.setRowCount(0);
        for (Producto p : lista) {
            Object[] dato={
            
                p.getCodigo(),
                p.getNombre(),
                p.getDescripcion(),
                p.getCantidad()
            };
            modelo.addRow(dato);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        Buscar = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        rbtnNombre = new javax.swing.JRadioButton();
        rbtnCodigo = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Productos");

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Descripcion", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProductos);
        if (tblProductos.getColumnModel().getColumnCount() > 0) {
            tblProductos.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblProductos.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblProductos.getColumnModel().getColumn(2).setPreferredWidth(200);
            tblProductos.getColumnModel().getColumn(3).setPreferredWidth(10);
        }

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        Buscar.add(rbtnNombre);
        rbtnNombre.setText("Nombre");

        Buscar.add(rbtnCodigo);
        rbtnCodigo.setText("Codigo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbtnNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnCodigo)
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnNombre)
                    .addComponent(rbtnCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
       
        
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        String nombre=txtBuscar.getText();
        System.out.println(nombre+"  "+evt.getKeyChar());
        if(rbtnNombre.isSelected()){
            llenar();
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
        if(evt.getClickCount()==2){
            int seleccion =tblProductos.getSelectedRow();
            String valor=JOptionPane.showInputDialog("Cantidad de "+tblProductos.getValueAt(seleccion, 1));
            int cantidad=Integer.parseInt(valor);
            int stock=(int)tblProductos.getValueAt(seleccion, 3);
            if(cantidad<=stock){
                int res=stock-cantidad;
                int codigo=(int)tblProductos.getValueAt(seleccion, 0);
                new Factura().llenarFactura(codigo, cantidad, res);
                
            }else{
                JOptionPane.showMessageDialog(this, "No hay sificiente mercaderia","error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_tblProductosMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Buscar;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtnCodigo;
    private javax.swing.JRadioButton rbtnNombre;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
