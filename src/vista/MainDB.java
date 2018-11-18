/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControlDom;
import controlador.ControlResultado;
import controlador.DAO.Conexion_DB;
import controlador.DAO.LocalDAO;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import modelo.Licencia;
import modelo.Local;
import modelo.Resultado;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author mati
 */
public class MainDB {

    public static void main(String[] args) {
        int opcion = 999;
        Scanner teclado = new Scanner(System.in);
        LocalDAO local = new LocalDAO();
        ControlDom dom = new ControlDom();
        Document doc = null;
        ControlResultado cres = new ControlResultado();
        Resultado res = null;
        Conexion_DB conexiondb = new Conexion_DB();
        System.out.println("Abrir conexion");
        Connection con = conexiondb.abrirConexion();
        System.out.println("Conexion abierta");
        while (opcion != 0) {
            mostrarMenu();
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    try {
                        conexiondb.cargarXMLaBD("registro-licencia.xml");
                    } catch (ParserConfigurationException ex) {
                        Logger.getLogger(MainDB.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SAXException ex) {
                        Logger.getLogger(MainDB.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(MainDB.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 2:
                    res = local.recuperar(con);
                    break;

                case 3:
                    if (res != null) {
                        try {
                            doc = dom.deXMLaDOC();
                            cres.escribirResult(doc, res);
                            dom.deDOCaXML(doc, new File("copiaBBDD.xml"));
                            System.out.println("Se ha guardado exitosamente en el archivo copiaBBDD.xml");
                        } catch (ParserConfigurationException | TransformerException ex) {
                            Logger.getLogger(MainDB.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        System.out.println("Debes instanciar primero el objeto resultado");
                    }

                    break;
            }
        }

        System.out.println("Cerrando conexion");
        conexiondb.CerrarConsulta(con);

    }

    public static void mostrarMenu() {
        System.out.println("1.- Cargar XML a BBDD , si ya fue cargada no se volveran a insertar datos");
        System.out.println("2.- Descargar de BBDD a objetos Resultado conteniendo todos los datos de la BBDD");
        System.out.println("3.- Guardar el objeto  Resultado como XML");
    }
}
