package io.reactivestax.school;

import io.reactivestax.school.entities.*;
import io.reactivestax.school.exceptions.NoSchoolAvailableForThisAgeException;
import io.reactivestax.school.exceptions.NoSchoolAvailableForThisGradeException;
import io.reactivestax.school.service.SchoolService;
import io.reactivestax.school.types.GradeType;
import io.reactivestax.school.types.SchoolType;

import java.util.Scanner;

public class Main {

    //Create 4 schools (one of each Type)
    static School preSchool= new PreSchool();
    static School elementarySchool = new ElementarySchool();
    static School middleSchool = new MiddleSchool();
    static School highSchool = new HighSchool();


    public static void main(String[] args) {
        collectStudentInformation();
        int age = schoolService.determineAgeBasedOnDOB(StudentDTO);
        GradeType gradeType = schoolService.determineGradeBasedOnAge(age)
        School school = schoolService.determineSchoolBasedOnGrade(gradeType)
        schoolService.admitStudent(student, school);
        //
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        int studentId = 0;
        System.out.println("***********************************************************");
        System.out.println("Welcome to the School Admissions App !!!  ");
        System.out.println("***********************************************************");

        do {

            System.out.println("Enter the Student Name for proceed further or  Press X for exit: ");
            String input= sc.next();
            String studentName="";
            if(input.equalsIgnoreCase("x")){
                System.out.println("System existing");
                System.out.println("Thanks for using it...");
                System.exit(0);
            }else {
                studentName = input;
            }

            //Student name should have atleast 3 chars and maximum 50 chars
            while (studentName.length() < 3 || studentName.length() > 50) {
                System.out.println("Name should not less than 3 chars and no more than 50 chars");
                studentName = sc.next();
            }
            System.out.println("Enter the student Date of birth. Age format should be mm/dd/yyyy : ");
            String studentAge = sc.next();
            int ageOfStudent = SchoolService.getAge(studentAge);

            while (ageOfStudent < 4 || ageOfStudent > 17) {
                System.out.println("Incorrect Age. Age should be between 4 and 17 :\n");
                System.out.println("Enter the student age. Age format should be mm/dd/yyyy : ");
                studentAge = sc.next();
                ageOfStudent = SchoolService.getAge(studentAge);
            }

            //Grade based on age
            GradeType grade= null;
            try {
                grade = SchoolService.determineGradeBasedOnAge(ageOfStudent);
            }catch (NoSchoolAvailableForThisAgeException e){
                System.out.println("Incorrect Age.");
            }

            studentId= studentId+1;


            //School based on Grade
            SchoolType schoolType= null;
            try{
                schoolType= SchoolService.determineSchoolBasedOnGrade(grade);
            }catch (NoSchoolAvailableForThisGradeException e){
                System.out.println("Grade is not correct");
            }


            //school admit student
            Student student= new Student(studentName, studentAge, grade, String.valueOf(studentId),schoolType);
            School school= SchoolService.determineSchoolTypeBasedOnSchool(schoolType);
            try{
                school.adminStudent(student);
            }catch (Exception e){
                System.out.println("Sorry the class for grade#\" + grade + \" is full, please try in another student");
                sc.close();
            }
            System.out.println("Welcome");



            System.out.println("press y to use this application again. press x to exit from this application ");
            String inputUser = sc.next();
            while (!inputUser.equalsIgnoreCase("y") && !inputUser.equalsIgnoreCase("x")) {
                System.out.println("Wrong selection.");
                System.out.println("press y to use this application again. press x to exit from this application ");
                inputUser = sc.next();
            }
            if (inputUser.equalsIgnoreCase("y")) {
                flag = true;
            }
            if (inputUser.equalsIgnoreCase("x")) {
                flag = false;
                System.out.println("Thanks for using this application...");
                sc.close();
            }

        } while (flag);

    }


}