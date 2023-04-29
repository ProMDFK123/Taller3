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

    /**
     * Método que busca un instrumento dado el codigo de este
     * @param codigo del instrumento a buscar.
     * @return el instrumento en caso de encontrarlo, nulo en caso contrario.
     */
    public Instrumento buscar(String codigo){
        //Recorre la lista en busca del instrumento.
        for(int i=0;i<this.cantInstrumentos;i++){
            Instrumento instrumento = this.instrumentos[i];
            //Compara el codigo entregado con el de un elemento en la lista.
            if(instrumento.getCodigo().equals(codigo)){
                return instrumento;
            }
        }
        //Se recorrio toda la lista y el instrumento no se encontro.
        System.out.println("No existe instrumento con ese codigo.");
        return null;
    }

    /**
     * Método booleano que comprueba si un instrumento ya existe o no.
     * @param codigo del instrumento a verificar.
     * @return true si el instrumento existe, false en caso contrario.
     */
    public boolean existe(String codigo){
        return this.buscar(codigo)!=null;
    }

    /**
     * Método que agrega un nuevo instrumento a la lista.
     * @param instrumento a agregar.
     */
    public void agregar(Instrumento instrumento){
        //Revisa si la lista no se encuentra vacia.
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
}
