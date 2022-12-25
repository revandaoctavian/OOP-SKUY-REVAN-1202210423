import java.util.Scanner; 

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
            Restaurant resto = new Restaurant();
            int customerID, orderQty;
            try {

                System.out.print("Masukkan No Pelanggan : ");
                customerID = input.nextInt();

                System.out.print("Masukkan jumlah makanan : ");
                orderQty = input.nextInt();

                Thread t1 = new Thread(resto);
                Waiters waiter = new Waiters(customerID, orderQty);
                Thread t2 = new Thread(waiter);


                t1.start();
                t2.start();
                t1.join();
                t2.join();

            } catch (Exception e) {
                System.out.println("Inputan harus Integer !!");
            }

    }

}

