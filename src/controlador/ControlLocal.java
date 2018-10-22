/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.ControlDom.getElementEtiqueta;
import java.util.ArrayList;
import javax.xml.soap.Node;
import modelo.Licencia;
import modelo.Local;
import modelo.Resultado;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author sportak
 */
public class ControlLocal extends ControlDom {

    public Local leerResult(Element elementoLocal) {
        Local local1 = new Local();

        local1.setId(Integer.parseInt(getValorEtiqueta(Constantes.ET_ID, elementoLocal).trim()));
        local1.setEmplazamiento(getValorEtiqueta(Constantes.ET_EMPLAZAMIENTO, elementoLocal));
        local1.setCodPortal(Integer.parseInt(getValorEtiqueta(Constantes.ET_CODPORTAL, elementoLocal)));
        local1.setCodVia(Integer.parseInt(getValorEtiqueta(Constantes.ET_CODVIA, elementoLocal).trim()));
        local1.setNumVia(getValorEtiqueta(Constantes.ET_NUMVIA, elementoLocal).trim());
        local1.setReferenciaCatastral(getValorEtiqueta(Constantes.ET_REFCAT, elementoLocal).trim());
        local1.setReferenciaMunicipal(getValorEtiqueta(Constantes.ET_REFMUN, elementoLocal).trim());
        local1.setPoligono(Integer.parseInt(getValorEtiqueta(Constantes.ET_POLI, elementoLocal).trim()));
        local1.setZonaSaturada(getValorEtiqueta(Constantes.ET_ZSAT, elementoLocal));
        if (elementoLocal.getElementsByTagName(Constantes.ET_COMMENTS).getLength() > 0) {
            local1.setComentarios(getValorEtiqueta(Constantes.ET_COMMENTS, elementoLocal));
        }

        local1.setListaLicencias(leerLicencia(elementoLocal, local1));

        return local1;
    }

    public ArrayList<Licencia> leerLicencia(Element elementoLocal, Local local) {
        Licencia licencia = new Licencia();
        Element elementoLicencias = getElementEtiqueta(Constantes.ET_LICENCIAS, elementoLocal);
        NodeList licencias = elementoLicencias.getChildNodes();
        ArrayList<Licencia> listaLicencias = new ArrayList<>();
        for (int i = 0; i < licencias.getLength(); i++) {
            if (licencias.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element Elelicencia = (Element) licencias.item(i);

                Element id = getElementEtiqueta(Constantes.ET_ID, Elelicencia);
                Element iae = getElementEtiqueta(Constantes.ET_LICENCIASIAE, id);
                licencia.setExpediente(getValorEtiqueta(Constantes.ET_EXPEDIENTE, iae));
                licencia.setAnyo(getValorEtiqueta(Constantes.ET_ANYO, iae));

                Element tipo = getElementEtiqueta(Constantes.ET_TIPO, Elelicencia);
                Element tipo2 = getElementEtiqueta(Constantes.ET_TIPO, tipo);
                licencia.setId(Integer.parseInt(getValorEtiqueta(Constantes.ET_ID, tipo2).trim()));
                licencia.setTitulo(getValorEtiqueta(Constantes.ET_TITULO, tipo2));
                licencia.setFechaCreacion(getValorEtiqueta(Constantes.ET_CREATIONDATE, tipo2));

                listaLicencias.add(licencia);
            }
        }
        return listaLicencias;
    }

    public void escribirLocal(Document doc, Element result, Local local) {
        Element eleLocal = doc.createElement("local");
        result.appendChild(eleLocal);

        Element id = doc.createElement(Constantes.ET_ID);
        id.appendChild(doc.createTextNode(local.getId() + ""));
        eleLocal.appendChild(id);

        Element emplazamiento = doc.createElement(Constantes.ET_EMPLAZAMIENTO);
        emplazamiento.appendChild(doc.createTextNode(local.getEmplazamiento()));
        eleLocal.appendChild(emplazamiento);

        Element codPortal = doc.createElement(Constantes.ET_CODPORTAL);
        codPortal.appendChild(doc.createTextNode(local.getCodPortal() + ""));
        eleLocal.appendChild(codPortal);

        Element codVia = doc.createElement(Constantes.ET_CODVIA);
        codVia.appendChild(doc.createTextNode(local.getCodVia() + ""));
        eleLocal.appendChild(codVia);

        Element numVia = doc.createElement(Constantes.ET_NUMVIA);
        numVia.appendChild(doc.createTextNode(local.getNumVia()));
        eleLocal.appendChild(numVia);

        Element referenciaCatastral = doc.createElement(Constantes.ET_REFCAT);
        referenciaCatastral.appendChild(doc.createTextNode(local.getReferenciaCatastral()));
        eleLocal.appendChild(referenciaCatastral);

        Element referenciaMunicipal = doc.createElement(Constantes.ET_REFMUN);
        referenciaMunicipal.appendChild(doc.createTextNode(local.getReferenciaMunicipal()));
        eleLocal.appendChild(referenciaMunicipal);

        Element poligono = doc.createElement(Constantes.ET_POLI);
        poligono.appendChild(doc.createTextNode(local.getPoligono() + ""));
        eleLocal.appendChild(poligono);

        Element zonaSaturada = doc.createElement(Constantes.ET_ZSAT);
        zonaSaturada.appendChild(doc.createTextNode(local.getZonaSaturada() + ""));
        eleLocal.appendChild(zonaSaturada);

        Element comentarios = doc.createElement(Constantes.ET_COMMENTS);
        comentarios.appendChild(doc.createTextNode(local.getComentarios() + ""));
        eleLocal.appendChild(comentarios);

        escribirLicencias(eleLocal, doc, local);

    }

    private void escribirLicencias(Element eleLocal, Document doc, Local local) {
        Element licencias = doc.createElement(Constantes.ET_LICENCIAS);
        eleLocal.appendChild(licencias);

        for (int i = 0; i < local.getListaLicencias().size(); i++) {
            Element licencia = doc.createElement(Constantes.ET_LICENCIA);
            licencias.appendChild(licencia);

            Element id = doc.createElement(Constantes.ET_ID);
            licencia.appendChild(id);

            Element iae = doc.createElement(Constantes.ET_LICENCIASIAE);
            id.appendChild(iae);

            Element expediente = doc.createElement(Constantes.ET_EXPEDIENTE);
            expediente.appendChild(doc.createTextNode(local.getListaLicencias().get(i).getExpediente()));
            iae.appendChild(expediente);

            Element anyo = doc.createElement(Constantes.ET_ANYO);
            anyo.appendChild(doc.createTextNode(local.getListaLicencias().get(i).getAnyo()));
            iae.appendChild(anyo);

            Element tipo = doc.createElement(Constantes.ET_TIPO);
            licencia.appendChild(tipo);

            Element tipo2 = doc.createElement(Constantes.ET_TIPO);
            tipo.appendChild(tipo2);

            Element id2 = doc.createElement(Constantes.ET_ID);
            id2.appendChild(doc.createTextNode(local.getListaLicencias().get(i).getId() + ""));
            tipo2.appendChild(id2);

            Element titulo = doc.createElement(Constantes.ET_TITULO);
            titulo.appendChild(doc.createTextNode(local.getListaLicencias().get(i).getTitulo()));
            tipo2.appendChild(titulo);

            Element fechaCreacion = doc.createElement(Constantes.ET_CREATIONDATE);
            fechaCreacion.appendChild(doc.createTextNode(local.getListaLicencias().get(i).getFechaCreacion()));
            tipo2.appendChild(fechaCreacion);

        }

    }

}
