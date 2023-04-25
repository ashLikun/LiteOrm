package com.ashlikun.orm.simple

import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ashlikun.orm.LiteOrmUtil
import java.util.Calendar
import java.util.Date

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LiteOrmUtil.init(application, true)
        LiteOrmUtil.setSdDbPath(Environment.getExternalStorageDirectory().path + "/likun/db")
    }

    fun onClick(v: View?) {
        LiteOrmUtil.getCascade()
            .save(
                CMyData(
                    11,
                    arrayListOf(DataList(1, "tgtttt"), DataList(2, "33333333333333")),
                    DataData(3, "ssssssssssssss"),
                    "asdadasd",
                    true,
                    Date(),
                    Calendar.getInstance(),
                    ddddd = Adddd("ssssssssssss")
                )
            )
    }

    fun onReadClick(v: View?) {
        val aaa: List<CMyData> = LiteOrmUtil.getCascade().query(CMyData::class.java)
        Log.e("aaaaa", aaa.toString())
    }
}