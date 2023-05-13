package system;

import contenedores.ListaInstrumento;
import objects.Instrumento;

import java.util.regex.Pattern;

/**
 * Clase auxiliar que contiene métodos auxiliares, como validaciones.
 */
public class Utils {
    private final static Pattern Code_Pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}");

    /**
     * Constructor Vacío.
     */
    private Utils() {}

    /**
     * Método que verifica si ya hay un instrumento en una ciertalista.
     * @param codigo a verificar su existencia.
     * @param lista en la cual se buscará el código del instrumento.
     * @return true si ya existe, false en caso contrario.
     */
    public static boolean codigoExiste(String codigo, ListaInstrumento lista){
        //Recorre la lista
        for(int i = 0; i<lista.getCantInstrumentos();i++){
            //Guarda el instrumento en la posición i
            Instrumento aux = lista.buscar(i);
            //Revisa si el instrumento ubicado en i tiene el mismo código a revisar.
            if(aux.getCodigo().equals(codigo)){
                //el código ingresado y el de un elemento en la lista coinciden.
                return true;
            }
        }
        //Se recorrio la lista y ningún elemento tiene el mismo código.
        return false;
    }

    /**
     * Método que valida si el código es válido o no.
     * @param codigoUnico - Código a validar
     */
    public static void validarCodigo(String codigoUnico){
        //Revisa si el código único ingresado NO sigue el patrón aceptado.
        if(!Code_Pattern.matcher(codigoUnico).matches()){
            throw new IllegalArgumentException("Código Invalido.");
        }
    }

    /**
     * Método que revisa si la lista está vacía.
     * @param lista a revisar.
     * @return true si esta vacía, false en caso contrario.
     */
    public static boolean listaVacia(ListaInstrumento lista){
        if(lista.getCantInstrumentos()==0){
            return true;
        }
        return false;
    }
}
