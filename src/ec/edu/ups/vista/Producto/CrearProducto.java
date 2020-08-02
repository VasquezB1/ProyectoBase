/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista.Producto;


import ec.edu.ups.controlador.CategoriaControlador;
import ec.edu.ups.controlador.ControladorProducto;
import ec.edu.ups.controlador.UnidadesControlador;
import ec.edu.ups.modelo.CategoriaProducto;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.modelo.UnidadMedida;
import static ec.edu.ups.personas.BuscarPersonas.x;
import ec.edu.ups.vista.Principal.Administrador;
import ec.edu.ups.vista.ProductoProveedor.CrearPP;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;


/**
 *
 * @author Edison
 */
public class CrearProducto extends javax.swing.JInternalFrame {

    public static String x;
    private ControladorProducto controladorProducto;
    private CategoriaControlador categoriaControlador;
    private UnidadesControlador unidadesControlador;

    /**
     * Creates new form CrearProducto
     */
    public CrearProducto(ControladorProducto controladorProducto, CategoriaControlador categoriaControlador, UnidadesControlador unidadesControlador) throws Exception {
        initComponents();
        x = "x";
        int a = Administrador.desktop.getWidth() - this.getWidth();
        int b = Administrador.desktop.getHeight() - this.getHeight();

        setLocation(a / 2, b / 2);
        setVisible(true);
        
        this.controladorProducto = controladorProducto;
        this.categoriaControlador = categoriaControlador;
        this.unidadesControlador = unidadesControlador;
        mostrarId();
        mostrarCategorias();
        mostrarUnidades();
    }
    
    public void mostrarId(){
        jTId.setText(String.valueOf(controladorProducto.buscarUltimoCodigo()+1));
    }            
    public void mostrarCategorias() throws Exception{
        Set<CategoriaProducto> list = categoriaControlador.listaCategoria();
        for (CategoriaProducto c: list) {
            jComboBox6.addItem(c.getId() +" "+ c.getNombre());
        }  
    }
    public void mostrarUnidades() throws Exception{
        Set<UnidadMedida> list = unidadesControlador.listaUn();
        for (UnidadMedida u : list) {
            jComboBox7.addItem(u.getId() +" "+ u.getNombre());
        }  
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLID = new javax.swing.JLabel();
        jLCBarras = new javax.swing.JLabel();
        jLNombre = new javax.swing.JLabel();
        jLPrecio = new javax.swing.JLabel();
        jLNacional = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLUnidad = new javax.swing.JLabel();
        jLCategoria = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTPrecio = new javax.swing.JTextField();
        jTNombre = new javax.swing.JTextField();
        jTCBarra = new javax.swing.JTextField();
        jTId = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jComboBox6 = new javax.swing.JComboBox<>();
        jComboBox7 = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
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

        jLID.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        jLID.setText("Id:");

        jLCBarras.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        jLCBarras.setText("Codigo De Barras:");

        jLNombre.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        jLNombre.setText("Nombre:");

        jLPrecio.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        jLPrecio.setText("Precio:");

        jLNacional.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        jLNacional.setText("Nacional:");
        jLNacional.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        jLabel1.setText("IVA:");

        jLUnidad.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        jLUnidad.setText("Unidad de Medida:");

        jLCategoria.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        jLCategoria.setText("Categoria:");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel2.setText("Crear Producto");
        jLabel2.setAutoscrolls(true);

        jTId.setEnabled(false);

        jToggleButton1.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        jToggleButton1.setText("Guradar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        jToggleButton2.setText("Cancelar");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "N", "E" }));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "T", "F" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLUnidad)
                            .addComponent(jLNacional)
                            .addComponent(jLabel1)
                            .addComponent(jLCBarras)
                            .addComponent(jLNombre)
                            .addComponent(jLPrecio)
                            .addComponent(jLCategoria)
                            .addComponent(jLID)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jToggleButton1)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTId, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jToggleButton2)
                                                .addComponent(jTCBarra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jTNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jTPrecio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jComboBox4, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox7, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox6, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLID)
                    .addComponent(jTId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCBarras)
                    .addComponent(jTCBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNombre)
                    .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLPrecio)
                    .addComponent(jTPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNacional)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLUnidad)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLCategoria)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1)
                    .addComponent(jToggleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
        x=null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
        x = null;
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        Producto p = new Producto();
        p.setId(Integer.parseInt(jTId.getText()));
        p.setCodBarra(jTCBarra.getText());
        p.setNombre(jTNombre.getText());
        p.setPrecio(Double.parseDouble(jTPrecio.getText()));
        p.setNacionalidad(jComboBox4.getSelectedItem().toString().charAt(0));
        p.setIva(jComboBox5.getSelectedItem().toString().charAt(0));
        p.setUm(unidadesControlador.Buscaar(Integer.parseInt(jComboBox7.getSelectedItem().toString().substring(0,1))));
        p.setCp(categoriaControlador.Buscar(Integer.parseInt(jComboBox6.getSelectedItem().toString().substring(0,1))));
        p.setStock(0);
        
        controladorProducto.create(p);
        JOptionPane.showMessageDialog(this, "Producto creado correctamente", "Crear Producto", JOptionPane.OK_OPTION);
          CrearPP.ComboProductor.removeAllItems();
        try {
            CrearPP.mostrarProductos();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        mostrarId();
        jTCBarra.setText("");
        jTNombre.setText("");
        jTPrecio.setText("");
    }//GEN-LAST:event_jToggleButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JLabel jLCBarras;
    private javax.swing.JLabel jLCategoria;
    private javax.swing.JLabel jLID;
    private javax.swing.JLabel jLNacional;
    private javax.swing.JLabel jLNombre;
    private javax.swing.JLabel jLPrecio;
    private javax.swing.JLabel jLUnidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTCBarra;
    private javax.swing.JTextField jTId;
    private javax.swing.JTextField jTNombre;
    private javax.swing.JTextField jTPrecio;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    // End of variables declaration//GEN-END:variables
}
