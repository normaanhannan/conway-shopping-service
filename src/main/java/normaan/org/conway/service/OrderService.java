package normaan.org.conway.service;

import normaan.org.conway.domain.entity.OrdersEntity;
import normaan.org.conway.dto.OrderRequest;
import normaan.org.conway.dto.Response;

public interface OrderService {

    Response<OrdersEntity> addOrder(OrderRequest orderRequest);

}
