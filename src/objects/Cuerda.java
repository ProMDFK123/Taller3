package objects;

/**
 * Clase que instancia instrumentos de cuerda.
 */
public class Cuerda extends Instrumento{
    //material de las cuerdas.
    private String tipoCuerda;
    //cantidad de cuerdas que posee el instrumento.
    private int cantidadCuerdas;
    //si el instrumento es acustico o electrico.
    private String tipo;

    /**
     * Constructor de un instrumento de cuerdas.
     * @param codigo
     * @param precio
     * @param stock
     * @param nombre
     * @param material
     * @param tipoCuerda
     * @param cantidadCuerdas
     * @param tipo
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
