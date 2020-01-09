package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorCargo;
import ec.edu.ups.controlador.ControladorCategoria;
import ec.edu.ups.controlador.ControladorCliente;
import ec.edu.ups.controlador.ControladorEmpleado;
import ec.edu.ups.controlador.ControladorMedida;
import ec.edu.ups.controlador.ControladorProducto;
import ec.edu.ups.controlador.ControladorProductoProveedor;
import ec.edu.ups.controlador.ControladorProfesion;
import ec.edu.ups.controlador.ControladorProveedor;
import java.awt.Dimension;

public class Secundaria extends javax.swing.JFrame {

    private Clientes c;
    private Productos p;
    private int n;
    private ControladorCliente controladorCliente;
    private ControladorProfesion controladorProfesion;
    private VistaEmpleado vistaEmpleado;
    private VistaCargo vistaCargo;
    private ControladorEmpleado controladorEmpleado;
    private ControladorCargo controladorCargo;
    private ControladorCategoria controladorCategoria;
    private ControladorMedida controladorMedida;
    
    public Secundaria(int n) {
        initComponents();
        controladorCliente=new ControladorCliente();
        controladorProfesion=new ControladorProfesion();
        vistaEmpleado = new VistaEmpleado(controladorEmpleado);
        vistaCargo = new VistaCargo(controladorCargo);
        controladorCargo = new ControladorCargo();
        controladorEmpleado = new ControladorEmpleado();
        controladorCategoria = new ControladorCategoria();
        controladorMedida = new ControladorMedida();
        this.n=n;
        //controlar();
        this.setExtendedState(MAXIMIZED_BOTH);
      
    }
    
