package Vista.Productos;

import Controlador.Conexion;
import Funciones.FuncionesProductos;
import static Vista.Principal.jDesktopPane1;
import static Vista.Principal.lblProceso;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author SwichBlade15
 */
public final class Baja extends javax.swing.JInternalFrame {

    FuncionesProductos funcion = new FuncionesProductos();
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.getConnection();
    public Integer totalRegistros;
    ResultSet rs;
    Statement st;
    PreparedStatement ps;
    String busqueda = "";
    DefaultTableModel model;

    public Baja() {
        initComponents();
        atxtMotivo.setEditable(false);
//        llenarTabla("");
        columnas();
    }
    
    private void columnas(){
        model = (DefaultTableModel)tblBaja.getModel();
        model.addColumn("Codigo");
        model.addColumn("Productos");
        
        TableColumnModel columna = tblBaja.getColumnModel();
        
        columna.getColumn(0).setPreferredWidth(20);
        columna.getColumn(1).setPreferredWidth(200);
        tblBaja.setModel(model);
    }

    void llenarTabla(String buscar) {
        try {
            String[] titulos = {"ID", "Codigo", "Productos"};
            model = new DefaultTableModel(null, titulos);
            String stsql = "SELECT idproductos, productos, codigo FROM productos";

            switch (busqueda) {
                default:
                    st = cn.createStatement();
                    rs = st.executeQuery(stsql);
                    break;
                case "codigo":
                    stsql = stsql + " WHERE codigo LIKE '%" + buscar + "%'";
                    st = cn.createStatement();
                    rs = st.executeQuery(stsql);
                    System.out.println(stsql);
                    break;
                case "productos":
                    stsql = stsql + " WHERE productos LIKE '%" + buscar + "%'";
                    st = cn.createStatement();
                    rs = st.executeQuery(stsql);
                    System.out.println(stsql);
                    break;
            }

            String[] fila = new String[3];
            while (rs.next()) {
                fila[0] = rs.getString("idproductos");
                fila[1] = rs.getString("codigo");
                fila[2] = rs.getString("productos");

                model.addRow(fila);
            }
            tblBaja.setModel(model);
            ocultar_columnas();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void ocultar_columnas() {
        tblBaja.getColumnModel().getColumn(0).setMaxWidth(0);
        tblBaja.getColumnModel().getColumn(0).setMinWidth(0);
        tblBaja.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtProductos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dchCompra = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        dchVencimiento = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        cmbMotivo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        atxtMotivo = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBaja = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        spnCantidad = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();

        setTitle("Baja de Productos");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Producto:");

        txtProductos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtProductos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtProductosFocusGained(evt);
            }
        });
        txtProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProductosKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("F. Compra:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("F. Vencimiento:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Motivo:");

        cmbMotivo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbMotivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Daños por agua", "Vencimiento", "Oxidación", "Rotura", "Daños de Fábrica", "Daños en transporte", "Error en carga", "Otros" }));
        cmbMotivo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMotivoItemStateChanged(evt);
            }
        });

        atxtMotivo.setColumns(20);
        atxtMotivo.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        atxtMotivo.setRows(5);
        jScrollPane1.setViewportView(atxtMotivo);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Codigo:");

        txtCodigo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodigoFocusGained(evt);
            }
        });
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoKeyReleased(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar32.png"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        tblBaja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblBaja);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Cantidad:");

        jButton1.setText("Seleccionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        spnCantidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        spnCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 0, 30, 1));
        spnCantidad.setToolTipText("");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Descripcion:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(5, 5, 5)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dchCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dchVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1)
                            .addComponent(txtProductos))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dchCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dchVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addComponent(btnGuardar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
//        if (txtIdproductos.getText().length() == 0) {
//            guardar();
//        } else {
//            auditoria();
//            editar();
//        }
//        control.cantidadMinima();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyReleased
        llenarTabla(txtCodigo.getText());
    }//GEN-LAST:event_txtCodigoKeyReleased

    private void txtCodigoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoFocusGained
        busqueda = "codigo";
    }//GEN-LAST:event_txtCodigoFocusGained

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if (evt.getClickCount() == 2) {
            llenarTabla("");
            txtCodigo.setText("");
            txtProductos.setText("");
            dchVencimiento.setCalendar(null);
            dchCompra.setCalendar(null);
        }
    }//GEN-LAST:event_formMouseClicked

    private void txtProductosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductosFocusGained
        busqueda = "productos";
    }//GEN-LAST:event_txtProductosFocusGained

    private void cmbMotivoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMotivoItemStateChanged
        if (evt.getSource() == cmbMotivo) {
            if (cmbMotivo.getSelectedItem().toString().equals("Otros")) {
                atxtMotivo.setEditable(true);
            } else {
                atxtMotivo.setEditable(false);
            }
        }
    }//GEN-LAST:event_cmbMotivoItemStateChanged

    private void txtProductosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductosKeyReleased
        llenarTabla(txtProductos.getText());
    }//GEN-LAST:event_txtProductosKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SeleccionarProductosBaja form = new SeleccionarProductosBaja();
        jDesktopPane1.add(form);
        lblProceso.setText("Proceso: ON");

        form.setClosable(true);
        form.setIconifiable(true);
        try {
            Dimension desktopSize = jDesktopPane1.getSize();
            Dimension FrameSize = form.getSize();
            form.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
            form.show();
        } catch (Exception e) {
        }

        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea atxtMotivo;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbMotivo;
    private com.toedter.calendar.JDateChooser dchCompra;
    private com.toedter.calendar.JDateChooser dchVencimiento;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner spnCantidad;
    private javax.swing.JTable tblBaja;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtProductos;
    // End of variables declaration//GEN-END:variables
}
