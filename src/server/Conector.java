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
        try {
            server = new ServerSocket(puerto);
            socket = server.accept();
            System.out.println("Cliente conectado");
            this.setName("conectado");
            main.main.getVen().getTextArea().setText("Cliente conectado");
            while (!socket.isClosed()) {
                entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String mensaje = entrada.readLine();
                salida = new PrintStream(socket.getOutputStream());
                salida.println("Mensaje procesado num: " + i);
                i++;
                main.main.getVen().getTextArea().setText("Mensaje del Cliente: " + mensaje);
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
