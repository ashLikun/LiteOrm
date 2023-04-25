package com.ashlikun.orm.simple

import com.ashlikun.orm.db.annotation.Mapping
import com.ashlikun.orm.db.annotation.Table
import com.ashlikun.orm.db.enums.Relation
import java.util.*
import kotlin.collections.ArrayList

/**
 * 作者　　: 李坤
 * 创建时间: 2018/5/11 0011　下午 5:29
 * 邮箱　　：496546144@qq.com
 *
 *
 * 功能介绍：
 */
@Table("CMyData")
data class CMyData(
    var id: Int = 0,
    @Mapping(Relation.OneToMany)
    var list: ArrayList<DataList> = ArrayList(),
    @Mapping(Relation.OneToOne)
    var data: DataData? = null,
    var a: String? = null,
    var ssss: Boolean = false,
    var time: Date? = null,
    var calendar: Calendar? = null,
    var ddddd: Adddd? = null
) {

}

data class DataList(val id: Int = 0, val aaa: String = "")
data class DataData(val id: Int = 0, val aaa: String = "")