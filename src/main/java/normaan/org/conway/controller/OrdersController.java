package normaan.org.conway.controller;

import normaan.org.conway.domain.entity.OrdersEntity;
import normaan.org.conway.dto.OrderRequest;
import normaan.org.conway.dto.Response;
import normaan.org.conway.dto.ResponseStatus;
import normaan.org.conway.service.OrderService;
import normaan.org.conway.validator.OrdersValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrdersController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrdersValidator ordersValidator;


    @PostMapping("/add")
    public ResponseEntity<Response<OrdersEntity>> add(@RequestBody OrderRequest orderRequest) {
        Response<OrdersEntity> response = ordersValidator.validateRequiredFields(orderRequest);
        if (response.getStatus() != ResponseStatus.ERROR) {
            response = orderService.addOrder(orderRequest);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    //Unit, Integration
    //JUnit, TestNg
}
