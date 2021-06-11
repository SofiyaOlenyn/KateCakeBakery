package com.university.confectionary.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.university.confectionary.repositories.UserRepository;
import com.university.confectionary.service.MyUserDetailsService;
import com.university.confectionary.utils.JwtTokenGenerator;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.session.SessionManagementFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import static org.springframework.http.HttpMethod.POST;

@RequiredArgsConstructor
@Configuration
@EnableGlobalMethodSecurity(jsr250Enabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;
    private final JwtTokenGenerator jwtTokenGenerator;

    @Bean
    CorsFilter corsFilter() {
        CorsFilter filter = new CorsFilter();
        return filter;
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
                .antMatchers("/order").authenticated()
                .antMatchers(HttpMethod.DELETE, "/product/**").authenticated()
                .antMatchers(HttpMethod.PATCH, "/product").authenticated()
                .antMatchers(POST, "/product").authenticated()
                .anyRequest().permitAll()
            .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
                .addFilterBefore(corsFilter(), SessionManagementFilter.class); //adds your custom CorsFilter
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new MyUserDetailsService(userRepository);
    }

    @Bean
    @SneakyThrows
    @Override
    public AuthenticationManager authenticationManagerBean() {
        return super.authenticationManagerBean();
    }


}
