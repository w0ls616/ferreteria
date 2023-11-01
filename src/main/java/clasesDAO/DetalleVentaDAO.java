/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesDAO;

/**
 *
 * @author wilber
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DetalleVentaDAO {
    private Connection connection; // Debes establecer la conexión a la base de datos

    public static void insertarDetalleVenta(Connection connection, String fechaVenta, int cantidad, double subtotal, boolean devolucion, int idProducto) {
        try {
            // Preparar la sentencia SQL para la inserción
            String sql = "INSERT INTO nombre_de_la_tabla (fechaVenta, cantidad, subtotal, devolucion, idProducto) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Establecer los valores de los parámetros
            preparedStatement.setString(1, fechaVenta);
            preparedStatement.setInt(2, cantidad);
            preparedStatement.setDouble(3, subtotal);
            preparedStatement.setBoolean(4, devolucion);
            preparedStatement.setInt(5, idProducto);

            // Ejecutar la sentencia de inserción
            int filasInsertadas = preparedStatement.executeUpdate();

            if (filasInsertadas > 0) {
                System.out.println("Detalle de venta insertado con éxito.");
            } else {
                System.out.println("El registro del detalle de venta ha fallado.");
            }

            // Cerrar la conexión y el PreparedStatement
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

