/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author wilber
 */
public class VentaDAO {
    private Connection connection; // Debes establecer la conexión a la base de datos

    public static void insertarVenta(Connection connection, int idEmpleado, int idMetodoPago, int idCliente, double total) {
        try {
            // Preparar la sentencia SQL para la inserción
            String sql = "INSERT INTO nombre_de_la_tabla (idEmpleado, idMetodoPago, idCliente, total) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Establecer los valores de los parámetros
            preparedStatement.setInt(1, idEmpleado);
            preparedStatement.setInt(2, idMetodoPago);
            preparedStatement.setInt(3, idCliente);
            preparedStatement.setDouble(4, total);

            // Ejecutar la sentencia de inserción
            int filasInsertadas = preparedStatement.executeUpdate();

            if (filasInsertadas > 0) {
                System.out.println("Venta registrada con éxito.");
            } else {
                System.out.println("El registro de la venta ha fallado.");
            }

            // Cerrar la conexión y el PreparedStatement
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
