package normaan.org.conway.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "PRODUCTS", schema = "CO")
@Data
public class ProductsEntity {

    @Id
    @Column(name = "PRODUCT_ID")
    private long productId;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "UNIT_PRICE")
    private double unitPrice;

    @Column(name = "PRODUCT_DETAILS")
    private byte[] productDetails;

    @Column(name = "PRODUCT_IMAGE")
    private byte[] productImage;

    @Column(name = "IMAGE_MIME_TYPE")
    private String imageMimeType;

    @Column(name = "IMAGE_FILENAME")
    private String imageFileName;

    @Column(name = "IMAGE_CHARSET")
    private String imageCharSet;

    @Column(name = "IMAGE_LAST_UPDATED")
    private LocalDateTime imageLastUpdated;

}
