package com.losK;

import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by m.losK on 2017-03-10.
 */
public class MyLoginModule implements LoginModule {

    private Subject subject;
    private CallbackHandler callbackHandler;
    private UserPrincipal userPrincipal;
    private PositionPrincipal positionPrincipal;
    private String login;
    private List<String> userGroups;


    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options) {
        this.callbackHandler = callbackHandler;
        this.subject = subject;
    }

    @Override
    public boolean login() throws LoginException {
        Callback[] callbacks = new Callback[2];
        callbacks[0] = new NameCallback("login");
        callbacks[1] = new PasswordCallback("password", true);

        try {
            this.callbackHandler.handle(callbacks);
            String login = ((NameCallback) callbacks[0]).getName();
            String password = String.valueOf(((PasswordCallback) callbacks[1]).getPassword());

            //Here we validate the login process.
            //In this case (instead of, for example, data base connecting) we hard coded login and password as below

            if (login != null && login.equals("user1234") &&
                    password != null && password.equals("password1234")) {
                this.login = login;
                this.userGroups = new ArrayList<String>();
                userGroups.add("admin");
                return true;
            }

            //If login process failed we throw a LoginException
            throw new LoginException("Authentication failed");


        } catch (IOException e) {
            throw new LoginException(e.getMessage());
        } catch (UnsupportedCallbackException e) {
            throw new LoginException(e.getMessage());
        }
    }

    @Override
    public boolean commit() throws LoginException {
        this.userPrincipal = new UserPrincipal(this.login);
        this.subject.getPrincipals().add(userPrincipal);

        if (userGroups != null && userGroups.size() > 0) {
            for (String groupName : userGroups) {
                this.positionPrincipal = new PositionPrincipal(groupName);
                this.subject.getPrincipals().add(positionPrincipal);
            }
        }
        return true;
    }

    @Override
    public boolean abort() throws LoginException {
        return false;
    }

    @Override
    public boolean logout() throws LoginException {
        subject.getPrincipals().remove(userPrincipal);
        subject.getPrincipals().remove(positionPrincipal);
        return true;
    }
}
