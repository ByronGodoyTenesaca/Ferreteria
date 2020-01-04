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
    private ControladorCliente controladorCliente;
    private ControladorProfesion controladorProfesion;
    private VistaEmpleado vistaEmpleado;
    private VistaCargo vistaCargo;
    private ControladorEmpleado controladorEmpleado;
    private ControladorCargo controladorCargo;
    
    public Secundaria() {
        initComponents();
        controladorCliente=new ControladorCliente();
        controladorProfesion=new ControladorProfesion();
        vistaEmpleado = new VistaEmpleado(controladorEmpleado);
        vistaCargo = new VistaCargo(controladorCargo);
        controladorCargo = new ControladorCargo();
        controladorEmpleado = new ControladorEmpleado();
        this.setExtendedState(MAXIMIZED_BOTH);
      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        pntAccesos = new javax.swing.JPanel();
        btnCliente = new javax.swing.JButton();
        btnProducto = new javax.swing.JButton();
        btnEmpleado = new javax.swing.JButton();
        btnFacturacion = new javax.swing.JButton();
        btnSesion = new javax.swing.JButton();
        btnProveedor = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        itmCargo = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

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

        fileMenu.setMnemonic('f');
        fileMenu.setText("Clientes");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Open");
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.setDisplayedMnemonicIndex(5);
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Productos");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Cut");
        editMenu.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Copy");
        editMenu.add(copyMenuItem);

        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Paste");
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Delete");
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Empleados");

        itmCargo.setMnemonic('c');
        itmCargo.setText("Cargo");
        itmCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmCargoActionPerformed(evt);
            }
        });
        helpMenu.add(itmCargo);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        jMenu1.setText("Facturacion");
        menuBar.add(jMenu1);

        jMenu2.setText("Reportes");
        menuBar.add(jMenu2);

        jMenu4.setText("Sesion");
        menuBar.add(jMenu4);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        //desktopPane.removeAll();
        desktopPane.repaint();
        c=new Clientes(controladorCliente,controladorProfesion);
        c.setVisible(true);
        desktopPane.add(c);
        Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = c.getSize();
        c.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
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
        p.setLocation((desktopSize.width - FrameSize.width), (desktopSize.height- FrameSize.height));
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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Secundaria().setVisible(true);
            }
        });
    }

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
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem itmCargo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JPanel pntAccesos;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

}
