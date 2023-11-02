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

public class GarantiaDAO {
    
    public void insertarGarantia(int idProducto, String fechaVencimiento, String tipoGarantia) {
        try {
            Conexion cn = new Conexion();
            Connection connection = cn.conectar();
            // Preparar la sentencia SQL para la inserción
            String sql = "INSERT INTO nombre_de_la_tabla (idProducto, fechaVencimiento, tipoGarantia) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Establecer los valores de los parámetros
            preparedStatement.setInt(1, idProducto);
            preparedStatement.setString(2, fechaVencimiento);
            preparedStatement.setString(3, tipoGarantia);

            // Ejecutar la sentencia de inserción
            int filasInsertadas = preparedStatement.executeUpdate();

            if (filasInsertadas > 0) {
                System.out.println("Garantía registrada con éxito.");
            } else {
                System.out.println("El registro de la garantía ha fallado.");
            }

            // Cerrar la conexión y el PreparedStatement
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

