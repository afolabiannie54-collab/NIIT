package net_banking_api.banking_api.banking.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
@EnableConfigurationProperties(VaultConfiguration.class)

public class DbConfiguration {
    @Value("${spring.datasource.url}")
    private String postgresurl;
    @Value("${spring.datasource.driver-class-name}")
    private String postgresDriver;

    private DataSourceBuilder dataSourceBuilder;

    private final VaultConfiguration vaultConfiguration;

    public DbConfiguration(VaultConfiguration vaultConfiguration) {
        this.vaultConfiguration = vaultConfiguration;
    }

    @Bean
    public DataSource getDataSource() {

        dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(postgresDriver);
        dataSourceBuilder.url(postgresurl);
        dataSourceBuilder.username(vaultConfiguration.getPostgresusername());
        dataSourceBuilder.password(vaultConfiguration.getPostgrespassword());
        return dataSourceBuilder.build();
    }
}

