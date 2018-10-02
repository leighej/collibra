package com.collibra.exercise;

import java.util.UUID;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MySocket {
    private ServerSocket server;

    public MySocket() throws Exception {
        this.server = new ServerSocket(50000);
    }
    public void listen() throws Exception {
        Long start = System.currentTimeMillis();
        String data = null;
        Socket client = this.server.accept();
        
        String clientAddress = client.getInetAddress().getHostAddress();
        System.out.println("\r\nNew connection from " + clientAddress);
        // Create a unique ID for the session
        UUID idOne = UUID.randomUUID();

        try {
            String inputLine, outputLine;
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(client.getInputStream()));

            out.println("HI, I'M " + idOne);

            
        
            // Initiate conversation with client
            CollibraConversation cc = new CollibraConversation();
                  
            while ((inputLine = in.readLine()) != null) {
                System.out.println("InputLine from client: " + inputLine);
                outputLine = cc.processInput(inputLine);
                out.println(outputLine);
                if (outputLine.equals("BYE MATE!")) {
                   Long end = System.currentTimeMillis();
                   System.out.println("Talking time : " + (end - start));
                    break;
                }
            }
            Long end = System.currentTimeMillis();
        } catch (Exception e) {

        }
    }
    public InetAddress getSocketAddress() {
        return this.server.getInetAddress();
    }

    public int getPort() {
        return this.server.getLocalPort();
    }
}