package ru.job4j.io.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private final Socket socket;

    public Client(Socket socket) {
        this.socket = socket;
    }

    public void start() throws Exception {
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner console = new Scanner(System.in);
        String question;
        do {
            question = console.nextLine();
            out.println(question);
            out.flush();
            if (in.ready()) {
                String str;
                while (!(str = in.readLine()).isEmpty()) {
                    System.out.println(str);
                }
            }
        } while (!"пока".equals(question));
    }

    public static void main(String[] args) throws Exception {
        try (Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 3000)) {
            new Client(socket).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
