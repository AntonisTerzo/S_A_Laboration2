package WarehouseResource;

import Service.WarehouseService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/")
public class WarehouseResource {
    private WarehouseService warehouseService;

    public WarehouseResource() {}

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

}