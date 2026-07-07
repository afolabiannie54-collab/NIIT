package net_banking_api.banking_api.banking.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties
public class VaultConfiguration {
private String postgresusername;
private String postgrespassword;
}
