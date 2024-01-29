package weather.forecast.frontend.utils;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class Utils {

    public String isDayOrNight(LocalTime currentTime){
        LocalTime startOfDay = LocalTime.of(6, 0);
        LocalTime endOfDay = LocalTime.of(18, 0);
        if (isDaytime(currentTime, startOfDay, endOfDay)) {
            return "Day";
        } else {
            return "Night";
        }
    }
    private boolean isDaytime(LocalTime currentTime, LocalTime startOfDay, LocalTime endOfDay) {
        return currentTime.isAfter(startOfDay) && currentTime.isBefore(endOfDay);
    }

    public String formatDate(Date date ){
        SimpleDateFormat sdf = new SimpleDateFormat("d MMM");
        return sdf.format(date);
    }
    public String getDayFromDate(Date currentDate){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        return new SimpleDateFormat("EEEE").format(currentDate);
    }
}
