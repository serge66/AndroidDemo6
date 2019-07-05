package com.example.androiddemo6.utils;

import java.util.HashMap;
import java.util.Map;

public class UrlUtil {
    //"?userid=ffffffff&_ticket_=dddddd"
    public static Map parseParams(String url) {
        Map<String, String> map = new HashMap<>();
        if (url.contains("?")) {
            String[] split = url.split("\\?");
            String[] strings = split[1].split("&");

            for (int i = 0; i < strings.length; i++) {
                String[] maps = strings[i].split("=");
                map.put(maps[0], maps[1]);
            }
        }

        return map;
    }
}
