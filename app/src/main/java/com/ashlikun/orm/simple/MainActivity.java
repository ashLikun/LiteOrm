package com.ashlikun.orm.simple;

import android.os.Bundle;
import android.os.Environment;

import com.ashlikun.orm.LiteOrmUtil;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LiteOrmUtil.init(getApplication());
        LiteOrmUtil.setSdDbPath(Environment.getExternalStorageDirectory().getPath() + "/likun/db");
        LiteOrmUtil.get().save(new CMyData(22, "asdadasd", true));
    }
}
