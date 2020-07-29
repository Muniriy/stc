package ru.makhmutov.task1;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ReadingJSON {
    private static final Logger log = LogManager.getLogger(ReadingJSON.class);

    /**
     * The entry point of ReadingJSON program.
     * This program allows to deserialize information
     * about the weather from 7timer.info and get
     * the average temperature for 3 days
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        getAvgTempFor3Days();
    }

    /**
     * This method allows to read JSON from 7timer.info API
     * and calculate the average temperature for each of 3 days
     * given in the input
     */
    private static void getAvgTempFor3Days() {
        try {
            URL jsonUrl = new URL("http://www.7timer.info/bin/api.pl?lon=113.17&lat=23.09&product=astro&output=json");
            ObjectMapper objectMapper = new ObjectMapper();
            Response response = objectMapper.readValue(jsonUrl, Response.class);
            float[] avgTemp = new float[3];
            int seriesAmount = response.getDataseries().length;
            for (int curSeries = 0; curSeries < seriesAmount; curSeries++) {
                int day;
                if (curSeries <= 7) {
                    day = 0;
                } else if (curSeries <= 14) {
                    day = 1;
                } else {
                    day = 2;
                }
                avgTemp[day] += response.getDataseries()[curSeries].getTemp2m();
            }
            for (int day = 0; day < avgTemp.length; day++) {
                avgTemp[day] /= 8;
                String msg = String.format("Day %d average temperature is %.1f\u2103", day + 1, avgTemp[day]);
                log.info(msg);
            }
        } catch (JsonParseException e) {
            log.error(e.getMessage());
        } catch (MalformedURLException e) {
            log.error(e.getMessage());
        } catch (JsonMappingException e) {
            log.error(e.getMessage());
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
