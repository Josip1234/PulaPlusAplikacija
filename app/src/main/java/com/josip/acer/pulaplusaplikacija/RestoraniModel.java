package com.josip.acer.pulaplusaplikacija;

/**
 * Created by HG on 15.12.2016..
 */

public class RestoraniModel {
    public String name;
    public String address;
    public String cotact;
    public RestoraniModel(String cotact,String address){
        this.cotact=cotact;
        this.address=address;
    }

    public String getName(){
        return  name;
    }
    public String getAddress(){
        return address;
    }
    public String getCotact(){
        return cotact;
    }
}
