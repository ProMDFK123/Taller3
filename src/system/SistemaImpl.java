package system;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import contenedores.ListaInstrumento;
import edu.princeton.cs.stdlib.StdIn;
import objects.Cuerda;
import objects.Instrumento;
import objects.Percusion;
import objects.Viento;

import java.io.FileNotFoundException;
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
    public SistemaImpl() throws IOException, CsvValidationException {
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
    public void menu() throws IOException, CsvValidationException {
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
     * Método que carga y guarda en arreglos los diversos datos.
     * @param archivo a abrir.
     * @throws IOException
     * @throws CsvValidationException
     */
    @Override
    public void agregarInstrumento(String archivo) throws IOException, CsvValidationException {
        CSVReader csvReader = new CSVReader(new FileReader(archivo));
        String[] fila = null;

        //recorre cada linea de archivo
        while ((fila = csvReader.readNext())!=null){
            //convierte el 3er y 4to dato de cada linea en variables de tipo integer.
            int precio = Integer.parseInt(fila[2]);
            int stock = Integer.parseInt(fila[3]);

            //valida el tipo de instrumento, lo genera, y lo guarda en las correspondientes listas.
            if(fila[0]=="Cuerda"){
                int cantidadCuerdas = Integer.parseInt(fila[7]);
                Instrumento instrumento = new Cuerda(fila[1], precio,stock,fila[4],fila[5],fila[6], cantidadCuerdas,fila[8]);
                this.totalInstrumentos.agregar(instrumento);
                this.instrumentosCuerda.agregar(instrumento);
            } else if (fila[0]=="Percusion") {
                Instrumento instrumento = new Percusion(fila[1], precio,stock,fila[4],fila[5],fila[6],fila[7]);
                this.totalInstrumentos.agregar(instrumento);
                this.instrumentosPercusion.agregar(instrumento);
            } else if (fila[0]=="Viento") {
                Instrumento instrumento = new Viento(fila[1], precio,stock,fila[4],fila[5]);
                this.totalInstrumentos.agregar(instrumento);
                this.instrumentosViento.agregar(instrumento);
            }
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
