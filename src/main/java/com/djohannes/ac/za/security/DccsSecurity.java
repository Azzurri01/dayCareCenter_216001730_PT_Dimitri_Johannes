package com.djohannes.ac.za.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class DccsSecurity extends WebSecurityConfigurerAdapter {

    private static final String USER_ROLE = "USER";
    private static final String ADMIN_ROLE = "ADMIN";

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("dimitri")
                .password(encoder().encode("cputPTguest"))
                .roles(USER_ROLE)
                .and()
                .withUser("admin")
                .password(encoder().encode("cputPTadmin"))
                .roles(USER_ROLE, ADMIN_ROLE);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                //Colour
                .antMatchers(HttpMethod.POST, "/dccs/**/create/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.POST, "/dccs/**/update/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET, "/dccs/**/delete/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET, "/dccs/**/read/**").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.GET, "/dccs/**/getall").hasRole(USER_ROLE)
                .and()
                .csrf().disable()
                .formLogin().disable();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
