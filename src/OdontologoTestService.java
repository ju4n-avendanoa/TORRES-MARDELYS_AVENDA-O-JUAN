import dao.BD;
import model.Odontologo;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import service.OdontologoService;

import java.util.List;

public class OdontologoTestService {
  @Test
  public void buscarOdontologos() {
    BD.crearTablas();
    OdontologoService odontologoService = new OdontologoService();
    Integer busqueda = 1;
    odontologoService.guardarOdontologo(new Odontologo(1, "Juan", "Pérez"));
    odontologoService.guardarOdontologo(new Odontologo(2, "María", "Gonzalez"));
    List<Odontologo> odontologos = odontologoService.buscarTodos();
    Assertions.assertNotNull(odontologos);
    for (Odontologo odontologo : odontologos) {
      System.out.println("Número de Matrícula: " + odontologo.getNumeroMatricula());
      System.out.println("Nombre: " + odontologo.getNombre());
      System.out.println("Apellido: " + odontologo.getApellido());
    }
  }
}