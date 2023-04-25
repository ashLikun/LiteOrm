package com.ashlikun.orm.convert;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 作者　　: 李坤
 * 创建时间: 2023/4/25　16:17
 * 邮箱　　：496546144@qq.com
 * <p>
 * 功能介绍：
 */
public class DefaultConvert {
    public static SimpleDateFormat defaultDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

    public static class DefaultDataConvert implements OnFiledConvertCall<Date, String> {
        @Override
        public Date set(Field field, String value) {
            try {
                return defaultDateFormat.parse(value);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        public String bind(Date value) {
            return defaultDateFormat.format(value);
        }
    }

    public static class DefaultCalendarConvertConvert implements OnFiledConvertCall<Calendar, String> {
        @Override
        public Calendar set(Field field, String value) {
            try {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(defaultDateFormat.parse(value));
                return calendar;
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        public String bind(Calendar value) {
            return defaultDateFormat.format(value.getTime());
        }
    }
}
