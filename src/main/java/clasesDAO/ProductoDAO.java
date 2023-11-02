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
public class ProductoDAO {
   
    public void insertarProducto(int idProducto, String nombre, double precio, String categoria_producto) {
        try {
            Conexion cn = new Conexion();
            Connection connection = cn.conectar();
            
            // Preparar la sentencia SQL para la inserción
            String sql = "INSERT INTO producto (idProducto, nombre, precio, categoria_producto) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Establecer los valores de los parámetros
            preparedStatement.setInt(1, idProducto);
            preparedStatement.setString(2, nombre);
            preparedStatement.setDouble(3, precio);
            preparedStatement.setString(4, categoria_producto);

            // Ejecutar la sentencia de inserción
            int filasInsertadas = preparedStatement.executeUpdate();

            if (filasInsertadas > 0) {
                System.out.println("Producto insertado con éxito.");
            } else {
                System.out.println("La inserción del producto ha fallado.");
            }

            // Cerrar la conexión y el PreparedStatement
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
