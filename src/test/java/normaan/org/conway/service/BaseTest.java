package normaan.org.conway.service;

import normaan.org.conway.domain.entity.CustomersEntity;
import normaan.org.conway.domain.entity.OrdersEntity;
import normaan.org.conway.domain.entity.StoresEntity;
import normaan.org.conway.dto.OrderRequest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
public class BaseTest {

    public OrdersEntity getOrderEntityAsResponse() {
        OrdersEntity ordersEntity = new OrdersEntity();
        ordersEntity.setOrderDateTime(LocalDateTime.now());
        ordersEntity.setOrderStatus("Complete");
        ordersEntity.setCustomerId(1001L);
        ordersEntity.setStoreId(100L);
        ordersEntity.setOrderId(10000L);
        return ordersEntity;
    }

    public OrderRequest getOrderRequest() {
        CustomersEntity customer = new CustomersEntity();
        customer.setEmailAddress("jdoe@fake.com");
        customer.setFullName("John Doe");

        StoresEntity store = new StoresEntity();
        store.setStoreName("Online 123");

        OrderRequest request = new OrderRequest();
        request.setCustomer(customer);
        request.setStore(store);
        request.setOrderStatus("COMPLETE");
        return request;
    }

    public StoresEntity getStoresAsResponse() {
        StoresEntity storesEntity = new StoresEntity();
        storesEntity.setStoreName("Online 123");
        storesEntity.setStoreId(100L);
        return storesEntity;
    }

    public CustomersEntity getCustomerEntityAsResponse() {
        CustomersEntity customer = new CustomersEntity();
        customer.setEmailAddress("jdoe@fake.com");
        customer.setFullName("John Doe");
        customer.setCustomerId(1001L);
        return customer;
    }
}
