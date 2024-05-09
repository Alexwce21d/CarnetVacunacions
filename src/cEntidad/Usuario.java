package cEntidad;

import java.util.ArrayList;
import java.util.Date;

public class Usuario {
    // Atributos o datos
    private int id; // ID de usuario
    private String tipoDocumento; // Tipo de documento (p. ej., DNI, pasaporte)
    private String numeroDocumento; // Número del Documento
    private Date fechaEmisionDNI;   //fecha de emisión del DNI
    private Date fechaNacimiento;// Fecha de nacimiento
    private String mensajeError;// Mensaje de error
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>(); // Lista de usuarios

    //Getters and setters de atributos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Date getFechaEmisionDNI() {
        return fechaEmisionDNI;
    }

    public void setFechaEmisionDNI(Date fechaEmisionDNI) {
        this.fechaEmisionDNI = fechaEmisionDNI;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void agregarUsuario(Usuario usuario) {
        this.listaUsuarios.add(usuario);
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    //Método para validar el número DNI
    public boolean validateDNI(String dni) {
        // Comprobar si la longitud del DNI no es igual a 8
        if (dni.length() != 8) {
            // Si la longitud no es 8, devuelve falso (DNI no válido)
            return false;
        }
        // Extrae los dígitos de la cadena del DNI (primeros 8 caracteres)
        String digits = dni.substring(0, 8);
        // recorre cada carácter en la cadena de dígitos
        for (int i = 0; i < digits.length(); i++) {
            //Comprueba si el carácter no es un dígito
            if (!Character.isDigit(digits.charAt(i))) {
                // Si el carácter no es un dígito, devuelve falso (DNI no válido)
                return false;
            }
        }
        // Si pasan todas las comprobaciones, devuelve verdadero (DNI válido)
        return true;
    }
    
    

}
