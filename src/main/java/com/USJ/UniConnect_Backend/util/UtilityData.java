package com.USJ.UniConnect_Backend.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

public class UtilityData {

    public static String generateuserId() {
        return "B/" + UUID.randomUUID();
    }

    // Updated to return java.util.Date
   /* public static Date generateTodayDate() {
        LocalDate localDate = LocalDate.now();
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }*/
}
