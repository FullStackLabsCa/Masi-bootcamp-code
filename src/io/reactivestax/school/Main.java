package io.reactivestax.school;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    //Create 4 schools (one of each Type)
    static School preSchool= new PreSchool();
    static School elementarySchool = new ElementarySchool();
    static School middleSchool = new MiddleSchool();
    static School highSchool = new HighSchool();

    public static SchoolType determineSchoolBasedOnGrade(GradeType grade) throws NoSchoolAvailableForThisGradeException {
        switch (grade){
            case JK_GRADE:
            case SK_GRADE:
                return SchoolType.PRE_SCHOOL;
            case GRADE1:
            case GRADE2:
            case GRADE3:
            case GRADE4:
            case GRADE5:
                return SchoolType.ELEMENTARY_SCHOOL;
            case GRADE6:
            case GRADE7:
            case GRADE8:
                return SchoolType.MIDDLE_SCHOOL;
            case GRADE9:
            case GRADE10:
            case GRADE11:
            case GRADE12:
                return SchoolType.HIGH_SCHOOL;
            default:
                throw new NoSchoolAvailableForThisGradeException();
        }
    }


    public static GradeType determineGradeBasedOnAge(int age) throws NoSchoolAvailableForThisAgeException{
        switch (age){
            case 4:
                return GradeType.JK_GRADE;
            case 5:
                return GradeType.SK_GRADE;
            case 6:
                return GradeType.GRADE1;
            case 7:
                return GradeType.GRADE2;
            case 8:
                return GradeType.GRADE3;
            case 9:
                return GradeType.GRADE4;
            case 10:
                return GradeType.GRADE5;
            case 11:
                return GradeType.GRADE6;
            case 12:
                return GradeType.GRADE7;
            case 13:
                return GradeType.GRADE8;
            case 14:
                return GradeType.GRADE9;
            case 15:
                return GradeType.GRADE10;
            case 16:
                return GradeType.GRADE11;
            case 17:
                return GradeType.GRADE12;
            default:
                throw new NoSchoolAvailableForThisAgeException();
        }
    }

    public static School determineSchoolTypeBasedOnSchool(SchoolType school){
        switch (school){
            case PRE_SCHOOL:
                return preSchool;
            case ELEMENTARY_SCHOOL:
                return elementarySchool;
            case MIDDLE_SCHOOL:
                return middleSchool;
            case HIGH_SCHOOL:
                return highSchool;
            default:
                throw new IllegalArgumentException("wrong school type");
        }
    }

    public static int getAge(String dateOfBirth){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Period p=null;
        try{
            LocalDate d = LocalDate.parse(dateOfBirth,formatter);
            LocalDate today = LocalDate.now();
            LocalDate birthday = LocalDate.of(d.getYear(), d.getMonth(), d.getDayOfMonth());
            p = Period.between(birthday, today);
        }catch (Exception e){
            System.out.println("Incorrect age format");
        }
        return p.getYears();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        int studentId = 0;

        do {
            System.out.println("***********************************************************");
            System.out.println("Welcome to the School Admissions App !!!   Press X for exit");
            System.out.println("***********************************************************");


            System.out.println("Enter the Student Name: ");
            String studentName = sc.next();


            //Student name should have atleast 3 chars and maximum 50 chars
            while (studentName.length() < 3 || studentName.length() > 50) {
                System.out.println("Name should not less than 3 chars and no more than 50 chars");
                studentName = sc.next();
            }
            System.out.println("Enter the student Date of birth. Age format should be mm/dd/yyyy : ");
            String studentAge = sc.next();
            int ageOfStudent = getAge(studentAge);

            while (ageOfStudent < 4 || ageOfStudent > 17) {
                System.out.println("Incorrect Age. Age should be between 4 and 17 :\n");
                System.out.println("Enter the student age. Age format should be mm/dd/yyyy : ");
                studentAge = sc.next();
                ageOfStudent = getAge(studentAge);
            }

            //Grade based on age
            GradeType grade= null;
            try {
                grade = determineGradeBasedOnAge(ageOfStudent);
            }catch (NoSchoolAvailableForThisAgeException e){
                System.out.println("Incorrect Age.");
            }

            studentId= studentId+1;


            //School based on Grade
            SchoolType schoolType= null;
            try{
                schoolType= determineSchoolBasedOnGrade(grade);
            }catch (NoSchoolAvailableForThisGradeException e){
                System.out.println("Grade is not correct");
            }


            //school admit student
            Student student= new Student(studentName, studentAge, grade, String.valueOf(studentId));
            School school= determineSchoolTypeBasedOnSchool(schoolType);
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