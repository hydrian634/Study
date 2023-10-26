package kr.co.rland.web.config.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class RlandSecurityConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{


        http.csrf(csrf->csrf.disable())
                .authorizeHttpRequests(
                        authorize->authorize
                                .requestMatchers("/admin/**")
                                .hasAnyRole("ADMIN")
                                .requestMatchers("/member/**")
                                .hasAnyRole("ADMIN", "MEMBER")
                                .anyRequest().permitAll())
                .formLogin(
                        form->form
                                .loginPage("/user/login"))
//                                .successForwardUrl("/index")
//                                .defaultSuccessUrl("/index"))
                .logout(logout->logout
                        .logoutUrl("/user/logout")  //경로 다르면 404
                        .logoutSuccessUrl("/index"));
        return http.build();
    }

//@Bean
    public UserDetailsService jdbcUserDetailService(){

    JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
    manager.setUsersByUsernameQuery("select user_name username, password, 1 enabled from member where user_name = ?");

//    manager.setAuthoritiesByUsernameQuery("select user_name username, 'ROLE_ADMIN' authority from member where user_name = ?");
    String sqlForAuthorize = "select m.user_name as username, " +
            "r.name as Auth from member_role mr " +
            "left join member m on mr.member_id = m.id " +
            "left join role r on mr.role_id = r.id " +
            "where m.user_name = ?";
    manager.setAuthoritiesByUsernameQuery(sqlForAuthorize);

        return manager;
    }

//@Bean
public UserDetailsService userDetailsService(){
        UserDetails user1 = User
                .builder()
                .username("newlec")
                .password("{noop}111")    //암호화방식을 비밀번호 앞에 써주면 된다. noop는 안쓰겠다라는 의미.
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
