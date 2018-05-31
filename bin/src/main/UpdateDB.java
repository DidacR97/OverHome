import java.io.IOException;

public class UpdateDB implements Runnable {

    @Override
    public void run() {
        try {
            while (!Main.looper()) {

                Main.syn.doWait();

                System.out.println("UDP_Packet_Received");

                InfoManager.updateInfo(Main.petitions.pop());

            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading initializer file");
            System.exit(1);

        }
        System.exit(0);
    }
}