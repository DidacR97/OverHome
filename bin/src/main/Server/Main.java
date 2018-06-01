import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Main{

    public static Stack<String> petitions = new Stack<>();
    public static Syn syn = new Syn();

    private static final String INIT = "C:\\bin\\apps\\overhome\\overhome.init";


    public static void main(String[] args) {

        RunUDPServer runUDPServer = new RunUDPServer();
        UpdateDB updateDB = new UpdateDB();

        Thread udp_Server = new Thread(runUDPServer);
        Thread update_DB = new Thread(updateDB);

        udp_Server.start();
        update_DB.start();

    }

    public static boolean looper() throws IOException {
        String cadena;
        FileReader f = new FileReader(INIT);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null);
        b.close();
        if("TRUE".equals(cadena)){
            return true;
        }else return false;
    }
}