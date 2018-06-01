import com.overhome.DAOManager;

import java.io.IOException;

/**
 * @author Samuel, Didac, Adrián
 */
public class DB_Reader implements Runnable{
    private Process p;

    /**
     * Thread. DB listener. Also executes a BASH script to configure GPIO pins depending on the case.
     */
    @Override
    public void run() {
        while (true){
            for (int i = 0;i < Main.ids.length;i++){
                try {
                    Main.values[i] = DAOManager.getItemDAO().read(Main.ids[i]);

                    System.out.println("Value of " + i + ": " + Main.values[i]);

                    switch (Main.values[i]){
                        case 0:
                            try {

                                p = new ProcessBuilder("sh", "/home/pi/Desktop/pinController.sh", Main.pins[i], "1").start();
                                p.waitFor();
                                if (p.getErrorStream().read() == -1) System.out.println("Error en el script");

                            } catch (IOException | InterruptedException e) {
                                e.printStackTrace();
                            }
                            break;
                        case 1:
                            try {
                                p = new ProcessBuilder("sh", "/home/pi/Desktop/pinController.sh", Main.pins[i], "0").start();
                                p.waitFor();
                                if (p.getErrorStream().read() == -1) System.out.println("Error en el script");

                            } catch (IOException | InterruptedException e) {
                                e.printStackTrace();
                            }
                            break;
                            default:
                                break;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
