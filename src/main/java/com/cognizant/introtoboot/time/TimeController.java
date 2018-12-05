package com.cognizant.introtoboot.time;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import java.util.OptionalInt;

@RestController
@RequestMapping("/")
public class TimeController {

    String MORNING_SUFFIX = " in the morning";
    String NOON_SUFFIX = " in the afternoon";
    String EVENING_SUFFIX = " in the evening";


    @GetMapping(value = {"/time-to-text/{time}"})
    String getTimeToText(@PathVariable("time") final String timeToConvert) {

        String times = "";
        String parsedTime = "";

        LocalTime timeToParse = LocalTime.now();

        try {
            timeToParse = LocalTime.parse(timeToConvert);
        } catch (DateTimeParseException ex) {
            return "Incorrect time format supplied!";
        }

        int hourOfTheTime = timeToParse.getHour();
        int minsOfTheTime = timeToParse.getMinute()
        //Noon
        if (12 == hourOfTheTime) {
            parsedTime = "It's noon";
        }

        //Midnight
        if (0 == hourOfTheTime) {
            parsedTime = "It's midnight";
        }

        return parsedTime;
    }








}
