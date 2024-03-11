package com.http.socket;

import java.io.*;
import java.net.Inet4Address;
import java.net.Socket;
import java.util.Scanner;

public class SockerRunner {
    public static void main(String[] args) throws IOException {
        var inet4add = Inet4Address.getByName("localhost");
        try (var socket = new Socket(inet4add, 7777);
             var output = new DataOutputStream(socket.getOutputStream());
             var input = new DataInputStream(socket.getInputStream());
             var scanner = new Scanner(System.in)
             ) {

            while (scanner.hasNext()) {
                var request = scanner.nextLine();
                output.writeUTF(request);
                System.out.println("Response from server:" + input.readUTF());

            }

        }


    }
}

