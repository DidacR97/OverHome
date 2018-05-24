package com.overhome;

import java.net.*;
import java.io.*;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class UDPServer {

    public static String start_UPD_Server(String args[]) {
        if (args.length == 0) usage();

        String logFilePath = "C:\\bin\\logs\\ServerUDP.log";

        try {
            //logger
            Logger logger =  Logger.getLogger("UDPServer");
            FileHandler fileHandler;

            System.out.println("Log file in: " + logFilePath);

            fileHandler = new FileHandler(logFilePath, 1024*1024, 1, true);
            logger.addHandler(fileHandler);
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            fileHandler.setFormatter(simpleFormatter);


            DatagramSocket socketUDP = new DatagramSocket(Integer.valueOf(args[0]));
            byte[] buffer = new byte[1000];

            System.out.println("Listening packets from port: " + args[0] + "...");

            // Build DatagramPacket
            DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);

            // Read DatagramSocket
            socketUDP.receive(datagramPacket);

            String debug = "\n------------MESSAGE RECIVED-------------\n" +
                    "Datagram recived from host: " + datagramPacket.getAddress() + "\n" +
                    "remote port: " + datagramPacket.getPort() + "\n" +
                    "Content recived: " + new String(datagramPacket.getData()) + "\n";

            logger.info(debug);

            return new String(datagramPacket.getData());

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage() + ", couldn't initiate logging in " + logFilePath);
        }
        return "Server error!!";
    }

    private static void usage(){

        System.out.println("Error: Missing Arguments!");
        System.out.println("Arguments should be as follows");
        System.out.println("[Port]");
    }

}