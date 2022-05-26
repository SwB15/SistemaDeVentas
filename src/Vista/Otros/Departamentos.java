package Vista.Otros;

import Datos.DatosDepartamentos;
import Fuentes.Fuentes;
import Funciones.FuncionesDepartamentos;
import Vista.Notificaciones.Aceptar_Cancelar;
import Vista.Notificaciones.Advertencia;
import Vista.Notificaciones.Fallo;
import Vista.Notificaciones.Realizado;
import Vista.Principal;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SwichBlade15
 */
public final class Departamentos extends javax.swing.JInternalFrame {

    DatosDepartamentos datos = new DatosDepartamentos();
    FuncionesDepartamentos funcion = new FuncionesDepartamentos();
    boolean tecla = false;
    Fuentes tipofuentes;
    Icon fondoprueba;

    public Departamentos() {
        initComponents();
        inhabilitar();
        mostrar("");
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setIconifiable(false);
        this.setBorder(null);
        txtIddepartamentos.setVisible(false);
        txtBuscar.setText("Buscar Departamento...");
        botonesTransparentes();
        pmnuVentas.add(pnlPopupMenu);

        btnNuevo.setMnemonic(KeyEvent.VK_ENTER);
    }

    public void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            modelo = funcion.mostrar(buscar);
            tblDepartamentos.setModel(modelo);
            ocultar_columnas();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void inhabilitar() {
        txtDepartamentos.setEditable(false);
        txtDepartamentos.setText("");
        txtBuscar.setText("");

        btnEliminar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnNuevo.setEnabled(true);
    }

    public void habilitar() {
        txtDepartamentos.setEditable(true);
        txtDepartamentos.setText("");
        txtBuscar.setText("");

        txtBuscar.setEditable(true);
        btnGuardar.setEnabled(true);
        btnNuevo.setEnabled(false);
        btnEliminar.setEnabled(true);
    }

