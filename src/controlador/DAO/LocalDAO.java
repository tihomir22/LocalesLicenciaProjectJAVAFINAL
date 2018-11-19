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
import modelo.Resultado;

/**
 *
 * @author mati
 */
public class LocalDAO {

    LicenciaDAO licenciadao = new LicenciaDAO();

    public void actualiza(Connection con, Local local) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement("UPDATE Local SET ID=?,Emplazamiento=?, CodigoPortal=?,CodigoVia=?,NumeroVia=?,RefCatas=?,RefMuni=?,Poligono=?,ZonaSaturada=?,Comentarios=? WHERE ID=?");
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

    public void delete(Connection con, int id) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement("DELETE FROM local WHERE ID=?");
            statement.setInt(1, id);
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

    public void insertar(Connection con, Local local) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement("INSERT INTO local(ID,Emplazamiento,CodigoPortal,CodigoVia,NumeroVia,RefCatas,RefMuni,Poligono,ZonaSaturada,Comentarios) VALUES(?,?,?,?,?,?,?,?,?,?)");
            statement.setInt(1, local.getId());
            statement.setString(2, local.getEmplazamiento());
            statement.setString(3, local.getCodPortal() + "");
            statement.setString(4, local.getCodVia() + "");
            statement.setString(5, local.getNumVia());
            statement.setString(6, local.getReferenciaCatastral());
            statement.setString(7, local.getReferenciaMunicipal());
            statement.setString(8, local.getPoligono() + "");
            statement.setString(9, local.getZonaSaturada());
            if (local.getComentarios() != null && local.getComentarios() != "") {
                statement.setString(10, local.getComentarios());
            } else {
                statement.setString(10, "");
            }

            statement.executeUpdate();
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1062) {
                System.out.println("LOCAL No se inserta nuevo ya que el id " + local.getId() + " esta duplicado");
            } else {
                Logger.getLogger(LocalDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
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

    public Resultado recuperarResultado(Connection con) {
        PreparedStatement statement = null;

        Resultado res = new Resultado();
        try {
            statement = con.prepareStatement("SELECT * FROM local");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                System.out.println("Recibiendo datos");
                int id = rs.getInt("ID");
                String emplazamiento = rs.getString("Emplazamiento");
                int codigoPortal = rs.getInt("CodigoPortal");
                int codigoVia = rs.getInt("CodigoVia");
                String numVia = rs.getString("NumeroVia");
                String referenciaCatastral = rs.getString("RefCatas");
                String referenciaMunicipal = rs.getString("RefMuni");
                int poligono = rs.getInt("Poligono");
                String zonaSaturada = rs.getString("ZonaSaturada");
                String comentarios = rs.getString("Comentarios");
                Local local = new Local(id, emplazamiento, codigoPortal, codigoVia, numVia, referenciaCatastral, referenciaMunicipal, poligono, zonaSaturada, comentarios);
                local.setListaLicencias(licenciadao.selectLicenciaByLocalID(con, id));
                System.out.println("CREADO LOCAL " + local.toString());
                res.add(local);
            }
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
        return res;
    }

    public Local recuperarById(Connection con, int id) {
        PreparedStatement statement = null;
        Local local = null;
        try {
            statement = con.prepareStatement("SELECT * FROM local WHERE ID=?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                System.out.println("Recibiendo datos");
                String emplazamiento = rs.getString("Emplazamiento");
                int codigoPortal = rs.getInt("CodigoPortal");
                int codigoVia = rs.getInt("CodigoVia");
                String numVia = rs.getString("NumeroVia");
                String referenciaCatastral = rs.getString("RefCatas");
                String referenciaMunicipal = rs.getString("RefMuni");
                int poligono = rs.getInt("Poligono");
                String zonaSaturada = rs.getString("ZonaSaturada");
                String comentarios = rs.getString("Comentarios");
                local = new Local(id, emplazamiento, codigoPortal, codigoVia, numVia, referenciaCatastral, referenciaMunicipal, poligono, zonaSaturada, comentarios);
            }
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
        return local;
    }

}
