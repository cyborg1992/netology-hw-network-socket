package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void main(String[] args) {
        int port = 8888;
        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            System.out.println("New connection accepted ("
                    + clientSocket.getInetAddress().getHostName() + " - "
                    + clientSocket.getInetAddress().getHostAddress() + ":"
                    + clientSocket.getPort() + ")");
            final String name = in.readLine();
            out.printf("Hi, %s, your port is %d%n", name, clientSocket.getPort());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}