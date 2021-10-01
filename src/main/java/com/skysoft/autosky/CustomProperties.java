package com.skysoft.autosky;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "com.skysoft.autosky")
public class CustomProperties{

    private String apiUrl;
}
