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

public class CompraDAO {

    public void insertarCompra(int idProveedor, String fecha, double total) {
        try {
            Conexion cn = new Conexion();
            Connection connection = cn.conectar();
            
            // Preparar la sentencia SQL para la inserción
            String sql = "INSERT INTO nombre_de_la_tabla (idProveedor, fecha, total) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Establecer los valores de los parámetros
            preparedStatement.setInt(1, idProveedor);
            preparedStatement.setString(2, fecha);
            preparedStatement.setDouble(3, total);

            // Ejecutar la sentencia de inserción
            int filasInsertadas = preparedStatement.executeUpdate();

            if (filasInsertadas > 0) {
                System.out.println("Compra registrada con éxito.");
            } else {
                System.out.println("El registro de la compra ha fallado.");
            }

            // Cerrar la conexión y el PreparedStatement
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
