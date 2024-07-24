package com.daku.tech.prototype.v1;

import com.daku.tech.prototype.v1.service.TriggerService;
import com.daku.tech.prototype.v1.service.impl.TriggerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    @Bean
    public TriggerService triggerService() {
        return new TriggerServiceImpl();
    }
}
