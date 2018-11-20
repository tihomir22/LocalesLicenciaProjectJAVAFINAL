/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControlDom;
import controlador.ControlResultado;
import controlador.DAO.Conexion_DB;
import controlador.DAO.LicenciaDAO;
import controlador.DAO.LocalDAO;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
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
        int opcion = 999, id, localID = 0;
        String eleccion, titulo, fechaCreacion, anyo, expediente;
        Local recuperado;
        Licencia licRecuperada;
        Scanner teclado = new Scanner(System.in);
        LocalDAO local = new LocalDAO();
        LicenciaDAO licenciadao = new LicenciaDAO();
        ArrayList<Licencia> listaLicencia = new ArrayList<>();
        ArrayList<Local> listalocales = new ArrayList<>();

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
                case 1: {
                    try {
                        doc = dom.deXMLaDOC(new File("registro-licencia.xml"));
                        res = cres.leerResult(doc);
                        res.impresionTOTAL();
                        System.out.println("\n Realizado con exito");
                    } catch (ParserConfigurationException ex) {
                        Logger.getLogger(MainDB.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SAXException ex) {
                        Logger.getLogger(MainDB.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(MainDB.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                break;
                case 2:
                    if (res != null) {
                        try {
                            conexiondb.cargarXMLaBD(res);
                        } catch (ParserConfigurationException ex) {
                            Logger.getLogger(MainDB.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SAXException ex) {
                            Logger.getLogger(MainDB.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(MainDB.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        System.out.println("Debes cargar el xml a objeto antes de hacer este paso!!");
                    }

                    break;
                case 3:
                    res = local.recuperarResultado(con);
                    break;

                case 4:
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

                case 5:
                    mostrarOpciones("Local");
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
                        case 5:
                            listalocales = local.recuperarTodos(con);
                            System.out.println(listalocales);
                            break;
                    }
                    break;
                case 6:
                    mostrarOpciones("Licencia");
                    opcion = teclado.nextInt();
                    switch (opcion) {
                        case 1:
                            System.out.println("Introduzca los siguientes campos [ idLicencia(int) Titulo(String) FechaCreacion(String) \n Expediente(String) Anyo(String) LocalID(int) si tiene]");
                            id = teclado.nextInt();
                            teclado.nextLine();
                            titulo = teclado.nextLine();
                            fechaCreacion = teclado.nextLine();
                            expediente = teclado.nextLine();
                            anyo = teclado.nextLine();
                            localID = teclado.nextInt();
                            teclado.nextLine();
                            Licencia lic = new Licencia(expediente, anyo, id, titulo, fechaCreacion);
                            licenciadao.insert(con, lic, localID);
                            break;

                        case 2:
                            teclado.nextLine();
                            System.out.println("Introduce el numero de expediente de la licencia a modificar"); // se realiza una busqueda en la BBDD y si se encuentra se recupera
                            expediente = teclado.nextLine();
                            licRecuperada = licenciadao.recuperarByExpediente(con, expediente);
                            if (licRecuperada != null) {
                                System.out.println("Se ha recuperado \n" + licRecuperada.toString());
                                System.out.println("Que deseas modificar ? [ Anyo , idLicencia ( no es la clave primaria) , titulo , fechaCreacion , idLocal (el local al que pertenece) ]");
                                eleccion = teclado.nextLine();
                                switch (eleccion) {
                                    case "Anyo":
                                        System.out.println("Introduce nuevo " + eleccion);
                                        licRecuperada.setAnyo(teclado.nextLine());
                                        break;
                                    case "idLicencia":
                                        System.out.println("Introduce nuevo " + eleccion);
                                        licRecuperada.setId(teclado.nextInt());
                                        teclado.nextLine();
                                        break;
                                    case "titulo":
                                        System.out.println("Introduce nuevo " + eleccion);
                                        licRecuperada.setTitulo(teclado.nextLine());
                                        break;
                                    case "fechaCreacion":
                                        System.out.println("Introduce nuevo " + eleccion);
                                        licRecuperada.setFechaCreacion(teclado.nextLine());
                                        break;
                                    case "idLocal":
                                        System.out.println("Introduce nuevo " + eleccion);
                                        licRecuperada.setIdLocal(teclado.nextInt());
                                        teclado.nextLine();
                                        break;

                                    default:
                                        System.out.println("Introduciste un valor incorrecto vuelva a intentarlo");
                                        break;
                                }
                                licenciadao.actualiza(con, licRecuperada);
                                System.out.println("Actualizado con exito");
                            } else {
                                System.out.println("No fue encontrado...");
                            }
                            break;

                        case 3:
                            teclado.nextLine();
                            System.out.println("Introduce el numero de expediente de la licencia a recuperar"); // se realiza una busqueda en la BBDD y si se encuentra se recupera
                            expediente = teclado.nextLine();
                            licRecuperada = licenciadao.recuperarByExpediente(con, expediente);
                            if (licRecuperada != null) {
                                System.out.println("Se ha recuperado " + licRecuperada.toString());
                            } else {
                                System.out.println("No se ha encontrado...");
                            }
                            break;

                        case 4:
                            teclado.nextLine();
                            System.out.println("Introduce el numero de expediente de la licencia a eliminar"); // se realiza una busqueda en la BBDD y si se encuentra se recupera
                            expediente = teclado.nextLine();
                            licRecuperada = licenciadao.recuperarByExpediente(con, expediente);
                            if (licRecuperada != null) {
                                System.out.println("Se ha borrado con exito " + licRecuperada.toString());
                                licenciadao.delete(con, licRecuperada.getExpediente());
                            } else {
                                System.out.println("No se ha encontrado...");
                            }
                            break;

                        case 5:
                            listaLicencia = licenciadao.recuperarTodos(con);
                            System.out.println(listaLicencia);
                            break;
                    }
                    break;
            }
        }

        System.out.println("Cerrando conexion");
        conexiondb.CerrarConsulta(con);

    }

    public static void mostrarMenu() {
        System.out.println("1.-Cargar XML a Objetos");
        System.out.println("2.-Cargar Objetos a BBDD , si ya fue cargada no se volveran a insertar datos");
        System.out.println("3.-Descargar la BBDD a objetos Resultado que contienen todos los datos de la BBDD");
        System.out.println("4.-Guardar el objeto Resultado como XML");
        System.out.println("5.-Opciones de Locales [ INSERTAR MODIFICAR RECUPERAR RECUPERAR ALL ELIMINAR ]");
        System.out.println("6.-Opciones de Licencia [ INSERTAR MODIFICAR RECUPERAR RECUPERAR ALL ELIMINAR ]");
    }

    public static void mostrarOpciones(String about) {
        System.out.println("1.- Insertar un " + about + " en la BBDD");
        System.out.println("2.- Modificar un " + about + " en la BBDD");
        System.out.println("3.- Recuperar un " + about + " de la BBDD");
        System.out.println("4.- Eliminar un " + about + " de la BBDD");
        System.out.println("5.- Recuperar todos los  " + about + " de la BBDD");
    }
}
