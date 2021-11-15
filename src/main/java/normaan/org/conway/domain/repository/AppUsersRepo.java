package normaan.org.conway.domain.repository;

import normaan.org.conway.domain.entity.AppUsersEntity;
import org.springframework.data.repository.CrudRepository;

public interface AppUsersRepo extends CrudRepository<AppUsersEntity, Long> {

    AppUsersEntity findOneByUserName(String username);
}
