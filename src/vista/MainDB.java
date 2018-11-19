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
        int opcion = 999, id;
        String eleccion;
        Local recuperado;
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
                    res = local.recuperarResultado(con);
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

                case 4:
                    mostrarOpciones();
                    opcion = teclado.nextInt();
                    switch (opcion) {
                        case 1:
                            System.out.println("Introduzca los siguientes campos [ id(int) emplazamiento(String) codPortal(int) codVia(int) numVia(String) referenciaCatastral(String) \n referenciaMunicipal(String) poligono(int) zonaSaturada(String) Comentarios(String)");
                            id = teclado.nextInt();
                            teclado.nextLine();
                            String emplazamiento = teclado.nextLine();
                            int codPortal = teclado.nextInt();
                            int codVia = teclado.nextInt();
                            teclado.nextLine();
                            String numVia = teclado.nextLine();
                            String refCatastral = teclado.nextLine();
                            String refMunicipal = teclado.nextLine();
                            int poligono = teclado.nextInt();
                            teclado.nextLine();
                            String zonaSaturada = teclado.nextLine();
                            String comentarios = teclado.nextLine();
                            Local localN = new Local(id, emplazamiento, codPortal, codVia, numVia, refCatastral, refMunicipal, poligono, zonaSaturada, comentarios);
                            local.insertar(con, localN);
                            break;

                        case 2:
                            System.out.println("Introduce el id del objeto a modificar"); // se realiza una busqueda en la BBDD y si se encuentra se recupera
                            id = teclado.nextInt();
                            teclado.nextLine();
                            recuperado = local.recuperarById(con, id);
                            if (recuperado != null) {
                                System.out.println("Se ha recuperado \n" + recuperado.toString());
                                System.out.println("Que deseas modificar ? [ Emplazamiento , codPortal , codVia , numVia, refCatastral, refMuni, poligon, zonaSaturada, comentarios ]");
                                eleccion = teclado.nextLine();
                                switch (eleccion) {
                                    case "Emplazamiento":
                                        System.out.println("Introduce nuevo " + eleccion);
                                        recuperado.setEmplazamiento(teclado.nextLine());
                                        break;
                                    case "codVia":
                                        System.out.println("Introduce nuevo " + eleccion);
                                        recuperado.setCodVia(teclado.nextInt());
                                        teclado.nextLine();
                                        break;
                                    case "codPortal":
                                        System.out.println("Introduce nuevo " + eleccion);
                                        recuperado.setCodPortal(teclado.nextInt());
                                        teclado.nextLine();
                                        break;
                                    case "numVia":
                                        System.out.println("Introduce nuevo " + eleccion);
                                        recuperado.setNumVia(teclado.nextLine());
                                        break;
                                    case "refCatastral":
                                        System.out.println("Introduce nuevo " + eleccion);
                                        recuperado.setReferenciaCatastral(teclado.nextLine());
                                        break;
                                    case "refMuni":
                                        System.out.println("Introduce nuevo " + eleccion);
                                        recuperado.setReferenciaMunicipal(teclado.nextLine());
                                        break;
                                    case "poligon":
                                        System.out.println("Introduce nuevo " + eleccion);
                                        recuperado.setPoligono(teclado.nextInt());
                                        teclado.nextLine();
                                        break;
                                    case "zonaSaturada":
                                        System.out.println("Introduce nuevo " + eleccion);
                                        recuperado.setZonaSaturada(teclado.nextLine());
                                        break;
                                    case "comentarios":
                                        System.out.println("Introduce nuevo " + eleccion);
                                        recuperado.setComentarios(teclado.nextLine());
                                        break;
                                    default:
                                        System.out.println("Introduciste un valor incorrecto vuelva a intentarlo");
                                        break;
                                }
                                local.actualiza(con, recuperado);
                                System.out.println("Actualizado con exito");
                            } else {
                                System.out.println("No fue encontrado...");
                            }
                            break;

                        case 3:
                            System.out.println("Introduce el id del objeto a recuperar"); // se realiza una busqueda en la BBDD y si se encuentra se recupera
                            id = teclado.nextInt();
                            teclado.nextLine();
                            recuperado = local.recuperarById(con, id);
                            if (recuperado != null) {
                                System.out.println("Se ha recuperado " + recuperado.toString());
                            } else {
                                System.out.println("No se ha encontrado...");
                            }
                            break;

                        case 4:
                            System.out.println("Introduce el id del objeto a eliminar"); // se realiza una busqueda en la BBDD y si se encuentra se recupera
                            id = teclado.nextInt();
                            teclado.nextLine();
                            recuperado = local.recuperarById(con, id);
                            if (recuperado != null) {
                                System.out.println("Se ha eliminado " + recuperado.toString());
                                local.delete(con, id);
                            } else {
                                System.out.println("No se ha encontrado...");
                            }
                            break;

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
        System.out.println("4.-Opciones de Locales [ INSERTAR MODIFICAR RECUPERAR ELIMINAR ]");
    }

    public static void mostrarOpciones() {
        System.out.println("1.- Insertar un Local en la BBDD");
        System.out.println("2.- Modificar un Local en la BBDD");
        System.out.println("3.- Recuperar un Local de la BBDD");
        System.out.println("4.- Eliminar un Local de la BBDD");
    }
}
