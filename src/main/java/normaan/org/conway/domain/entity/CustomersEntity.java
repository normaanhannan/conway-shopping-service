package normaan.org.conway.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CUSTOMERS", schema = "CO")
public class CustomersEntity {

    @GeneratedValue(generator = "customerIdGenerator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "customerIdGenerator", sequenceName = "ISEQ$$_73584", schema = "CO", allocationSize = 1)
    @Id
    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    @Column(name = "FULL_NAME")
    private String fullName;
}
