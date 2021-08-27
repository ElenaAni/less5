import Utils.RetrofitUtils;
import com.github.javafaker.Faker;
import dto.Category;
import dto.Product;
import enums.CategoryType;
import java.io.IOException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import service.CategoryService;
import service.ProductService;

import static org.junit.Assert.assertThat;

public class ProductTests {
    static Retrofit client;
    static ProductService productService;
    static CategoryService categoryService;
    Faker faker = new Faker();
    Product product;

    @BeforeAll
    static void beforeAll(){
        client = RetrofitUtils.getRetrofit();
        productService = client.create(ProductService.class);
        categoryService = client.create(CategoryService.class);
    }

    @BeforeEach
    void setUp(){
        product = new Product();
        product.withTitle(faker.food().dish());
        product.withPrice((int) ((Math.random() + 1) * 100));
        product.withCategoryTitle(CategoryType.FOOD.getTitle());

    }

    @Test
    void postProductTest()throws IOException{
    Response<Product> response = productService.createProduct(product).execute();
    assertThat(response.body().getTitle(),equalTo(product.getTitle()));
    assertThat(response.body().getPrice(),equalTo(product.getPrice()));
    assertThat(response.body().getCategoryTitle(),equalTo(product.getCategoryTitle()));
    }

    @Test
    void getCategoryByIdTest()throws IOException{
        integer id = CategoryType.FOOD.getId();
        Response<Category> response = categoryService
                .getCategory(id)
                .execute();
        log.info(response.body().toString());
        assertThat(response.body().getTitle(),equalTo(CategoryType.FOOD.getTitle()));
        assertThat(response.body().getid(),equalTo(id));
    }
}


