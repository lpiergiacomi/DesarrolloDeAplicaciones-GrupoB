package ar.edu.unq.desapp.grupob.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Shop {

    private ArrayList<Exchangeable> exchangeables;

    public Shop(){
        this.exchangeables =  new ArrayList<Exchangeable>();
    }


    public ArrayList<Exchangeable> getExchangeables() {
        return exchangeables;
    }

    public void addExchangeable(Exchangeable exchangeable) {
        exchangeables.add(exchangeable);
    }

    public void addListExchangeables(List<Exchangeable> listExangeables) {
        exchangeables.addAll(listExangeables);
    }

}
