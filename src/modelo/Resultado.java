/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sportak
 */
public class Resultado extends ArrayList<Local> {

    public Resultado() {
    }

    public int getModCount() {
        return modCount;
    }

    public void setModCount(int modCount) {
        this.modCount = modCount;
    }

    public void impresionTOTAL() {
        Scanner entrada = new Scanner("empresa.xml");
        System.out.println("El archivo es ");
        while (entrada.hasNextLine()) {
            System.out.println(entrada.nextLine());
        }
        System.out.println("Su arbol de nodos es");

        for (int i = 0; i < this.size(); i++) {
            System.out.println(this.get(i).toString());
        }
    }

    @Override
    public String toString() {
        return "Resultado{" + '}';
    }

}
