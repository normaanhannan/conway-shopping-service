package normaan.org.conway.service.impl;

import normaan.org.conway.domain.entity.ProductsEntity;
import normaan.org.conway.domain.repository.ProductRepo;
import normaan.org.conway.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<ProductsEntity> getAllProducts() {
        List<ProductsEntity> products = new ArrayList<>();
        Iterable<ProductsEntity> all = productRepo.findAll();
        all.forEach(productEntity -> products.add(productEntity));
        return products;
    }

    @Override
    public ProductsEntity getProductById(long productId) {
        Optional<ProductsEntity> byId = productRepo.findById(productId);
        if (byId.isPresent()) {
            return byId.get();
        }
        return null;
    }

    @Override
    public List<ProductsEntity> getAllProductByNameAndUnitPrice(String productName, Double unitPrice) {
        return productRepo.findAllByProductNameAndUnitPrice(productName, unitPrice);
    }
}
