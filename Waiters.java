public class Waiters implements Runnable{

    private  final int orderQty;
    private final int customerID;
    static int foodPrice = 25000;

    public Waiters(int customerID, int orderQty) {
        this.customerID = customerID;
        this.orderQty = orderQty;
    }

    @Override
    public void run() {
        while (true) {
            getFood();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void orderInfo() {
        System.out.println("==================== RESTO BANG DAPID ====================");
        System.out.println("No Pelanggan          : "+ this.customerID);
        System.out.println("Jumlah Makanan        : "+ this.orderQty);
        System.out.println("Total Harga           : "+ this.orderQty * foodPrice);
        System.out.println("========================================================");
    }
    public void getFood() {
        synchronized(Restaurant.getLock()) {

            System.out.println("Waiter : Makanan Siap Diantarkan");
            Restaurant restoRestaurant = new Restaurant();
            restoRestaurant.setWaitingForPickup(false);

            if (Restaurant.getFoodNumber() == this.orderQty + 1) {
                orderInfo();
                System.exit(0);
            }
            Restaurant.getLock().notifyAll();
            System.out.println("Waiter : Memberitahu Resto untuk membuat makanan yang lain\n");

        }
    }
        
}
    

