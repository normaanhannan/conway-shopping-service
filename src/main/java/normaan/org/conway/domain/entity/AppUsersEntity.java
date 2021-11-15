package normaan.org.conway.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "APP_USERS")
@Data
public class AppUsersEntity {
    @Column(name = "USER_ID")
    @Id
    private Long userId;
    @Column(name = "USERNAME")
    private String userName;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "ACTIVE")
    private String active;
    @Column(name = "ACCOUNT_EXPIRED")
    private String accountExpired;
    @Column(name = "ACCOUNT_LOCKED")
    private String accountLocked;
    @Column(name = "CREDENTIALS_EXPIRED")
    private String credentialExpired;
    @Column(name = "ROLES")
    private String roles;
    @Column(name = "CUSTOMER_ID")
    private Long customerId;
}
