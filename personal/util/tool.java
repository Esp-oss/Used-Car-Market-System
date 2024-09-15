package com.personal.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class tool {
    
    //转型，将localdate转化为字符串
    public static String formatdate (LocalDate date) {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(date);
        
    }

    //字符串转化为localdate
    public  static  LocalDate parsDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate Id = LocalDate.parse(date,formatter);

        return Id;
    }


}
