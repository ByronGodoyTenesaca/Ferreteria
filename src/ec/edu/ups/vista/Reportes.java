package ec.edu.ups.vista;

import ec.edu.ups.controlador.ConexionBD;
import ec.edu.ups.controlador.ControladorCliente;
import ec.edu.ups.controlador.ControladorFactura;
import ec.edu.ups.modelo.Factura;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Reportes extends javax.swing.JInternalFrame {
private ControladorCliente controladorCliente;
private ControladorFactura controladorFactura;
private ConexionBD conexion;

    public Reportes(ControladorCliente controladorCliente,ControladorFactura controladorFactura) {
        initComponents();
        this.controladorCliente=controladorCliente;
        this.controladorFactura=controladorFactura;
        conexion= new ConexionBD();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCedula = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReportes = new javax.swing.JTable();

        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCedulaKeyPressed(evt);
            }
        });

        tblReportes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblReportes.setRowHeight(30);
        tblReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblReportesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblReportes);
        if (tblReportes.getColumnModel().getColumnCount() > 0) {
            tblReportes.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCedulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyPressed
       if(evt.getKeyCode()==10){
           String cedula=txtCedula.getText();
           //Cliente c=controladorCliente.ListarCedula(cedula);
           DefaultTableModel modelo=(DefaultTableModel) tblReportes.getModel();
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

    private void tblReportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReportesMouseClicked
        int valor =tblReportes.getSelectedRow();
        if(evt.getClickCount()==2){
            int codigo=(int)tblReportes.getValueAt(valor, 0);
            generarPDF(codigo);
        }
    }//GEN-LAST:event_tblReportesMouseClicked

    public void generarPDF(int codigo){
        try {
            conexion.Conectar();
            File reporteArchivo = new File("src/ec/edu/ups/reporte/ReporteFactura.jasper");
            JasperReport reporteJasper = (JasperReport) JRLoader.loadObject(reporteArchivo);
            Map parametro=new HashMap();
            parametro.put("codFAc", codigo);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporteJasper, parametro, conexion.getConexion()); 
          
            JasperExportManager.exportReportToPdfFile(jasperPrint, "Factura.pdf");
            
            JasperViewer.viewReport(jasperPrint,false);
            
            conexion.Desconectar();
        } catch (JRException ex) {
           ex.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblReportes;
    private javax.swing.JTextField txtCedula;
    // End of variables declaration//GEN-END:variables
}
