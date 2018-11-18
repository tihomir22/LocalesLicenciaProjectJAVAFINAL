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

    public void insertar(Connection con, Local local) {
        PreparedStatement statement = null;
        Licencia lic = null;

        for (int i = 0; i < local.getListaLicencias().size(); i++) {
            try {
                System.out.println("Procesando " + local.getListaLicencias().get(i).toString());

                lic = local.getListaLicencias().get(i);
                statement = con.prepareStatement("INSERT INTO licencia(idLicencia,Titulo,FechaCreacion,Expediente,ANYO,LocalID) VALUES(?,?,?,?,?,?) ");
                statement.setInt(1, lic.getId());
                statement.setString(2, lic.getTitulo());
                statement.setString(3, lic.getFechaCreacion());
                statement.setString(4, lic.getExpediente());
                statement.setString(5, lic.getAnyo());
                statement.setInt(6, local.getId());

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

}
