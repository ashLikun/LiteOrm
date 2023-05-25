package com.ashlikun.orm.simple

import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ashlikun.orm.LiteOrmUtil
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.Calendar
import java.util.Date

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LiteOrmUtil.init(application, true)
//        LiteOrmUtil.setSdDbPath(Environment.getExternalStorageDirectory().path + "/likun/db")
    }

    fun onClick(v: View?) {
        val list = arrayListOf<DataList>()
        (0..100000).forEach {
            list.add(DataList(aaa = "wwwwwwwwwwwwwww a ${it}"))
        }
        GlobalScope.launch {
            var start = System.currentTimeMillis()
            LiteOrmUtil.getCascade()
                .save(
                    CMyData(
                        22,
                        list,
                        DataData(3, "dddddddddddddd"),
                        "ffffffffffffffff",
                        true,
                        Date(),
                        Calendar.getInstance(),
                        ddddd = Adddd("sawwwwwwwwwwwwwwwwww")
                    )
                )

            Log.e("aaaa", "保存数据花费时间 数据量${list.size} ${System.currentTimeMillis() - start}")
        }
    }

    fun onReadClick(v: View?) {
        GlobalScope.launch {
            var start = System.currentTimeMillis()
            val aaa: List<CMyData> = LiteOrmUtil.getCascade().query(CMyData::class.java)
            var count = 0
            aaa.forEach {
                count += it.list.size
            }
            Log.e("aaaa", "读取数据花费时间，数据量：${count} ${System.currentTimeMillis() - start}")
        }
    }

    fun onDeleteClick(v: View?) {
        GlobalScope.launch {
            var start = System.currentTimeMillis()
            val aa = LiteOrmUtil.getCascade().deleteById(22, CMyData::class.java)
            Log.e("aaaa", "删除数据花费时间，数据量：${aa} ${System.currentTimeMillis() - start}")
        }
    }

    fun onSingClick(v: View?) {
        val list = arrayListOf<CMyOneData>()
        (0..100).forEach {
            list.add(
                CMyOneData(
                    it,
                    true,
                    Date(),
                    Calendar.getInstance(),
                    ddddd = Adddd("sawwwwwwwwwwwwwwwwww"),
                    speeds = (0..100).map { it.toFloat() }.toMutableList()
                )
            )
        }
        GlobalScope.launch {
            var start = System.currentTimeMillis()
            LiteOrmUtil.get().save(list)
            Log.e("aaaa", "保存数据花费时间 数据量${list.size} ${System.currentTimeMillis() - start}")
        }
    }

    fun onSingReadClick(v: View?) {
        GlobalScope.launch {
            var start = System.currentTimeMillis()
            val aaa: List<CMyOneData> = LiteOrmUtil.get().query(CMyOneData::class.java)
            Log.e("aaaa", "读取数据花费时间，数据量：${aaa} ${System.currentTimeMillis() - start}")
        }
    }

    fun onSingDeleteClick(v: View?) {
        GlobalScope.launch {
            var start = System.currentTimeMillis()
            val aa = LiteOrmUtil.get().deleteById(22, CMyOneData::class.java)
            Log.e("aaaa", "删除数据花费时间，数据量：${aa} ${System.currentTimeMillis() - start}")
        }
    }
}