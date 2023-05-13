package objects;

import system.Utils;

/**
 * Clase para generación de instrumentos.
 */
public class Instrumento {
    //código del instrumento.
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
        //Valida el código ingresado
        try{Utils.validarCodigo(codigo);}catch (IllegalArgumentException ex){System.out.println("Ha ocurrido un error.");}
        try{Utils.validarString(codigo);}catch (IllegalArgumentException ex){System.out.println("Ha ocurrido un error.");}
        this.codigo = codigo;

        try{Utils.validarNumeros(precio);}catch (IllegalArgumentException ex){System.out.println("Ha ocurrido un error.");}
        this.precio = precio;

        try{Utils.validarNumeros(precio);}catch (IllegalArgumentException ex){System.out.println("Ha ocurrido un error.");}
        this.stock = stock;

        try{Utils.validarString(nombre);}catch (IllegalArgumentException ex){System.out.println("Ha ocurrido un error.");}
        this.nombre = nombre;

        try{Utils.validarString(material);}catch (IllegalArgumentException ex){System.out.println("Ha ocurrido un error.");}
        this.material = material;
    }

    //Los Getters

    /**
     * @return el código único del instrumento.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @return el precio del instrumento.
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * @return la cantidad de unidades disponibles.
     */
    public int getStock() {
        return stock;
    }

    /**
     * @return el nombre del instrumento.
     * ¿Qué instrumento es?
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return el material de fabricación del instrumento.
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Modifica el valor del stock de un instrumento.
     * @param stock - Nuevo valor del stock.
     */
    public void setStock(int stock) {
        try{Utils.validarNumeros(stock);}catch (IllegalArgumentException ex){System.out.println("Ha ocurrido un error.");}
        this.stock = stock;
    }
}
