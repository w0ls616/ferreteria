/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesDAO;

/**
 *
 * @author wilber
 */
import db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DevolucionDAO {

    public void insertarDevolucion(String fechaDevolucion, int idVenta, String motivo) {
        try {
            Conexion cn = new Conexion();
            Connection connection = cn.conectar();
            // Preparar la sentencia SQL para la inserción
            String sql = "INSERT INTO nombre_de_la_tabla (fechaDevolucion, idVenta, motivo) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Establecer los valores de los parámetros
            preparedStatement.setString(1, fechaDevolucion);
            preparedStatement.setInt(2, idVenta);
            preparedStatement.setString(3, motivo);

            // Ejecutar la sentencia de inserción
            int filasInsertadas = preparedStatement.executeUpdate();

            if (filasInsertadas > 0) {
                System.out.println("Devolución registrada con éxito.");
            } else {
                System.out.println("El registro de la devolución ha fallado.");
            }

            // Cerrar la conexión y el PreparedStatement
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

