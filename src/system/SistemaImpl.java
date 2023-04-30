package system;

import com.opencsv.exceptions.CsvValidationException;
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
     * @throws CsvValidationException
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
     * @throws CsvValidationException
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
                //ToDo: metodos correspondientes a cada caso
            }
        }
    }

    /**
     * Método que carga y guarda en arreglos los diversos datos
     * ubicados en un archivo de tipo 'valores separados por coma' (CVS).
     * @param archivo a abrir.
     * @throws IOException
     * @throws CsvValidationException
     */
    @Override
    public void agregarInstrumento(String archivo) throws IOException{
        //
        BufferedReader lectura = new BufferedReader(new FileReader(archivo));
        String linea = lectura.readLine();

        while(linea!=null){
            String[] atributos = linea.split(",");

            if(atributos[0]=="Viento"){
                int precio = Integer.parseInt(atributos[2]);
                int stock = Integer.parseInt(atributos[3]);
                Instrumento viento = new Viento(atributos[1],precio,stock,atributos[4],atributos[5]);
                this.totalInstrumentos.agregar(viento);
                this.instrumentosViento.agregar(viento);
            } else if (atributos[0]=="Cuerda") {
                int precio = Integer.parseInt(atributos[2]);
                int stock = Integer.parseInt(atributos[3]);
                int cantCuerdas = Integer.parseInt(atributos[7]);
                Instrumento cuerda = new Cuerda(atributos[1],precio,stock,atributos[4],atributos[5], atributos[6], cantCuerdas, atributos[8]);
                this.totalInstrumentos.agregar(cuerda);
                this.instrumentosCuerda.agregar(cuerda);
            } else if (atributos[0]=="Percusion") {
                int precio = Integer.parseInt(atributos[2]);
                int stock = Integer.parseInt(atributos[3]);
                Instrumento percusion = new Percusion(atributos[1],precio,stock,atributos[4],atributos[5], atributos[6],atributos[7]);
                this.totalInstrumentos.agregar(percusion);
                this.instrumentosPercusion.agregar(percusion);
            }
            linea = lectura.readLine();
        }

        if(lectura!=null){
            lectura.close();
        }
    }

    @Override
    public void venderInstrumento(Instrumento instrumento) {

    }

    @Override
    public String consultarInventario() {
        return null;
    }

    @Override
    public void cierre(boolean estado) {

    }

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
}
