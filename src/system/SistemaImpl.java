package system;

import contenedores.ListaInstrumento;
import edu.princeton.cs.stdlib.StdIn;
import objects.Instrumento;

/**
 * Clase que implementa los contratos del sistema.
 */
public class SistemaImpl implements Sistema{
    private ListaInstrumento totalInstrumentos;
    private ListaInstrumento instrumentosCuerda;
    private ListaInstrumento instrumentosPercusion;
    private ListaInstrumento instrumentosViento;

    public SistemaImpl() {
        totalInstrumentos = new ListaInstrumento(100);
        instrumentosCuerda = new ListaInstrumento(100);
        instrumentosPercusion = new ListaInstrumento(100);
        instrumentosViento = new ListaInstrumento(100);
        menu();
    }

    public void menu(){
        boolean estado = true;

        while(estado) {
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

            String opcion = StdIn.readString();
            switch (opcion) {
                //ToDo: metodos correspondientes a cada caso
            }
        }
    }

    @Override
    public void agregarInstrumento(String direccionArchivo) {

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
}
