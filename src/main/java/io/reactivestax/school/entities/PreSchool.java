package io.reactivestax.school.entities;

import java.text.DecimalFormat;

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


