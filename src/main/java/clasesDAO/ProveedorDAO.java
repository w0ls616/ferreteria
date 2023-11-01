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

public class ProveedorDAO {
    private Connection connection; // Debes establecer la conexión a la base de datos

    public static void insertarProveedor(Connection connection, String nombreEmpresa, String nombreContacto, String direccion, String telefono, String correoElectronico, String categoriaProducto) {
        try {
            // Preparar la sentencia SQL para la inserción
            String sql = "INSERT INTO nombre_de_la_tabla (nombreEmpresa, nombreContacto, direccion, telefono, correoElectronico, categoriaProducto) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Establecer los valores de los parámetros
            preparedStatement.setString(1, nombreEmpresa);
            preparedStatement.setString(2, nombreContacto);
            preparedStatement.setString(3, direccion);
            preparedStatement.setString(4, telefono);
            preparedStatement.setString(5, correoElectronico);
            preparedStatement.setString(6, categoriaProducto);

            // Ejecutar la sentencia de inserción
            int filasInsertadas = preparedStatement.executeUpdate();

            if (filasInsertadas > 0) {
                System.out.println("Proveedor registrado con éxito.");
            } else {
                System.out.println("El registro del proveedor ha fallado.");
            }

            // Cerrar la conexión y el PreparedStatement
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

