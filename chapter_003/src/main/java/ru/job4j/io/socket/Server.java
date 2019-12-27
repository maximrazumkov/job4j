package ru.job4j.io.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final Socket socket;

    public Server(Socket socket) {
        this.socket = socket;
    }

    public void start() throws Exception {
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String ask = "";
        do {
            System.out.println("wait command ...");
            ask = in.readLine();
            System.out.println(ask);
            if ("hello".equals(ask)) {
                out.println("Hello, dear friend, I'm a oracle.");
            }
            out.println();
            out.flush();
        } while (!"пока".equals(ask));
    }

    public static void main(String[] args) {
        try (Socket socket = new ServerSocket(3000).accept()){
            new Server(socket).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
