package com.daku.tech.prototype.v1.service.impl;

import com.daku.tech.prototype.v1.dto.ReadingResponse;
import com.daku.tech.prototype.v1.service.TriggerService;
import lombok.extern.log4j.Log4j2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Log4j2
public class TriggerServiceImpl implements TriggerService {
    private static final String FILE_PATH = "../output.txt";
    private double lat;
    private double lng;
    private int moistureFlag;

    public ReadingResponse checkDeviceReadings() {
        ReadingResponse response = new ReadingResponse();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line = reader.readLine();
            if (line != null) {
                String[] numbers = line.split(",");
                if (numbers.length == 3) {
                    lat = Double.parseDouble(numbers[0].trim());
                    lng = Double.parseDouble(numbers[1].trim());
                    moistureFlag = Integer.parseInt(numbers[2].trim());
                }
                log.info("device readings for lat, lng, moisture {},{},{}",lat,lng,moistureFlag);
                response.setLat(lat);
                response.setLng(lng);
                response.setMoistureFlag(moistureFlag);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

}
