package com.zzh.calendar.util;

import android.util.Log;

/**
 * Created by Administrator on 2017/5/3 0003.
 */

public class ShowLog {
    public static final int LOG_VERBOSE = 0;
    public static final int LOG_DEBUG = 1;
    public static final int LOG_INFO = 2;
    public static final int LOG_WARN = 3;
    public static final int LOG_ERROR = 4;
    public static final int LOG_NOTHING = 5;

    public static int LOG_LEVEL = LOG_VERBOSE;

    public static void v(String tag , String msg){
        if (LOG_LEVEL <= LOG_VERBOSE){
            Log.v(tag , msg);
        }
    }

    public static void d(String tag , String msg){
        if (LOG_LEVEL <= LOG_DEBUG){
            Log.d(tag , msg);
        }
    }

    public static void i(String tag , String msg){
        if (LOG_LEVEL <= LOG_INFO){
            Log.i(tag , msg);
        }
    }
    public static void w(String tag , String msg){
        if (LOG_LEVEL <= LOG_WARN){
            Log.w(tag , msg);
        }
    }
    public static void e(String tag , String msg){
        if (LOG_LEVEL <= LOG_ERROR){
            Log.e(tag , msg);
        }
    }



}
