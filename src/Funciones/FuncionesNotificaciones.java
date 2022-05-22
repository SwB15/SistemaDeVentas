package Funciones;

import Vista.Principal;
import static Vista.Principal.lblContadorNotificaciones;
import static Vista.Principal.lblNotificaciones;
import javax.swing.JPanel;

/**
 *
 * @author SwichBlade15
 */
public class FuncionesNotificaciones {

    
    JPanel pnlNot = new JPanel();
    private int contador = 0;

    public void agregar(String dato, String descripcion) {

        contador = Integer.parseInt(Principal.txtContadorNotificaciones.getText());
        
        contador = contador + 1;
        System.out.println("COntador final: " + contador);
        //Agregar datos a la tabla        
        String datos[] = new String[3];
        datos[0] = String.valueOf(contador);
        datos[1] = String.valueOf(dato);
        datos[2] = String.valueOf(descripcion);
        Principal.modelo.addRow(datos);
        Principal.tblNotificaciones.setModel(Principal.modelo);

        int cantidadNotificaciones = Principal.modelo.getRowCount();

        if (cantidadNotificaciones < 100) {
            Principal.lblContadorNotificaciones.setText(String.valueOf(cantidadNotificaciones));
        } else {
            Principal.lblContadorNotificaciones.setText(String.valueOf("+99"));
        }
        
        Principal.txtContadorNotificaciones.setText(String.valueOf(contador));
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
