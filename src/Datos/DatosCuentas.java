
package Datos;

/**
 *
 * @author SwichBlade15
 */
public class DatosCuentas {
    int idcuentas;
    String cuentas;
    String codigo;
    String atxtDescripcion;
    
    public DatosCuentas(){
        
    }

    public DatosCuentas(int idcuentas, String cuentas, String codigo, String atxtDescripcion) {
        this.idcuentas = idcuentas;
        this.cuentas = cuentas;
        this.codigo = codigo;
        this.atxtDescripcion = atxtDescripcion;
    }

    public int getIdcuentas() {
        return idcuentas;
    }

    public void setIdcuentas(int idcuentas) {
        this.idcuentas = idcuentas;
    }

    public String getCuentas() {
        return cuentas;
    }

    public void setCuentas(String cuentas) {
        this.cuentas = cuentas;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getAtxtDescripcion() {
        return atxtDescripcion;
    }

    public void setAtxtDescripcion(String atxtDescripcion) {
        this.atxtDescripcion = atxtDescripcion;
    }
}
