package com.losK;

import java.security.Principal;

/**
 * Created by m.losK on 2017-03-10.
 */
public class UserPrincipal implements Principal {

    private String firstName;

    public UserPrincipal(String firstName) {
        super();
        this.firstName = firstName;
    }

    @Override
    public String getName() {
        return firstName;
    }
}
