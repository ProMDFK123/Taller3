package objects;

/**
 * Clase que instancia instrumentos de cuerda.
 */
public class Cuerda extends Instrumento{
    //material de las cuerdas.
    private final String tipoCuerda;
    //cantidad de cuerdas que posee el instrumento.
    private final int cantidadCuerdas;
    //si el instrumento es acustico o electrico.
    private final String tipo;

    /**
     * Constructor de un instrumento de cuerdas.
     * @param codigo del instrumento.
     * @param precio del instrumento.
     * @param stock - Cantidad de unidades disponibles.
     * @param nombre - ¿Qué instrumento es?
     * @param material de fabricación.
     * @param tipoCuerda - Tipo de cuerdas que usa.
     * @param cantidadCuerdas - Cantidad de cuerdas que posee el instrumento.
     * @param tipo de sonido.
     */
    public Cuerda(String codigo, int precio, int stock, String nombre, String material, String tipoCuerda, int cantidadCuerdas, String tipo) {
        super(codigo, precio, stock, nombre, material);
        this.tipoCuerda=tipoCuerda;
        this.cantidadCuerdas=cantidadCuerdas;
        this.tipo=tipo;
    }

    /**
     * get's de los aributos.
     */
    public String getTipoCuerda() {
        return tipoCuerda;
    }

    public int getCantidadCuerdas() {
        return cantidadCuerdas;
    }

    public String getTipo() {
        return tipo;
    }
}
