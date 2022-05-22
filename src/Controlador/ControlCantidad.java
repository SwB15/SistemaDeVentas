package Controlador;

import Funciones.FuncionesNotificaciones;
import Vista.Principal;
import static Vista.Principal.lblContadorNotificaciones;
import static Vista.Principal.lblNotificaciones;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SwichBlade15
 */
public class ControlCantidad {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.getConnection();
    FuncionesNotificaciones notificaciones = new FuncionesNotificaciones();
    int totalRegistros, i, cant, min, contador;
    String sSQL;
    int x, y;

    public DefaultTableModel actualizar(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"Codigo", "Productos", "Cantidad"};
        String[] registros = new String[3];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT idproductos, productos, cantidadminima FROM productos WHERE cantidad <= cantidadminima ORDER BY idproductos DESC";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registros[0] = rs.getString("idproductos");
                registros[1] = rs.getString("productos");
                registros[2] = rs.getString("cantidadminima");

                totalRegistros = totalRegistros + 1;
                modelo.addRow(registros);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    public void mostrar(String buscar) {
        //Llenar la tabla Cantidades
        DefaultTableModel modelo2;
        modelo2 = actualizar(buscar);
        Principal.tblCantidadMinima.setModel(modelo2);
    }


    public void cantidadMinima() {
        if (Principal.tblCantidadMinima.getRowCount() > 0) {
            for (i = 0; i< Principal.tblCantidadMinima.getRowCount(); i++) {
                notificaciones.agregar(String.valueOf("El producto "+Principal.tblCantidadMinima.getValueAt(0, 1)), "Ha alcanzado su cantidad minima");
            }
            notificaciones.cont();
        }
    }

    public void cont() {
        if (lblContadorNotificaciones.getText().equals("0")) {
            lblNotificaciones.setVisible(false);
            lblContadorNotificaciones.setVisible(false);
        } else {
            lblNotificaciones.setVisible(true);
            lblContadorNotificaciones.setVisible(true);
        }
    }
}
