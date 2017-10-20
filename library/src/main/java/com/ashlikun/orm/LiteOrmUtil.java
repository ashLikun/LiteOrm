package com.ashlikun.orm;


import android.app.Application;

import com.ashlikun.orm.db.DataBaseConfig;


public class LiteOrmUtil {
    private static LiteOrm liteOrm;

    private static OnNeedListener listener;

    /**
     * 作者　　: 李坤
     * 创建时间: 2017/8/7 10:29
     * 邮箱　　：496546144@qq.com
     * <p>
     * 方法功能：一定要在Application里面调用
     */

    public static void init(OnNeedListener listener) {
        LiteOrmUtil.listener = listener;
    }


    public interface OnNeedListener {
        public Application getApplication();

        public boolean isDebug();

        public int getVersionCode();
    }

    public static Application getApp() {
        if (listener == null) {
            throw new RuntimeException("请在Application调用Utils的init方法");
        } else {
            return listener.getApplication();
        }
    }

    public static boolean isDebug() {
        if (listener == null) {
            throw new RuntimeException("请在Application调用Utils的init方法");
        } else {
            return listener.isDebug();
        }
    }

    public static int versionCode() {
        if (listener == null) {
            throw new RuntimeException("请在Application调用Utils的init方法");
        } else {
            return listener.getVersionCode();
        }
    }

    private LiteOrmUtil() {
    }


    public static LiteOrm get() {
        if (liteOrm == null) {
            synchronized (LiteOrmUtil.class) {
                if (liteOrm == null) {
                    init();
                }
            }
        }
        return liteOrm;
    }

    private static void init() {
        if (liteOrm == null) {
            DataBaseConfig config = new DataBaseConfig(getApp(), getApp().getString(R.string.app_name_letter));
            config.debugged = isDebug();
            config.dbVersion = versionCode();
            config.onUpdateListener = null;
            liteOrm = LiteOrm.newSingleInstance(config);
        }
    }
}
