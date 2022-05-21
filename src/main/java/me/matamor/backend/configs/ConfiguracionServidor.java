package me.matamor.backend.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ConfigurationProperties(prefix = "config")
@PropertySource("classpath:./configuracion.properties")
public class ConfiguracionServidor {

    public String storageDir = "upload-dir";
    public int pageSize = 10;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
