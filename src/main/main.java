/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import vista.vistaServer;

/**
 *
 * @author angel
 */
public class main {

    private static vistaServer ven;

    public static void main(String[] args) {
        ven = new vistaServer();
        ven.setVisible(true);
    }

    public static vistaServer getVen() {
        return ven;
    }

    public static void setVen(vistaServer ven) {
        main.ven = ven;
    }

}
