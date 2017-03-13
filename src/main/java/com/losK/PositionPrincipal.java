package com.losK;

import java.security.Principal;

/**
 * Created by m.losK on 2017-03-10.
 */
public class PositionPrincipal implements Principal {

    private String name;

    public PositionPrincipal(String name) {
        super();
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
