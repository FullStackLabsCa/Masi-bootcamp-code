package io.reactivestax.school.service;

import io.reactivestax.school.Main;
import io.reactivestax.school.entities.School;
import io.reactivestax.school.exceptions.NoSchoolAvailableForThisAgeException;
import io.reactivestax.school.exceptions.NoSchoolAvailableForThisGradeException;
import io.reactivestax.school.types.GradeType;
import io.reactivestax.school.types.SchoolType;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class SchoolService {
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

    public static GradeType determineGradeBasedOnAge(int age) throws NoSchoolAvailableForThisAgeException {
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
                return Main.preSchool;
            case ELEMENTARY_SCHOOL:
                return Main.elementarySchool;
            case MIDDLE_SCHOOL:
                return Main.middleSchool;
            case HIGH_SCHOOL:
                return Main.highSchool;
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
}
