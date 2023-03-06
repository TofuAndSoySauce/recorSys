package com.cos.recorSys.GsonExample;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class MapToJson {
	 public static void main(String[] args) {
		 
	        // Map
	        Map<String, String> map = new HashMap<>();
	        map.put("id", "1");
	        map.put("name", "Anna");
	 
	        // Map -> Json 문자열
	        Gson gson = new Gson();
	        String jsonStr = gson.toJson(map);
	 
	        // Json 문자열 출력
	        System.out.println(jsonStr); // {"name":"Anna","id":"1"}
	 
	    }
}
