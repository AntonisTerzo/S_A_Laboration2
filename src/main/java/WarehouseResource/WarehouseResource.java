package WarehouseResource;

import Service.WarehouseService;
import entities.Category;
import entities.Product;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.Optional;

@Path("/")
public class WarehouseResource {
    private WarehouseService warehouseService;

    public WarehouseResource() {
    }

    @Inject
    public WarehouseResource(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GET
    @Path("/all-products")
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
    @Path("/all-products/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductById(@PathParam("id") String id) {
        Optional<Product> product = warehouseService.getProductById(id);
        if (product.isPresent()) {
            return Response.ok().entity(product.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }


}