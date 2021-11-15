package normaan.org.conway.service.impl;

import normaan.org.conway.domain.entity.CustomersEntity;
import normaan.org.conway.domain.entity.OrdersEntity;
import normaan.org.conway.domain.entity.StoresEntity;
import normaan.org.conway.domain.repository.CustomersRepo;
import normaan.org.conway.domain.repository.OrdersRepo;
import normaan.org.conway.domain.repository.StoresRepo;
import normaan.org.conway.dto.OrderRequest;
import normaan.org.conway.dto.Response;
import normaan.org.conway.dto.ResponseStatus;
import normaan.org.conway.service.OrderService;
import normaan.org.conway.validator.OrdersValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private CustomersRepo customersRepo;

    @Autowired
    private StoresRepo storesRepo;

    @Autowired
    private OrdersRepo ordersRepo;

    @Autowired
    private OrdersValidator ordersValidator;

    @Override
    public Response<OrdersEntity> addOrder(OrderRequest orderRequest) {
        Response<OrdersEntity> response = new Response<>();
        //Step 1: Check if the customer exist in the DB. If not found then create
        //Step 1 (a): Run select * from co.customers where full_name='' and email_address='';
        CustomersEntity customer = customersRepo.findByFullNameAndEmailAddress(orderRequest.getCustomer().getFullName(),
                orderRequest.getCustomer().getEmailAddress());
        //Step 1 (b): Check if the customer exist otherwise insert the customer
        if (customer == null) {
            customer = customersRepo.save(orderRequest.getCustomer());
        }
        // Step 2: Find the store. If the store is not found then return as an error mentioning the store is not found.
        //Step 2 (a)Find the store.
        StoresEntity store = storesRepo.findByStoreName(orderRequest.getStore().getStoreName());
        //Step 2 (b)If the store is not found then return as an error mentioning the store is not found.
        if (store == null) {
            response.setMessage("Store name is not found in DB.");
            response.setStatus(ResponseStatus.ERROR);
            return response;
        }
        // Step 3: Insert into the orders table and return the added order
        OrdersEntity ordersEntity = buildNewOrders(orderRequest, customer.getCustomerId(), store.getStoreId());
        OrdersEntity order = ordersRepo.save(ordersEntity);
        response.setBody(order);
        response.setStatus(ResponseStatus.SUCCESS);
        return response;
    }

    private OrdersEntity buildNewOrders(OrderRequest orderRequest, Long customerId, Long storeId) {
        OrdersEntity ordersEntity = new OrdersEntity();
        ordersEntity.setOrderDateTime(LocalDateTime.now());
        ordersEntity.setCustomerId(customerId);
        ordersEntity.setOrderStatus(orderRequest.getOrderStatus().toUpperCase());
        ordersEntity.setStoreId(storeId);
        return ordersEntity;
    }

}
