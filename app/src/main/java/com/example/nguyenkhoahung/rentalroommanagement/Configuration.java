package com.example.nguyenkhoahung.rentalroommanagement;

import android.content.ContentValues;


public class Configuration {

    private boolean isConfiged = false;
    private ContentValues mConfigParams = new ContentValues();

    public void config() {
        if (!isConfiged) {
            isConfiged = true;
            onConfig();
        }
    }

    protected void onConfig() {

    }

    public void put(String key, Object val) {
        if (val instanceof String)
            mConfigParams.put(key, (String) val);
        else if (val instanceof Byte)
            mConfigParams.put(key, (Byte) val);
        else if (val instanceof Short)
            mConfigParams.put(key, (Short) val);
        else if (val instanceof Integer)
            mConfigParams.put(key, (Integer) val);
        else if (val instanceof Long)
            mConfigParams.put(key, (Long) val);
        else if (val instanceof Float)
            mConfigParams.put(key, (Float) val);
        else if (val instanceof Double)
            mConfigParams.put(key, (Double) val);
        else if (val instanceof byte[])
            mConfigParams.put(key, (byte[]) val);
        else if (val instanceof Boolean)
            mConfigParams.put(key, (Boolean) val);
    }

    public boolean hasConfiguration(String key) {
        return mConfigParams.containsKey(key);
    }

    public Object getValue(String key) {
        return mConfigParams.get(key);
    }

    public boolean getBoolean(String key) {
        return mConfigParams.containsKey(key)? mConfigParams.getAsBoolean(key) : false;
    }

    public int getInt(String key) {
        return mConfigParams.containsKey(key)? mConfigParams.getAsInteger(key) : -1;
    }
}

