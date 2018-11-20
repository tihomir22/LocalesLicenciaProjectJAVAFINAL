/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.ControlDom;
import controlador.ControlLocal;
import controlador.ControlResultado;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import modelo.Local;
import modelo.Resultado;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author mati
 */
public class Conexion_DB {

    Connection con = null;

    public Connection abrirConexion() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String urlDb = "jdbc:mysql://localhost:3306/localesV2";
            con = (java.sql.DriverManager.getConnection(urlDb, "root", ""));

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion_DB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger("Ha sido imposible cerrar la conexion");
        }

        return con;

    }

    public void cargarXMLaBD(Resultado res) throws ParserConfigurationException, SAXException, IOException {

        LocalDAO localdao = new LocalDAO();
        LicenciaDAO licenciadao = new LicenciaDAO();

        for (int i = 0; i < res.size(); i++) {
            Local local = res.get(i);
            localdao.insertar(con, local);
            licenciadao.insertByLocal(con, local);

        }
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
