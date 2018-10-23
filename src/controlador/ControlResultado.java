/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.Node;
import javax.xml.transform.TransformerException;
import modelo.Resultado;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author sportak
 */
public class ControlResultado extends ControlDom {
    
    public Document recuperar(File xmlFile) throws ParserConfigurationException, SAXException, IOException {
        Document doc = null;
        doc = deXMLaDOC(xmlFile);
        return doc;
    }

    public void almacenar(Document doc, File archivoDestino) throws TransformerException {
        deDOCaXML(doc, archivoDestino);
    }
    
    
    public Resultado leerResult(Document doc) {
        ControlLocal cl = new ControlLocal();
        Element raizResultado = doc.getDocumentElement();
        Element etiquetaResult = getElementEtiqueta(Constantes.ET_RESULT, raizResultado);
        NodeList listaLocales = etiquetaResult.getChildNodes();
        Resultado res = new Resultado();
        
        for (int i = 0; i < listaLocales.getLength(); i++) {
            if (listaLocales.item(i).getNodeType() == Node.ELEMENT_NODE) {
                System.out.println("Voy a tramitar " + listaLocales.item(i).getNodeName() + " " + listaLocales.item(i).getChildNodes().getLength());
                res.add(cl.leerLocal((Element) listaLocales.item(i)));
            }
        }
        return res;
    }
    
    public void escribirResult(Document doc, Resultado res) {
        ControlLocal cl = new ControlLocal();
        
        Element raiz = doc.createElement("resultado");
        doc.appendChild(raiz);
        
        Element result = doc.createElement("result");
        raiz.appendChild(result);
        
        for (int i = 0; i < res.size(); i++) {
            cl.escribirLocal(doc, result, res.get(i));
        }
        
    }
    
}
