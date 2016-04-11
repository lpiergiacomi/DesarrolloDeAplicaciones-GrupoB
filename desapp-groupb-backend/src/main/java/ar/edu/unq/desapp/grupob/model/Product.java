package ar.edu.unq.desapp.grupob.model;

public class Product {

    private String name;
    private int stock;
    private int cost;

    public Product(String name, int stock, int cost) {
        this.name = name;
        this.stock = stock;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public int getStock() {
        return stock;
    }

    public void subtractStock(int subtractNumber) {
        stock -= subtractNumber;
    }
}
