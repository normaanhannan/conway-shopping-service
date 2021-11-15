package normaan.org.conway.dto;

import normaan.org.conway.domain.entity.CustomersEntity;
import normaan.org.conway.domain.entity.StoresEntity;
import lombok.Data;

@Data
public class OrderRequest {

    private CustomersEntity customer;
    private StoresEntity store;
    private String orderStatus;
}
