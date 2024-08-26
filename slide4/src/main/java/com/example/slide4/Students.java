package com.example.slide4;

public class Students {
    String studentNo, name;
    //constructor

    public Students(String studentNo, String name) {
        this.studentNo = studentNo;
        this.name = name;
    }
    // getter & setter

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
