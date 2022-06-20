package Vista.Caja;

import Datos.DatosCuentas;
import Funciones.FuncionesCuentas;
import Vista.Notificaciones.Aceptar_Cancelar;
import Vista.Notificaciones.Advertencia;
import Vista.Notificaciones.Fallo;
import Vista.Notificaciones.Realizado;
import Vista.Principal;
import java.awt.Frame;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SwichBlade15
 */
public final class Cuentas extends javax.swing.JInternalFrame {

    FuncionesCuentas funcion = new FuncionesCuentas();
    DatosCuentas datos = new DatosCuentas();
    boolean tecla = false;

    public Cuentas() {
        initComponents();
        inhabilitar();
        mostrar("");
    }

    public void mostrar(String buscar) {
        try {
            //Llenar la tabla
            DefaultTableModel modelo;
            modelo = funcion.mostrar(buscar);
            tblCuentas.setModel(modelo);
//            ocultar_columnas();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void inhabilitar() {
        txtCuentas.setEditable(false);
        txtCodigo.setEditable(false);
        atxtDescripcion.setEditable(false);

        btnGuardar.setEnabled(false);
        btnNuevo.setEnabled(true);
        btnEliminar.setEnabled(false);
    }

    public void limpiarTextFields() {
        txtCuentas.setText("");
        txtCodigo.setText("");
        atxtDescripcion.setText("");
    }

    public void habilitar() {
        txtCuentas.setEditable(true);
        txtCodigo.setEditable(true);
        atxtDescripcion.setEditable(true);

        btnGuardar.setEnabled(true);
        btnNuevo.setEnabled(false);
        btnEliminar.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBuscar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCuentas = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        atxtDescripcion = new javax.swing.JTextArea();
        txtCodigo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCuentas = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        txtIdcuentas = new javax.swing.JTextField();
        lblFondoBuscar = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBuscar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(0, 102, 255));
        txtBuscar.setText("Buscar Cuentas...");
        txtBuscar.setBorder(null);
        txtBuscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarFocusLost(evt);
            }
        });
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });
        getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 72, 150, 17));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Cuenta:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 115, 50, -1));
        getContentPane().add(txtCuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 113, 166, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Descripcion:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 181, -1, -1));

        atxtDescripcion.setColumns(20);
        atxtDescripcion.setRows(5);
        jScrollPane1.setViewportView(atxtDescripcion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 181, -1, -1));
        getContentPane().add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 150, 166, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Codigo:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 152, 50, -1));

        tblCuentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblCuentas);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 299, -1, 205));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar32.png"))); // NOI18N
        btnEliminar.setToolTipText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(422, 236, 40, -1));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Nuevo32.png"))); // NOI18N
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 236, 40, -1));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar32.png"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 236, 40, -1));
        getContentPane().add(txtIdcuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 32, -1));

        lblFondoBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoBuscador.png"))); // NOI18N
        getContentPane().add(lblFondoBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 65, -1, 30));

        lblCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cerrar32.png"))); // NOI18N
        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarMouseClicked(evt);
            }
        });
        getContentPane().add(lblCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 11, -1, -1));

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
//        eliminar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        habilitar();
        txtCodigo.requestFocus();
        txtBuscar.setEditable(false);
        mostrar("");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtIdcuentas.getText().length() == 0) {
            guardar();
        } else {
            editar();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtBuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusGained
        if (tecla == false) {
            txtBuscar.setText("");
        }
    }//GEN-LAST:event_txtBuscarFocusGained

    private void txtBuscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusLost
        if (tecla == false) {
            txtBuscar.setText("Busque Cuentas...");
        }
    }//GEN-LAST:event_txtBuscarFocusLost

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        txtBuscar.transferFocus();
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        tecla = true;
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        mostrar(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }

        char validar = evt.getKeyChar();

        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
            mensaje = "Ingrese solo letras";
            advertencia();
        }

        int numerocaracteres = 19;
        if (txtBuscar.getText().length() > numerocaracteres) {
            evt.consume();
            mensaje = "Solo se permiten 20 caracteres";
            advertencia();
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        Principal.lblProceso.setText("Proceso: OFF");
        this.dispose();
    }//GEN-LAST:event_lblCerrarMouseClicked

    //Metodos para llamar a los JDialog de Advertencia, Fallo y Realizado
    Frame f = JOptionPane.getFrameForComponent(this);
    String encabezado;
    String mensaje;
    Icon icono;

    public void advertencia() {
        Advertencia dialog = new Advertencia(f, true);
        Advertencia.lblEncabezado.setText(mensaje);
        dialog.setVisible(true);
    }

    public void fallo() {
        Fallo dialog = new Fallo(f, true);
        Fallo.lblEncabezado.setText(mensaje);
        dialog.setVisible(true);
    }

    public void realizado() {
        Realizado dialog = new Realizado(f, true);
        Realizado.lblEncabezado.setText(mensaje);
        dialog.setVisible(true);
    }

    public void aceptarCancelar() {
        Aceptar_Cancelar dialog = new Aceptar_Cancelar(f, true);
        icono = new ImageIcon(getClass().getResource("/Imagenes/FondoCerrarSesion.png"));
        Aceptar_Cancelar.lblFondo.setIcon(icono);
        Aceptar_Cancelar.lblEncabezado.setText(encabezado);
        Aceptar_Cancelar.lblMensaje.setText(mensaje);
        dialog.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea atxtDescripcion;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    public static javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblFondoBuscar;
    private javax.swing.JTable tblCuentas;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCuentas;
    private javax.swing.JTextField txtIdcuentas;
    // End of variables declaration//GEN-END:variables

    public void guardar() {
//        validarCampos();

        datos.setCuentas(txtCuentas.getText());
        datos.setCodigo(txtCodigo.getText());
        datos.setDescripcion(atxtDescripcion.getText());

        if (funcion.insertar(datos)) {
            mensaje = "Cuenta guardada correctamente";
            realizado();
            mostrar("");
            inhabilitar();
        } else {
            mensaje = "Cuenta no guardada";
            fallo();
            mostrar("");
        }
    }

    public void editar() {
//        validarCampos();

        datos.setIdcuentas(Integer.parseInt(txtIdcuentas.getText()));
        datos.setCuentas(txtCuentas.getText());
        datos.setCodigo(txtCodigo.getText());
        datos.setDescripcion(atxtDescripcion.getText());
        
        if (funcion.editar(datos)) {
            mensaje = "Cuenta editada correctamente";
            realizado();
            mostrar("");
            inhabilitar();
        } else {
            mensaje = "Cuenta no editada";
            fallo();
            mostrar("");
        }
    }

    public void eliminar() {
        if (txtCuentas.getText().length() == 0) {
            mensaje = "Debes seleccionar primero una cuenta a eliminar.";
            advertencia();
            txtCuentas.requestFocus();
        } else {
            encabezado = "Eliminar permanentemente";
            mensaje = "Esta seguro de eliminar este registro?";
            String reply = Principal.txtAceptarCancelar.getText();
            if (reply.equals("1")) {

                datos.setIdcuentas(Integer.parseInt(txtIdcuentas.getText()));

                if (funcion.eliminar(datos)) {
                    mensaje = "Cuenta eliminada correctamente";
                    realizado();
                    txtCuentas.setText("");
                    mostrar("");
                    inhabilitar();
                } else {
                    mensaje = "Cuenta no eliminada";
                    fallo();
                    mostrar("");
                }
            }
        }
    }
}
