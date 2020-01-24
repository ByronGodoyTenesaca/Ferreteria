package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorCargo;
import ec.edu.ups.controlador.ControladorCategoria;
import ec.edu.ups.controlador.ControladorCliente;
import ec.edu.ups.controlador.ControladorEmpleado;
import ec.edu.ups.controlador.ControladorFactura;
import ec.edu.ups.controlador.ControladorFacturaDetalle;
import ec.edu.ups.controlador.ControladorMedida;
import ec.edu.ups.controlador.ControladorProducto;
import ec.edu.ups.controlador.ControladorProductoProveedor;
import ec.edu.ups.controlador.ControladorProfesion;
import ec.edu.ups.controlador.ControladorProveedor;
import java.awt.Dimension;


public class Secundaria extends javax.swing.JFrame {

    private Clientes c;
    private Productos p;
    private Proveedores pr;
    private Facturas f;
    private int n;
    private ControladorCliente controladorCliente;
    private ControladorProfesion controladorProfesion;
    private VistaEmpleado vistaEmpleado;
    private VistaCargo vistaCargo;
    private ControladorEmpleado controladorEmpleado;
    private ControladorCargo controladorCargo;
    private ControladorCategoria controladorCategoria;
    private ControladorMedida controladorMedida;
    private int empleado;
    
    public Secundaria(int n, int empleado) {
        initComponents();
        controladorCliente=new ControladorCliente();
        controladorProfesion=new ControladorProfesion();
        
        controladorCargo = new ControladorCargo();
        controladorEmpleado = new ControladorEmpleado();
        controladorCategoria = new ControladorCategoria();
        controladorMedida = new ControladorMedida();
        this.empleado=empleado;
        this.n=n;
        controlar();
        this.setExtendedState(MAXIMIZED_BOTH);
      
    }
    
