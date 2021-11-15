package normaan.org.conway.domain.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "ORDERS", schema = "CO")
public class OrdersEntity {

    @Id
    @GeneratedValue(generator = "orderIdGenerator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "orderIdGenerator", sequenceName = "ISEQ$$_73596", schema = "CO", allocationSize = 1)
    @Column(name = "ORDER_ID")
    private Long orderId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "ORDER_DATETIME")
    private LocalDateTime orderDateTime;

    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    @Column(name = "ORDER_STATUS")
    private String orderStatus;

    @Column(name = "STORE_ID")
    private Long storeId;
}
