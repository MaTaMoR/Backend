package me.matamor.backend.auth;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationManagerProvider implements SmartInitializingSingleton {

    private final AuthenticationManagerBuilder authMgrBuilder;

    private AuthenticationManager authenticationManager;

    public AuthenticationManagerProvider(AuthenticationManagerBuilder authMgrBuilder) {
        this.authMgrBuilder = authMgrBuilder;
    }

    @Override
    public void afterSingletonsInstantiated() {
        this.authenticationManager = authMgrBuilder.getObject();
    }

    public AuthenticationManager authenticationManager() {
        return this.authenticationManager;
    }
}