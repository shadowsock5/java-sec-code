package org.joychou.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketReadObject {
    public static void main(String[] args) throws IOException {
        int port = 10001;
        ServerSocket server = new ServerSocket(10001);
        System.out.println("[*] Listening on port: " + port);
        while (true) {
            Socket socket = server.accept();
            execute(socket);

        }
    }
    public static void execute(final Socket socket){
        new Thread(new Runnable() {
            public void run() {
                try {
                    ObjectInputStream is  = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
                    Object obj = is.readObject();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
