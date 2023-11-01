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

public class MetodoPagoDAO {
    private Connection connection; // Debes establecer la conexión a la base de datos

    public static void insertarMetodoPago(Connection connection, String tipo_pago, String descripcion) {
        try {
            // Preparar la sentencia SQL para la inserción
            String sql = "INSERT INTO nombre_de_la_tabla (tipo_pago, descripcion) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Establecer los valores de los parámetros
            preparedStatement.setString(1, tipo_pago);
            preparedStatement.setString(2, descripcion);

            // Ejecutar la sentencia de inserción
            int filasInsertadas = preparedStatement.executeUpdate();

            if (filasInsertadas > 0) {
                System.out.println("Método de pago registrado con éxito.");
            } else {
                System.out.println("El registro del método de pago ha fallado.");
            }

            // Cerrar la conexión y el PreparedStatement
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

