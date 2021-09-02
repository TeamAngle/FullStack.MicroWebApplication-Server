//package com.example.demo.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class MainConfig {
//
//    @Value("${CLEARDB_DATABASE_URL}")
//    private String db_url;
//
//    @Value("${CLEARDB_DATABASE_USERNAME}")
//    private String username;
//
//    @Value("{CLEARDB_DATABASE_PASSWORD}")
//    private String password;
//
//    @Bean
//    public DataSource getDataSource() {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.url(db_url);
//        dataSourceBuilder.username(username);
//        dataSourceBuilder.password(password);
//        return dataSourceBuilder.build();
//    }
//}
