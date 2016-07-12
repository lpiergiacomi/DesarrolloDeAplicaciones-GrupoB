package ar.edu.unq.desapp.grupob.services;

import ar.edu.unq.desapp.grupob.model.Product;
import ar.edu.unq.desapp.grupob.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.*;

@Path("/products")
public class ProductService extends GenericService<Product> {
    @Autowired
    private ProductsRepository repository;

    public ProductsRepository getRepository() {
        return repository;
    }

    public void setRepository(ProductsRepository repository) {
        this.repository = repository;
    }

    @GET
    @Path("/{name}/find")
    @Produces("application/json")
    @Transactional
    public Product findProductByName(@PathParam("name") String productName) {
        return getRepository().findByName(productName);
    }

}
