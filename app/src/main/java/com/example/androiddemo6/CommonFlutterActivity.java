package com.example.androiddemo6;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.taobao.idlefish.flutterboost.containers.BoostFlutterActivity;

import java.util.HashMap;
import java.util.Map;

import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.GeneratedPluginRegistrant;

public class CommonFlutterActivity extends BoostFlutterActivity {
    private Map map = new HashMap();
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (intent != null) {
            url = intent.getStringExtra("url");
            String json = intent.getStringExtra("json");
            Gson gson = new Gson();
            map = gson.fromJson(json, Map.class);
            Log.w("lsj", "json=" + json);
            /*Map map = UrlUtil.parseParams(url);
            userid = map.get("userid").toString();
            _ticket_ = map.get("_ticket_").toString();
            Log.w("lsj", "userid=" + userid + "   +ticket=" + _ticket_);*/
        }
    }

    @Override
    public String getContainerName() {
        return url;
    }

    @Override
    public Map getContainerParams() {
       /* Map map = new HashMap();
        map.put("userid", userid);
        map.put("_ticket_", _ticket_);*/
        return map;
    }

    @Override
    public void onRegisterPlugins(PluginRegistry registry) {
        GeneratedPluginRegistrant.registerWith(registry);
    }
}