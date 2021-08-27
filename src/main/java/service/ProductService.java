package service;

import dto.Product;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.*;
import sun.plugin.util.PluginSysUtil;

public interface ProductService {
    @GET("products")
    Call<ArrayList<Product>> getProducts();

    @GET("products/{id}")
    default <createProduct> Call<Product> getProduct(@Path("id") Integer id;

    @POST("products")
            Call<Product>createProduct(@Body Product product)



        @GET("Returns products")
         Call<Product> getProducts() {
            Object productService;
            return productService.getAllProducts().stream().map(Product:new));
        }

        @GET("Returns a specific product by their identifier. 404 if does not exist.")
        public Call Product getProductById("Id of the book to be obtained. Cannot be empty.") @Path Long id) {
            Product p = productService.getOneById(id).orElseThrow(() -> new ResourceNotFoundException("Unable to find product with id: " + id));
            return new Product();
        }

        @POST("Creates a new product. If id != null, then throw bad request response")
        public Response<?> createNewProduct(@RequestBody Product p) {
            if (p.getId() != null) {
                return new Response<>(new Market(HttpStatus.BAD_REQUEST.value(), "Id must be null for new entity"), HttpStatus.BAD_REQUEST);
            }
            return new Response<>(new Product(productService.save(p)), HttpStatus.CREATED);
        }

        @PUT("Modify product")
        public Response<?> modifyProduct(@RequestBody ProductDto p) {
            if (p.getId() == null) {
                return new Response<>(new Market(HttpStatus.BAD_REQUEST.value(), "Id must be not null for new entity"), HttpStatus.BAD_REQUEST);
            }
            if (!productService.existsById(p.getId())) {
                return new Response<>(new Market(HttpStatus.BAD_REQUEST.value(), "Product with id: " + p.getId() + " doesn't exist"), HttpStatus.BAD_REQUEST);
            }
            return new Response<>(new Product(productService.save(p)), HttpStatus.OK);
        }

        @DELETE("Delete product")
        public void delete("Id of the product") @PathVariable Long id) {
            productService.deleteById(id);
        }
    }

}
