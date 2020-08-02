/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista.Principal;

import ec.edu.ups.controlador.BaseDeDatos;
import ec.edu.ups.controlador.CategoriaControlador;
import ec.edu.ups.controlador.ControladorProducto;
import ec.edu.ups.controlador.FCabeceraControlador;
import ec.edu.ups.controlador.PersonaControlador;
import ec.edu.ups.controlador.ProvProdControlador;
import ec.edu.ups.controlador.ProveedorControlador;
import ec.edu.ups.controlador.UnidadesControlador;
import ec.edu.ups.empleados.BuscarEmpleado;
import ec.edu.ups.empleados.CrearEmpleado;
import ec.edu.ups.empleados.EliminarEmpleado;
import ec.edu.ups.empleados.ModificarEmpleado;
import ec.edu.ups.personas.BuscarPersonas;
import ec.edu.ups.personas.CrearPersonas;
import ec.edu.ups.personas.EliminarPersona;
import ec.edu.ups.personas.ModificarEliminar;
import ec.edu.ups.personas.RegistrarPersonas;
import ec.edu.ups.vista.Categoria.BuscarCategoria;
import ec.edu.ups.vista.Categoria.CrearCategoria;
import ec.edu.ups.vista.Categoria.EliminarCategoria;
import ec.edu.ups.vista.Categoria.ModificarCategoria;
import ec.edu.ups.vista.Factura.AnularFactura;
import ec.edu.ups.vista.Factura.BuscarFactura;
import ec.edu.ups.vista.Factura.CrearFactura;
import ec.edu.ups.vista.Producto.BuscarProducto;
import ec.edu.ups.vista.Producto.CrearProducto;
import ec.edu.ups.vista.Producto.EliminarProducto;
import ec.edu.ups.vista.Producto.ModificarProducto;
import ec.edu.ups.vista.ProductoProveedor.BuscarPP;
import ec.edu.ups.vista.ProductoProveedor.CrearPP;
import ec.edu.ups.vista.ProductoProveedor.ListarPP;
import ec.edu.ups.vista.Proveedor.BuscarProveedor;
import ec.edu.ups.vista.Proveedor.CrearProveedor;
import ec.edu.ups.vista.Proveedor.ListarProveedores;
import ec.edu.ups.vista.Proveedor.ModificarProveedor;
import ec.edu.ups.vista.Unidad.BuscarUnidad;
import ec.edu.ups.vista.Unidad.CrearUnidad;
import ec.edu.ups.vista.Unidad.ModificarUnidad;
import java.awt.Desktop;
import java.net.URI;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/* 
 *
 * @author ByronPC
 */
public class Administrador extends javax.swing.JFrame {

