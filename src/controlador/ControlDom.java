/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 *
 * @author sportak
 */
public class ControlDom {

    public Document deXMLaDOC(File archivo) throws ParserConfigurationException, SAXException, IOException {
        Document doc = null;
        doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(archivo);
        return doc;
    }

    public Document deXMLaDOC() throws ParserConfigurationException {
        Document doc = null;
        doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        return doc;
    }

    //De DOM a XML
    public void deDOCaXML(Document doc, File file) throws TransformerConfigurationException, TransformerException {
        Transformer trans = TransformerFactory.newInstance().newTransformer();
        trans.setOutputProperty(OutputKeys.INDENT, "yes"); //indentar XML

        StreamResult result = new StreamResult(file);
        DOMSource source = new DOMSource(doc);
        trans.transform(source, result);
    }

    //Obtener ETIQUETAS
    public static Element getElementEtiqueta(String ETIQUETA, Element elemento) {
        return (Element) elemento.getElementsByTagName(ETIQUETA).item(0);
    }

    //Obtener VALOR de las etiquetas
    public static String getValorEtiqueta(String ETIQUETA, Element elemento) {
        Node nValue = elemento.getElementsByTagName(ETIQUETA).item(0);
        return nValue.getChildNodes().item(0).getNodeValue();
    }

    //Obtener ATRIBUTO
    public static String getAtributoEtiqueta(Element elemento, String ETIQUETA) {
        return elemento.getAttribute(ETIQUETA);
    }

}
