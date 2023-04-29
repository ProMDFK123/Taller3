package contenedores;

import objects.Instrumento;

/**
 * Clase que genera listas de instrumentos.
 */
public class ListaInstrumento {
    //lista de instrumentos.
    private Instrumento[] instrumentos;
    //capacidad maxima de la lista.
    private int maximo;
    //cantidad de elementos en la lista.
    private int cantInstrumentos;

    /**
     * Constructor de una lista de instrumentos.
     * @param maximo capacidad maxima de la lista.
     */
    public ListaInstrumento(int maximo) {
        this.maximo = maximo;
        this.instrumentos = new Instrumento[maximo];
        this.cantInstrumentos=0;
    }

    /**
     * @return la cantidad maxima de la lista.
     */
    public int getMaximo() {
        return maximo;
    }

    /**
     * @return la cantidad de elementos en la lista.
     */
    public int getCantInstrumentos() {
        return cantInstrumentos;
    }
}
