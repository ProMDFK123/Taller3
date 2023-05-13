package objects;

import system.Utils;

public class Percusion extends Instrumento{
    private final String tipoPercusion;
    private final String altura;

    /**
     * Constructor de un instrumento de percusión.
     *
     * @param codigo del instrumento.
     * @param precio del instrumento.
     * @param stock - Cantidad de unidades disponibles.
     * @param nombre - ¿Qué instrumento es?
     * @param material de fabricación.
     * @param tipoPercusion - Forma de dispersión del sonido.
     * @param altura definida o indefinida.
     */
    public Percusion(String codigo, int precio, int stock, String nombre, String material, String tipoPercusion, String altura) {
        super(codigo, precio, stock, nombre, material);

        try{Utils.validarString(tipoPercusion);}catch (IllegalArgumentException ex){System.out.println("Ha ocurrido un error.");}
        this.tipoPercusion=tipoPercusion;

        try{Utils.validarString(altura);}catch (IllegalArgumentException ex){System.out.println("Ha ocurrido un error.");}
        this.altura=altura;
    }


    /**
     * @return la forma en que se transmite el sonido.
     */
    public String getTipoPercusion() {
        return tipoPercusion;
    }

    /**
     * @return si tiene altura definida o indefinida.
     */
    public String getAltura() {
        return altura;
    }
}
