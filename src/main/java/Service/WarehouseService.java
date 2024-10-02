package Service;

import entities.Product;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@ApplicationScoped
public class WarehouseService {
    private final List<Product> products = new CopyOnWriteArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }
}
