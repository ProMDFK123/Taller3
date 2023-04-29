package objects;

public class Percusion extends Instrumento{
    private String tipoPercusion;
    private String altura;

    /**
     * Constructor de un instrumento de percusion.
     *
     * @param codigo
     * @param precio
     * @param stock
     * @param nombre
     * @param material
     * @param tipoPercusion
     * @param altura
     */
    public Percusion(String codigo, int precio, int stock, String nombre, String material, String tipoPercusion, String altura) {
        super(codigo, precio, stock, nombre, material);
        this.tipoPercusion=tipoPercusion;
        this.altura=altura;
    }

    /**
     * get's de los atributos.
     */
    public String getTipoPercusion() {
        return tipoPercusion;
    }

    public String getAltura() {
        return altura;
    }
}
