package practice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class B05 {
    public static void main(String[] args) {
        //yyyy-MM-dd HH:mm:ss
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(localDateTime.format(dateTimeFormatter));
    }
}
