package cNegocio;

// CapaNegocio: UsuarioService.java
import cDatos.ArchivoTextoDAO;
import cEntidad.Usuario;
import java.text.SimpleDateFormat;

public class UsuarioService {

    //agregar al archivo
    public void agregarUsuario(Usuario objUsuario) {
        ArchivoTextoDAO objArchivoTextoDAO = new ArchivoTextoDAO();
        objArchivoTextoDAO.setNombreArchivo("usuarios.txt");

        objUsuario.setId(objArchivoTextoDAO.obtenerUltimoId(objArchivoTextoDAO));
        if (objArchivoTextoDAO.getMensajeError() == null) {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            String fechaEmisionDNIFormateada = formatoFecha.format(objUsuario.getFechaEmisionDNI());
            String fechaNacimientoFormateada = formatoFecha.format(objUsuario.getFechaNacimiento());

            String linea = String.format("%d,%s,%s,%s,%s",
                    objUsuario.getId(),
                    objUsuario.getTipoDocumento(),
                    objUsuario.getNumeroDocumento(),
                    fechaEmisionDNIFormateada,
                    fechaNacimientoFormateada);

            objArchivoTextoDAO.setLinea(linea);
            objArchivoTextoDAO.agregar(objArchivoTextoDAO);
        } else {
            objUsuario.setMensajeError(objArchivoTextoDAO.getMensajeError());
        }
    }
    
    
    
}
