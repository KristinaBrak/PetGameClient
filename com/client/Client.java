package com.client;

public interface Client {
    void connect();

    void send(String input);

    void close();
}