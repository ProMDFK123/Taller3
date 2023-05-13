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
    //lista que guarda todos los instrumentos de cuerda.
    private final ListaInstrumento instrumentosCuerda;
    //lista que guarda todos los instrumentos de percusión.
    private final ListaInstrumento instrumentosPercusion;
    //lista que guarda todos los instrumentos de viento.
    private final ListaInstrumento instrumentosViento;

    /**
     * Constructor del sistema.
     * @throws IOException en caso de error.
     */
    public SistemaImpl() throws IOException {
        //Generación de las listas sobredimensionadas.
        totalInstrumentos = new ListaInstrumento(100);
        instrumentosCuerda = new ListaInstrumento(100);
        instrumentosPercusion = new ListaInstrumento(100);
        instrumentosViento = new ListaInstrumento(100);
        //ejecuta el main.
        menu();
    }

    /**
     * Menu principal del programa.
     * @throws IOException en caso de error.
     */
    public void menu() throws IOException {
        //Variable booleana que indica si el programa se encuentra encendido o no.
        boolean encendido = true;

        //Ubicación del archivo.
        String csv = "/home/gabo/Escritorio/Universidad/2023-I/Programación Avanzada/Talleres/Taller 3/Taller3/src/csv/instrumentos.csv";

        //ciclo infinito
        while(encendido) {
            //menu que aparece al inicial el programa.
            this.mainmenu();

            //registra la opción escogida por el usuario.
            String opcion = StdIn.readString();
            switch (opcion) {
                //Agrega y/o actualiza la lista de instrumentos.
                case "1" -> agregarInstrumento(csv);
                //Vende un instrumento.
                case "2" -> venderInstrumento();
                //Consulta el inventario.
                case "3" -> consultarInventario();
                //Cierra la sesión.
                case "4" -> encendido = cierre(encendido);
                //Se ingresó una opción inválida.
                default -> System.out.println("Opción Invalida, intente nuevamente.");
            }
        }
    }

    /**
     * Método que carga y guarda en arreglos los diversos datos
     * ubicados en un archivo de tipo 'valores separados por coma' (CVS).
     * @param archivo a abrir.
     * @throws IOException en caso de error.
     */
    @Override
    public void agregarInstrumento(String archivo) throws IOException{
        //lee el archivo cvs
        BufferedReader lectura = new BufferedReader(new FileReader(archivo));
        //lee la primera linea del archivo
        String linea = lectura.readLine();

        //Ciclo infinito.
        while(linea!=null){
            //Separa cada línea
            String[] atributos = linea.split(",");

            //Revisa el tipo de instrumento.
            switch (atributos[0]) {
                //Para instrumentos de viento.
                case "Viento" -> {
                    //Revisa si la lista esta vacía.
                    if (Utils.listaVacia(this.totalInstrumentos)) {
                        //Casteo de las variables necesarias.
                        int precio = Integer.parseInt(atributos[2]);
                        int stock = Integer.parseInt(atributos[3]);
                        //Crea un elemento.
                        Instrumento viento = new Viento(atributos[1], precio, stock, atributos[4], atributos[5]);
                        //Agrega el elemento a las listas correspondientes.
                        this.totalInstrumentos.agregar(viento);
                        this.instrumentosViento.agregar(viento);
                    //La lista no esta vacía.
                    } else {
                        Instrumento aux = this.totalInstrumentos.buscar(atributos[1]);
                        //El instrumento a agregar ya se encuentra en la lista y aún queda stock.
                        if (Utils.codigoExiste(atributos[1], this.totalInstrumentos) && aux.getStock() > 0) {
                            //Castea el stock.
                            int stock = Integer.parseInt(atributos[3]);

                            //Recorre la lista
                            for (int i = 0; i < this.totalInstrumentos.getCantInstrumentos(); i++) {
                                //Generá elementos auxiliares.
                                Instrumento aux3 = this.totalInstrumentos.buscar(i);
                                Viento aux2 = (Viento) this.instrumentosViento.buscar(aux3.getCodigo());

                                //Actualiza el stock para ambos elementos auxiliares.
                                aux3.setStock(aux3.getStock() + stock);
                                aux2.setStock(aux3.getStock() + stock);
                            }
                        //El instrumento no tiene stock o no estaba registrado en la lista.
                        } else {
                            //Casteo de las variables necesarias.
                            int precio = Integer.parseInt(atributos[2]);
                            int stock = Integer.parseInt(atributos[3]);
                            //Crea un elemento.
                            Instrumento viento = new Viento(atributos[1], precio, stock, atributos[4], atributos[5]);
                            //Agrega el elemento a las listas correspondientes.
                            this.totalInstrumentos.agregar(viento);
                            this.instrumentosViento.agregar(viento);
                        }
                    }
                }
                //Para instrumentos de percusión.
                case "Percusion" -> {
                    //Revisa si la lista esta vacía.
                    if (Utils.listaVacia(this.totalInstrumentos)) {
                        //Casteo de las variables necesarias.
                        int precio = Integer.parseInt(atributos[2]);
                        int stock = Integer.parseInt(atributos[3]);
                        //Crea un elemento.
                        Instrumento percusion = new Percusion(atributos[1], precio, stock, atributos[4], atributos[5], atributos[6], atributos[7]);
                        //Agrega el elemento a las listas correspondientes.
                        this.totalInstrumentos.agregar(percusion);
                        this.instrumentosPercusion.agregar(percusion);
                    //La lista no esta vacía.
                    } else {
                        Instrumento aux = this.totalInstrumentos.buscar(atributos[1]);
                        //El instrumento a agregar ya se encuentra en la lista y aún queda stock.
                        if (Utils.codigoExiste(atributos[1], this.totalInstrumentos) && aux.getStock() > 0) {
                            //Castea el stock.
                            int stock = Integer.parseInt(atributos[3]);

                            //Recorre la lista
                            for (int i = 0; i < this.totalInstrumentos.getCantInstrumentos(); i++) {
                                //Generá elementos auxiliares.
                                Instrumento aux3 = this.totalInstrumentos.buscar(i);
                                Percusion aux2 = (Percusion) this.instrumentosPercusion.buscar(aux3.getCodigo());

                                //Actualiza el stock para ambos elementos auxiliares.
                                aux3.setStock(aux3.getStock() + stock);
                                aux2.setStock(aux3.getStock() + stock);
                            }
                        //El instrumento no tiene stock o no estaba registrado en la lista.
                        } else {
                            //Casteo de las variables necesarias.
                            int precio = Integer.parseInt(atributos[2]);
                            int stock = Integer.parseInt(atributos[3]);
                            //Crea un elemento.
                            Instrumento percusion = new Percusion(atributos[1], precio, stock, atributos[4], atributos[5], atributos[6], atributos[7]);
                            //Agrega el elemento a las listas correspondientes.
                            this.totalInstrumentos.agregar(percusion);
                            this.instrumentosViento.agregar(percusion);
                        }
                    }
                }
                //Para instrumentos de cuerda.
                case "Cuerda" -> {
                    //Revisa si la lista esta vacía.
                    if (Utils.listaVacia(this.totalInstrumentos)) {
                        //Casteo de las variables necesarias.
                        int precio = Integer.parseInt(atributos[2]);
                        int stock = Integer.parseInt(atributos[3]);
                        int cantCuerdas = Integer.parseInt(atributos[7]);
                        //Crea un elemento.
                        Instrumento cuerda = new Cuerda(atributos[1], precio, stock, atributos[4], atributos[5], atributos[6], cantCuerdas, atributos[8]);
                        //Agrega el elemento a las listas correspondientes.
                        this.totalInstrumentos.agregar(cuerda);
                        this.instrumentosViento.agregar(cuerda);
                    //La lista no esta vacía.
                    } else {
                        Instrumento aux = this.totalInstrumentos.buscar(atributos[1]);
                        //El instrumento a agregar ya se encuentra en la lista y aún queda stock.
                        if (Utils.codigoExiste(atributos[1], this.totalInstrumentos) && aux.getStock() > 0) {
                            //Castea el stock.
                            int stock = Integer.parseInt(atributos[3]);

                            //Recorre la lista
                            for (int i = 0; i < this.totalInstrumentos.getCantInstrumentos(); i++) {
                                //Generá elementos auxiliares.
                                Instrumento aux3 = this.totalInstrumentos.buscar(i);
                                Cuerda aux2 = (Cuerda) this.instrumentosCuerda.buscar(aux3.getCodigo());

                                //Actualiza el stock para ambos elementos auxiliares.
                                aux3.setStock(aux3.getStock() + stock);
                                aux2.setStock(aux3.getStock() + stock);
                            }
                        //El instrumento no tiene stock o no estaba registrado en la lista.
                        } else {
                            //Casteo de las variables necesarias.
                            int precio = Integer.parseInt(atributos[2]);
                            int stock = Integer.parseInt(atributos[3]);
                            int cantCueras = Integer.parseInt(atributos[7]);
                            //Crea un elemento.
                            Instrumento cuerda = new Cuerda(atributos[1], precio, stock, atributos[4], atributos[5], atributos[6], cantCueras, atributos[8]);
                            //Agrega el elemento a las listas correspondientes.
                            this.totalInstrumentos.agregar(cuerda);
                            this.instrumentosViento.agregar(cuerda);
                        }
                    }
                }
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
        //Valida el código.
        try{Utils.validarCodigo(codigo);}catch (IllegalArgumentException ex){System.out.println("Ha ocurrido un error.");}
        //Revisa si el instrumento existe o no.
        if(!this.totalInstrumentos.existe(codigo)){
            System.out.println("El código ingresado no corresponde a ningún instrumento registrado.");
            return;
        }
        //El instrumento existe y es guardado en una variable auxiliar.
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

    /**
     * Método que despliega el inventario.
     */
    @Override
    public void consultarInventario() {
        //Opción del usuario.
        String opcion;

        //Menú.
        String menu = """
                ========================
                = CONSULTAR INVENTARIO =
                ========================

                1. Ver Todo.
                2. Ver Por Tipo.
                3. Ver Producto en Especifico.
                4. Volver Atrás
                Opción:\s""";

        //Imprime el menú.
        System.out.println(menu);

        //Registro de la opción.
        opcion = StdIn.readString();
        switch (opcion){
            //Mostrar todos los instrumentos.
            case "1" -> verTodo(this.totalInstrumentos);
            //Mostrar los instrumentos de un dado tipo.
            case "2" -> verTipo();
            //Mostrar un único instrumento dado su código.
            case "3" -> verEspecifico(this.totalInstrumentos);
            //Vuelve a la ventana anterior.
            case "4" -> {return;}
            //Opción invalida.
            default -> System.out.println("Opción invalida, intente nuevamente.");
        }
    }

    /**
     * Método para buscar un instrumento en el catálogo dado su código.
     * @param lista en donde buscar el instrumento.
     */
    public void verEspecifico(ListaInstrumento lista){
        //Código del instrumento a buscar.
        String code;

        //String con los datos a imprimir.
        StringBuilder inventario = new StringBuilder();

        System.out.println("Ingrese el código del instrumento a buscar: ");
        //Ingreso de un código.
        code = StdIn.readString();

        //Valida el código ingresado.
        try{Utils.validarCodigo(code);}catch (IllegalArgumentException ex){System.out.println("Ha ocurrido un error.");}

        //Recibe el código del instrumento y lo busca.
        Instrumento instrumento = lista.buscar(code);

        //Analiza el instrumento para castearlo y asi imprimir sus datos.
        switch (instrumento.getNombre()) {
            //Para instrumentos de cuerda.
            case "Guitarra", "Bajo", "Violin", "Arpa" -> {
                //Casteo del instrumento.
                Cuerda cuerda = (Cuerda) instrumento;
                //Generación de información.
                inventario.append("Codigo: ").append(cuerda.getCodigo()).append("\n");
                inventario.append("Precio: ").append(cuerda.getPrecio()).append("\n");
                inventario.append("Stock: ").append(cuerda.getStock()).append("\n");
                inventario.append("Instrumento: ").append(cuerda.getNombre()).append("\n");
                inventario.append("Tipo de Cuerda: ").append(cuerda.getTipoCuerda()).append("\n");
                inventario.append("Número de Cuerdas: ").append(cuerda.getCantidadCuerdas()).append("\n");
                inventario.append("Material: ").append(cuerda.getMaterial()).append("\n");
                inventario.append("Tipo de Sonido: ").append(cuerda.getTipo()).append("\n");
                inventario.append("==================================================\n");
                //Imprime la información.
                System.out.println(inventario);
            }
            //Para instrumentos de percusión.
            case "Bongo", "Cajon", "Campanas", "Tubulares", "Bombo" -> {
                Percusion percusion = (Percusion) instrumento;
                inventario.append("Código: ").append(percusion.getCodigo()).append("\n");
                inventario.append("Precio: ").append(percusion.getPrecio()).append("\n");
                inventario.append("Stock: ").append(percusion.getStock()).append("\n");
                inventario.append("Instrumento: ").append(percusion.getNombre()).append("\n");
                inventario.append("Tipo de Percusión: ").append(percusion.getTipoPercusion()).append("\n");
                inventario.append("Número de Cuerdas: ").append(percusion.getAltura()).append("\n");
                inventario.append("Material: ").append(percusion.getMaterial()).append("\n");
                inventario.append("==================================================\n");
                System.out.println(inventario);
            }
            //Para instrumentos de viento.
            case "Trompeta", "Saxofon", "Clarinete", "Flauta Traversa" -> {
                Viento viento = (Viento) instrumento;
                inventario.append("Código: ").append(viento.getCodigo()).append("\n");
                inventario.append("Precio: ").append(viento.getPrecio()).append("\n");
                inventario.append("Stock: ").append(viento.getStock()).append("\n");
                inventario.append("Instrumento: ").append(viento.getNombre()).append("\n");
                inventario.append("Material: ").append(viento.getMaterial()).append("\n");
                inventario.append("==================================================\n");
                System.out.println(inventario);
            }
        }
    }

    /**
     * Método que despliega un submenú para ver el catálogo por
     * un cierto tipo dado.
     */
    public void verTipo(){
        //Opción del usuario.
        String opcion;

        //Menú.
        String subMenu = """
                ================
                = VER POR TIPO =
                ================

                1. Instrumentos de Cuerda.
                2. Instrumentos de Percusión.
                3. Instrumentos de Viento.
                4. Volver Atrás.
                Opción:\s""";

        //Imprime el menú.
        System.out.println(subMenu);

        //Registro de la opción.
        opcion = StdIn.readString();
        switch (opcion){
            //Muestra los instrumentos de cuerda.
            case "1" -> verTodo(this.instrumentosCuerda);
            //Muestra los instrumentos de percusión.
            case "2" -> verTodo(this.instrumentosPercusion);
            //Muestra los instrumentos de viento.
            case "3" -> verTodo(this.instrumentosViento);
            //Vuelve a la ventana anterior.
            case "4" -> {return;}
            //Opción invalida.
            default -> System.out.println("Opción Invalida, intente nuevamente.");
        }
    }

    /**
     * Método auxiliar que imprime el catálogo completo.
     * @param lista a recorrer.
     */
    public void verTodo(ListaInstrumento lista){
        //Lo que se va a imprimir.
        StringBuilder inventario = new StringBuilder();

        //Recorre la lista.
        for(int i=0;i<lista.getCantInstrumentos();i++){
            //Guarda un elemento.
            Instrumento instrumento = lista.buscar(i);

            /*
            Revisa el tipo de instrumento, lo castea, obtiene los datos necesarios
            y los imprime.
             */
            switch (instrumento.getNombre()) {
                //Muestra los instrumentos de cuerda.
                case "Guitarra", "Bajo", "Violin", "Arpa" -> {
                    Cuerda cuerda = (Cuerda) instrumento;
                    inventario.append("Código: ").append(cuerda.getCodigo()).append("\n");
                    inventario.append("Precio: ").append(cuerda.getPrecio()).append("\n");
                    inventario.append("Stock: ").append(cuerda.getStock()).append("\n");
                    inventario.append("Instrumento: ").append(cuerda.getNombre()).append("\n");
                    inventario.append("Tipo de Cuerda: ").append(cuerda.getTipoCuerda()).append("\n");
                    inventario.append("Número de Cuerdas: ").append(cuerda.getCantidadCuerdas()).append("\n");
                    inventario.append("Material: ").append(cuerda.getMaterial()).append("\n");
                    inventario.append("Tipo de Sonido: ").append(cuerda.getTipo()).append("\n");
                    inventario.append("==================================================\n");
                    System.out.println(inventario);
                }
                //Muestra los instrumentos de percusión.
                case "Bongo", "Cajon", "Campanas", "Tubulares", "Bombo" -> {
                    Percusion percusion = (Percusion) instrumento;
                    inventario.append("Código: ").append(percusion.getCodigo()).append("\n");
                    inventario.append("Precio: ").append(percusion.getPrecio()).append("\n");
                    inventario.append("Stock: ").append(percusion.getStock()).append("\n");
                    inventario.append("Instrumento: ").append(percusion.getNombre()).append("\n");
                    inventario.append("Tipo de Percusión: ").append(percusion.getTipoPercusion()).append("\n");
                    inventario.append("Número de Cuerdas: ").append(percusion.getAltura()).append("\n");
                    inventario.append("Material: ").append(percusion.getMaterial()).append("\n");
                    inventario.append("==================================================\n");
                    System.out.println(inventario);
                }
                //Muestra los instrumentos de viento.
                case "Trompeta", "Saxofon", "Clarinete", "Flauta Traversa" -> {
                    Viento viento = (Viento) instrumento;
                    inventario.append("Código: ").append(viento.getCodigo()).append("\n");
                    inventario.append("Precio: ").append(viento.getPrecio()).append("\n");
                    inventario.append("Stock: ").append(viento.getStock()).append("\n");
                    inventario.append("Instrumento: ").append(viento.getNombre()).append("\n");
                    inventario.append("Material: ").append(viento.getMaterial()).append("\n");
                    inventario.append("==================================================\n");
                    System.out.println(inventario);
                }
            }
        }
    }

    /**
     * Método para cerrar el programa.
     */
    @Override
    public boolean cierre(boolean estado) {
        //Mensaje de despedida.
        System.out.println("Hasta luego, vuelva pronto!");
        //Retorna falso.
        return !estado;
    }

    /**
     * Método auxiliar que despliega el menu principal del programa
     */
    private void mainmenu(){
        String mainMenu = """
                * BIENVENID@ A BEAT THE RYTHM *
                ¿Qué desea hacer?
                
                1. Agregar Instrumento.
                2. Vender un instrumento.
                3. Consultar inventario.
                4. Salir.""";
        System.out.println(mainMenu);
    }

    /**
     * Método auxiliar que genera la boleta de una venta.
     * @param instrumento vendido.
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

                //generación de la boleta.
                String boleta = "BEAT THE RYTHM\n" +
                        "----------------------------------------------------------------\n" +
                        "RUC O CI: " + ci + "\n" +
                        "----------------------------------------------------------------\n" +
                        "NOMBRE VENDEDOR: " + vendedor + "\n" +
                        "----------------------------------------------------------------\n" +
                        "CANTIDAD | DESCRIPCIÓN | PRECIO UNITARIO | IVA% | VALOR DE VENTA\n" +
                        "----------------------------------------------------------------\n" +
                        "1        | " + instrumento.getNombre() + "       | " + instrumento.getPrecio() + "          | 19%  | " + instrumento.getPrecio() + "\n" +
                        "----------------------------------------------------------------\n" +
                        "TOTAL A PAGAR: " + instrumento.getPrecio();

                //Imprime la boleta.
                System.out.println(boleta);
            }
        }
    }

    /**
     * Método del menú principal de una venta.
     */
    public void venderInstrumento(){
        //código a ingresar.
        String code;

        //menú principal.
        String vender = """
                =========================
                = VENDER UN INSTRUMENTO =
                =========================

                Ingrese el código del instrumento:\s""";

        //Imprime el menú para vender un instrumento.
        System.out.println(vender);

        //Registro del código.
        code = StdIn.readString();

        try{Utils.validarCodigo(code);}catch (IllegalArgumentException ex){System.out.println("Ha ocurrido un error.");}

        //Realización de la venta.
        this.venderInstrumentoImpl(code);
    }
}
