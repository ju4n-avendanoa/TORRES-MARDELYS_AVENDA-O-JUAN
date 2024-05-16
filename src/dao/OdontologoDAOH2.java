package dao;

import model.Odontologo;
import model.Paciente;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements iDao<Odontologo> {
  private static final Logger logger = Logger.getLogger(PacienteDAOH2.class);
  private static final String SQL_INSERT = "INSERT INTO ODONTOLOGO (NUMERO_MATRICULA, NOMBRE, APELLIDO) VALUES (?, ?," +
          " ?)";
  private static final String SQL_SELECT_ALL = "SELECT * FROM ODONTOLOGO";
  
  @Override
  public Odontologo guardar(Odontologo odontologo) {
    logger.info("inicando la operacion de guardado");
    Connection connection = null;
    try {
      connection = BD.getConnection();
      PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
      psInsert.setInt(1, odontologo.getNumeroMatricula());
      psInsert.setString(2, odontologo.getNombre());
      psInsert.setString(3, odontologo.getApellido());
      psInsert.execute();
      ResultSet rs = psInsert.getGeneratedKeys();
      while (rs.next()) {
        odontologo.setId(rs.getInt(1));
      }
      logger.info("Se ha guardado el odontologo");
    } catch (Exception e) {
      logger.warn(e.getMessage());
    }
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
    Connection connection = null;
    List<Odontologo> odontologos = new ArrayList<>();
    try {
      connection = BD.getConnection();
      Statement statement = connection.createStatement();
      PreparedStatement psSelectAll = connection.prepareStatement(SQL_SELECT_ALL);
      ResultSet rs = psSelectAll.executeQuery();
      
      while (rs.next()) {
        int numeroMatricula = rs.getInt("numero_matricula");
        String nombre = rs.getString("nombre");
        String apellido = rs.getString("apellido");
        Odontologo odontologo = new Odontologo(numeroMatricula, nombre, apellido);
        odontologos.add(odontologo);
      }
      logger.info("Se han cargado los odontologos");
    } catch (Exception e) {
      logger.warn(e.getMessage());
    }
    return odontologos;
  }
}
