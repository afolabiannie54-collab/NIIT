package net_banking_api.banking_api.banking.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.url}")
    private String jdbcUrl;

    @Value("${spring.datasource.username}")
    private String dbUser;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Value("${spring.datasource.driver-class-name:org.postgresql.Driver}")
    private String driverClassName;

    @Bean
    public DataSource dataSource() throws Exception {
        // Parse jdbcUrl like: jdbc:postgresql://host:port/dbname
        String url = jdbcUrl;
        if (!url.startsWith("jdbc:postgresql://")) {
            // return default HikariDataSource if not Postgres
            HikariDataSource ds = new HikariDataSource();
            ds.setJdbcUrl(jdbcUrl);
            ds.setUsername(dbUser);
            ds.setPassword(dbPassword);
            ds.setDriverClassName(driverClassName);
            return ds;
        }

        String withoutPrefix = url.substring("jdbc:postgresql://".length());
        String[] parts = withoutPrefix.split("/", 2);
        String hostPart = parts[0];
        String dbName = parts.length > 1 ? parts[1] : "postgres";

        String host;
        String port = "5432";
        if (hostPart.contains(":")) {
            String[] hp = hostPart.split(":");
            host = hp[0];
            port = hp[1];
        } else {
            host = hostPart;
        }

        // Connect to the default 'postgres' database to create DB if missing
        String adminUrl = String.format("jdbc:postgresql://%s:%s/postgres", host, port);

        try (Connection c = DriverManager.getConnection(adminUrl, dbUser, dbPassword)) {
            String checkSql = "SELECT 1 FROM pg_database WHERE datname = ?";
            try (PreparedStatement ps = c.prepareStatement(checkSql)) {
                ps.setString(1, dbName);
                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next()) {
                        String createSql = String.format("CREATE DATABASE \"%s\"", dbName);
                        try (PreparedStatement create = c.prepareStatement(createSql)) {
                            create.execute();
                        }
                    }
                }
            }
        }

        // Now return a HikariDataSource pointing at the target DB
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(jdbcUrl);
        ds.setUsername(dbUser);
        ds.setPassword(dbPassword);
        ds.setDriverClassName(driverClassName);
        return ds;
    }
}
