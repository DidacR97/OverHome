
public class UpdateDB implements Runnable {

    @Override
    public void run() {
        System.out.println("Ha entrado en UpdateUDP");
        Main.syn.doWait();
        System.out.println("PacketeUDPRecivido");

        String string = Main.stack.pop();

        System.out.println(string.equals("00010001;didac"));

        InfoManager.updateInfo(string);

    }

}