    public void controlar(){
        if(n==1){
            menuProducto.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        desktopPane = new javax.swing.JDesktopPane();
        pntAccesos = new javax.swing.JPanel();
        btnCliente = new javax.swing.JButton();
        btnProducto = new javax.swing.JButton();
        btnEmpleado = new javax.swing.JButton();
        btnFacturacion = new javax.swing.JButton();
        btnSesion = new javax.swing.JButton();
        btnProveedor = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        menuCliente = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuProducto = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        menuEmpleado = new javax.swing.JMenu();
        itmCargo = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();
        menuFactura = new javax.swing.JMenu();
        menuReportes = new javax.swing.JMenu();
        menuSesion = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pntAccesos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCliente.setText("Cliente");
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });
        pntAccesos.add(btnCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 91, 50));

        btnProducto.setText("Productos");
        btnProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductoActionPerformed(evt);
            }
        });
        pntAccesos.add(btnProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 0, 91, 50));

        btnEmpleado.setText("Empleados");
        btnEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadoActionPerformed(evt);
            }
        });
        pntAccesos.add(btnEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 0, -1, 50));

        btnFacturacion.setText("Facturacion");
        pntAccesos.add(btnFacturacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 0, -1, 50));

        btnSesion.setText("Sesion");
        btnSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSesionActionPerformed(evt);
            }
        });
        pntAccesos.add(btnSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 0, 91, 50));

        btnProveedor.setText("Proveedor");
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });
        pntAccesos.add(btnProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, -1, 50));

        desktopPane.add(pntAccesos);
        pntAccesos.setBounds(0, 0, 950, 50);

        getContentPane().add(desktopPane, java.awt.BorderLayout.CENTER);

        menuCliente.setText("Cliente");

        jMenuItem1.setText("Profesion");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuCliente.add(jMenuItem1);

        menuBar.add(menuCliente);

        menuProducto.setMnemonic('e');
        menuProducto.setText("Productos");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Categoria");
        cutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutMenuItemActionPerformed(evt);
            }
        });
        menuProducto.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Medida");
        copyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyMenuItemActionPerformed(evt);
            }
        });
        menuProducto.add(copyMenuItem);

        menuBar.add(menuProducto);

        menuEmpleado.setMnemonic('h');
        menuEmpleado.setText("Empleados");

        itmCargo.setMnemonic('c');
        itmCargo.setText("Cargo");
        itmCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmCargoActionPerformed(evt);
            }
        });
        menuEmpleado.add(itmCargo);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        menuEmpleado.add(aboutMenuItem);

        menuBar.add(menuEmpleado);

        menuFactura.setText("Facturacion");
        menuBar.add(menuFactura);

        menuReportes.setText("Reportes");
        menuBar.add(menuReportes);

        menuSesion.setText("Sesion");
        menuBar.add(menuSesion);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        //desktopPane.removeAll();
        desktopPane.repaint();
        c=new Clientes(controladorCliente,controladorProfesion);
        c.setVisible(true);
        desktopPane.add(c);
        Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = c.getSize();
        c.setLocation((desktopSize.width - FrameSize.width-940)/7, (desktopSize.height- FrameSize.height)/7);
        c.show();
        
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductoActionPerformed
       // desktopPane.removeAll();
        desktopPane.repaint();
        p=new Productos(new ControladorCategoria(),new ControladorMedida(),new ControladorProducto(),new ControladorProveedor(),new ControladorProductoProveedor());
        p.setVisible(true);
        desktopPane.add(p);
        Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = p.getSize();
        p.setLocation((desktopSize.width - FrameSize.width-940)/7, (desktopSize.height- FrameSize.height)/7);
        p.show();
    }//GEN-LAST:event_btnProductoActionPerformed

    private void btnSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSesionActionPerformed
        this.dispose();
        new Login().setVisible(true);
        
    }//GEN-LAST:event_btnSesionActionPerformed

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProveedorActionPerformed

    private void btnEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadoActionPerformed
        // TODO add your handling code here:
        vistaEmpleado = new VistaEmpleado(controladorEmpleado);
        vistaEmpleado.setVisible(true);
        desktopPane.add(vistaEmpleado);
        vistaEmpleado.show();
    }//GEN-LAST:event_btnEmpleadoActionPerformed

    private void itmCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmCargoActionPerformed
        // TODO add your handling code here:
        vistaCargo = new VistaCargo(controladorCargo);
        desktopPane.add(vistaCargo);
        vistaCargo.show();
    }//GEN-LAST:event_itmCargoActionPerformed

    private void cutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutMenuItemActionPerformed
        Categorias c=new Categorias(controladorCategoria);
        c.setVisible(true);
        desktopPane.add(c);
        Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = c.getSize();
        c.setLocation((desktopSize.width - FrameSize.width-940)/7, (desktopSize.height- FrameSize.height)/7);
        c.show();
    }//GEN-LAST:event_cutMenuItemActionPerformed

    private void copyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyMenuItemActionPerformed
        Medida m=new Medida(controladorMedida);
        m.setVisible(true);
        desktopPane.add(m);
        Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = m.getSize();
        m.setLocation((desktopSize.width - FrameSize.width-940)/7, (desktopSize.height- FrameSize.height)/7);
        m.show();
    }//GEN-LAST:event_copyMenuItemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Profesiones p=new Profesiones(controladorProfesion);
        p.setVisible(true);
        desktopPane.add(p);
        Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = p.getSize();
        p.setLocation((desktopSize.width - FrameSize.width-940)/7, (desktopSize.height- FrameSize.height)/7);
        p.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
   // public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
/*        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Secundaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Secundaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Secundaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Secundaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
     //   java.awt.EventQueue.invokeLater(new Runnable() {
       //     public void run() {
         //       new Secundaria().setVisible(true);
       //     }
       // });
   // }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnEmpleado;
    private javax.swing.JButton btnFacturacion;
    private javax.swing.JButton btnProducto;
    private javax.swing.JButton btnProveedor;
    private javax.swing.JButton btnSesion;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem itmCargo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuCliente;
    private javax.swing.JMenu menuEmpleado;
    private javax.swing.JMenu menuFactura;
    private javax.swing.JMenu menuProducto;
    private javax.swing.JMenu menuReportes;
    private javax.swing.JMenu menuSesion;
    private javax.swing.JPanel pntAccesos;
    // End of variables declaration//GEN-END:variables

}
