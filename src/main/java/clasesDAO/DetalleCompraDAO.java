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

public class DetalleCompraDAO {

    public void insertarDetalleCompra(int idCompra, int idProducto, int cantidad, double precioUnitario, double subtotal) {
        try {
            Conexion cn = new Conexion();
            Connection connection = cn.conectar();
            
            // Preparar la sentencia SQL para la inserción
            String sql = "INSERT INTO nombre_de_la_tabla (idCompra, idProducto, cantidad, precioUnitario, subtotal) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Establecer los valores de los parámetros
            preparedStatement.setInt(1, idCompra);
            preparedStatement.setInt(2, idProducto);
            preparedStatement.setInt(3, cantidad);
            preparedStatement.setDouble(4, precioUnitario);
            preparedStatement.setDouble(5, subtotal);

            // Ejecutar la sentencia de inserción
            int filasInsertadas = preparedStatement.executeUpdate();

            if (filasInsertadas > 0) {
                System.out.println("Detalle de compra insertado con éxito.");
            } else {
                System.out.println("El registro del detalle de compra ha fallado.");
            }

            // Cerrar la conexión y el PreparedStatement
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

