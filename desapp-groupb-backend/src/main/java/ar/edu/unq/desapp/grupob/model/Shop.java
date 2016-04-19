package ar.edu.unq.desapp.grupob.model;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private ArrayList<ExchangeRegister> exchangeRegisters= new ArrayList<>();

    public void registerExchange(User user, Product product) {
        exchangeRegisters.add(new ExchangeRegister(user, product));
    }

    public List<ExchangeRegister> getExchangeRegisters() {
        return exchangeRegisters;
    }
}
