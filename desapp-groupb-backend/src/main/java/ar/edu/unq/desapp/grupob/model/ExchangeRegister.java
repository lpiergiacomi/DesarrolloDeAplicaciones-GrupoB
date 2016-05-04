package ar.edu.unq.desapp.grupob.model;

import javax.persistence.*;

@Entity
@Table
public class ExchangeRegister {
    private User user;
    private Product product;
    private Integer id;

    public ExchangeRegister(User user, Product product) {
        this.user = user;
        this.product = product;
    }

    @Id @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}