    public void controlar(){
        if(n==2){
            menuEmpleado.setVisible(false);
            menuReportes.setVisible(false);
            itemCategoria.setVisible(false);
            itemMedida.setVisible(false);
            itemProveedor.setVisible(false);
            
            
        }else if(n==3){
            menuCliente.setVisible(false);
            menuEmpleado.setVisible(false);
            menuFactura.setVisible(false);
            menuReportes.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        menuCliente = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuProducto = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        itemProveedor = new javax.swing.JMenuItem();
        itemCategoria = new javax.swing.JMenuItem();
        itemMedida = new javax.swing.JMenuItem();
        menuEmpleado = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        itmCargo = new javax.swing.JMenuItem();
        menuFactura = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        menuReportes = new javax.swing.JMenu();
        menuSesion = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(desktopPane, java.awt.BorderLayout.CENTER);

        menuCliente.setText("Cliente");

        jMenuItem2.setText("Cliente");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuCliente.add(jMenuItem2);

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

        jMenuItem3.setText("Producto");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuProducto.add(jMenuItem3);

        itemProveedor.setText("Proveedor");
        itemProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemProveedorActionPerformed(evt);
            }
        });
        menuProducto.add(itemProveedor);

        itemCategoria.setMnemonic('t');
        itemCategoria.setText("Categoria");
        itemCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCategoriaActionPerformed(evt);
            }
        });
        menuProducto.add(itemCategoria);

        itemMedida.setMnemonic('y');
        itemMedida.setText("Medida");
        itemMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMedidaActionPerformed(evt);
            }
        });
        menuProducto.add(itemMedida);

        menuBar.add(menuProducto);

        menuEmpleado.setMnemonic('h');
        menuEmpleado.setText("Empleados");

        jMenuItem4.setText("Empleado");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menuEmpleado.add(jMenuItem4);

        itmCargo.setMnemonic('c');
        itmCargo.setText("Cargo");
        itmCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmCargoActionPerformed(evt);
            }
        });
        menuEmpleado.add(itmCargo);

        menuBar.add(menuEmpleado);

        menuFactura.setText("Facturacion");

        jMenuItem5.setText("Facturacion");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menuFactura.add(jMenuItem5);

        menuBar.add(menuFactura);

        menuReportes.setText("Reportes");
        menuBar.add(menuReportes);

        menuSesion.setText("Sesion");

        jMenuItem7.setText("Cerrar Sesion");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        menuSesion.add(jMenuItem7);

        menuBar.add(menuSesion);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itmCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmCargoActionPerformed
        // TODO add your handling code here:
        desktopPane.removeAll();
        desktopPane.repaint();
        vistaCargo = new VistaCargo(controladorCargo);
        desktopPane.add(vistaCargo);
        vistaCargo.show();
    }//GEN-LAST:event_itmCargoActionPerformed

    private void itemCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCategoriaActionPerformed
        desktopPane.removeAll();
        desktopPane.repaint();
        Categorias c=new Categorias(controladorCategoria);
        c.setVisible(true);
        desktopPane.add(c);
        Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = c.getSize();
        c.setLocation((desktopSize.width - FrameSize.width-940)/7, (desktopSize.height- FrameSize.height)/7);
        c.show();
    }//GEN-LAST:event_itemCategoriaActionPerformed

    private void itemMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMedidaActionPerformed
        desktopPane.removeAll();
        desktopPane.repaint();
        Medida m=new Medida(controladorMedida);
        m.setVisible(true);
        desktopPane.add(m);
        Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = m.getSize();
        m.setLocation((desktopSize.width - FrameSize.width-940)/7, (desktopSize.height- FrameSize.height)/7);
        m.show();
    }//GEN-LAST:event_itemMedidaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        desktopPane.removeAll();
        desktopPane.repaint();
        Profesiones p=new Profesiones(controladorProfesion);
        p.setVisible(true);
        desktopPane.add(p);
        Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = p.getSize();
        p.setLocation((desktopSize.width - FrameSize.width-940)/7, (desktopSize.height- FrameSize.height)/7);
        p.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        desktopPane.removeAll();
        desktopPane.repaint();
        c=new Clientes(controladorCliente,controladorProfesion);
        c.setVisible(true);
        desktopPane.add(c);
        Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = c.getSize();
        c.setLocation((desktopSize.width - FrameSize.width-940)/7, (desktopSize.height- FrameSize.height)/7);
        c.show();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        desktopPane.removeAll();
        desktopPane.repaint();
        p=new Productos(new ControladorCategoria(),new ControladorMedida(),new ControladorProducto(),new ControladorProveedor(),new ControladorProductoProveedor());
        p.setVisible(true);
        desktopPane.add(p);
        Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = p.getSize();
        p.setLocation((desktopSize.width - FrameSize.width-940)/7, (desktopSize.height- FrameSize.height)/7);
        p.show();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        desktopPane.removeAll();
        desktopPane.repaint();
        vistaEmpleado = new VistaEmpleado(controladorEmpleado,new ControladorCargo());
        vistaEmpleado.setVisible(true);
        desktopPane.add(vistaEmpleado);
        vistaEmpleado.show();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void itemProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemProveedorActionPerformed
        desktopPane.removeAll();
        desktopPane.repaint();
        pr=new Proveedores(new ControladorProveedor(),new ControladorProductoProveedor());
        pr.setVisible(true);
        desktopPane.add(pr);
        Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = pr.getSize();
        pr.setLocation((desktopSize.width - FrameSize.width-940)/7, (desktopSize.height- FrameSize.height)/7);
        pr.show();
    }//GEN-LAST:event_itemProveedorActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
       this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        desktopPane.removeAll();
        desktopPane.repaint();
        f=new Facturas(new ControladorCliente(),new ControladorFactura(),new ControladorProducto(),new ControladorProfesion(),new ControladorFacturaDetalle(),empleado);
        f.setVisible(true);
        desktopPane.add(f);
    }//GEN-LAST:event_jMenuItem5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem itemCategoria;
    private javax.swing.JMenuItem itemMedida;
    private javax.swing.JMenuItem itemProveedor;
    private javax.swing.JMenuItem itmCargo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuCliente;
    private javax.swing.JMenu menuEmpleado;
    private javax.swing.JMenu menuFactura;
    private javax.swing.JMenu menuProducto;
    private javax.swing.JMenu menuReportes;
    private javax.swing.JMenu menuSesion;
    // End of variables declaration//GEN-END:variables

}
