package system;

import contenedores.ListaInstrumento;
import objects.Instrumento;

import java.util.regex.Pattern;

/**
 * Clase auxiliar que contiene métodos auxiliares, como validaciones.
 */
public class Utils {
    private Pattern Code_Pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}");
    /**
     * Constructor Vacío.
     */
    public Utils() {}

    /**
     * Método que verifica si ya hay un instrumento en una ciertalista.
     * @param codigo a verificar su existencia.
     * @param lista en la cual se buscará el código del instrumento.
     * @return true si ya existe, false en caso contrario.
     */
    public boolean codigoExiste(String codigo, ListaInstrumento lista){
        //Recorre la lista
        for(int i = 0; i<lista.getCantInstrumentos();i++){
            Instrumento aux = lista.buscar(i);
            if(aux.getCodigo().equals(codigo)){
                return true;
            }
        }
        return false;
    }

    /**
     * Método que valida si el código es válido o no.
     * @param codigoUnico - Código a validar
     */
    public void validarCodigo(String codigoUnico){
        if(!Code_Pattern.matcher(codigoUnico).matches()){
            throw new IllegalArgumentException("Código Invalido.");
        }
    }
}
