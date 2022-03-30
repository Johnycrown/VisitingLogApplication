package org.challenge.termiVistingApplication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    RDBUserDetailsServiceImpl rdbUserDetailsService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                    .authorizeHttpRequests()
                     .antMatchers(HttpMethod.POST, "api/visitor").permitAll()
                     .antMatchers(HttpMethod.POST, "api/staff").permitAll()
                     .antMatchers(HttpMethod.POST, "api/visit").permitAll()
                     .anyRequest()
                      .authenticated()
                       .and()
                        .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                        .addFilter(new JWTAthorizationFilter(authenticationManager()))
                        .exceptionHandling()
                       .and()
                       .sessionManagement()
                       .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        //super.configure(http);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(rdbUserDetailsService)
                                .passwordEncoder(passwordEncoder());
    }


     @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
}
}


