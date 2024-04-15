package org.example;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       return http
               .csrf(AbstractHttpConfigurer::disable)
               .authorizeHttpRequests(authorizeHttpRequests->
                       authorizeHttpRequests
                               .requestMatchers("/api/v1/**")
                                .hasRole("USER")
                               .requestMatchers("/admin/api/v1/**")
                                .hasRole("ADMIN"))
               .httpBasic(Customizer.withDefaults())
               .formLogin(AbstractHttpConfigurer::disable)
               .build();
    }
    @Bean
    public DataSource dataSource(){
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
                .build();
    }

    @Bean
    public UserDetailsManager users(DataSource dataSource) {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);

        userDetailsManager.createUser(createUserWithName("Тимур"));
        userDetailsManager.createUser(createUserWithName("Петя"));
        userDetailsManager.createUser(createUserWithName("Ваня"));
        userDetailsManager.createUser(createUserWithName("Асим"));
        userDetailsManager.createUser(createUserWithName("Влад"));

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("USER","ADMIN")
                .build();
        userDetailsManager.createUser(admin);
        return userDetailsManager;
    }

    private UserDetails createUserWithName(String name){
        return User.withDefaultPasswordEncoder()
                .username(name)
                .password("password")
                .roles("USER")
                .build();
    }


}
