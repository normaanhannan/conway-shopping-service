package normaan.org.conway.validator;

import normaan.org.conway.dto.Response;
import normaan.org.conway.dto.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductValidator {


    public ResponseEntity<Response> validateGetAllProductByNameAndUnitPrice(String productName, Double unitPrice) {

        Response response = new Response();
        if (productName == null || productName.isEmpty()) {
            response.setStatus(ResponseStatus.ERROR);
            response.setMessage("productName cannot be null or empty");
        } else if (unitPrice == null) {
            response.setStatus(ResponseStatus.ERROR);
            response.setMessage("unitPrice cannot be null");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
