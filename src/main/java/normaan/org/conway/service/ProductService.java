package normaan.org.conway.service;

import normaan.org.conway.domain.entity.ProductsEntity;

import java.util.List;


public interface ProductService {

    List<ProductsEntity> getAllProducts();

    ProductsEntity getProductById(long productId);

    List<ProductsEntity> getAllProductByNameAndUnitPrice(String productName, Double unitPrice);
}
