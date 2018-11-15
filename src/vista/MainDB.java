/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.DAO.Conexion_DB;
import controlador.DAO.LocalDAO;
import java.sql.Connection;
import modelo.Licencia;
import modelo.Local;

/**
 *
 * @author mati
 */
public class MainDB {

    public static void main(String[] args) {

        Conexion_DB conexiondb = new Conexion_DB();
        System.out.println("Abrir conexion");
        Connection con = conexiondb.abrirConexion();
        System.out.println("Conexion abierta");

        LocalDAO locald = new LocalDAO();
        Local localpojo = new Local(1, "emplazamiento de ejemplo", 43433, 34345343, "num via de ejemplo 3 ", "ref catastral ejemplo 3 ", "referencia munipal ejemplo", 3, "zona saturadita 2", "cometnario ejemplar");
       // String expediente, String anyo, int id, String titulo, String fechaCreacion
        localpojo.getListaLicencias().add(new Licencia("xpediente","2016",1,"titulo ejemplo","20199"));
        localpojo.getListaLicencias().add(new Licencia("x2pediente","20126",2,"titulo ejemplo2","220199"));
        locald.actualiza(con, localpojo);
        
        System.out.println("Cerrando conexion");
        conexiondb.CerrarConsulta(con);

    }
}
