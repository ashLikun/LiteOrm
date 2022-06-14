package com.ashlikun.orm;


import android.app.Application;

import com.ashlikun.orm.db.DataBaseConfig;


public class LiteOrmUtil {
    private static LiteOrm liteOrm;
    private static LiteOrm liteOrmCascade;
    private static Application app;
    private static boolean isDebug = true;
    private static int versionCode = 1;
    private static String sdDbPath;
    private static DataBaseConfig config;

    /**
     * 作者　　: 李坤
     * 创建时间: 2017/8/7 10:29
     * 邮箱　　：496546144@qq.com
     * <p>
     * 方法功能：一定要在Application里面调用
     */

    public static void init(Application app) {
        LiteOrmUtil.app = app;
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
