/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista.Proveedor;


import ec.edu.ups.controlador.ProveedorControlador;
import ec.edu.ups.modelo.Proveedor;
import ec.edu.ups.vista.Principal.Administrador;
import java.util.Set;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose Guillermo Quinde
 */
public class ListarProveedores extends javax.swing.JInternalFrame {

    /**
     * Creates new form ListarProveedores
     */
    public static String x;
    private ProveedorControlador proveedorControlador;
    NuevoModelo modelo;
    public ListarProveedores(ProveedorControlador proveedorControlador) throws Exception {
        initComponents();
          x = "x";
        int a = Administrador.desktop.getWidth() - this.getWidth();
        int b = Administrador.desktop.getHeight() - this.getHeight();

        setLocation(a / 2, b / 2);
        setVisible(true);
        
        this.proveedorControlador=proveedorControlador;
         modelo = new NuevoModelo();
        Object[] columnas = {"CODIGO", "EMPRESA", "RESPONSABLE"};
        modelo.setColumnIdentifiers(columnas);
        tblProveedores.setModel(modelo);
        llenarTabla();
    }
     public void llenarTabla() throws Exception {

        Set<Proveedor> Lista = proveedorControlador.listaProveedor();
        for (Proveedor p : Lista) {
            Object[] datos = {
                p.getId(),
                p.getEmpresa(),
               p.getResponsable()};
            modelo.addRow(datos);
        }
    }
     
      /**
     * Metodo para que la tabla no sea editable
     */
    public class NuevoModelo extends DefaultTableModel {

        /**
         * Define la posibilidad de editar las columnas
         */
         public final boolean[] TblColums = {false, false};

        @Override
        public boolean isCellEditable(int row, int column) {
            return this.TblColums[column];
        }
    
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProveedores = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("LISTAR PROVEEDORES");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        btCancelar.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        btCancelar.setText("Regresar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        tblProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "EMPRESA", "EMPRESA"
            }
        ));
        jScrollPane1.setViewportView(tblProveedores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(319, 319, 319)
                        .addComponent(btCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btCancelar)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
        x = null;
    }//GEN-LAST:event_btCancelarActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
        x=null;
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProveedores;
    // End of variables declaration//GEN-END:variables
}