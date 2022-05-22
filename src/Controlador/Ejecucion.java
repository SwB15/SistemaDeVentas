package Controlador;

import Funciones.FuncionesUsuarios;
import Vista.Instalacion;
import Vista.Login;

/**
 *
 * @author SwichBlade15
 */
public class Ejecucion {

    public static void main(String[] args) {
        if (new Control().comprobar()) {
            FuncionesUsuarios funcion = new FuncionesUsuarios();
            int cantidadUsuarios = funcion.ContarUsuarios();

            if (cantidadUsuarios == 0) {
                Instalacion form = new Instalacion();
                form.setResizable(false);
                form.toFront();
                form.setVisible(true);
                form.setLocationRelativeTo(null);
            } else {
                Login form = new Login();
                form.setResizable(false);
                form.toFront();
                form.setVisible(true);
                form.setLocationRelativeTo(null);
            }
        } else {
            System.exit(0);
        }
    }
}
