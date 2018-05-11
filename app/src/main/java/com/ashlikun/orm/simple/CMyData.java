package com.ashlikun.orm.simple;

import com.ashlikun.orm.db.annotation.Table;

/**
 * 作者　　: 李坤
 * 创建时间: 2018/5/11 0011　下午 5:29
 * 邮箱　　：496546144@qq.com
 * <p>
 * 功能介绍：
 */
@Table("CMyData")
public class CMyData {
    public int id;
    public String a;
    public boolean ssss;

    public CMyData() {
    }

    public CMyData(int id, String a, boolean ssss) {
        this.id = id;
        this.a = a;
        this.ssss = ssss;
    }
}
