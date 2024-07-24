package com.daku.tech.prototype.v1.web;

import com.daku.tech.prototype.v1.dto.ReadingResponse;
import com.daku.tech.prototype.v1.service.TriggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TriggerController {

    @Autowired
    TriggerService triggerService;

    @GetMapping("/deviceReadings")
    public ReadingResponse greet() {
        return triggerService.checkDeviceReadings() ;
    }

}