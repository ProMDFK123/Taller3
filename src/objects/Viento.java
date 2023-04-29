package objects;

public class Viento extends Instrumento{
    /**
     * Constructor de un instrumento de viento.
     *
     * @param codigo
     * @param precio
     * @param stock
     * @param nombre
     * @param material
     */
    public Viento(String codigo, int precio, int stock, String nombre, String material) {
        super(codigo, precio, stock, nombre, material);
    }
}
