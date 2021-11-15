package normaan.org.conway.domain.repository;

import normaan.org.conway.domain.entity.StoresEntity;
import org.springframework.data.repository.CrudRepository;

public interface StoresRepo extends CrudRepository<StoresEntity, Long> {
    StoresEntity findByStoreName(String storeName);
}
