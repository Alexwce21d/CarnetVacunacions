package cDatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArchivoTextoDAO {

    private String mensajeError, nombreArchivo, linea;
    private ArrayList<String> lista = new ArrayList<>();

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public ArrayList<String> getLista() {
        return lista;
    }

    public void agregarLinea(String linea) {
        this.lista.add(linea);
    }

    //Metodos
    public int obtenerUltimoId(ArchivoTextoDAO objArchivoTextoDAO) {
        int nuevoId = 0;
        try (BufferedReader objBufferedReader = new BufferedReader(new FileReader(objArchivoTextoDAO.getNombreArchivo()))) {
            String linea = null;
            while ((linea = objBufferedReader.readLine()) != null) {

                String[] datos = linea.split(",");
                
                if (datos.length >= 5) {
                    int ultimoId = Integer.parseInt(datos[0]);
                    if (ultimoId > nuevoId) {
                        nuevoId = ultimoId;
                    }
                }
            }
        }catch (IOException ex){
    objArchivoTextoDAO.setMensajeError(ex.getMessage());
    }
    return nuevoId + 1;
}
    
//metodo agregar
    public void agregar(ArchivoTextoDAO objArchivoTextoDAO) {
    try (BufferedWriter objBufferedWriter = new BufferedWriter(new FileWriter(objArchivoTextoDAO.getNombreArchivo(), true))) {
        objBufferedWriter.write(objArchivoTextoDAO.getLinea());
        objBufferedWriter.newLine();
        
    }catch(IOException ex){
        objArchivoTextoDAO.setMensajeError(ex.getMessage());
    }
    
    
}
    
    
        
}

