package com.example.item.app;

import android.app.Application;
import android.content.Context;

import com.example.item.utils.SpUtils;
import com.live.MyApplication;

import java.util.HashMap;

public class MyApp extends Application {
    private static String[] modules = {"com.live.MyApplication"};

    public static MyApp app;
    public static HashMap<String, Object> map;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        map = new HashMap<>();
        SpUtils.getInstance().setValue("image",true);

        initMoudles();
    }
    public static MyApp getApp() {
        return app;
    }
    private static Context mAppContext = null;
    public static HashMap<String, Object> getMap() {
        return map;
    }

    private void initMoudles() {
        for (String moduleImpl : modules){
            try {
                Class<?> clazz = Class.forName(moduleImpl);
                Object obj = clazz.newInstance();
                if (obj instanceof MyApplication){
                    ((MyApplication) obj).initApp(app);
                    String token = SpUtils.getInstance().getString("token");
                    ((MyApplication) obj).initToken(token);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

}
