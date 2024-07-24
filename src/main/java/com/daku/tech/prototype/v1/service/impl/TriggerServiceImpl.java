package com.daku.tech.prototype.v1.service.impl;

import com.daku.tech.prototype.v1.dto.ReadingResponse;
import com.daku.tech.prototype.v1.service.TriggerService;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TriggerServiceImpl implements TriggerService {
    private static final String FILE_PATH = "../output.txt";
    private int lat;
    private int lng;
    private int moistureFlag;

    @Scheduled(fixedRate = 1000)
    public ReadingResponse checkDeviceReadings() {
        ReadingResponse response = new ReadingResponse();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line = reader.readLine();
            if (line != null) {
                String[] numbers = line.split(",");
                if (numbers.length == 3) {
                    lat = Integer.parseInt(numbers[0].trim());
                    lng = Integer.parseInt(numbers[1].trim());
                    moistureFlag = Integer.parseInt(numbers[2].trim());
                }
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
