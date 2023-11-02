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
public class EmpleadoDAO {


    public void insertarEmpleado(int idEmpleado, String nombre, String apellido, String genero, String correo, String dui, String direccion, String telefono) {
        try {
            Conexion cn = new Conexion();
            Connection connection = cn.conectar();
            // Preparar la sentencia SQL para la inserción
            String sql = "INSERT INTO empleado (idEmpleado, nombre, apellido, genero, correo, dui, direccion, telefono) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Establecer los valores de los parámetros
            preparedStatement.setInt(1, idEmpleado);
            preparedStatement.setString(2, nombre);
            preparedStatement.setString(3, apellido);
            preparedStatement.setString(4, genero);
            preparedStatement.setString(5, correo);
            preparedStatement.setString(6, dui);
            preparedStatement.setString(7, direccion);
            preparedStatement.setString(8, telefono);

            // Ejecutar la sentencia de inserción
            int filasInsertadas = preparedStatement.executeUpdate();

            if (filasInsertadas > 0) {
                System.out.println("Empleado insertado con éxito.");
            } else {
                System.out.println("La inserción del empleado ha fallado.");
            }

            // Cerrar la conexión y el PreparedStatement
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
