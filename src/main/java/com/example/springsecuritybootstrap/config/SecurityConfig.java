package com.example.springsecuritybootstrap.config;


import com.example.springsecuritybootstrap.service.UserService;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserService userService;
    private final SuccessUserHandler userHandler;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(UserService userService, SuccessUserHandler userHandler, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.userHandler = userHandler;
        this.passwordEncoder = passwordEncoder;
    }

    //Настраиваем аутентификацию
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/error").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                .and()
                .formLogin()
                .loginPage("/")
                .loginProcessingUrl("/process_login")
                .successHandler(userHandler)
                .failureUrl("/?error")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService((UserDetailsService) userService).passwordEncoder(passwordEncoder);
    }


}
