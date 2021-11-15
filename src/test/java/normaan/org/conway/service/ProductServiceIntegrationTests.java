package normaan.org.conway.service;

import normaan.org.conway.domain.entity.ProductsEntity;
import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ProductServiceIntegrationTests {

    @Test
    public void findProductByIdTest() {
        RestAssured.baseURI = "http://localhost:7777";

        ResponseBody body = RestAssured.when().get("/product/36").getBody();
        ProductsEntity productsEntity = body.as(ProductsEntity.class);
        Assertions.assertTrue(productsEntity.getProductName().equals("Women's Trousers (Blue)"));
        Assertions.assertTrue(productsEntity.getUnitPrice() == 29.51);
    }


}
