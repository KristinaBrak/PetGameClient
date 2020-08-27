package com;

import java.util.Scanner;

import com.client.Client;
import com.client.ClientImp;

public class Main {
    public static void main(String[] args) {
        String hostName = "localhost";
        int listeningPort = 32100;
        Client client = new ClientImp(hostName, listeningPort);
        client.connect();

        Scanner scanner = new Scanner(System.in);
        String input = "energy";
        // do {
        // input = scanner.nextLine();
        // client.send(input);
        // client.getResponse();

        // } while (input.length() != 0); // until enter is pressed
        client.send(input);
        client.getResponse();

        scanner.close();
        client.close();

        // send string energy
        // get energy value
    }
}