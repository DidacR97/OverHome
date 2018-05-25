import com.overhome.UDPServer;

import java.util.Stack;

public class RunUDPServer implements Runnable {

    String port;

    @Override
    public void run() {
        System.out.println("Ha entrado en RunUDPSERVER");
        String[] args = new String[1];
        args[0] = "12000";
        Main.stack.push(UDPServer.start_UPD_Server(args));

        Main.syn.doNotify();

    }
}