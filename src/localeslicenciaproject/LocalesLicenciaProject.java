/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package localeslicenciaproject;

import controlador.ControlDom;
import controlador.ControlResultado;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import modelo.Licencia;
import modelo.Local;
import modelo.Resultado;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author sportak
 */
public class LocalesLicenciaProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
        int opcion = 999;
        String ruta = "";
        ControlDom cd = new ControlDom();
        ControlResultado cr = new ControlResultado();
        Resultado resNuevo = null;
        Resultado res = new Resultado();
        Document doc = null;
        Document docNuevo = null;

        Scanner teclado = new Scanner(System.in);
        while (opcion != 0) {
            mostrarMenu();
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Introduzca ruta del fichero xml o dejalo en blanco para coger la ruta por defecto");
                    ruta = teclado.nextLine();
                    if (ruta.length() == 0) {
                        ruta = "registro-licencia.xml";
                    }
                    doc = cd.deXMLaDOC(new File(ruta));
                    break;

                case 2:
                    res = cr.leerResult(doc);
                    break;

                case 3:
                    res.impresionTOTAL();

                    break;

                case 4:
                    resNuevo = crearObjectoResultadoNuevo();
                    docNuevo = cd.deXMLaDOC();
                    cr.escribirResult(docNuevo, resNuevo);
                    break;

                case 5:
                    cd.deDOCaXML(docNuevo, new File("copia.xml"));
                    break;

            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("1.- Seleccionar un fichero xml a recuperar y crea un document");
        System.out.println("2.- Lee del documento y crea un objeto Resultado");
        System.out.println("3.-Muestra el objeto Resultado");
        System.out.println("4.-Crea un objeto resultado dando de alta un par de locales con sus licencias y escribe en un documento vacio ");
        System.out.println("5.-Guardado en copia.xml");
    }

    private static Resultado crearObjectoResultadoNuevo() {

        Resultado res = new Resultado();
        Local local1 = new Local(1, "Alcudia", 454664, 4545454, "Yea boi", "43534543FFF", "435643521345F", 1, "Zona Saturadisima", "este local es peligroiso");
        Local local2 = new Local(2, "Canals", 454664, 4545454, "Yea boi", "43534543FFF", "435643521345F", 2, "Zona Saturadisima", "este local es peligroiso");
        Local local3 = new Local(3, "Xativa", 454664, 4545454, "Yea boi", "43534543FFF", "435643521345F", 3, "Zona Saturadisima", "este local es peligroiso");

        Licencia licence = new Licencia("JERK THAT MEAT", "2030", 34, "LICENCIA DOS ", Calendar.getInstance().getTime().toString());

        local1.getListaLicencias().add(licence);
        local2.getListaLicencias().add(licence);
        local3.getListaLicencias().add(licence);

        res.add(local1);
        res.add(local2);
        res.add(local3);
        return res;
    }

}
