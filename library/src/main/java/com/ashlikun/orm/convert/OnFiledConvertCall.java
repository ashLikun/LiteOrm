package com.ashlikun.orm.convert;

import java.lang.reflect.Field;

/**
 * 作者　　: 李坤
 * 创建时间: 2023/4/25　16:10
 * 邮箱　　：496546144@qq.com
 * <p>
 * 功能介绍：字段赋值时候的回调
 */
public interface OnFiledConvertCall<F, T> {
    /**
     * 设置值
     *
     * @param field 字段
     * @param value 值
     */
    F set(Field field, T value);

    /**
     * 设置值
     *
     * @param value 值
     * @return 返回数据库对应数据
     */
    T bind(F value);
}
