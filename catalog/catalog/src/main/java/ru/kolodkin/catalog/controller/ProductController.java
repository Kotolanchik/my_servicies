package ru.kolodkin.catalog.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import ru.kolodkin.catalog.domain.Product;
import ru.kolodkin.catalog.service.CategoryService;
import ru.kolodkin.catalog.service.ProductService;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static lombok.AccessLevel.PRIVATE;

@Path("/product")
@FieldDefaults(level = PRIVATE)
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public Response getProduct(@PathParam("id") final long id) {
        return Response.ok(productService.getProduct(id))
                .build();
    }

    @GET
    @Path("/all")
    @Produces(APPLICATION_JSON)
    public Response getProducts() {
        return Response.ok().build();
    }

    @POST
    @Path("/add")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response saveProduct(final Product product) {
        return Response.ok(productService.saveProduct(product))
                .build();
    }

    @DELETE
    @Path("/{id}/delete")
    public Response deleteProduct(@PathParam("id") final long id) {
        productService.deleteProduct(id);
        return Response.ok()
                .build();
    }
}
