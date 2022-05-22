package Vista.Caja;

import Controlador.Conexion;
import Datos.DatosCaja;
import Funciones.FuncionesAuditoria;
import Funciones.FuncionesCaja;
import Vista.Notificaciones.Advertencia;
import Vista.Notificaciones.Fallo;
import Vista.Notificaciones.Realizado;
import Vista.Principal;
import java.awt.Color;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author SwichBlade15
 */
public final class CierreCaja extends javax.swing.JInternalFrame {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.getConnection();
    FuncionesCaja funcion = new FuncionesCaja();
    DatosCaja datos = new DatosCaja();
    TableRowSorter trs;
    JTable tabla;
    ResultSet rs;
    FuncionesAuditoria audi = new FuncionesAuditoria();
    DecimalFormat formateador14 = new DecimalFormat("#,##0.###");
    DefaultTableModel dfm = new DefaultTableModel();
    Date date = new Date();
    DateFormat fecha, hora;
    String fechaActual, horaActual, registros;
    int idcaja;

    public CierreCaja() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setIconifiable(false);
        this.setBorder(null);

        fechaHora();
        saldoApertura();
        botonesTransparentes();
    }
    
    public void botonesTransparentes() {
        btnGuardar.setOpaque(false);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setBorderPainted(false);

        btnSalir.setOpaque(false);
        btnSalir.setContentAreaFilled(false);
        btnSalir.setBorderPainted(false);
    }

    public void limpiar() {
        txtSaldoCierre.setText("");
    }

    public void fechaHora() {
        fecha = new SimpleDateFormat("dd/MM/yyyy");
        fechaActual = fecha.format(date);
        txtFecha.setText(fechaActual);

        hora = new SimpleDateFormat("HH:mm:ss");
        horaActual = hora.format(date);
        txtHora.setText(horaActual);
    }

    private void saldoApertura() {
        try {
            String sql = "SELECT saldoapertura FROM caja WHERE idcaja = (SELECT MAX(idcaja) FROM caja)";
            Statement st = cn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                txtSaldoApertura.setText(rs.getString("saldoapertura"));
            }
        } catch (SQLException ex) {
        }
    }

    private int idCaja() {
        String sql = "SELECT MAX(idcaja)As caja FROM caja";
        try {
            Statement st = cn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                idcaja = rs.getInt("caja");
            }
            return idcaja;
        } catch (SQLException e) {
            return 0;
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

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtSaldoApertura = new javax.swing.JTextField();
        txtSaldoCierre = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        lblPermisos = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textIDCaja = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setBorder(null);
        setIconifiable(true);
        setFrameIcon(null);
        setOpaque(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Fecha:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 12, -1, -1));

        txtFecha.setEditable(false);
        txtFecha.setBackground(new java.awt.Color(255, 255, 255));
        txtFecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 11, 180, 23));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Hora:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 55, -1, -1));

        txtHora.setEditable(false);
        txtHora.setBackground(new java.awt.Color(255, 255, 255));
        txtHora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 55, 180, 23));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Saldo Apertura:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 12, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Saldo Cierre:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(317, 58, -1, -1));

        txtSaldoApertura.setEditable(false);
        txtSaldoApertura.setBackground(new java.awt.Color(255, 255, 255));
        txtSaldoApertura.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtSaldoApertura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtSaldoApertura, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 11, 180, 23));

        txtSaldoCierre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSaldoCierre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSaldoCierreKeyReleased(evt);
            }
        });
        jPanel1.add(txtSaldoCierre, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 55, 180, 23));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonCajaSalir.png"))); // NOI18N
        btnSalir.setToolTipText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonCajaGuardar.png"))); // NOI18N
        btnGuardar.setToolTipText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, -1, 80));
        jPanel1.add(lblPermisos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 33, 21));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 660, 180));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Cierre de Caja");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 280, -1));

        textIDCaja.setBackground(new java.awt.Color(240, 240, 240));
        getContentPane().add(textIDCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(542, 20, 26, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoAperturaCaja.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtSaldoCierre.getText().length() == 0) {
            mensaje = "Ingrese un monto de cierre";
            advertencia();
            txtSaldoCierre.requestFocus();
        }

        datos.setSaldocierre(Integer.parseInt(txtSaldoCierre.getText().replace(".", "")));
        datos.setFechacierre(txtFecha.getText());
        datos.setHoracierre(txtHora.getText());
        idCaja();
        datos.setIdcaja(idcaja);

        if (funcion.cerrarCaja(datos)) {
            mensaje = "Caja cerrada exitosamente";
            realizado();

            Principal.smnuMovimientos.setEnabled(false);
            funcion.idCaja();
            funcion.idDetalleCaja();
            Principal.txtCaja.setText("Caja Cerrada");
            Principal.smnuAbrirCaja.setEnabled(true);
            Principal.smnuCerrarCaja.setEnabled(false);
            Principal.mnuCompras.setEnabled(false);
            Principal.mnuVentas.setEnabled(false);
            
            String usuario = Principal.lblUsuario.getText();
            String objeto = txtSaldoCierre.getText();
            String Accion = "CIERRE";
//            audi.audiclientes(usuario, objeto, Accion);
            
            dispose();
        } else {
            mensaje = "Error al cerrar la caja";
            fallo();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtSaldoCierreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaldoCierreKeyReleased
        if (txtSaldoCierre.getText().length() > 3) {
            String cadena = txtSaldoCierre.getText().replace(".", "");
            txtSaldoCierre.setText(formateador14.format(Integer.parseInt(cadena)));
        }
    }//GEN-LAST:event_txtSaldoCierreKeyReleased

    //Metodos para llamar a los JDialog de Advertencia, Fallo y Realizado
    Frame f = JOptionPane.getFrameForComponent(this);
    String mensaje;

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JLabel lblPermisos;
    private javax.swing.JTextField textIDCaja;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtSaldoApertura;
    private javax.swing.JTextField txtSaldoCierre;
    // End of variables declaration//GEN-END:variables
}
