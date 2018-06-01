public class Main {

    public static final String[] ids = {"00030001","00030002","00030003","00030004"};
    public static final String[] pins = {"17", "19", "21", "23"};

    public static int[] values = {0,0,0,0};

    public static void main(String[] args) throws Exception {

        DB_Reader db_reader = new DB_Reader();

        Thread thread = new Thread(db_reader);

        thread.start();

    }

}
