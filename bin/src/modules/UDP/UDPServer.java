package com.overhome;

import java.net.*;
import java.io.*;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class UDPServer {

    private static String args[];
    private static Logger logger = Logger.getLogger("UDPServer");
    private static DatagramSocket socketUDP;

    public static String start_UPD_Server(String args[]) {
        if (args.length == 0) usage();
        try {
            socketUDP = new DatagramSocket(Integer.valueOf(args[0]));
        } catch (SocketException e) {
            e.printStackTrace();
            System.exit(1);
        }
        byte[] buffer = new byte[1000];

            System.out.println("Listening packets from port: " + args[0] + "...");

            // Build DatagramPacket
            DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);

            // Read DatagramSocket
        try {
            socketUDP.receive(datagramPacket);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        if (init_Logger_Server_UDP()){
            String debug = "\n------------MESSAGE RECIVED-------------\n" +
                    "Datagram recived from host: " + datagramPacket.getAddress() + "\n" +
                    "remote port: " + datagramPacket.getPort() + "\n" +
                    "Content recived: " + new String(datagramPacket.getData()) + "\n";

            logger.info(debug);
        }

            return new String(datagramPacket.getData());
    }

    private static boolean init_Logger_Server_UDP() {
        String logFilePath = "C:\\bin\\logs\\ServerUDP.log";

        try {
            //logger

            System.out.println("Log file in: " + logFilePath);

            FileHandler fileHandler = new FileHandler(logFilePath, 1024 * 1024, 1, true);
            logger.addHandler(fileHandler);
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            fileHandler.setFormatter(simpleFormatter);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void usage(){

        System.out.println("Error: Missing Arguments!");
        System.out.println("Arguments should be as follows");
        System.out.println("[Port]");
    }

}