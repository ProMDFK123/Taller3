package system;

import objects.Instrumento;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Sistema {
    void agregarInstrumento(String direccionArchivo) throws IOException;
    void venderInstrumentoImpl(String codigo);
    String consultarInventario();
    boolean cierre(boolean estado);
}
