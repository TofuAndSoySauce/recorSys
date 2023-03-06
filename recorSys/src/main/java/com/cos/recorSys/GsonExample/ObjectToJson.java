package com.cos.recorSys.GsonExample;

import com.google.gson.Gson;

public class ObjectToJson {
 
    public static void main(String[] args) {
 
        // Student 객체 생성
        Student student = new Student(1, "Anna");
 
        // Gson 객체 생성
        Gson gson = new Gson();
 
        // Student 객체 -> Json 문자열
        String studentJson = gson.toJson(student);
 
        // Json 문자열 출력
        System.out.println(studentJson);  // {"id":1,"name":"Anna"}
    }
}