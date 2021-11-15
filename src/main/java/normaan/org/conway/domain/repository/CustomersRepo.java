package normaan.org.conway.domain.repository;

import normaan.org.conway.domain.entity.CustomersEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomersRepo extends CrudRepository<CustomersEntity, Long> {

    CustomersEntity findByFullNameAndEmailAddress(String fullName, String emailAddress);
}
