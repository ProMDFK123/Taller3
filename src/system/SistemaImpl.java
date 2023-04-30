package system;

import contenedores.ListaInstrumento;
import edu.princeton.cs.stdlib.StdIn;
import objects.Cuerda;
import objects.Instrumento;
import objects.Percusion;
import objects.Viento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase que implementa los contratos del sistema.
 */
public class SistemaImpl implements Sistema{
    //lista de todos los instrumentos.
    private final ListaInstrumento totalInstrumentos;
    //lista que gaurda todos los instrumentos de cuerda.
    private final ListaInstrumento instrumentosCuerda;
    //lista que guarda todos los instrumentos de percusión.
    private final ListaInstrumento instrumentosPercusion;
    //lista que guarda todos los instrumentos de viento.
    private final ListaInstrumento instrumentosViento;

    /**
     * Constructor del sistema.
     * @throws IOException

     */
    public SistemaImpl() throws IOException {
        totalInstrumentos = new ListaInstrumento(100);
        instrumentosCuerda = new ListaInstrumento(100);
        instrumentosPercusion = new ListaInstrumento(100);
        instrumentosViento = new ListaInstrumento(100);
        menu();
    }

    /**
     * Menu principal del programa.
     * @throws IOException
     */
    public void menu() throws IOException {
        //variable booleana que comprueba si el programa esta encendido o no.
        boolean encendido = true;

        //carga el archivo.
        String csv = "/home/gabo/Escritorio/Universidad/2023-I/Programación Avanzada/Talleres/Taller 3/Taller3/src/csv/instrumentos.csv";
        this.agregarInstrumento(csv);

        //ciclo infinito
        while(encendido) {
            //menu que aparece al inicial el programa.
            this.mainmenu();

            //registra la opcion escogida por el usuario.
            String opcion = StdIn.readString();
            switch (opcion) {
                case "1" -> venderInstrumento();
            }
        }
    }

    /**
     * Método que carga y guarda en arreglos los diversos datos
     * ubicados en un archivo de tipo 'valores separados por coma' (CVS).
     * @param archivo a abrir.
     * @throws IOException
     */
    @Override
    public void agregarInstrumento(String archivo) throws IOException{
        //lee el archivo cvs
        BufferedReader lectura = new BufferedReader(new FileReader(archivo));
        //lee la primera linea del archivo
        String linea = lectura.readLine();

        while(linea!=null){
            //Separa cada linea
            String[] atributos = linea.split(",");

            /*
            comprueba el tipo de instrumento,
            cambia a integer las variables pertinentes para
            crear un objeto instrumento, y lo almacena en sus
            correspondientes contenedores.
             */
            if(atributos[0]=="Viento"){
                int precio = Integer.parseInt(atributos[2]);
                int stock = Integer.parseInt(atributos[3]);
                Instrumento viento = new Viento(atributos[1],precio,stock,atributos[4],atributos[5]);
                this.totalInstrumentos.agregar(viento);
                Viento v = (Viento) viento;
                this.instrumentosViento.agregar(v);
            } else if (atributos[0]=="Cuerda") {
                int precio = Integer.parseInt(atributos[2]);
                int stock = Integer.parseInt(atributos[3]);
                int cantCuerdas = Integer.parseInt(atributos[7]);
                Instrumento cuerda = new Cuerda(atributos[1],precio,stock,atributos[4],atributos[5], atributos[6], cantCuerdas, atributos[8]);
                this.totalInstrumentos.agregar(cuerda);
                Cuerda c = (Cuerda) cuerda;
                this.instrumentosCuerda.agregar(c);
            } else if (atributos[0]=="Percusion") {
                int precio = Integer.parseInt(atributos[2]);
                int stock = Integer.parseInt(atributos[3]);
                Instrumento percusion = new Percusion(atributos[1],precio,stock,atributos[4],atributos[5], atributos[6],atributos[7]);
                this.totalInstrumentos.agregar(percusion);
                Percusion p = (Percusion) percusion;
                this.instrumentosPercusion.agregar(p);
            }
            //lee otra linea.
            linea = lectura.readLine();
        }
    }

