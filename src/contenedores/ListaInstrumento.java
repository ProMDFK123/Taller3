package contenedores;

import objects.Instrumento;

/**
 * Clase que genera listas de instrumentos.
 */
public class ListaInstrumento {
    //lista de instrumentos.
    private final Instrumento[] instrumentos;
    //capacidad maxima de la lista.
    private final int maximo;
    //cantidad de elementos en la lista.
    private int cantInstrumentos;

    /**
     * Constructor de una lista de instrumentos.
     *
     * @param maximo capacidad maxima de la lista.
     */
    public ListaInstrumento(int maximo) {
        this.maximo = maximo;
        this.instrumentos = new Instrumento[maximo];
        this.cantInstrumentos=0;
    }

    /**
     * Gets cant instrumentos.
     *
     * @return la cantidad de elementos en la lista.
     */
    public int getCantInstrumentos() {
        return cantInstrumentos;
    }

    /**
     * Método que busca un instrumento dado el código de este
     *
     * @param codigo del instrumento a buscar.
     * @return el instrumento en caso de encontrarlo, nulo en caso contrario.
     */
    public Instrumento buscar(String codigo){
        //Recorre la lista en busca del instrumento.
        for(int i=0;i<this.cantInstrumentos;i++){
            Instrumento instrumento = this.instrumentos[i];
            //Compara el código entregado con el de un elemento en la lista.
            if(instrumento.getCodigo().equals(codigo)){
                return instrumento;
            }
        }
        //Se recorrió toda la lista y el instrumento no se encontró.
        return null;
    }

    /**
     * Método booleano que comprueba si un instrumento ya existe o no.
     *
     * @param codigo del instrumento a verificar.
     * @return true si el instrumento existe, false en caso contrario.
     */
    public boolean existe(String codigo){
        return this.buscar(codigo)!=null;
    }

    /**
     * Método que agrega un nuevo instrumento a la lista.
     *
     * @param instrumento a agregar.
     */
    public void agregar(Instrumento instrumento){
        //Revisa si la lista no se encuentra vacía.
        if(this.cantInstrumentos>=this.maximo){
            System.out.println("La lista ya esta llena.");
            return;
        }

        //Revisa si el elemento ya existe en la lista o no.
        if(this.existe(instrumento.getCodigo())){
            System.out.println("El instrumento a agregar ya existe.");
            return;
        }

        this.instrumentos[this.cantInstrumentos]=instrumento;
        this.cantInstrumentos++;
    }

    /**
     * Método que busca un instrumento dada su posición.
     *
     * @param posicion a encontrar.
     * @return el instrumento en la posición dada.
     */
    public Instrumento buscar(int posicion){return this.instrumentos[posicion];}

    /**
     * Método que valida el código único ingresado.
     * @param codigo a validar.
     * @return true si el código es correcto, false en caso contrario.
     */
    public boolean validarCodigo(String codigo){
        //Recorre la lista.
        for(int i=0;i<this.cantInstrumentos;i++){
            //Instrumento auxiliar.
            Instrumento aux = this.instrumentos[i];
            //Comprueba si el código del instrumento auxiliar es igual al código ingresado.
            if (aux.getCodigo().equals(codigo)){
                //El código ingresado existe en la lista, por lo tanto, el código es válido.
                return true;
            }
        }
        //Se recorrió toda la lista y el código no es válido.
        return false;
    }
}
