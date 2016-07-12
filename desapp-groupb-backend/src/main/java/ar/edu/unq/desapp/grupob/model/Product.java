package ar.edu.unq.desapp.grupob.model;

import javax.persistence.*;

@Entity
@Table
public class Product {

    private Integer id;
    private String name;
    private int stock;
    private int cost;

    public Product(String name, int stock, int cost) {
        this.name = name;
        this.stock = stock;
        this.cost = cost;
    }

    public Product() {
    }

    public void subtractStock(int subtractNumber) {
        stock -= subtractNumber;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
