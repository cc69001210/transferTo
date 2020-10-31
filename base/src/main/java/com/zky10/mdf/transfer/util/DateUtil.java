package com.zky10.mdf.transfer.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @company: 北京一零科技
 * @program: transfer
 * @author: cc
 * @Date: 2020-10-30 13:51
 * @Description:
 */
public class DateUtil {

    public static String getDateStr(LocalDate localDate, String pattern) {
        return localDate.format(DateTimeFormatter.ofPattern(pattern));
    }
}
