package com.bank.bankAM.security;

import com.bank.bankAM.filter.CustomAuthenticationFilter;
import com.bank.bankAM.filter.CustomAuthorisationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration @EnableWebSecurity @RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private  final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs/**");
        web.ignoring().antMatchers("/swagger.json");
        web.ignoring().antMatchers("/swagger-ui.html");
        web.ignoring().antMatchers("/swagger-resources/**");
        web.ignoring().antMatchers("/webjars/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
        customAuthenticationFilter.setFilterProcessesUrl("/api/login");

        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        //http.authorizeRequests().antMatchers("/swagger-ui.html/**").permitAll();

        http.authorizeRequests().antMatchers("/api/login/**","/api/user/changePassword","/v2/api-docs/**", "/swagger-resources/configuration/ui/**", "/swagger-resources", "/swagger-resources/configuration/security", "/swagger-ui.html", "/webjars/").permitAll();

        http.authorizeRequests().antMatchers(GET,"/api/users/**").hasAnyAuthority("DSS");
        //http.authorizeRequests().antMatchers(POST,"/api/users/**").permitAll();
        //http.authorizeRequests().antMatchers("GET","/api/user/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorisationFilter(),UsernamePasswordAuthenticationFilter.class);

    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean()throws Exception{
        return  super.authenticationManagerBean();
    }

}