    public void ocultar_columnas() {
        tblDepartamentos.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDepartamentos.getColumnModel().getColumn(0).setMinWidth(0);
        tblDepartamentos.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    public void botonesTransparentes() {
        btnEliminar.setOpaque(false);
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.setBorderPainted(false);

        btnGuardar.setOpaque(false);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setBorderPainted(false);

        btnNuevo.setOpaque(false);
        btnNuevo.setContentAreaFilled(false);
        btnNuevo.setBorderPainted(false);

        pbtnEditar.setOpaque(false);
        pbtnEditar.setContentAreaFilled(false);
        pbtnEditar.setBorderPainted(false);

        pbtnEliminar.setOpaque(false);
        pbtnEliminar.setContentAreaFilled(false);
        pbtnEliminar.setBorderPainted(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pmnuVentas = new javax.swing.JPopupMenu();
        pnlPopupMenu = new javax.swing.JPanel();
        pbtnEditar = new javax.swing.JButton();
        pbtnEliminar = new javax.swing.JButton();
        lblFondoPopup = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        lblFondoBuscar = new javax.swing.JLabel();
        lblEncabezado = new javax.swing.JLabel();
        lblDepartamentos = new javax.swing.JLabel();
        txtIddepartamentos = new javax.swing.JTextField();
        txtDepartamentos = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDepartamentos = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        lblCerrar = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        pmnuVentas.setBorder(null);
        pmnuVentas.setBackground(new java.awt.Color(0,0,0,0));
        pmnuVentas.setBorder(null);
        pmnuVentas.setBorderPainted(false);

        pnlPopupMenu.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.setBorder(null);
        pnlPopupMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pbtnEditar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        pbtnEditar.setForeground(new java.awt.Color(0, 102, 255));
        pbtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Editar15.png"))); // NOI18N
        pbtnEditar.setText("Editar");
        pbtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pbtnEditarActionPerformed(evt);
            }
        });
        pnlPopupMenu.add(pbtnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 104, 25));

        pbtnEliminar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        pbtnEliminar.setForeground(new java.awt.Color(0, 102, 255));
        pbtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar15.png"))); // NOI18N
        pbtnEliminar.setText("Eliminar");
        pbtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pbtnEliminarActionPerformed(evt);
            }
        });
        pnlPopupMenu.add(pbtnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 32, 104, 25));

        lblFondoPopup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoPopup.png"))); // NOI18N
        pnlPopupMenu.add(lblFondoPopup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 60));

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(650, 443));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBuscar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(0, 102, 255));
        txtBuscar.setText("Buscar Departamento...");
        txtBuscar.setBorder(null);
        txtBuscar.setDisabledTextColor(new java.awt.Color(255, 255, 255));
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
        getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 73, 148, 18));

        lblFondoBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoBuscador.png"))); // NOI18N
        getContentPane().add(lblFondoBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, -1, -1));

        lblEncabezado.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        lblEncabezado.setForeground(new java.awt.Color(255, 255, 255));
        lblEncabezado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEncabezado.setText("Departamentos");
        getContentPane().add(lblEncabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 280, -1));

        lblDepartamentos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDepartamentos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDepartamentos.setText("Departamentos:");
        getContentPane().add(lblDepartamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 143, -1, -1));
        getContentPane().add(txtIddepartamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 21, -1));

        txtDepartamentos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDepartamentosActionPerformed(evt);
            }
        });
        txtDepartamentos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDepartamentosKeyTyped(evt);
            }
        });
        getContentPane().add(txtDepartamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 140, 200, -1));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar32.png"))); // NOI18N
        btnGuardar.setToolTipText("Guardar");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnGuardarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnGuardarMouseReleased(evt);
            }
        });
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 40, 40));

        tblDepartamentos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        tblDepartamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblDepartamentos.setComponentPopupMenu(pmnuVentas);
        tblDepartamentos.setFocusable(false);
        tblDepartamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDepartamentosMouseClicked(evt);
            }
        });
        tblDepartamentos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblDepartamentosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblDepartamentos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 238, 610, 180));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Nuevo32.png"))); // NOI18N
        btnNuevo.setToolTipText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, 40, 40));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar32.png"))); // NOI18N
        btnEliminar.setToolTipText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        btnEliminar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEliminarKeyPressed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, 40, 40));

        lblCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cerrar32.png"))); // NOI18N
        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarMouseClicked(evt);
            }
        });
        getContentPane().add(lblCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 14, -1, -1));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoDepartamentos.png"))); // NOI18N
        lblFondo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFondoMouseClicked(evt);
            }
        });
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtIddepartamentos.getText().length() == 0) {
            guardar();
        } else {
            editar();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        habilitar();
        txtDepartamentos.requestFocus();
        txtBuscar.setEditable(false);
        mostrar("");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtDepartamentosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDepartamentosKeyTyped
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

        int numerocaracteres = 39;
        if (txtDepartamentos.getText().length() > numerocaracteres) {
            evt.consume();
            mensaje = "Solo se permiten 40 caracteres";
            advertencia();
        }
    }//GEN-LAST:event_txtDepartamentosKeyTyped

    private void tblDepartamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDepartamentosMouseClicked
        int seleccionar = tblDepartamentos.rowAtPoint(evt.getPoint());
        txtIddepartamentos.setText(String.valueOf(tblDepartamentos.getValueAt(seleccionar, 0)));
        txtDepartamentos.setText(String.valueOf(tblDepartamentos.getValueAt(seleccionar, 1)));
        txtDepartamentos.setEditable(true);
        btnEliminar.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnNuevo.setEnabled(false);
        txtBuscar.setEnabled(false);
        txtDepartamentos.requestFocus();
    }//GEN-LAST:event_tblDepartamentosMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEliminarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEliminarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarKeyPressed

    private void txtDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDepartamentosActionPerformed
        if (txtIddepartamentos.getText().length() == 0) {
            guardar();
        } else {
            editar();
        }
    }//GEN-LAST:event_txtDepartamentosActionPerformed

    private void tblDepartamentosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDepartamentosKeyPressed

    }//GEN-LAST:event_tblDepartamentosKeyPressed

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        Principal.lblProceso.setText("Proceso: OFF");
        this.dispose();
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void txtBuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusGained
        if (tecla == false) {
            txtBuscar.setText("");
        }
    }//GEN-LAST:event_txtBuscarFocusGained

    private void txtBuscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusLost
        if (tecla == false) {
            txtBuscar.setText("Busque algo...");
        }
    }//GEN-LAST:event_txtBuscarFocusLost

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        txtBuscar.transferFocus();
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        tecla = true;
    }//GEN-LAST:event_txtBuscarKeyPressed

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

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        mostrar(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void pbtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pbtnEliminarActionPerformed
        eliminar();
    }//GEN-LAST:event_pbtnEliminarActionPerformed

    private void lblFondoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFondoMouseClicked
        if (evt.getClickCount() == 2) {
            inhabilitar();
            txtBuscar.setEditable(true);
            txtBuscar.requestFocus();
        }
    }//GEN-LAST:event_lblFondoMouseClicked

    private void btnGuardarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMousePressed
        fondoprueba = new ImageIcon(getClass().getResource("/Imagenes/PruebaGuardar.png"));
        btnGuardar.setIcon(fondoprueba);
    }//GEN-LAST:event_btnGuardarMousePressed

    private void btnGuardarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseReleased
        fondoprueba = new ImageIcon(getClass().getResource("/Imagenes/Guardar32.png"));
        btnGuardar.setIcon(fondoprueba);
    }//GEN-LAST:event_btnGuardarMouseReleased

    private void pbtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pbtnEditarActionPerformed
        editar();
    }//GEN-LAST:event_pbtnEditarActionPerformed

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
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblDepartamentos;
    private javax.swing.JLabel lblEncabezado;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblFondoBuscar;
    private javax.swing.JLabel lblFondoPopup;
    private javax.swing.JButton pbtnEditar;
    private javax.swing.JButton pbtnEliminar;
    private javax.swing.JPopupMenu pmnuVentas;
    private javax.swing.JPanel pnlPopupMenu;
    private javax.swing.JTable tblDepartamentos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDepartamentos;
    private javax.swing.JTextField txtIddepartamentos;
    // End of variables declaration//GEN-END:variables

    private void guardar() {
        if (txtDepartamentos.getText().length() == 0) {
            mensaje = "Ingrese un departamento";
            advertencia();

            txtDepartamentos.requestFocus();
            return;
        }

        datos.setDepartamentos(txtDepartamentos.getText());

        if (funcion.insertar(datos)) {
            mensaje = "Departamento guardado correctamente";
            realizado();
            mostrar("");
            inhabilitar();

        } else {
            mensaje = "Departamento no guardado";
            fallo();
            mostrar("");
        }
    }

    private void editar() {
        if (txtDepartamentos.getText().length() == 0) {
            mensaje = "Ingrese un Departamento";
            advertencia();

            txtDepartamentos.requestFocus();
            return;
        }

        datos.setIddepartamentos(Integer.parseInt(txtIddepartamentos.getText()));
        datos.setDepartamentos(txtDepartamentos.getText());

        if (funcion.editar(datos)) {
            mensaje = "Departamento actualizado correctamente";
            realizado();
            mostrar("");
            inhabilitar();
        } else {
            mensaje = "Departamento no actualizado";
            fallo();

        }
    }
    
    private void eliminar() {
        if (txtDepartamentos.getText().length() == 0) {
            mensaje = "Seleccione un departamento a eliminar";
            advertencia();
            txtDepartamentos.requestFocus();
        } else {
            encabezado = "Eliminar permanentemente";
            mensaje = "Esta seguro de eliminar este registro?";
            String reply = Principal.txtAceptarCancelar.getText();
            if (reply.equals("1")) {

                datos.setIddepartamentos(Integer.parseInt(txtIddepartamentos.getText()));

                if (funcion.eliminar(datos)) {
                    mensaje = "Departamento eliminado correctamente";
                    realizado();
                    txtDepartamentos.setText("");
                    mostrar("");
                    inhabilitar();
                } else {
                    mensaje = "Departamento no eliminado";
                    fallo();
                    mostrar("");
                }
            }
        }
    }
}
