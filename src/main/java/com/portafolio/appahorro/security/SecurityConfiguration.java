package com.portafolio.appahorro.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserPrincipalDetailService userPrincipalDetailService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth){
        auth.authenticationProvider(authenticationProvider());


                /*
                // throws Exception
                .inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder().encode("123"))
                .authorities("ACCESS_TEST2","ROLE_ADMIN")

                .and()

                .withUser("dan").password(passwordEncoder().encode("123"))
                .roles("USER");
                */

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/v1/test1").permitAll()
                .antMatchers("/").authenticated()
                .antMatchers("/user/**").hasRole("ADMIN")
                .antMatchers("/operation/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/api/v1/test2").hasAuthority("ACCESS_TEST2")
                .antMatchers("/api/v1/users").hasRole("ADMIN")
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .and()
                .rememberMe().tokenValiditySeconds(60*60*24).rememberMeParameter("checkRememberMe")
                .alwaysRemember(true).useSecureCookie(true).rememberMeCookieName("rememberme");
    }




    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider d = new DaoAuthenticationProvider();
        d.setPasswordEncoder(passwordEncoder());
        d.setUserDetailsService(userPrincipalDetailService);
        return d;
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
