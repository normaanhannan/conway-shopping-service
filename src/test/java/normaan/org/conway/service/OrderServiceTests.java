package normaan.org.conway.service;

import normaan.org.conway.domain.entity.OrdersEntity;
import normaan.org.conway.domain.repository.CustomersRepo;
import normaan.org.conway.domain.repository.OrdersRepo;
import normaan.org.conway.domain.repository.StoresRepo;
import normaan.org.conway.dto.Response;
import normaan.org.conway.dto.ResponseStatus;
import normaan.org.conway.service.impl.OrderServiceImpl;
import normaan.org.conway.validator.OrdersValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

public class OrderServiceTests extends BaseTest {

    @Mock
    private CustomersRepo customersRepo;
    @Mock
    private StoresRepo storesRepo;
    @Mock
    private OrdersRepo ordersRepo;
    @Mock
    private OrdersValidator ordersValidator;
    @InjectMocks
    private OrderService orderService = new OrderServiceImpl();

    @BeforeEach
    public void beforeEach() {
        Mockito.when(storesRepo.findByStoreName(Mockito.any())).thenReturn(getStoresAsResponse());
        Mockito.when(ordersRepo.save(Mockito.any())).thenReturn(getOrderEntityAsResponse());
    }

    //Scenario 1/Test case 1: Customer that exists in the db
    @Test
    public void testExistingCustomer() {
        //Instruct the Mockito to return a specific outcome for this request
        Mockito.when(customersRepo.findByFullNameAndEmailAddress(Mockito.any(), Mockito.any())).thenReturn(getCustomerEntityAsResponse()); //output

        Response<OrdersEntity> response = orderService.addOrder(getOrderRequest());
        //Assertions
        Assertions.assertTrue(response.getStatus() == ResponseStatus.SUCCESS);
        Assertions.assertTrue(response.getBody().getOrderId() == 10000L);
        Assertions.assertTrue(response.getMessage() == null);
    }

    //Scenario 2/Test case 2: Customer that does not exist in the db
    @Test
    public void testNonExistingCustomer() {
        Mockito
                .when(customersRepo.findByFullNameAndEmailAddress(Mockito.any(), Mockito.any())) //input
                .thenReturn(null); //output
        Mockito.when(customersRepo.save(Mockito.any())).thenReturn(getCustomerEntityAsResponse());

        Response<OrdersEntity> response = orderService.addOrder(getOrderRequest());

        //Assertions
        Assertions.assertTrue(response.getStatus() == ResponseStatus.SUCCESS);
        Assertions.assertTrue(response.getBody().getOrderId() == 10000L);
        Assertions.assertTrue(response.getMessage() == null);
    }


}