    /**
     * Método que implementa la venta de un instrumento.
     * @param codigo del instrumento a vender
     */
    @Override
    public void venderInstrumentoImpl(String codigo) {
        //Revisa si el instrumento existe o no.
        if(!this.totalInstrumentos.existe(codigo)){
            System.out.println("El codigo ingresado no corresponde a ningun instrumento registrado.");
            return;
        }
        //El instrumento existe y es guardado en una variable auxilar.
        Instrumento instrumentoVendido = this.totalInstrumentos.buscar(codigo);

        //Valida si aun hay stock de dicho instrumento o no.
        if(instrumentoVendido.getStock()==0){
            System.out.println("No queda stock de este instrumento,");
            return;
        }

        //generación de una boleta.
        this.generarBoleta(instrumentoVendido);
        //Disminuye en 1 el stock del instrumento vendido.
        instrumentoVendido.setStock(instrumentoVendido.getStock()-1);
    }

    @Override
    public String consultarInventario() {
        return null;
    }

    /**
     * Método para cerrar el programa.
     * @param estado del prograna
     * @return false para que el programa finalice
     */
    @Override
    public boolean cierre(boolean estado) {return estado=false;}

    /**
     * Método auxiliar que despliega el menu principal del programa
     */
    private void mainmenu(){
        StringBuilder sb = new StringBuilder();
        sb.append("* BIENVENID@ A BEAT THE RYTHM *");
        sb.append("\n");
        sb.append("¿Qué desea hacer?");
        sb.append("\n");
        sb.append("1. Vender un instrumento.");
        sb.append("\n");
        sb.append("2. Consultar inventario.");
        sb.append("\n");
        sb.append("3. Salir.");
        String mainMenu = sb.toString();
        System.out.println(mainMenu);
    }

    /**
     * Método auxiliar que genera la boleta de una venta.
     * @param instrumento
     */
    public void generarBoleta(Instrumento instrumento){
        //Listas que almacenan la información de los vendedores.
        String[] CI = {"2825349", "2749256", "5465893","2578323","XX"};
        String[] vendedores = {"Yolanda Castro","Matias Rios","Yassine Valenzuela","Brenda Arnau","SIN NOMBRE"};

        //posición auxiliar.
        int posAux = (int) (Math.random()*5);
        //Recorre la lista hasta encontrar al vendedor, si este se ha registrado.
        for(int i = 0;i<5;i++){
            //Comprueba la info del vendedor.
            if(i==posAux){
                String ci = CI[i];
                String vendedor = vendedores[i];

                //generación de llaboleta.
                StringBuilder boleta = new StringBuilder();
                boleta.append("BEAT THE RYTHM\n");
                boleta.append("----------------------------------------------------------------\n");
                boleta.append("RUC O CI: "+ci+"\n");
                boleta.append("----------------------------------------------------------------\n");
                boleta.append("NOMBRE VENDEDOR: "+vendedor+"\n");
                boleta.append("----------------------------------------------------------------\n");
                boleta.append("CANTIDAD | DESCRIPCIÓN | PRECIO UNITARIO | IVA% | VALOR DE VENTA\n");
                boleta.append("----------------------------------------------------------------\n");
                boleta.append("1 | "+instrumento.getNombre()+" | "+instrumento.getPrecio()+" | 19% | "+instrumento.getPrecio());
                boleta.append("----------------------------------------------------------------\n");
                boleta.append("TOTAL A PAGAR: "+instrumento.getPrecio());
            }
        }
    }

    /**
     * Método del menú principal de una venta.
     */
    public void venderInstrumento(){
        //codigo a ingresar.
        String code;

        //menú principal.
        StringBuilder vender = new StringBuilder();
        vender.append("=========================\n");
        vender.append("= VENDER UN INSTRUMENTO =\n");
        vender.append("=========================\n");
        vender.append("\n");
        vender.append("Ingrese el código del instrumento: ");

        //Registro del código.
        code = StdIn.readString();
        //Realización de la venta.
        this.venderInstrumentoImpl(code);
    }
}
