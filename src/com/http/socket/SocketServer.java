package com.http.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

public class SocketServer {
    public static void main(String[] args) throws IOException {
        try (var serverSocket = new ServerSocket(7777);
             var socket = serverSocket.accept();
             var inputStream = new DataInputStream(socket.getInputStream());
             var outputStream = new DataOutputStream(socket.getOutputStream());
             var scanner = new Scanner(System.in)) {
            String request = inputStream.readUTF();
            while (!"stop".equals(request)) {
                System.out.println("Request client: " + request);
                var response = scanner.nextLine();
                outputStream.writeUTF(response);
                request = inputStream.readUTF();

            }
        }

    }
}
