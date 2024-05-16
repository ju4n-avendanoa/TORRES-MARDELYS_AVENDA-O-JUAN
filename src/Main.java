import dao.MemoryOdontologoDAO;
import model.Odontologo;

import java.util.List;

public class Main {
  public static void main(String[] args) {

  MemoryOdontologoDAO memoryOdontologoDAO = new MemoryOdontologoDAO();
  
  // Ejemplo de guardar odontólogos
    memoryOdontologoDAO.guardar(new Odontologo(1,"Juan","Pérez"));
    memoryOdontologoDAO.guardar(new Odontologo(2,"María","González"));
  
    
  // Ejemplo de listar todos los odontólogos
  List<Odontologo> odontologos = memoryOdontologoDAO.buscarTodos();
        for(Odontologo odontologo :odontologos){
    System.out.println("Número de Matrícula: " + odontologo.getNumeroMatricula());
    System.out.println("Nombre: " + odontologo.getNombre());
    System.out.println("Apellido: " + odontologo.getApellido());
    System.out.println("-------------------------");
  }
}
}