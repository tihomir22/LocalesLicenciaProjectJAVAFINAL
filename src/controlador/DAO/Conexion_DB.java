/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mati
 */
public class Conexion_DB {
    public Connection abrirConexion() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String urlDb = "jdbc:mysql://localhost:3306/locales";
            con = (java.sql.DriverManager.getConnection(urlDb, "root", ""));

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion_DB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger("Ha sido imposible cerrar la conexion");
        }

        return con;

    }

    public void CerrarConsulta(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexion_DB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
