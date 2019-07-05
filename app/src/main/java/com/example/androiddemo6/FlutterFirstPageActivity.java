package com.example.androiddemo6;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.androiddemo6.utils.UrlUtil;
import com.taobao.idlefish.flutterboost.containers.BoostFlutterActivity;

import java.util.HashMap;
import java.util.Map;

import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.GeneratedPluginRegistrant;

public class FlutterFirstPageActivity extends BoostFlutterActivity {
    private String userid;
    private String _ticket_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (intent != null) {
            String url = intent.getStringExtra("url");
            Map map = UrlUtil.parseParams(url);
            userid = map.get("userid").toString();
            _ticket_ = map.get("_ticket_").toString();
            Log.w("lsj", "userid=" + userid + "   +ticket=" + _ticket_);
        }
    }

    @Override
    public String getContainerName() {
        return PageRouter.FLUTTER_CHANGE_PWD_PAGE_URL;
    }

    @Override
    public Map getContainerParams() {
        Map map = new HashMap();
        map.put("userid", userid);
        map.put("_ticket_", _ticket_);
        return map;
    }

    @Override
    public void onRegisterPlugins(PluginRegistry registry) {
        GeneratedPluginRegistrant.registerWith(registry);
    }
}