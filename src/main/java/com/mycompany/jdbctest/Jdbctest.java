package com.mycompany.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author saam_
 */
public class Jdbctest {

    public static void main(String[] args) {
        String usuario="root";
        String password="";
        String url="jdbc:mysql://localhost:3306/jdbctest";
        Connection conexion;
        Statement Statement;
        ResultSet rs;
        
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            Statement = conexion.createStatement();
            rs = Statement.executeQuery("SELECT * FROM `usuarios`");
            while(rs.next())
             System.out.println(rs.getString("nombre"));
            
            //insercion de datos
           Statement.execute("INSERT INTO `usuarios` (`id`, `nombre`) VALUES (NULL, 'yenci');");
            System.out.println("");
           Statement = conexion.createStatement();
            rs = Statement.executeQuery("SELECT * FROM `usuarios`");
            while(rs.next())
             System.out.println(rs.getString("nombre"));
            
            // Actualizacion
            Statement.execute("UPDATE `usuarios` SET `nombre` = 'maria' WHERE `usuarios`.`id` = 1;");
            System.out.println("");
           Statement = conexion.createStatement();
            rs = Statement.executeQuery("SELECT * FROM `usuarios`");
            while(rs.next())
             System.out.println(rs.getString("nombre"));
            
            //eliminacion
             Statement.execute("DELETE FROM `usuarios` WHERE `usuarios`.`id` = 2");
            System.out.println("");
           Statement = conexion.createStatement();
            rs = Statement.executeQuery("SELECT * FROM `usuarios`");
            while(rs.next())
             System.out.println(rs.getString("nombre"));
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Jdbctest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
