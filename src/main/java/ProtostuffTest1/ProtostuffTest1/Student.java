package ProtostuffTest1.ProtostuffTest1;

import io.protostuff.Tag;

public class Student {
	@Tag(1)  
    private String name;  
    @Tag(2)  
    private String studentNo;  
    @Tag(3)  
    private int age;  
    @Tag(4)  
    private String schoolName;  
  
   // 关于@Tag,要么所有属性都有@Tag注解,要么都没有,不能一个类中只有部分属性有@Tag注解  
  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public String getStudentNo() {  
        return studentNo;  
    }  
  
    public void setStudentNo(String studentNo) {  
        this.studentNo = studentNo;  
    }  
  
    public int getAge() {  
        return age;  
    }  
  
    public void setAge(int age) {  
        this.age = age;  
    }  
  
    public String getSchoolName() {  
        return schoolName;  
    }  
  
    public void setSchoolName(String schoolName) {  
        this.schoolName = schoolName;  
    }  
  
    @Override  
    public String toString() {  
        return "Student{" +  
                "name='" + name + '\'' +  
                ", studentNo='" + studentNo + '\'' +  
                ", age=" + age +  
                ", schoolName='" + schoolName + '\'' +  
                '}';  
    }
}
