import java.util.Stack;

public class Main{

    public static Stack<String> stack = new Stack<>();
    public static Syn syn = new Syn();
    public static void main(String[] args) {

        RunUDPServer runUDPServer = new RunUDPServer();
        UpdateDB updateDB = new UpdateDB();

        new Thread(runUDPServer).start();
        new Thread(updateDB).start();

    }


}