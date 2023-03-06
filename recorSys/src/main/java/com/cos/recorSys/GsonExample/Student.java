package com.cos.recorSys.GsonExample;

public class Student {
    private int id;
//    private transient int id // 해당 필드를 제외하고 Json 문자열이 생성
    private String name;
 
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
 
    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + "]";
    }
 
}
