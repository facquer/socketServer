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
import java.util.List;

/**
 *
 * @author angel
 */
public class clientes extends Thread {

    ServerSocket server;
    Socket socket = new Socket();
    int puerto = 9669;
    PrintStream salida;
    BufferedReader entrada;
    int posicion ;
    public clientes(int posicion) {
        this.posicion = posicion;
    }

    public void run() {
        int i = 1;
        try {
            while (!socket.isClosed()) {
                entrada = new BufferedReader(new InputStreamReader(main.main.listSockets.get(posicion).getInputStream()));
                String mensaje = entrada.readLine();
                for(Socket sock: main.main.listSockets){
                    salida = new PrintStream(sock.getOutputStream());
                    salida.println(mensaje);
                }
                i++;
                main.main.getVen().getTextArea().append("Mensaje del Cliente: " + mensaje +"\n");
                System.out.println("Mensaje del Cliente: " + mensaje);
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
