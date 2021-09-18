package io.reactivestax.school;

import java.util.*;

public abstract class SchoolClass implements School{
    int age;
    GradeType grade;
    double fee = 0;

    Map<GradeType, List<Student>> gradeToStudentsMap= new EnumMap<>(GradeType.class);

    public Student adminStudent(Student student) throws ClassFullException{
        if(gradeToStudentsMap.get(student.getGrade())==null){
            List<Student> studentList = new ArrayList<>();
            studentList.add(student);
            gradeToStudentsMap.put(student.getGrade(), studentList);
        }else{
            List<Student> studentList = gradeToStudentsMap.get(student.getGrade());
            if(studentList.size()>=3){
                throw new ClassFullException();
            }
            studentList.add(student);
            gradeToStudentsMap.put(student.getGrade(), studentList);
        }
        System.out.println("added student = " + student+  " into grade"+ student.getGrade());
        return student;
    }



}
