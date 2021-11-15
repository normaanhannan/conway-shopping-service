package normaan.org.conway.service.security;

import normaan.org.conway.domain.entity.AppUsersEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class JdbcAuthUserDetail implements UserDetails {

    private AppUsersEntity entity;

    public JdbcAuthUserDetail(AppUsersEntity entity) {
        this.entity = entity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return null;
    }

    @Override
    public String getPassword() {
        return entity.getPassword();
    }

    @Override
    public String getUsername() {
        return entity.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return entity.getAccountExpired().equalsIgnoreCase("N");
    }

    @Override
    public boolean isAccountNonLocked() {
        return entity.getAccountLocked().equalsIgnoreCase("N");
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return entity.getCredentialExpired().equalsIgnoreCase("N");
    }

    @Override
    public boolean isEnabled() {
        return entity.getActive().equalsIgnoreCase("Y");
    }
}
