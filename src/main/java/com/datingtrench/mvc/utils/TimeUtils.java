package com.datingtrench.mvc.utils;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by elvis on 2/14/14.
 */

@Component
public class TimeUtils {

    public List<Integer> years() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        List<Integer> years = new ArrayList<Integer>();
        int currentYear = calendar.get(Calendar.YEAR);
        for (int i = currentYear; i > 1900; i--) {
            years.add(i);
        }
        return years;
    }

}
