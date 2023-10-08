package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocket {
    public static void main(String[] args) throws IOException {
        String hosts = "netology.homework";
        int port = 8080;
        try (Socket clientSocket = new Socket(hosts, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())))
        {
            out.println("Ivan");
            System.out.println(in.readLine());
            out.println("yes");
            System.out.println(in.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
