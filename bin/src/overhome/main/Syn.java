public class Syn {

    private static boolean status;


    public static boolean update_Done() {
        return !Syn.status;
    }

    public void doWait(){
        synchronized (this){
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
    }

    public void doNotify(){
        synchronized (this){
            this.notify();
        }
    }

    public void doWaitL(long l) {
        try {
            this.wait(l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
