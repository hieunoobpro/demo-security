package com.example.demosecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        String[] patterns = {"/ccc", "/aaa/**", "/bbb/**"};
        http.authorizeRequests(authorize -> authorize
                .requestMatchers("/").permitAll()
                .requestMatchers("/css/**", "/js/**").permitAll()
                .requestMatchers(patterns).permitAll()
                //1. Xem dashboard - ADMIN, SALE
                .requestMatchers("/dashboard").hasAnyRole("ADMIN","USER")
                //8. Xem thông tin cá nhân, thay đổi thông tin cá nhân USER
                .requestMatchers("/profile", "/api/users/**").hasRole("USER")
                //2. Quản lý user (CRU) - ADMIN
                .requestMatchers("/admin").hasAuthority("ADMIN")
                //3. Quản lý category (CRUD) ADMIN, SALE
                .requestMatchers("/categoríe").hasAnyAuthority("ADMIN", "SALE")
                //4. Quản lý sản phẩm (CRUD) ADMIN, SALE
                .requestMatchers("/product").hasAnyAuthority("ADMIN", "SALE")
                //5. Quản lý brand (CRUD) ADMIN, SALE
                .requestMatchers("/brands").hasAnyAuthority("ADMIN", "SALE")
                //6. Quản lý order (CRU) ADMIN, SALE
                .requestMatchers("/order").hasAnyAuthority("ADMIN", "SALE")
                //7. Quản lý bài viết (CRUD) ADMIN, SALE, AUTHOR
                .requestMatchers("/post").hasAnyAuthority("ADMIN", "SALE","AUTHOR")
        );
        http.formLogin(login -> login
                .defaultSuccessUrl("/", true)
                .permitAll()
        );
        http.logout(logout -> logout
                .logoutSuccessUrl("/")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .permitAll()
        );
        return http.build();
    }
}
