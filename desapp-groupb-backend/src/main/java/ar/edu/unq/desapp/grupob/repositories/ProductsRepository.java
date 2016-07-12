package ar.edu.unq.desapp.grupob.repositories;

import ar.edu.unq.desapp.grupob.model.Product;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ProductsRepository extends GenericRepository<Product> {

    @Override
    protected Class<Product> getDomainClass() {
        return Product.class;
    }

    @Transactional
    public Product findByName(String productName) {
        try {
            List<Product> products = this.getHibernateTemplate()
                    .findByCriteria(DetachedCriteria.forClass(Product.class)
                            .add(Restrictions.eq("name", productName)));
            return products.get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}
