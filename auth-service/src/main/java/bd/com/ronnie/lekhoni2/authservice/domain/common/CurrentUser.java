package bd.com.ronnie.lekhoni2.authservice.domain.common;

import bd.com.ronnie.lekhoni2.authservice.config.enumvalue.UserStatus;
import bd.com.ronnie.lekhoni2.authservice.domain.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public CurrentUser(User user) {
        super(user.getEmail(),
                user.getPassword(),
                user.getStatus().equals(UserStatus.ACTIVE),
                true,
                true,
                true,
                //AuthorityUtils.createAuthorityList(user.getAuthorities().toString())
                Arrays.asList(new SimpleGrantedAuthority("USER"), new SimpleGrantedAuthority("ADMIN")) // TODO : dummy role, need to fix it, role might need to move from account to auth
        );
        this.user = user;
    }

    private User getUser() {
        return user;
    }

    private Long getId() {
        return user.getId();
    }

}
