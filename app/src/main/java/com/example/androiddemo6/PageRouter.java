package com.example.androiddemo6;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class PageRouter {
    public static final String NATIVE_FIRST_PAGE_URL = "flutterbus://nativeFirstPage";
    public static final String NATIVE_SECOND_PAGE_URL = "flutterbus://nativeSecondPage";
    public static final String FLUTTER_FIRST_PAGE_URL = "flutterbus://flutterFirstPage";
    public static final String FLUTTER_SECOND_PAGE_URL = "flutterbus://flutterSecondPage";
    public static final String FLUTTER_CHANGE_PWD_PAGE_URL = "zhuku://ChangePwd";

    public static boolean openPageByUrl(Context context, String url, int requestCode) {
        Map<String, String> map = new HashMap<>();
        return openPageByUrl(context, url, requestCode, map);
    }

    public static boolean openPageByUrl(Context context, String url, Map map) {
        return openPageByUrl(context, url, 0, map);
    }

    public static boolean openPageByUrl(Context context, String url, int requestCode, Map map) {

        Gson gson = new Gson();
        String toJson = gson.toJson(map);
        Intent intent = new Intent();
        intent.putExtra("url", url);
        intent.putExtra("json", toJson);

        try {
            if (url.startsWith(NATIVE_FIRST_PAGE_URL)) {
                intent.setClass(context, FlutterFirstPageActivity.class);
                context.startActivity(intent);
                return true;
            } else if (url.startsWith(NATIVE_SECOND_PAGE_URL)) {
                intent.setClass(context, FlutterFirstPageActivity.class);
                if (context instanceof Activity) {
                    ((Activity) context).startActivityForResult(intent, requestCode);
                }
                return true;
            } else if (url.startsWith(FLUTTER_FIRST_PAGE_URL)) {
                intent.setClass(context, FlutterFirstPageActivity.class);
                context.startActivity(intent);
                return true;
            } else if (url.startsWith(FLUTTER_SECOND_PAGE_URL)) {
                intent.setClass(context, FlutterFirstPageActivity.class);
                if (context instanceof Activity) {
                    ((Activity) context).startActivityForResult(intent, requestCode);
                }
                return true;
            } else if (url.startsWith(FLUTTER_CHANGE_PWD_PAGE_URL)) {
                intent.setClass(context, CommonFlutterActivity.class);
                if (context instanceof Activity) {
                    ((Activity) context).startActivityForResult(intent, requestCode);
                }
                return true;
            } else {
                return false;
            }
        } catch (Throwable t) {
            return false;
        }
    }

}
