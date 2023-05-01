package objects;

public class Viento extends Instrumento{
    /**
     * Constructor de un instrumento de viento.
     *
     * @param codigo único del instrumento.
     * @param precio del instrumento.
     * @param stock - Cantidad de unidades disponibles.
     * @param nombre - ¿Qué instrumento es?
     * @param material de fabricación.
     */
    public Viento(String codigo, int precio, int stock, String nombre, String material) {
        super(codigo, precio, stock, nombre, material);
    }
}
