package com.overhome;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class UDPClient {

    public static void send_UDP_Packet(String args[]) {

        if (args.length < 3) usage();

        String logFilePath = "C:\\bin\\logs\\ClientUDP.log";

        try {

            // Logger
            Logger logger =  Logger.getLogger("UDPClient");
            FileHandler fileHandler;

            System.out.println("Log file in: " + logFilePath);

            fileHandler = new FileHandler(logFilePath,  1024*1024, 1, true);
            logger.addHandler(fileHandler);
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            fileHandler.setFormatter  (simpleFormatter);

            DatagramSocket socketUDP = new DatagramSocket();
            byte[] message = args[0].getBytes();
            InetAddress hostServer = InetAddress.getByName(args[1]);
            int portServer = Integer.valueOf(args[2]);

            // Datagram
            DatagramPacket datagramPacket = new DatagramPacket(message, args[0].length(), hostServer, portServer);

            // Sending
            socketUDP.send(datagramPacket);

            String debug;

            debug = "Message send--> " + args[0] + "\n" +
                    "Server IP--> " + args[1] + "\n" +
                    "Server Port--> " + args[2] + "\n";

            logger.info(debug);

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
    }

    private static void usage(){
        System.out.println("Error: Missing Arguments!");
        System.out.println("Arguments should be as follows:");
        System.out.println("[Message] [IP] [Port]");
    }

}