package com.luv2code.ecommerce;

import com.luv2code.ecommerce.config.JwtAuthenticationEntryPoint;
import com.luv2code.ecommerce.config.JwtTokenFilter;
import com.luv2code.ecommerce.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Autowired
    JwtAuthenticationEntryPoint authenticationEntryPoint;
    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Bean
    public JwtTokenFilter jwtTokenFilter(){
        return new JwtTokenFilter();
    }
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // We don't need CSRF for this example
        httpSecurity.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().antMatchers("/auth/**").permitAll()
                .antMatchers(HttpMethod.GET, "/**").permitAll()
                .anyRequest().authenticated();

        httpSecurity.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}