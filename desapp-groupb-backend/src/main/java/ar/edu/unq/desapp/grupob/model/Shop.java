package ar.edu.unq.desapp.grupob.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table
public class Shop {
    private List<ExchangeRegister> exchangeRegisters= new ArrayList<ExchangeRegister>();
    private int id;

    private ArrayList<ExchangeRegister> exchangeRegisters= new ArrayList<ExchangeRegister>();

    public void registerExchange(User user, Product product) {
        exchangeRegisters.add(new ExchangeRegister(user, product));
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany
    @JoinColumn(name ="Shop")
    public List<ExchangeRegister> getExchangeRegisters() {
        return exchangeRegisters;
    }

    public void setExchangeRegisters(List<ExchangeRegister> exchangeRegisters) {
        this.exchangeRegisters = exchangeRegisters;
    }

}
