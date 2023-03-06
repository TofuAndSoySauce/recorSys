package com.cos.recorSys.GsonExample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
 
public class CreateGson {
    public static void main(String[] args) {
        
        // new
        Gson gson1 = new Gson();
 
        // GsonBuilder
        Gson gson2 = new GsonBuilder().create();
        Gson gson3 = new GsonBuilder().setPrettyPrinting().create();
        
    }
}