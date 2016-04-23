package ar.edu.unq.desapp.grupob.repositories;

import ar.edu.unq.desapp.grupob.model.Product;

public class ProductsRepository  extends GenericRepository<Product> {

    @Override
    protected Class<Product> getDomainClass() {
        return Product.class;
    }
}
