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
        String input;
        do {
            input = scanner.nextLine();
            client.send(input);

        } while (input.length() != 0); // until enter is presseds
        scanner.close();
    }
}