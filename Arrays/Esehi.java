package Arrays;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Esehi {

    public static final String HH_MMA = "hh:mma";

    public static void main(String args[]) {
        System.out.println(convertStringToTime("01:00Pm"));
    }

    public static LocalTime convertStringToTime(String timeString) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(HH_MMA);
            return LocalTime.parse(timeString, formatter);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
