package com.ashlikun.orm;


import android.app.Application;

import com.ashlikun.orm.convert.DefaultConvert;
import com.ashlikun.orm.convert.OnFiledConvertCall;
import com.ashlikun.orm.db.DataBaseConfig;
import com.ashlikun.orm.db.annotation.NotNull;

import java.util.Calendar;
import java.util.Date;


public class LiteOrmUtil {
    private static LiteOrm liteOrm;
    private static LiteOrm liteOrmCascade;
    private static Application app;
    private static boolean isDebug = true;
    private static int versionCode = 1;
    private static String sdDbPath;
    private static DataBaseConfig config;

    @NotNull
    public static OnFiledConvertCall<Date, String> dateConvert = new DefaultConvert.DefaultDataConvert();
    @NotNull
    public static OnFiledConvertCall<Calendar, String> calendarConvert = new DefaultConvert.DefaultCalendarConvertConvert();

    /**
     * 一定要在Application里面调用
     */

    public static void init(Application app, boolean isDebug) {
        LiteOrmUtil.app = app;
        try {
            LiteOrmUtil.versionCode = app.getPackageManager().getPackageInfo(app.getPackageName(), 0).versionCode;
        } catch (Exception e) {
        }
        LiteOrmUtil.isDebug = isDebug;
        liteOrm = null;
    }

    public static void setIsDebug(boolean isDebug) {
        LiteOrmUtil.isDebug = isDebug;
        liteOrm = null;
    }

    public static void setVersionCode(int versionCode) {
        LiteOrmUtil.versionCode = versionCode;
        liteOrm = null;
    }

    public static void setSdDbPath(String sdDbPath) {
        LiteOrmUtil.sdDbPath = sdDbPath;
        liteOrm = null;
    }

    public static void setConfig(DataBaseConfig config) {
        LiteOrmUtil.config = config;
        liteOrm = null;
    }

    /**
     * 清空单例
     */
    public static void cleanSing() {
        liteOrm = null;
    }

    public static Application getApp() {
        if (app == null) {
            throw new RuntimeException("请在Application调用Utils的init方法");
        } else {
            return app;
        }
    }

    public static boolean isDebug() {
        return isDebug;
    }

    public static int versionCode() {
        return versionCode;
    }

    private LiteOrmUtil() {
    }

    public static DataBaseConfig getConfig() {
        if (config == null) {
            config = new DataBaseConfig(getApp());
            config.debugged = isDebug();
            config.dbVersion = versionCode();
            config.onUpdateListener = null;
            config.sdDbPath = sdDbPath;
            return config;
        }
        return config;
    }

    /**
     * 单表
     */
    public static LiteOrm get() {
        if (liteOrm == null) {
            synchronized (LiteOrmUtil.class) {
                if (liteOrm == null) {
                    liteOrm = LiteOrm.newSingleInstance(getConfig());
                }
            }
        }
        return liteOrm;
    }

    /**
     * 多表关联
     */
    public static LiteOrm getCascade() {
        if (liteOrmCascade == null) {
            synchronized (LiteOrmUtil.class) {
                if (liteOrmCascade == null) {
                    liteOrmCascade = LiteOrm.newCascadeInstance(getConfig());
                }
            }
        }
        return liteOrmCascade;
    }
}
