package com.ashlikun.orm.simple;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import com.ashlikun.orm.LiteOrmUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LiteOrmUtil.init(getApplication());
        LiteOrmUtil.setSdDbPath(Environment.getExternalStorageDirectory().getPath() + "/likun/db");
        LiteOrmUtil.getSd().save(new CMyData(22, "asdadasd", true));
    }
}
