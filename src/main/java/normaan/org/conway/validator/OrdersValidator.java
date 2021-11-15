package normaan.org.conway.validator;

import normaan.org.conway.domain.entity.OrdersEntity;
import normaan.org.conway.dto.OrderRequest;
import normaan.org.conway.dto.Response;
import normaan.org.conway.dto.ResponseStatus;
import org.springframework.stereotype.Component;

@Component
public class OrdersValidator {

    public Response<OrdersEntity> validateRequiredFields(OrderRequest orderRequest) {
        Response<OrdersEntity> response = new Response<>();
        //Customer object has fullName as well as email address
        //Store name is not null or empty
        //OrderStatus is not null or empty
        // || vs &&

        if (orderRequest.getCustomer() == null || isEmpty(orderRequest.getCustomer().getFullName()) || isEmpty(orderRequest.getCustomer().getEmailAddress())) {
            response.setStatus(ResponseStatus.ERROR);
            response.setMessage("Customer's full name and email address are required");
        }
        if (orderRequest.getStore() == null || isEmpty(orderRequest.getStore().getStoreName())) {
            response.setStatus(ResponseStatus.ERROR);
            response.setMessage("Store's name is required.");
        }
        if (isEmpty(orderRequest.getOrderStatus()) || isInvalidOrderStatus(orderRequest.getOrderStatus())) {
            response.setStatus(ResponseStatus.ERROR);
            response.setMessage("A valid order status is required. Valid order status are: 'CANCELLED','COMPLETE','OPEN','PAID','REFUNDED','SHIPPED'");
        }
        return response;
    }

    private boolean isInvalidOrderStatus(String orderStatus) {
        //" order_status in
        //                    ( 'CANCELLED','COMPLETE','OPEN','PAID','REFUNDED','SHIPPED')"
        if (orderStatus.equalsIgnoreCase("CANCELLED") || orderStatus.equalsIgnoreCase("COMPLETE")
                || orderStatus.equalsIgnoreCase("OPEN") || orderStatus.equalsIgnoreCase("PAID")
                || orderStatus.equalsIgnoreCase("REFUNDED") || orderStatus.equalsIgnoreCase("SHIPPED")) {
            return false;
        }
        return true;
    }

    private static boolean isEmpty(String value) {
        if (value == null || value.isEmpty()) {
            return true;
        }
        return false;
    }

}
