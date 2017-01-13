package com.josip.acer.pulaplusaplikacija;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.net.http.RequestQueue;

import com.android.volley.Request;
import com.android.volley.toolbox.Volley;

/**
 * Created by HG on 13.01.2017..
 */

public class RequestApp extends Application {
    private com.android.volley.RequestQueue mRequestQueue;
    private  static RequestApp mInstance;
    private Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public void setContext(Context context){
        this.context = context;
    }
    public static synchronized  RequestApp getmInstance(){
        return  mInstance;
    }

    public  <T> void addToReqQueue(Request<T> req){
        getmRequestQueue().add(req);
    }
    public com.android.volley.RequestQueue getmRequestQueue(){
        if(mRequestQueue ==null){
            mRequestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return mRequestQueue;
    }
}
