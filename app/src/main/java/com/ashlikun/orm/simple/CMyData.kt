package com.ashlikun.orm.simple

import com.ashlikun.orm.db.annotation.Mapping
import com.ashlikun.orm.db.annotation.PrimaryKey
import com.ashlikun.orm.db.annotation.Table
import com.ashlikun.orm.db.enums.AssignType
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
    val list: ArrayList<DataList> = ArrayList(),
    @Mapping(Relation.OneToOne)
    var data: DataData? = null,
    var a: String? = null,
    var ssss: Boolean = false,
    var time: Date? = null,
    var calendar: Calendar? = null,
    var ddddd: Adddd? = null
) {

}

@Table("DataList")
data class DataList(@PrimaryKey(value = AssignType.AUTO_INCREMENT) val id: Int = 0, val aaa: String = "")

@Table("DataData")
data class DataData(@PrimaryKey(value = AssignType.AUTO_INCREMENT) val id: Int = 0, val aaa: String = "")


@Table("CMyOneData")
data class CMyOneData(
    var id: Int = 0,
    var boolean: Boolean = false,
    var time: Date? = null,
    var calendar: Calendar? = null,
    var ddddd: Adddd? = null,
    var speeds: MutableList<Float> = mutableListOf(),
    var title2: String = "aaaaaaaaaa",
    var title3: String = "bbbbbbbbbbbb",
    var title4: String = "qqqqqqqq",
    var title5: String = "wwwwwwwww",
    var title6: String = "eeeeeeee",
    var title7: String = "rrrrrrrrr",
    var title8: String = "tttttttttt",
    var title9: String = "yyyyyyyyy",
    var title11: String = "uuuuuuuuuu",
    var title12: String = "iiiiiiiii",
    var title13: String = "oooooooooo",
    var title14: String = "asdadw",
    var title15: String = "dasdawd",
    var title16: String = "wdasdwfdfgf",
    var title17: String = "wdasdasd",
    var title18: String = "fffffffffffffffffff",
    var title19: String = "ffwdfwffw",
    var title20: String = "fwfqqqqqqqqqqqqqqqqqqqq",
    var title21: String = "ffwwwwwwwwwwwwwwwwwwww",
    var title22: String = "qqqqqqqqqqqqqqqqqqqqqqqq",

    ) {

}