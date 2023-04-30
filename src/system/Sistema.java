package system;

import com.opencsv.exceptions.CsvValidationException;
import objects.Instrumento;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Sistema {
    void agregarInstrumento(String direccionArchivo) throws IOException, CsvValidationException;
    void venderInstrumento(Instrumento instrumento);
    String consultarInventario();
    void cierre(boolean estado);
}
