package system;

import java.io.IOException;

public interface Sistema {
    void agregarInstrumento(String direccionArchivo) throws IOException;
    void venderInstrumentoImpl(String codigo);
    void consultarInventario();
    boolean cierre();
}
