package ru.job4j.io.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private final Socket socket;
    private final Input input;

    public Client(Socket socket, Input input) {
        this.socket = socket;
        this.input = input;
    }

    public void start() throws Exception {
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String question;
        do {
            question = input.ask();
            out.println(question);
            out.flush();
            if (in.ready()) {
                String str;
                while ((str = in.readLine()).isEmpty()) {
                    System.out.println(str);
                }
            }
        } while (!"пока".equals(question));
    }

    public static void main(String[] args) throws Exception {
        try (Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 3000)) {
            new Client(socket, new ScannerInput()).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
