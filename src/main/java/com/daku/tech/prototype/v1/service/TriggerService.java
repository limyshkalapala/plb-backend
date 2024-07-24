package com.daku.tech.prototype.v1.service;

import com.daku.tech.prototype.v1.dto.ReadingResponse;
import org.springframework.stereotype.Service;

@Service
public interface TriggerService {
    ReadingResponse checkDeviceReadings();
}
