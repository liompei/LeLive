package com.bjletu.lelive.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.bjletu.lelive.App;

/**
 * Created by Liompei
 * Time 2017/10/5 11:07
 * 1137694912@qq.com
 * remark:
 */

public class SharedPreferencesUtils {

    /**
     * 清空数据
     */
    public static void reset(final Context ctx) {

        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(ctx).edit();
        edit.clear();
        edit.commit();
    }

    public static String getString(String key) {
//        String defValue
        return PreferenceManager.getDefaultSharedPreferences(App.getInstance()).getString(key, "");
    }

    public static long getLong(String key, long defValue) {

        return PreferenceManager.getDefaultSharedPreferences(App.getInstance()).getLong(key, defValue);
    }

    public static float getFloat(String key) {
//        float defValue
        return PreferenceManager.getDefaultSharedPreferences(App.getInstance()).getFloat(key, 0.0f);
    }


    public static void put(String key, String value) {

        putString(key, value);
    }

    public static void put(String key, int value) {

        putInt(key, value);
    }

    public static void put(String key, float value) {

        putFloat(key, value);
    }

    public static void put(String key, boolean value) {

        putBoolean(key, value);
    }

    public static void put(String key, long value) {

        putLong(key, value);
    }


    public static void putFloat(String key, float value) {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(App.getInstance());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(key, value);
        editor.commit();
    }


    public static SharedPreferences getPreferences() {

        return PreferenceManager.getDefaultSharedPreferences(App.getInstance());
    }

    public static int getInt(String key) {

        return PreferenceManager.getDefaultSharedPreferences(App.getInstance()).getInt(key, 0);
    }

    public static boolean getBoolean(String key, boolean defValue) {

        return PreferenceManager.getDefaultSharedPreferences(App.getInstance()).getBoolean(key, defValue);
    }

    public static void putStringProcess(String key, String value) {

        SharedPreferences sharedPreferences = App.getInstance().getSharedPreferences("preference_le_live", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String getStringProcess(String key, String defValue) {

        SharedPreferences sharedPreferences = App.getInstance().getSharedPreferences("preference_le_live", Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, defValue);
    }

    public static boolean hasString(String key) {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(App.getInstance());
        return sharedPreferences.contains(key);
    }

    public static void putString(String key, String value) {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(App.getInstance());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static void putLong(String key, long value) {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(App.getInstance());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(key, value);
        editor.commit();
    }

    public static void putBoolean(String key, boolean value) {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(App.getInstance());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static void putInt(String key, int value) {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(App.getInstance());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    //移除
    public static void remove(String... keys) {

        if (keys != null) {
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(App.getInstance());
            SharedPreferences.Editor editor = sharedPreferences.edit();
            for (String key : keys) {
                editor.remove(key);
            }
            editor.commit();
        }
    }
}
