/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author angel
 */
public class Conector extends Thread {

    ServerSocket server;
    Socket socket = new Socket();
    int puerto = 9669;
    PrintStream salida;
    BufferedReader entrada;

    public void run() {
        int i = 1;
        int posicion = 0;
        try {
            server = new ServerSocket(puerto);
            while (true) {
                socket = server.accept();
                main.main.listSockets.add(socket);
                System.out.println("Cliente conectado");
                main.main.getVen().getTextArea().append("Cliente conectado \n");
                clientes cli =  new clientes(posicion);
                cli.start();
                posicion++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

}
