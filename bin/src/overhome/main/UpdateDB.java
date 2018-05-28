
public class UpdateDB implements Runnable {

    @Override
    public void run() {
        Main.syn.doWait();
        System.out.println("UDP_Packet_Received");

        String packet = Main.stack.pop();

        String []action;

        action = packet.split(",");

        InfoManager.updateInfo(action[0]);

    }

}
