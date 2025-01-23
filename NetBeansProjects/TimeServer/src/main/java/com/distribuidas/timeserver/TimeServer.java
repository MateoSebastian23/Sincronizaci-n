package com.distribuidas.timeserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class TimeServer {

    public static void main(String[] args) {
        int port = 12345; // Puerto del servidor de tiempo

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor de tiempo iniciado...");

            while (true) {
                try (Socket socket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                    LocalDateTime now = LocalDateTime.now();
                    out.println(now);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
