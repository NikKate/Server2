package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
    public static void main(String[] args) throws IOException {
        System.out.println("New connection accepted");
        int port = 8080;
        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(port);
                 Socket clientSocket=serverSocket.accept();
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())))
            {
                System.out.printf("Hi, Write your name", clientSocket.getPort());
                final String name = in.readLine();
                System.out.println(name);
                out.println(String.format("Are you child? (yes/no)",
                        name, clientSocket.getPort()));
                final String child = in.readLine();
                System.out.println(child);
                if(child.equals("yes")){
                    out.println("Welcome to the kids area, " + name + "Let's play!");
                }else if(child.equals("no")){
                    out.println("Welcome to the adult zone, " + name + "Have a good rest, or a good working day!");
                }else{
                    out.println("Try again!");
                }

            }
            catch(IOException e){
                e.printStackTrace();
            }

        }
    }
}

