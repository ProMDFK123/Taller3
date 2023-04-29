package objects;

/**
 * Clase para generación de instrumentos.
 */
public class Instrumento {
    //codigo del instrumento.
    private String codigo;
    //precio del instrumento.
    private int precio;
    //cantidad de unidades disponibles.
    private int stock;
    //¿qué instrumento es?
    private String nombre;
    //material de construcción.
    private String material;

    /**
     * Constructor de un instrumento.
     * @param codigo
     * @param precio
     * @param stock
     * @param nombre
     * @param material
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
}
