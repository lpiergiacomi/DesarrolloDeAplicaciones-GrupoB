package ar.edu.unq.desapp.grupob.repositories;

import ar.edu.unq.desapp.grupob.model.Shop;

public class ShopRepository extends GenericRepository<Shop>{

    @Override
    protected Class<Shop> getDomainClass() {
        return Shop.class;
    }
}
