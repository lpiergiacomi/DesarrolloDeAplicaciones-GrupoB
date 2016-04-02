package ar.edu.unq.desapp.grupob.model;

public class Product extends Exchangeable{

    public Product(String name, int stock, int cost) {
        super(name, stock, cost);
    }

    public boolean isProduct() {
        return true;
    }

    public boolean isVoucher() {
        return false;
    }
}
