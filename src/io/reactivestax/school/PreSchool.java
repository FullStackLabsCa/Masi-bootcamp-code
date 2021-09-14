package io.reactivestax.school;

import io.reactivestax.school.SchoolClass;
import io.reactivestax.school.Student;

import java.text.DecimalFormat;
import java.util.Formatter;

public class PreSchool extends SchoolClass {

    @Override
    public Double chargeFees(Student student) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        double fee = 0;
        if (student.getGrade().toString().equals("JK_GRADE")) {
            fee = 100 * 1.1;

        } else if (student.getGrade().toString().equals("SK_GRADE")) {
            fee = 100 * 1.1+(100 * 1.1) * 0.25;


        } return Double.valueOf(decimalFormat.format(fee));
    }
}


