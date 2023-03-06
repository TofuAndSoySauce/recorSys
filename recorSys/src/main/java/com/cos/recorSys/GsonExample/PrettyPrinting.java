package com.cos.recorSys.GsonExample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PrettyPrinting {

	public static void main(String[] args) {
		 
        // Json 문자열로 변환할 Student 객체
        Student student = new Student(1, "Anna");
 
        // PrettyPrinting 옵션을 추가하여 Gson 객체 생성
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
 
        // Student 객체 -> Json 문자열
        String studentJson = gson.toJson(student);
 
        // Json 문자열 출력 ( 예쁘게 출력 )
        System.out.println(studentJson);
 
    }
}
