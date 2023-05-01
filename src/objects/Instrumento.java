package objects;

/**
 * Clase para generación de instrumentos.
 */
public class Instrumento {
    //codigo del instrumento.
    private final String codigo;
    //precio del instrumento.
    private final int precio;
    //cantidad de unidades disponibles.
    private int stock;
    //¿qué instrumento es?
    private final String nombre;
    //material de construcción.
    private final String material;

    /**
     * Constructor de un instrumento.
     * @param codigo del instrumento.
     * @param precio del instrumento.
     * @param stock - Cantidad de unidades disponibles.
     * @param nombre - ¿Qué instrumento es?
     * @param material de fabricación.
     */
    public Instrumento(String codigo, int precio, int stock, String nombre, String material) {
        this.codigo = codigo;
        this.precio = precio;
        this.stock = stock;
        this.nombre = nombre;
        this.material = material;
    }

    /**
     * get's de cada atributo.
     */
    public String getCodigo() {
        return codigo;
    }

    public int getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMaterial() {
        return material;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
