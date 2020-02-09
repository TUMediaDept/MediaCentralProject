package com.tumedia.mediaandroidpractice.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.tumedia.mediaandroidpractice.common.Constants;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by XIMON on 2019-12-01
 */
public class SharedPreferencesUtil {
    private static SharedPreferencesUtil mInstance = null;
    private static SharedPreferences mSharedPreferences;
    private static SharedPreferences.Editor editor;

    private static Context mContext;

    private SharedPreferencesUtil() {
    }

    public static SharedPreferencesUtil getInstance(Context context) {
        mContext = context;

        if (mInstance == null) {
            mInstance = new SharedPreferencesUtil();
        }
        if (mSharedPreferences == null) {
            mSharedPreferences = mContext.getSharedPreferences(Constants.PREF_KEY, Context.MODE_PRIVATE);
            editor = mSharedPreferences.edit();
        }
        return mInstance;
    }

//    public static SharedPreferencesUtil getInstance(){
//        return getInstance(mContext);
//    }

    public void putIntExtra(String key, int value) {
        editor.putInt(key, value);
        editor.apply();
    }

    public void putStringExtra(String key, String value) {
        editor.putString(key, value);
        editor.apply();
    }

    public void putLongExtra(String key, long value) {
        editor.putLong(key, value);
        editor.apply();
    }

    public void putBooleanExtra(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.apply();
    }

    public int getIntExtra(String key) {
        return mSharedPreferences.getInt(key, 0);
    }

    public String getStringExtra(String key) {
        return mSharedPreferences.getString(key, "");
    }

    public long getLongExtra(String key) {
        return mSharedPreferences.getLong(key, 0);
    }

    public boolean getBooleanExtra(String key) {
        return mSharedPreferences.getBoolean(key, false);
    }

    public void removePref(String key) {
        editor.remove(key).apply();
    }

    public boolean containCheck(String key) {
        return mSharedPreferences.contains(key);
    }

    public void clearPref() {
        editor.clear().apply();
    }

    // ArrayList를 (ArrayList -> JSONArray 변환 후 String으로) SharedPreferences에 저장하는 메소드
    public void putArrayListExtra(String key, ArrayList<String> values) {
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < values.size(); i++) {
            jsonArray.put(values.get(i));
        }
        if (!values.isEmpty()) {
            putStringExtra(key, jsonArray.toString());
        } else {
            putStringExtra(key, null);
        }
    }

    // ArrayList로 pref 저장된 데이터 가져오는 메소드
    public ArrayList<String> getArrayListExtra(String key) {
        String json = getStringExtra(key);
        ArrayList<String> arr = new ArrayList<>();

        if (json != null && !"".equals(json)) {
            try {
                JSONArray jsonArray = new JSONArray(json);
                for (int i = 0; i < jsonArray.length(); i++) {
                    String arrItem = jsonArray.optString(i);
                    arr.add(arrItem);
                }
                return arr;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
