package ar.edu.unq.desapp.grupob.model;

public class Product extends Entity {

    private String name;
    private int stock;
    private int cost;


    public Product(String name, int stock, int cost)  {
        this.name = name;
        this.stock = stock;
        this.cost = cost;
    }

    public Product(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCost() {
        return cost;
    }

    public int getStock() {
        return stock;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void subtractStock(int subtractNumber) {
        stock -= subtractNumber;
    }
}
