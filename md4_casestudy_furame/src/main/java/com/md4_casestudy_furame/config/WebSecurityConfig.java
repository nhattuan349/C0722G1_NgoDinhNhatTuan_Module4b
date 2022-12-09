package com.md4_casestudy_furame.config;


import com.md4_casestudy_furame.service.impl.MyUserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailServiceImpl userDetailService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService)
                .passwordEncoder(passwordEncoder());
    }




    //    Cấu hình về xác thực  HTTP Basic và phân quyền
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/").permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/home").permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/user/show-form-create").permitAll()
                .antMatchers("/create").hasRole("ADMIN")
                .antMatchers("/edit/**").hasRole("ADMIN")
                .antMatchers("/delete/**").hasRole("ADMIN")
                .anyRequest().authenticated();
        http.authorizeRequests().and().rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(1*24*60*60);

    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        InMemoryTokenRepositoryImpl inMemoryTokenRepository = new InMemoryTokenRepositoryImpl();
        return inMemoryTokenRepository;
    }


}
