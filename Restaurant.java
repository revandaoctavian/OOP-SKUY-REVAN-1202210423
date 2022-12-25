public class Restaurant implements Runnable{

    private boolean waitingForPickup = false;
    private static final Object lock = new Object();
    private static int foodNumber = 1;
    
    @Override
    public void run() {
        while (true) {
            makeFood();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        
        }
    }  
    
    public void  setWaitingForPickup(boolean waitingForPickup) {
        this.waitingForPickup = waitingForPickup;
    }

    public static int getFoodNumber(){
                return foodNumber;
    }

    public void makeFood() {
        synchronized(Restaurant.lock) {
            if (this.waitingForPickup) {
                try {
                    System.out.println("Resto  : Menunggu untuk delivery makanan");
                    Restaurant.lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            waitingForPickup = true;
            System.out.println("Resto : Membuat Makanan ke-" + foodNumber++);
            Restaurant.lock.notifyAll();
            System.out.println("Resto : Memberitahu waiter untuk mengambil makanan\n");
        }
    }
    public static Object getLock() {
        return lock;
    }
}