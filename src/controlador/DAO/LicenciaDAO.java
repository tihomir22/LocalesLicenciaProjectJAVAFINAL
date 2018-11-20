/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Licencia;
import modelo.Local;
import modelo.Resultado;

/**
 *
 * @author sportak
 */
public class LicenciaDAO {

    public void actualiza(Connection con, Licencia lic) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement("UPDATE licencia SET idLicencia=?,Titulo=?,FechaCreacion=?,Anyo=?,LocalID=? WHERE Expediente=?");
            statement.setInt(1, lic.getId());
            statement.setString(2, lic.getTitulo());
            statement.setString(3, lic.getFechaCreacion());
            statement.setString(4, lic.getAnyo());
            statement.setInt(5, lic.getIdLocal());
            statement.setString(6, lic.getExpediente());
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

    public void delete(Connection con, String expediente) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement("DELETE FROM licencia WHERE expediente=?");
            statement.setString(1, expediente);
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

    public void insertByLocal(Connection con, Local local) {

        for (Licencia li : local.getListaLicencias()) {
            this.insert(con, li, local.getId());
        }

    }

    public void insert(Connection con, Licencia lic, int localID) {

        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement("INSERT INTO licencia(idLicencia,Titulo,FechaCreacion,Expediente,ANYO,LocalID) VALUES(?,?,?,?,?,?) ");
            statement.setInt(1, lic.getId());
            statement.setString(2, lic.getTitulo());
            statement.setString(3, lic.getFechaCreacion());
            statement.setString(4, lic.getExpediente());
            statement.setString(5, lic.getAnyo());
            statement.setInt(6, localID);

            statement.execute();
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1062) {
                System.out.println("LICENCIA No se inserta nuevo ya que el numero de expediente" + lic.getExpediente() + " esta duplicado");
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

    public ArrayList<Licencia> selectLicenciaByLocalID(Connection con, int localID) {
        ArrayList<Licencia> listalicencias = new ArrayList<>();
        PreparedStatement statement = null;
        // Resultado res = new Resultado();
        try {
            statement = con.prepareStatement("SELECT * FROM licencia WHERE LocalID=?");
            statement.setInt(1, localID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                System.out.println("Recibiendo datos");
                int id = rs.getInt("idLicencia");
                String expediente = rs.getString("Expediente");
                String anyo = rs.getString("ANYO");
                String titulo = rs.getString("Titulo");
                String fechaCreacion = rs.getString("FechaCreacion");
                Licencia licencia = new Licencia(expediente, anyo, id, titulo, fechaCreacion);
                System.out.println("CREADO LICENCIA " + licencia.toString());
                listalicencias.add(licencia);
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
        return listalicencias;

    }

    public Licencia recuperarByExpediente(Connection con, String expediente) {
        PreparedStatement statement = null;
        Licencia lic = null;
        try {
            statement = con.prepareStatement("SELECT * FROM licencia WHERE Expediente=?");
            statement.setString(1, expediente);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                System.out.println("Recibiendo datos");
                int idLic = rs.getInt("idLicencia");
                String titulo = rs.getString("Titulo");
                String fechaCreacion = rs.getString("FechaCreacion");
                String expedienteRec = rs.getString("Expediente");
                String anyo = rs.getString("ANYO");
                lic = new Licencia(expedienteRec, anyo, idLic, titulo, fechaCreacion);
                lic.setIdLocal(rs.getInt("LocalID"));
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
        return lic;
    }

    public ArrayList<Licencia> recuperarTodos(Connection con) {
        PreparedStatement statement = null;
        ArrayList<Licencia> listalicencias = new ArrayList<>();
        Licencia lic = null;
        try {
            statement = con.prepareStatement("SELECT * FROM licencia");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                System.out.println("Recibiendo datos");
                int idLic = rs.getInt("idLicencia");
                String titulo = rs.getString("Titulo");
                String fechaCreacion = rs.getString("FechaCreacion");
                String expedienteRec = rs.getString("Expediente");
                String anyo = rs.getString("ANYO");
                lic = new Licencia(expedienteRec, anyo, idLic, titulo, fechaCreacion);
                lic.setIdLocal(rs.getInt("LocalID"));
                listalicencias.add(lic);
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
        return listalicencias;
    }

}
