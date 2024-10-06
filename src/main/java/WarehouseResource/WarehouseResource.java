package WarehouseResource;

import Service.WarehouseService;
import entities.Category;
import entities.Product;
import interceptor.LogInfo;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/")
@LogInfo
public class WarehouseResource {
    private static final Logger logger = LoggerFactory.getLogger(WarehouseResource.class);

    private WarehouseService warehouseService;

    public WarehouseResource() {
    }

    @Inject
    public WarehouseResource(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GET
    @Path("/products")
    @Produces(MediaType.APPLICATION_JSON)
    public Response allProducts() {
        return Response.ok().entity(warehouseService.getAllProducts()).build();
    }

    @POST
    @Path("/add-product")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProduct(@Valid Product product) {
        warehouseService.addProduct(product);
        return Response.created(URI.create("/add-product")).build();
    }

    @GET
    @Path("/products/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductById(@PathParam("id") @Valid String id) {
        Optional<Product> product = warehouseService.getProductById(id);
        if (product.isPresent()) {
            return Response.ok().entity(product.get()).build();
        }
        logger.error("No Product with id {} is found.", id);
        return Response.status(Response.Status.NOT_FOUND)
                .entity("No product with this id is found: " + id)
                .build();
    }

    @GET
    @Path("/products/categories/{category}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductsFromCategory(@PathParam("category") @Valid String categoryString) {
        Category category = Category.valueOf(categoryString.toUpperCase());
        List<Product> products = warehouseService.getProductsByCategory(category);
        if (products.isEmpty()) {
            logger.error("No products found for category {}", category);
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("No products found for category: " + category)
                    .build();
        }
        return Response.ok().entity(products).build();
    }
}