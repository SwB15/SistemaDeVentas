package Vista.Caja;

import Controlador.Conexion;
import Vista.Principal;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author SwichBlade15
 */
public final class MovimientosCaja extends javax.swing.JInternalFrame {

    private final Conexion mysql = new Conexion();
    private Connection cn = Conexion.getConnection();
    ResultSet st;
    Date date = new Date();
    DateFormat hora, fecha;
    String fechaActual, horaActual;
    int ingresodia, egresodia;

    public MovimientosCaja() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setIconifiable(false);
        this.setBorder(null);
        
        fechaHora();
        movimiento();
        diferencia();
    }

    public void fechaHora() {
        fecha = new SimpleDateFormat("dd/MM/yyyy");
        fechaActual = fecha.format(date);
    }

    public void movimiento() {
        try {
            PreparedStatement ps = cn.prepareStatement("SELECT ingresodia, egresodia FROM caja WHERE fechaapertura = ? AND fechacierre = ?");
            ps.setString(1, fechaActual);
            ps.setString(2, "ABIERTO");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ingresodia = rs.getInt("ingresodia");
                egresodia = rs.getInt("egresodia");
            }
            txtIngresodia.setText(String.valueOf(ingresodia));
            txtEgresodia.setText(String.valueOf(egresodia));
        } catch (SQLException e) {
        }
    }
    
    public void diferencia(){
        int ingre = Integer.parseInt(txtIngresodia.getText());
        int egre = Integer.parseInt(txtEgresodia.getText());
        int resta;
        resta = ingre-egre;
        
        txtDiferencia.setText(String.valueOf(resta));
        
        if(ingre>egre){
            txtDiferencia.setBackground(new Color(204,255,204));
        }else{
            txtDiferencia.setBackground(new Color(255,229,229));
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

        lblCerrar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIngresodia = new javax.swing.JTextField();
        txtEgresodia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDiferencia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setBorder(null);
        setOpaque(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cerrar32.png"))); // NOI18N
        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarMouseClicked(evt);
            }
        });
        getContentPane().add(lblCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 14, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Movimiento");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 220, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ingresos");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 150, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Egresos");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 150, -1));

        txtIngresodia.setEditable(false);
        txtIngresodia.setBackground(new java.awt.Color(255, 255, 255));
        txtIngresodia.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtIngresodia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIngresodia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIngresodiaActionPerformed(evt);
            }
        });
        getContentPane().add(txtIngresodia, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 150, 30));

        txtEgresodia.setEditable(false);
        txtEgresodia.setBackground(new java.awt.Color(255, 255, 255));
        txtEgresodia.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtEgresodia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtEgresodia, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 150, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Diferencia");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 150, -1));

        txtDiferencia.setEditable(false);
        txtDiferencia.setBackground(new java.awt.Color(255, 255, 255));
        txtDiferencia.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtDiferencia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtDiferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 150, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoMovimientos.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        Principal.lblProceso.setText("Proceso: OFF");
        this.dispose();
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void txtIngresodiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIngresodiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIngresodiaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JTextField txtDiferencia;
    private javax.swing.JTextField txtEgresodia;
    private javax.swing.JTextField txtIngresodia;
    // End of variables declaration//GEN-END:variables
}
