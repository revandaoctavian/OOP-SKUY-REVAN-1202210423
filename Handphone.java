public class Handphone extends Perangkat {

    boolean fingerprint;

    Handphone(String drive, int ram, float processor, boolean fingerprint) {
        super(drive, ram, processor);
        this.fingerprint = fingerprint;
    }

    @Override
    public void informasi() {
        if (fingerprint) {
            System.out.printf(
                    "Handphone ini memiliki drive tipe %s dengan ram sebesar %d GB dan processor secepat %.2f Ghz. Selain itu handphone ini juga memiliki Fingerprint \n",
                    this.drive, this.ram, this.processor);
        } else {
            System.out.printf(
                    "Handphone ini memiliki drive tipe %s dengan ram sebesar %d GB dan processor secepat %.2f Ghz. Handphone ini TIDAK memiliki Fingerprint \n",
                    this.drive, this.ram, this.processor);
        }
    }

    public void telfon(int no_hp) {
        System.out.printf("Handphone berhasil menyambungkan telfon ke No %d \n", no_hp);
    }

    public void kirimSMS(int no_hp) {
        System.out.printf("Handphone berhasil mengirim SMS ke No %d", no_hp);
    }

    public void kirimSMS(int no_hp1, int no_hp2) {
        System.out.printf("Handphone berhasil mengirim SMS ke No %d dan %d", no_hp1, no_hp2);
    }

}
