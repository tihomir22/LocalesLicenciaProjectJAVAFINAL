/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;


import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Local;

/**
 *
 * @author mati
 */
public class LocalDAO {

    public void actualiza(Connection con, Local local) {
        PreparedStatement statement = null;
        

        try {
            statement = con.prepareStatement("UPDATE Local SET ID=?,Emplazamiento=?, CodigoPortal=?,CodigoVia=?,NumeroVia=?,RefCatas=?,RefMuni=?,Poligono=?,ZonaSaturada=?,Comentarios=?,idLicencia=? WHERE ID=?");
            statement.setInt(1, local.getId());
            statement.setString(2, local.getEmplazamiento());
            statement.setInt(3, local.getCodPortal());
            statement.setInt(4, local.getCodVia());
            statement.setString(5, local.getNumVia());
            statement.setString(6, local.getReferenciaCatastral());
            statement.setString(7, local.getReferenciaMunicipal());
            statement.setInt(8, local.getPoligono());
            statement.setString(9, local.getZonaSaturada());
            statement.setString(10, local.getComentarios());
            
            
            //statement.setArray(11, (Array)local.getListaLicencias());

            statement.setInt(11, local.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LocalDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LocalDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

}
