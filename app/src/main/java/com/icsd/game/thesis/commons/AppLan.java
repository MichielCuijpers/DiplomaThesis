package com.icsd.game.thesis.commons;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;

import java.util.Locale;

public class AppLan extends android.app.Application {
    public static String sDefSystemLanguage;

    private static Locale locale = null;
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        Configuration config = getBaseContext().getResources().getConfiguration();
        String lang = "en";
        if (!"".equals(lang) && !config.locale.getLanguage().equals(lang)) {
            locale = new Locale(lang);
            Locale.setDefault(locale);
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        }


    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (locale != null) {
            newConfig.locale = locale;
            Locale.setDefault(locale);
            getBaseContext().getResources().updateConfiguration(newConfig, getBaseContext().getResources().getDisplayMetrics());
        }
        Log.e("MYDEBUG", "incongchange");
    }
    public static Context getAppContext() {
        return context;
    }

}
