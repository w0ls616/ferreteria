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

public class InventarioDAO {
    private Connection connection; // Debes establecer la conexión a la base de datos

    public static void insertarInventario(Connection connection, int idProducto, int cantidad, double precioUnitario, String proveedor, String estado) {
        try {
            // Preparar la sentencia SQL para la inserción
            String sql = "INSERT INTO nombre_de_la_tabla (idProducto, cantidad, precioUnitario, proveedor, estado) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Establecer los valores de los parámetros
            preparedStatement.setInt(1, idProducto);
            preparedStatement.setInt(2, cantidad);
            preparedStatement.setDouble(3, precioUnitario);
            preparedStatement.setString(4, proveedor);
            preparedStatement.setString(5, estado);

            // Ejecutar la sentencia de inserción
            int filasInsertadas = preparedStatement.executeUpdate();

            if (filasInsertadas > 0) {
                System.out.println("Registro de inventario insertado con éxito.");
            } else {
                System.out.println("El registro de inventario ha fallado.");
            }

            // Cerrar la conexión y el PreparedStatement
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

