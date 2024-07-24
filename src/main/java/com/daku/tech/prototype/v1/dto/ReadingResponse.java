package com.daku.tech.prototype.v1.dto;

import lombok.Data;

@Data
public class ReadingResponse {
    int lat;
    int lng;
    int moistureFlag;
}
