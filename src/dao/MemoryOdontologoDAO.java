package dao;

import model.Odontologo;
import java.util.ArrayList;
import java.util.List;


public class MemoryOdontologoDAO implements iDao<Odontologo> {
  
  private List<Odontologo> odontologos;

  public MemoryOdontologoDAO() {
    this.odontologos = new ArrayList<>();
  }
  
  @Override
  public Odontologo guardar(Odontologo odontologo) {
    odontologos.add(odontologo);
    return odontologo;
  }
  
  @Override
  public Odontologo buscarPorID(Integer id) {
    return null;
  }
  
  @Override
  public void actualizar(Odontologo odontologo) {
  
  }
  
  @Override
  public void eliminar(Integer id) {
  
  }
  
  @Override
  public List<Odontologo> buscarTodos() {
    
    return odontologos;
  }
}