package system;

import objects.Instrumento;

public interface Sistema {
    void agregarInstrumento(String direccionArchivo);
    void venderInstrumento(Instrumento instrumento);
    String consultarInventario();
    void cierre(boolean estado);
}
