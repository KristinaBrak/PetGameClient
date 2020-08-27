package com.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientImp implements Client {
    private int LISTENING_PORT;
    private String hostName;
    private Socket connection;
    private PrintWriter out;
    private Scanner incomming;

    public ClientImp(String hostName, int listeningPort) {
        this.LISTENING_PORT = listeningPort;
        this.hostName = hostName;
    }

    @Override
    public void connect() {
        try {
            connection = new Socket(hostName, LISTENING_PORT);
            OutputStream outputStream = connection.getOutputStream();
            out = new PrintWriter(outputStream);

            InputStream inputStream = connection.getInputStream();
            incomming = new Scanner(inputStream);

        } catch (UnknownHostException ue) {
        } catch (IOException e) {
        }

    }

    @Override
    public void send(String message) {
        out.println(message);
        out.flush();
    }

    @Override
    public void close() {
        out.close();
        incomming.close();
    }

    @Override
    public void getResponse() {
        if (!connection.isClosed() && incomming.hasNext()) {
            printMessage(incomming.nextLine());
        }
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

}