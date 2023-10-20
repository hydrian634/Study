package kr.co.rland.web.auth.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class RlandSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{


        http.csrf(csrf->csrf.disable())
                .authorizeHttpRequests(
                        authorize->authorize
                                .requestMatchers("member/**")
                                .hasAnyRole("ADMIN", "MEMBER")
                                .anyRequest().permitAll())
                .formLogin(
                        form->form
                                .loginPage("/user/login"));
        return http.build();
    }

@Bean
public UserDetailsService userDetailsService(){
        UserDetails user1 = User
                .builder()
                .username("newlec")
                .password("111")
                .roles("MEMBER", "ADMIN")
                .build();
    UserDetails user2 = User
            .builder()
            .username("dragon")
            .password("111")
            .roles("MEMBER")
            .build();

    return new InMemoryUserDetailsManager(user1, user2);
}
}
