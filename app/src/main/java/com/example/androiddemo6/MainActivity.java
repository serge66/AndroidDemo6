package com.example.androiddemo6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static WeakReference<MainActivity> sRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sRef = new WeakReference<>(this);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        Map map = new HashMap();
        map.put("userid", "d78aa2f971024d2a889e25d2ba2e1c5e");
        map.put("_ticket_", "7foNAlJJJ547UBtp61V4BxdW2qkLQx2UyzhPUx44lw34kwq6OYwoUcZAMI0hyZCHvTLncC7+CFOWGTEWA6glzw==");
        PageRouter.openPageByUrl(this, PageRouter.FLUTTER_CHANGE_PWD_PAGE_URL, map);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sRef.clear();
        sRef = null;
    }

}
