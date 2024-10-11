package Service;

import entities.Category;
import entities.Product;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.Valid;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@ApplicationScoped
public class WarehouseService {
    private final List<Product> products = new CopyOnWriteArrayList<>();

    public void addProduct(@Valid Product product) {
        if (products.stream().anyMatch(p -> p.id().equals(product.id()))) {
            throw new IllegalArgumentException("Product already exists");
        }
        products.add(product);
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public Optional<Product> getProductById(@Valid String id) {
        return Collections.unmodifiableList(products)
                .stream()
                .filter(p -> p.id().equals(id))
                .findFirst();
    }

    public List<Product> getProductsByCategory(Category category) {
        return Collections.unmodifiableList(products)
                .stream()
                .filter(c -> c.category().equals(category))
                .sorted(Comparator.comparing(Product::name))
                .collect(Collectors.toList());
    }

    public List<Product> getProductsCreatedAfter(LocalDateTime specificDateTime) {
        return Collections.unmodifiableList(products)
                .stream()
                .filter(d -> d.createdDate().isAfter(specificDateTime))
                .toList();
    }

    public List<Product> getProductsModifiedSinceCreation() {
        return Collections.unmodifiableList(products)
                .stream()
                .filter(p -> !p.modifiedDate().equals(p.createdDate()))
                .toList();
    }

    public void modifyProduct(String id, String newName, Category newCategory, int newRating) {
        Product product = products
                .stream()
                .filter(p -> p.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Product with id " + id + " not found"));

        Product modifiedProduct = new Product(
                id,
                newName,
                newCategory,
                newRating,
                product.createdDate(),
                LocalDateTime.now());

        products.set(products.indexOf(product), modifiedProduct);
    }
}
