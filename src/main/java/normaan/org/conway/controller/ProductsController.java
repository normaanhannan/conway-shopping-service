package normaan.org.conway.controller;

import normaan.org.conway.domain.entity.ProductsEntity;
import normaan.org.conway.domain.repository.ProductRepo;
import normaan.org.conway.dto.Response;
import normaan.org.conway.dto.ResponseStatus;
import normaan.org.conway.service.ProductService;
import normaan.org.conway.validator.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductsController {

    @Autowired
    private ProductService productService;
    @Autowired
    ProductRepo productRepo;

    @Autowired
    ProductValidator productValidator;

    @GetMapping("/all") //localhost:8080/product/all
    public List<ProductsEntity> getAll() {
        return productService.getAllProducts();
    }
    // getAllProductsByNameAndPrice

    @GetMapping(value = "/all", params = {"productName", "unitPrice"})
    public ResponseEntity<Response> getAllProductByNameAndUnitPrice(@RequestParam("productName") String productName,
                                                                    @RequestParam("unitPrice") Double unitPrice) {

        //Step 1: Validate
        ResponseEntity<Response> responseEntity = productValidator.validateGetAllProductByNameAndUnitPrice(productName, unitPrice);

        //Step 2: Check to see if the validation fails. If it fails then return right a way.
        if (responseEntity.getBody().getStatus() == normaan.org.conway.dto.ResponseStatus.ERROR) {
            return responseEntity;
        }

        //Step 3: If the validation does not fail, make a call to service get a list of the data.sql and create success response, then retunr to user
        List<ProductsEntity> products = productService.getAllProductByNameAndUnitPrice(productName, unitPrice);
        Response<List<ProductsEntity>> response = new Response<>();
        response.setBody(products);
        response.setStatus(ResponseStatus.SUCCESS);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/{productId}")
    public ProductsEntity findProductById(@PathVariable long productId) {

        return productService.getProductById(productId);

    }
}
