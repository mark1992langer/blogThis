package com.simpleTestThis.blogThis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                     .antMatchers("/", "/Nadik").permitAll()
                     .anyRequest().authenticated()
                .and()
                     .formLogin()
                     .loginPage("/login")
                     .permitAll()
                .and()
                     .logout()
                     .permitAll();
        return http.build();
    }


    @Bean

    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("q")
                        .password("3")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }

}

/*
    extends WebSecurityConfigurerAdapter

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/Nadik").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Override




package com.simpleTestThis.blogThis.config;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MvcConfig implements WebMvcConfigurer {

   // public void addViewControllers(ViewControllerRegistry registry) {
   //     registry.addViewController("/login").setViewName("login");
   // }

}
    */

