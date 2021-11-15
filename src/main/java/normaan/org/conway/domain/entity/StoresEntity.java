package normaan.org.conway.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STORES", schema = "CO")
@Data
public class StoresEntity {

    @Id
    @Column(name = "STORE_ID")
    private Long storeId;

    @Column(name = "STORE_NAME")
    private String storeName;
}
