package objects;

import system.Utils;

/**
 * Clase que instancia instrumentos de cuerda.
 */
public class Cuerda extends Instrumento{
    //material de las cuerdas.
    private final String tipoCuerda;
    //cantidad de cuerdas que posee el instrumento.
    private final int cantidadCuerdas;
    //si el instrumento es acústico o eléctrico.
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

        try{Utils.validarString(tipoCuerda);}catch (IllegalArgumentException ex){System.out.println("Ha ocurrido un error.");}
        this.tipoCuerda=tipoCuerda;

        try{Utils.validarNumeros(cantidadCuerdas);}catch (IllegalArgumentException ex){System.out.println("Ha ocurrido un error.");}
        this.cantidadCuerdas=cantidadCuerdas;

        try{Utils.validarString(tipo);}catch (IllegalArgumentException ex){System.out.println("Ha ocurrido un error.");}
        this.tipo=tipo;
    }

    //Los Getters

    /**
     * @return el tipo de cuerdas que usa el instrumento.
     */
    public String getTipoCuerda() {
        return tipoCuerda;
    }

    /**
     * @return la cantidad de cuerdas del instrumento.
     */
    public int getCantidadCuerdas() {
        return cantidadCuerdas;
    }

    /**
     * @return el tipo de sonido del instrumento.
     */
    public String getTipo() {
        return tipo;
    }
}
