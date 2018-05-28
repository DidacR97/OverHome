import com.overhome.UDPServer;

public class RunUDPServer implements Runnable {

    String port;

    @Override
    public void run() {
        System.out.println("Ha entrado en RunUDPSERVER");
        String[] args = new String[1];
        args[0] = "12000";

        while (true){

            String packet = UDPServer.start_UPD_Server(args);

            String []action;

            action = packet.split(",");

            Main.petitions.push(action[0]);

            Main.syn.doNotify();

        }
    }

}