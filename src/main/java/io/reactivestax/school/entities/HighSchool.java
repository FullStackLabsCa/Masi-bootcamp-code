package io.reactivestax.school.entities;


import java.text.DecimalFormat;

public class HighSchool extends SchoolClass {
    @Override
    public Double chargeFees(Student student) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        if (student.getGrade().toString().equals("GRADE9")) {
            fee = 100 * 2.00;
        }
        else if (student.getGrade().toString().equals("GRADE10")) {
            fee = (100 * 2.00) + (100 * 2.00) * 0.45;
        } else if (student.getGrade().toString().equals("GRADE11")) {
            fee = ((100 * 2.00) + (100 * 2.00) * 0.45) + (((100 * 2.00) + (100 * 2.00) * 0.45) * 0.45);
        } else if (student.getGrade().toString().equals("GRADE12")) {
            fee = (((100 * 2.00) + (100 * 2.00) * 0.45) + (((100 * 2.00) + (100 * 2.00) * 0.45) * 0.45)) + (((100 * 2.00) + (100 * 2.00) * 0.45) + (((100 * 2.00) + (100 * 2.00) * 0.45) * 0.45)) * 0.45;
        }

        return Double.valueOf(decimalFormat.format(fee));
    }
}