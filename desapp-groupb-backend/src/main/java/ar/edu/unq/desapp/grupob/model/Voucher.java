package ar.edu.unq.desapp.grupob.model;

public class Voucher extends Exchangeable {

    public Voucher(String name, int stock, int cost) {
        super(name, stock, cost);
    }

    public boolean isProduct() {
        return false;
    }

    public boolean isVoucher() {
        return true;
    }
}