    private RegistrarPersonas registrarPersonas;  
    private BuscarPersonas buscarPersonas;
    private ModificarEliminar modificarEliminar;
    private EliminarPersona eliminarPersona;
    private CrearEmpleado crearEmpleado;
    private BuscarEmpleado buscarEmpleado;
    private EliminarEmpleado eliminarEmpleado;    
    private ModificarEmpleado modificarEmpleado;
    private CrearProducto crearProducto;
    private BuscarProducto buscarProducto;
    private ModificarProducto modificarProducto;
    private EliminarProducto eliminarProducto;
    private CrearFactura crearFactura;
    private BuscarFactura buscarFactura;
    private AnularFactura anularFactura;
    private CrearCategoria crearCategoria;
    private BuscarCategoria buscarCategoria;
    private ModificarCategoria modificarCategoria;
    private EliminarCategoria eliminarCategoria;
    private CrearPP cpp;
    private BuscarPP bpp;
    private ListarPP lpp;
    private CrearProveedor  crearProveedor;
    private BuscarProveedor buscarProveedor;
    private ModificarProveedor modificarProveedor;
    private ListarProveedores listarProveedores;
    private CrearUnidad crearUnidad;
    private BuscarUnidad buscarUnidad;
    private ModificarUnidad modificarUnidad;
    
//  ------------------------CONTROLADORES---------------------------
      private PersonaControlador personaControlador;
      private ControladorProducto controladorProducto;
      private FCabeceraControlador fCabeceraControlador;
      private CategoriaControlador categoriaControlador;
      private ControladorProducto controladorProducto1;
      private UnidadesControlador unidadesControlador;
      private ProveedorControlador proveedorControlador;
      private ProvProdControlador provProdControlador;
      String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    String user = "BaseFarmacia";
    String password = "bf123";
    /**
     * Creates new form Administrador
     */
    public Administrador() {
        initComponents();
        personaControlador=new PersonaControlador(url, user, password);
        categoriaControlador = new CategoriaControlador(url, user, password);
        controladorProducto = new ControladorProducto(url, user, password);
        unidadesControlador = new UnidadesControlador(url, user, password);
        proveedorControlador = new ProveedorControlador(url, user, password);
        provProdControlador = new ProvProdControlador(url, user, password);
        
        desktop.setBorder(new FondoEs());
        this.setIconImage(new ImageIcon(("src/ec/edu/ups/imageness/escudo.png")).getImage());
        this.setExtendedState(Administrador.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setTitle("***** FÁRMACIA FÁRMACOS ADMINISTRADOR*****");
        this.setLocationRelativeTo(null);
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        desktop = new javax.swing.JDesktopPane();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        botonreporte = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
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
        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMCC = new javax.swing.JMenuItem();
        jMBC = new javax.swing.JMenuItem();
        jMMC = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenu12 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenuItem2.setText("jMenuItem2");

        jMenu6.setText("File");
        jMenuBar3.add(jMenu6);

        jMenu7.setText("Edit");
        jMenuBar3.add(jMenu7);

        jMenuItem7.setText("jMenuItem7");

        jMenuItem9.setText("jMenuItem9");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/universidad-politecnica-salesiana-infodesarrollo.png"))); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/salir2.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField1.setText("Link del Proyecto");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/gitt.png"))); // NOI18N
        jButton2.setText("GitHub");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        botonreporte.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonreporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/provlistar.png"))); // NOI18N
        botonreporte.setText("Generar Reportes");
        botonreporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonreporteActionPerformed(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("Reportes");

        desktop.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(jTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(botonreporte, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(jTextField2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonreporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
                .addGroup(desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(desktopLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(214, 214, 214))
                    .addGroup(desktopLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(188, 188, 188)))
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, desktopLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(desktopLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(desktopLayout.createSequentialGroup()
                        .addGroup(desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(desktopLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22))
                            .addGroup(desktopLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonreporte)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5))))
        );

        fileMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/persona.png"))); // NOI18N
        fileMenu.setMnemonic('f');
        fileMenu.setText("Cliente");
        fileMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        openMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        openMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/crearcliente.png"))); // NOI18N
        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Crear Cliente");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        saveMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        saveMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/buscarcliente.png"))); // NOI18N
        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Buscar Cliente");
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        saveAsMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/modificarcliente.png"))); // NOI18N
        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Modificar Cliente");
        saveAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        exitMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/eliminarcliente.png"))); // NOI18N
        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Eliminar Cliente");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/empleado.png"))); // NOI18N
        editMenu.setMnemonic('e');
        editMenu.setText("Empleado");
        editMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        cutMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cutMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/clienteicono.png"))); // NOI18N
        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Crear Empleado");
        cutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(cutMenuItem);

        copyMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        copyMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/buscar.png"))); // NOI18N
        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Buscar Empleado");
        copyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(copyMenuItem);

        pasteMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pasteMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/actualizar2.png"))); // NOI18N
        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Modificar Cliente");
        pasteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/eliminarr.png"))); // NOI18N
        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Eliminar Empleado");
        deleteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/producto.png"))); // NOI18N
        jMenu5.setText("Productos");
        jMenu5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/elimarservicio.png"))); // NOI18N
        jMenuItem1.setText("Crear Producto");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem1);

        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/busacar2.png"))); // NOI18N
        jMenuItem3.setText("Buscar Producto");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem3);

        jMenuItem4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/listarrrr.png"))); // NOI18N
        jMenuItem4.setText("Modificar Producto");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem4);

        jMenuItem5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/listarr.png"))); // NOI18N
        jMenuItem5.setText("Eliminar Producto");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem5);

        menuBar.add(jMenu5);

        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/factura.png"))); // NOI18N
        jMenu8.setText("Facturar");
        jMenu8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenuItem11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/facturacrear.png"))); // NOI18N
        jMenuItem11.setText("Crear Factura");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem11);

        jMenuItem10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/buscarfactura.png"))); // NOI18N
        jMenuItem10.setText("Buscar Factura");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem10);

        jMenuItem8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/modifi.png"))); // NOI18N
        jMenuItem8.setText("Modificar Factura");
        jMenu8.add(jMenuItem8);

        jMenuItem6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/deleteffac.png"))); // NOI18N
        jMenuItem6.setText("Anular Factura");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem6);

        menuBar.add(jMenu8);

        jMenu9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/agregarcate.png"))); // NOI18N
        jMenu9.setText("Categoria");
        jMenu9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMCC.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/agregarcat.png"))); // NOI18N
        jMCC.setText("Crear Categoria");
        jMCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMCCActionPerformed(evt);
            }
        });
        jMenu9.add(jMCC);

        jMBC.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMBC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/buscarcat.png"))); // NOI18N
        jMBC.setText("Buscar Categoria");
        jMBC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMBCActionPerformed(evt);
            }
        });
        jMenu9.add(jMBC);

        jMMC.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMMC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/modificarcat.png"))); // NOI18N
        jMMC.setText("Modificar Categoria");
        jMMC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMMCActionPerformed(evt);
            }
        });
        jMenu9.add(jMMC);

        menuBar.add(jMenu9);

        jMenu10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/proveed.png"))); // NOI18N
        jMenu10.setText("Registro Proveedor");
        jMenu10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenuItem13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/crearporvee.png"))); // NOI18N
        jMenuItem13.setText("Crear Registro");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem13);

        jMenuItem16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/buscarproveed.png"))); // NOI18N
        jMenuItem16.setText("Buscar Registro");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem16);

        jMenuItem17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/listarprovee.png"))); // NOI18N
        jMenuItem17.setText("Listar Registros");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem17);

        menuBar.add(jMenu10);

        jMenu11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/prov.png"))); // NOI18N
        jMenu11.setText("Proveedor");
        jMenu11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenuItem18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/provcrear.png"))); // NOI18N
        jMenuItem18.setText("Crear Proveedor");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem18);

        jMenuItem19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/provbuscar.png"))); // NOI18N
        jMenuItem19.setText("Buscar Proveedor");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem19);

        jMenuItem20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/provmodifi.png"))); // NOI18N
        jMenuItem20.setText("Modificar Proveedor");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem20);

        jMenuItem21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/provlistar.png"))); // NOI18N
        jMenuItem21.setText("Listar Proveedores");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem21);

        menuBar.add(jMenu11);

        jMenu12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/uni.png"))); // NOI18N
        jMenu12.setText("Unidades de Medida");
        jMenu12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenuItem12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/unicrear.png"))); // NOI18N
        jMenuItem12.setText("Crear Unidad");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem12);

        jMenuItem14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/unibuscar.png"))); // NOI18N
        jMenuItem14.setText("Buscar Unidad");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem14);

        jMenuItem15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imageness/unimodificar.png"))); // NOI18N
        jMenuItem15.setText("Modificar Unidad");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem15);

        menuBar.add(jMenu12);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
         String x = EliminarPersona.x;
        try {
            if (x == null) {
                if (eliminarPersona == null || eliminarPersona.isVisible() == false) {
                    eliminarPersona = new EliminarPersona(url, user, password);
                    desktop.add(eliminarPersona);
                }
            } else {
                JOptionPane.showMessageDialog(this, "La ventana ya esta abierta");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            Desktop.getDesktop().browse(new URI("https://github.com/DomenicaC/ProyectoFinalFarmacia"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error el URL no existe");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        // TODO add your handling code here:
          
        
        String x = RegistrarPersonas.x;
        try {
            if (x == null) {
                if (registrarPersonas == null || registrarPersonas.isVisible() == false) {
                    registrarPersonas = new RegistrarPersonas(personaControlador);
                    desktop.add(registrarPersonas);
                }
            } else {
                JOptionPane.showMessageDialog(this, "La ventana ya esta abierta");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }    
        
        
       
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
        // TODO add your handling code here:
        String x = BuscarPersonas.x;
        try {
            if (x == null) {
                if (buscarPersonas == null || buscarPersonas.isVisible() == false) {
                    buscarPersonas = new BuscarPersonas(personaControlador);
                    desktop.add(buscarPersonas);
                }
            } else {
                JOptionPane.showMessageDialog(this, "La ventana ya esta abierta");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_saveMenuItemActionPerformed

    private void saveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMenuItemActionPerformed
        // TODO add your handling code here:
        String x = modificarEliminar.x;
        try {
            if (x == null) {
                if (modificarEliminar == null || modificarEliminar.isVisible() == false) {
                    modificarEliminar = new ModificarEliminar(url, user, password);
                    desktop.add(modificarEliminar);
                }
            } else {
                JOptionPane.showMessageDialog(this, "La ventana ya esta abierta");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_saveAsMenuItemActionPerformed

    private void cutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutMenuItemActionPerformed
        // TODO add your handling code here:
        String x = crearEmpleado.x;
        try {
            if (x == null) {
                if (crearEmpleado == null || crearEmpleado.isVisible() == false) {
                    crearEmpleado = new CrearEmpleado(personaControlador);
                    desktop.add(crearEmpleado);
                }
            } else {
                JOptionPane.showMessageDialog(this, "La ventana ya esta abierta");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cutMenuItemActionPerformed

    private void copyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyMenuItemActionPerformed
        // TODO add your handling code here:
          String x = buscarEmpleado.x;
        try {
            if (x == null) {
                if (buscarEmpleado == null || buscarEmpleado.isVisible() == false) {
                    buscarEmpleado = new BuscarEmpleado(personaControlador);
                    desktop.add(buscarEmpleado);
                }
            } else {
                JOptionPane.showMessageDialog(this, "La ventana ya esta abierta");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_copyMenuItemActionPerformed

    private void pasteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteMenuItemActionPerformed
        // TODO add your handling code here:
              String x = modificarEmpleado.x;
        try {
            if (x == null) {
                if (modificarEmpleado == null || modificarEmpleado.isVisible() == false) {
                    modificarEmpleado = new ModificarEmpleado(personaControlador);
                    desktop.add(modificarEmpleado);
                }
            } else {
                JOptionPane.showMessageDialog(this, "La ventana ya esta abierta");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_pasteMenuItemActionPerformed

    private void deleteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMenuItemActionPerformed
        // TODO add your handling code here:
              String x = eliminarEmpleado.x;
        try {
            if (x == null) {
                if (eliminarEmpleado == null || eliminarEmpleado.isVisible() == false) {
                    eliminarEmpleado = new EliminarEmpleado(personaControlador);                    
                    desktop.add(eliminarEmpleado);
                }
            } else {
                JOptionPane.showMessageDialog(this, "La ventana ya esta abierta");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_deleteMenuItemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
             String x = crearProducto.x;
        try {
            if (x == null) {
                if (crearProducto == null || crearProducto.isVisible() == false) {
                    crearProducto = new CrearProducto(controladorProducto, categoriaControlador,unidadesControlador);
                    desktop.add(crearProducto);
                }
            } else {
                JOptionPane.showMessageDialog(this, "La ventana ya esta abierta");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
             String x = buscarProducto.x;
        try {
            if (x == null) {
                if (buscarProducto == null || buscarProducto.isVisible() == false) {
                    buscarProducto = new BuscarProducto(controladorProducto);
                    desktop.add(buscarProducto);
                }
            } else {
                JOptionPane.showMessageDialog(this, "La ventana ya esta abierta");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
               String x = modificarProducto.x;
        try {
            if (x == null) {
                if (modificarProducto == null || modificarProducto.isVisible() == false) {
                    modificarProducto = new ModificarProducto(controladorProducto, categoriaControlador, unidadesControlador);
                    desktop.add(modificarProducto);
                }
            } else {
                JOptionPane.showMessageDialog(this, "La ventana ya esta abierta");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
                String x = eliminarProducto.x;
        try {
            if (x == null) {
                if (eliminarProducto == null || eliminarProducto.isVisible() == false) {
                    eliminarProducto = new EliminarProducto(controladorProducto);
                    desktop.add(eliminarProducto);
                }
            } else {
                JOptionPane.showMessageDialog(this, "La ventana ya esta abierta");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
       String x = crearFactura.x;
        try {
            if (x == null) {
                if (crearFactura == null || crearFactura.isVisible() == false) {
                    crearFactura = new CrearFactura(fCabeceraControlador);
                    desktop.add(crearFactura);
                }
            } else {
                JOptionPane.showMessageDialog(this, "La ventana ya esta abierta");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
         String x = buscarFactura.x;
        try {
            if (x == null) {
                if (buscarFactura == null || buscarFactura.isVisible() == false) {
                    buscarFactura = new BuscarFactura(fCabeceraControlador);
                    desktop.add(buscarFactura);
                }
            } else {
                JOptionPane.showMessageDialog(this, "La ventana ya esta abierta");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
          String x = anularFactura.x;
        try {
            if (x == null) {
                if (anularFactura == null || anularFactura.isVisible() == false) {
                    anularFactura = new AnularFactura(fCabeceraControlador,controladorProducto);
                    desktop.add(anularFactura);
                }
            } else {
                JOptionPane.showMessageDialog(this, "La ventana ya esta abierta");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMCCActionPerformed
        String x = crearCategoria.x;
        try {
            if (x == null) {
                if (crearCategoria == null || crearCategoria.isVisible() == false) {
                    crearCategoria = new CrearCategoria(categoriaControlador);
                    desktop.add(crearCategoria);
                }
            } else {
                JOptionPane.showMessageDialog(this, "La ventana ya esta abierta");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMCCActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
            String x = cpp.x;
        try {
            if (x == null) {
                if (cpp == null || cpp.isVisible() == false) {
                    cpp = new CrearPP(controladorProducto, proveedorControlador, provProdControlador,categoriaControlador, unidadesControlador);
                    desktop.add(cpp);
                }
            } else {
                JOptionPane.showMessageDialog(this, "La ventana ya esta abierta");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        // TODO add your handling code here:
             String x = crearProveedor.x;
        try {
            if (x == null) {
                if (crearProveedor == null || crearProveedor.isVisible() == false) {
                    crearProveedor = new CrearProveedor(proveedorControlador);
                    desktop.add(crearProveedor);
                }
            } else {
                JOptionPane.showMessageDialog(this, "La ventana ya esta abierta");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        // TODO add your handling code here:
               String x = buscarProveedor.x;
        try {
            if (x == null) {
                if (buscarProveedor == null || buscarProveedor.isVisible() == false) {
                    buscarProveedor = new BuscarProveedor(proveedorControlador);
                    desktop.add(buscarProveedor);
                }
            } else {
                JOptionPane.showMessageDialog(this, "La ventana ya esta abierta");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        // TODO add your handling code here:
               String x = modificarProveedor.x;
        try {
            if (x == null) {
                if (modificarProveedor == null || modificarProveedor.isVisible() == false) {
                    modificarProveedor = new ModificarProveedor(proveedorControlador);
                    desktop.add(modificarProveedor);
                }
            } else {
                JOptionPane.showMessageDialog(this, "La ventana ya esta abierta");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        // TODO add your handling code here:
               String x = listarProveedores.x;
        try {
            if (x == null) {
                if (listarProveedores == null || listarProveedores.isVisible() == false) {
                    listarProveedores = new ListarProveedores(proveedorControlador);
                    desktop.add(listarProveedores);
                }
            } else {
                JOptionPane.showMessageDialog(this, "La ventana ya esta abierta");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        // TODO add your handling code here:
             String x = bpp.x;
        try {
            if (x == null) {
                if (bpp == null || bpp.isVisible() == false) {
                    bpp = new BuscarPP( provProdControlador);
                    desktop.add(bpp);
                }
            } else {
                JOptionPane.showMessageDialog(this, "La ventana ya esta abierta");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        // TODO add your handling code here:
                   String x = lpp.x;
        try {
            if (x == null) {
                if (lpp == null || lpp.isVisible() == false) {
                    lpp = new ListarPP( provProdControlador);
                    desktop.add(lpp);
                }
            } else {
                JOptionPane.showMessageDialog(this, "La ventana ya esta abierta");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMMCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMMCActionPerformed
       String x = crearCategoria.x;
        try {
            if (x == null) {
                if (modificarCategoria == null || modificarCategoria .isVisible() == false) {
                    modificarCategoria  = new ModificarCategoria (categoriaControlador);
                    desktop.add(modificarCategoria );
                }
            } else {
                JOptionPane.showMessageDialog(this, "La ventana ya esta abierta");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMMCActionPerformed

    private void jMBCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMBCActionPerformed
        String x = buscarCategoria.x;
        try {
            if (x == null) {
                if (buscarCategoria == null || buscarCategoria .isVisible() == false) {
                    buscarCategoria  = new BuscarCategoria (categoriaControlador);
                    desktop.add(buscarCategoria );
                }
            } else {
                JOptionPane.showMessageDialog(this, "La ventana ya esta abierta");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMBCActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        String x = crearUnidad.x;
        try {
            if (x == null) {
                if (crearUnidad == null || crearUnidad .isVisible() == false) {
                    crearUnidad  = new CrearUnidad(unidadesControlador);
                    desktop.add(crearUnidad);
                }
            } else {
                JOptionPane.showMessageDialog(this, "La ventana ya esta abierta");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        String x = buscarUnidad.x;
        try {
            if (x == null) {
                if (buscarUnidad == null || buscarUnidad .isVisible() == false) {
                    buscarUnidad  = new BuscarUnidad(unidadesControlador);
                    desktop.add(buscarUnidad);
                }
            } else {
                JOptionPane.showMessageDialog(this, "La ventana ya esta abierta");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        String x = modificarUnidad.x;
        try {
            if (x == null) {
                if (modificarUnidad == null || modificarUnidad .isVisible() == false) {
                    modificarUnidad = new ModificarUnidad(unidadesControlador);
                    desktop.add(modificarUnidad);
                }
            } else {
                JOptionPane.showMessageDialog(this, "La ventana ya esta abierta");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void botonreporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonreporteActionPerformed
        // TODO add your handling code here:
        try {
             BaseDeDatos db = new BaseDeDatos(url, user, password);
             db.conectar();       
          
        JasperReport reporte = null;
        String path = "src\\ec\\edu\\ups\\reportes\\PruebaReporte.jasper";        
        
            reporte = (JasperReport)JRLoader.loadObjectFromFile(path);            
            JasperPrint jprint = JasperFillManager.fillReport(reporte,null,db.getConexionBD());
            JasperViewer view = new JasperViewer(jprint,false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
            
            
        } catch (JRException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }//GEN-LAST:event_botonreporteActionPerformed

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
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonreporte;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    public static javax.swing.JDesktopPane desktop;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMBC;
    private javax.swing.JMenuItem jMCC;
    private javax.swing.JMenuItem jMMC;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

}
