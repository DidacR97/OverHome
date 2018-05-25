public class Syn {
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

}
