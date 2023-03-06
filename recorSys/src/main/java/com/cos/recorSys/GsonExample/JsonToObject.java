package com.cos.recorSys.GsonExample;

import com.google.gson.Gson;

public class JsonToObject {
	public static void main(String[] args) {
		 
        // Json 문자열
        String jsonStr = "{\"id\":1,\"name\":\"Anna\"}";
 
        // Gson 객체 생성
        Gson gson = new Gson();
 
        // Json 문자열 -> Student 객체
        Student student = gson.fromJson(jsonStr, Student.class);
 
        // Student 객체 toString() 출력
        System.out.println(student); // Student [id=1, name=Anna]
    }

}
