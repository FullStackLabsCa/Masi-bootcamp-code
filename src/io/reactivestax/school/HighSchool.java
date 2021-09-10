package io.reactivestax.school;

import java.text.DecimalFormat;

public class HighSchool extends SchoolClass {
    @Override
    public Double chargeFees(Student student) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        if (grade.equals("9")) {
            fee = 100 * 2.00;

        } else if (grade.equals("10")) {
            fee = (100 * 2.00) + (100 * 2.00) * 0.45;
        } else if (grade.equals("11")) {
            fee = ((100 * 2.00) + (100 * 2.00) * 0.45) + (((100 * 2.00) + (100 * 2.00) * 0.45) * 0.45);
        } else if (grade.equals("12")) {
            fee = (((100 * 2.00) + (100 * 2.00) * 0.45) + (((100 * 2.00) + (100 * 2.00) * 0.45) * 0.45)) + (((100 * 2.00) + (100 * 2.00) * 0.45) + (((100 * 2.00) + (100 * 2.00) * 0.45) * 0.45)) * 0.45;
        }
        return Double.valueOf(decimalFormat.format(fee));
    }
}
