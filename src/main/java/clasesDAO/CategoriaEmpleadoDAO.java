/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesDAO;
import db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author wilber
 */
public class CategoriaEmpleadoDAO {
    private Connection connection; // Debes establecer la conexión a la base de datos

    public void insertarCategoriaEmpleado(int idCategoriaEmpleado, String cargo, String descripcion, double sueldo) {
        try {
            Conexion cn = new Conexion();
            Connection connection = cn.conectar();
            
            // Preparar la sentencia SQL para la inserción
            String sql = "INSERT INTO nombre_de_la_tabla (idCategoriaEmpleado, cargo, descripcion, sueldo) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Establecer los valores de los parámetros
            preparedStatement.setInt(1, idCategoriaEmpleado);
            preparedStatement.setString(2, cargo);
            preparedStatement.setString(3, descripcion);
            preparedStatement.setDouble(4, sueldo);

            // Ejecutar la sentencia de inserción
            int filasInsertadas = preparedStatement.executeUpdate();

            if (filasInsertadas > 0) {
                System.out.println("Categoría de empleado insertada con éxito.");
            } else {
                System.out.println("La inserción de la categoría de empleado ha fallado.");
            }

            // Cerrar la conexión y el PreparedStatement
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
