package normaan.org.conway.domain.repository;

import normaan.org.conway.domain.entity.OrdersEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepo extends CrudRepository<OrdersEntity, Long> {
}
