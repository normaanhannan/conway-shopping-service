package normaan.org.conway.domain.repository;

import normaan.org.conway.domain.entity.ProductsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//CrudRepository is a part of the Spring Data JPA framework: CrudRepository,
public interface ProductRepo extends CrudRepository<ProductsEntity, Long> {
    List<ProductsEntity> findAllByProductNameAndUnitPrice(String productName, Double unitPrice);
}
