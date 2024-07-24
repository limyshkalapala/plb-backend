package com.daku.tech.prototype.v1.dto;

import lombok.Data;

@Data
public class ReadingResponse {
    double lat;
    double lng;
    int moistureFlag;
}
