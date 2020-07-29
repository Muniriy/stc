package ru.makhmutov.task1;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ReadingJson {
    private static final Logger log = LogManager.getLogger(ReadingJson.class);

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

    /*
    { "product" : "astro" ,
    "init" : "2020072906" ,
    "dataseries" :
    [ { "timepoint" : 3, "cloudcover" : 9, "seeing" : 6, "transparency" : 3, "lifted_index" : -1, "rh2m" : 2, "wind10m" : { "direction" : "NE", "speed" : 2 }, "temp2m" : 38, "prec_type" : "none" },
    { "timepoint" : 6, "cloudcover" : 9, "seeing" : 6, "transparency" : 3, "lifted_index" : -6, "rh2m" : 6, "wind10m" : { "direction" : "SE", "speed" : 3 }, "temp2m" : 35, "prec_type" : "rain" }, { "timepoint" : 9, "cloudcover" : 3, "seeing" : 6, "transparency" : 3, "lifted_index" : -1, "rh2m" : 6, "wind10m" : { "direction" : "S", "speed" : 3 }, "temp2m" : 34, "prec_type" : "rain" }, { "timepoint" : 12, "cloudcover" : 6, "seeing" : 6, "transparency" : 3, "lifted_index" : -4, "rh2m" : 7, "wind10m" : { "direction" : "SE", "speed" : 3 }, "temp2m" : 32, "prec_type" : "rain" }, { "timepoint" : 15, "cloudcover" : 9, "seeing" : 6, "transparency" : 3, "lifted_index" : -1, "rh2m" : 7, "wind10m" : { "direction" : "SE", "speed" : 2 }, "temp2m" : 31, "prec_type" : "rain" }, { "timepoint" : 18, "cloudcover" : 7, "seeing" : 6, "transparency" : 3, "lifted_index" : -1, "rh2m" : 6, "wind10m" : { "direction" : "E", "speed" : 2 }, "temp2m" : 32, "prec_type" : "rain" }, { "timepoint" : 21, "cloudcover" : 5, "seeing" : 6, "transparency" : 3, "lifted_index" : -1, "rh2m" : 3, "wind10m" : { "direction" : "E", "speed" : 2 }, "temp2m" : 36, "prec_type" : "rain" }, { "timepoint" : 24, "cloudcover" : 7, "seeing" : 6, "transparency" : 3, "lifted_index" : -1, "rh2m" : 2, "wind10m" : { "direction" : "E", "speed" : 2 }, "temp2m" : 37, "prec_type" : "rain" }, { "timepoint" : 27, "cloudcover" : 9, "seeing" : 6, "transparency" : 3, "lifted_index" : -1, "rh2m" : 3, "wind10m" : { "direction" : "E", "speed" : 3 }, "temp2m" : 37, "prec_type" : "rain" }, { "timepoint" : 30, "cloudcover" : 9, "seeing" : 6, "transparency" : 3, "lifted_index" : -1, "rh2m" : 4, "wind10m" : { "direction" : "E", "speed" : 3 }, "temp2m" : 36, "prec_type" : "rain" }, { "timepoint" : 33, "cloudcover" : 8, "seeing" : 6, "transparency" : 3, "lifted_index" : -1, "rh2m" : 5, "wind10m" : { "direction" : "SE", "speed" : 3 }, "temp2m" : 33, "prec_type" : "none" }, { "timepoint" : 36, "cloudcover" : 8, "seeing" : 6, "transparency" : 3, "lifted_index" : -1, "rh2m" : 5, "wind10m" : { "direction" : "SE", "speed" : 2 }, "temp2m" : 32, "prec_type" : "none" }, { "timepoint" : 39, "cloudcover" : 9, "seeing" : 6, "transparency" : 3, "lifted_index" : -1, "rh2m" : 6, "wind10m" : { "direction" : "NE", "speed" : 2 }, "temp2m" : 31, "prec_type" : "none" }, { "timepoint" : 42, "cloudcover" : 8, "seeing" : 6, "transparency" : 3, "lifted_index" : -1, "rh2m" : 5, "wind10m" : { "direction" : "NE", "speed" : 2 }, "temp2m" : 32, "prec_type" : "none" }, { "timepoint" : 45, "cloudcover" : 6, "seeing" : 6, "transparency" : 3, "lifted_index" : -1, "rh2m" : 4, "wind10m" : { "direction" : "E", "speed" : 3 }, "temp2m" : 36, "prec_type" : "none" }, { "timepoint" : 48, "cloudcover" : 7, "seeing" : 6, "transparency" : 3, "lifted_index" : -4, "rh2m" : 3, "wind10m" : { "direction" : "E", "speed" : 3 }, "temp2m" : 37, "prec_type" : "none" }, { "timepoint" : 51, "cloudcover" : 9, "seeing" : 6, "transparency" : 3, "lifted_index" : -1, "rh2m" : 3, "wind10m" : { "direction" : "E", "speed" : 3 }, "temp2m" : 36, "prec_type" : "none" }, { "timepoint" : 54, "cloudcover" : 8, "seeing" : 6, "transparency" : 3, "lifted_index" : -1, "rh2m" : 4, "wind10m" : { "direction" : "E", "speed" : 3 }, "temp2m" : 34, "prec_type" : "rain" }, { "timepoint" : 57, "cloudcover" : 8, "seeing" : 6, "transparency" : 3, "lifted_index" : -1, "rh2m" : 6, "wind10m" : { "direction" : "E", "speed" : 3 }, "temp2m" : 32, "prec_type" : "rain" }, { "timepoint" : 60, "cloudcover" : 8, "seeing" : 6, "transparency" : 3, "lifted_index" : -1, "rh2m" : 7, "wind10m" : { "direction" : "E", "speed" : 3 }, "temp2m" : 30, "prec_type" : "rain" }, { "timepoint" : 63, "cloudcover" : 7, "seeing" : 6, "transparency" : 4, "lifted_index" : -1, "rh2m" : 8, "wind10m" : { "direction" : "E", "speed" : 3 }, "temp2m" : 30, "prec_type" : "rain" }, { "timepoint" : 66, "cloudcover" : 6, "seeing" : 6, "transparency" : 4, "lifted_index" : -1, "rh2m" : 8, "wind10m" : { "direction" : "E", "speed" : 3 }, "temp2m" : 30, "prec_type" : "rain" }, { "timepoint" : 69, "cloudcover" : 9, "seeing" : 6, "transparency" : 3, "lifted_index" : -1, "rh2m" : 7, "wind10m" : { "direction" : "E", "speed" : 3 }, "temp2m" : 33, "prec_type" : "rain" }, { "timepoint" : 72, "cloudcover" : 9, "seeing" : 6, "transparency" : 3, "lifted_index" : -1, "rh2m" : 5, "wind10m" : { "direction" : "E", "speed" : 3 }, "temp2m" : 34, "prec_type" : "rain" } ] }
     */

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
